package Runner;

import java.io.IOException;
import java.util.Properties;

import org.testing.Assertions.TestCaseValidate;
import org.testing.TestMethods.TestCase01;
import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.JsonVariable;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTestCases {
	TestCase01 tc = new TestCase01();
    static String jsonPath ="../RishabhAssignment/src/test/java/org/testing/Resources/";
    String UserId; // Saved UserId in global Variable to use this in Test_004_fetchEntrie()
	
    
    
//    This method will create new user, post, comment and todo for success scenario and
//    also for when some mandatory fields are missing.
    

	@Test(enabled=true)
	public void Test_001_createUser() throws IOException 
	{	
		
//		Pass userName and email in method parameters to run the test
		String name="R89";
		String email= "apple89@gmail.com";
		
		Response rs =tc.MethodUser(name, email);
	    UserId = rs.jsonPath().get("id").toString(); // user id 
	  	String UserName = rs.jsonPath().get("name").toString(); // user name 
	  	String userEmail = rs.jsonPath().get("email").toString();// user email id
	  	String postID = tc.methodPost(UserId,UserName);
	  	tc.methodComment(userEmail, postID);
	  	tc.methodTodo(UserName, UserId);
	  	
//	   Bellow methods called with missing fields 
	  	
	  	tc.MethodUser("","");
	  	tc.methodPost("", "");
	  	tc.methodComment("", "");
	  	tc.methodTodo("", "");
	  		  	
	  	
	  	System.out.println("***** end of test case 01 *****");
	 }
	
	
	
//	create two users with the same email address.
	
	@Test(enabled=false)
	public static void Test_002_sameEmailAddress() throws IOException
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties");//Load Properties file to get the URI 
		String data =  LoadJsonFile.handleJsonFile(jsonPath+"createUser.JSON"); // Loading JSON file 
		String NameElement = "Hart"; //provide any new name 
		String multiple = JsonVariable.jsonVariableReplacement(data, "name", NameElement);//replacing value of name in JSON
        HttpMethods http = new HttpMethods(prObject); 
        Response rs = http.PostMethod("users_Post", multiple ); //calling post method
        TestCaseValidate.validateSTATUS(rs);
        JsonPath jp = rs.jsonPath();
        System.out.println(jp.get("message"));        
        if (rs.statusCode()==422)
	      {
		     String  errorMessage = rs.jsonPath().get("message").toString();
		     TestCaseValidate.validateErroMessage(errorMessage, "[has already been taken]");// Validating the errorMessage
	      }        
        System.out.println("***** end of test case 02 *****");

        
	}
	
	@Test(enabled=false)
	public void Test_003_invalidEmail() throws IOException
	{
	
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties");//Load Properties file to get the URI 
		String data =  LoadJsonFile.handleJsonFile(jsonPath+"invalidEmail.JSON"); // Loading JSON file 
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
	  	Response rs = http.PostMethod("users_Post", data ); // Json file read for boddy data
	  	TestCaseValidate.validateSTATUS(rs);
	  	if (rs.statusCode()==422)
	      {
		     String  errorMessage = rs.jsonPath().get("message").toString();
		     TestCaseValidate.validateErroMessage(errorMessage, "[is invalid]");// Validating the errorMessage
	      }

	    System.out.println("****** end of test case 03 ******");

	}
	
	
	@Test(enabled=false)
	public void Test_004_fetchEntries() throws IOException
	{

		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties");//Load Properties file to get the URI 
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
      	Response rs = http.getMethod("get_Entries", UserId );
      	TestCaseValidate.validateSTATUS(rs);   //// Validating the ResponseCode
	  	System.out.println("***** end of test case 04 *****");

 	}

}
