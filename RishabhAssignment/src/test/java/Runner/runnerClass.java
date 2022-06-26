package Runner;

import java.io.IOException;
import java.util.Properties;

import org.testing.Assertions.TestCaseValidate;
import org.testing.TestMethods.TestCase01;
import org.testing.TestScript.TestCases;
import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.jsonVariable;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class runnerClass {
	TestCase01 tc = new TestCase01();
	static TestCaseValidate tv = new TestCaseValidate();
    static String jsonPath ="../RishabhAssignment/src/test/java/org/testing/Resources/";
    String UserId;
	
	@Test(enabled=true)
	public void Test_001_createUser() throws IOException 
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile(jsonPath+"createUser.JSON"); // fetching bodyData.Json file
        HttpMethods http = new HttpMethods(prObject); // This require the object of property file
	  	Response rs = http.PostMethod("users_Post", data ); // Json file read for boddy data
		tv.validateSTATUS(rs);
	  	UserId = rs.jsonPath().get("id").toString(); // user id 
	  	String UserName = rs.jsonPath().get("name").toString(); // user name 
	  	String userEmail = rs.jsonPath().get("email").toString();// user email id
	  	String postID = tc.methodPost(UserId,UserName);
	  	tc.methodComment(userEmail, postID);
	  	tc.methodTodo(UserName, UserId);
	  	
	  	//when some mandatory fields are missing
	  	tc.methodPostFailed("", "");
	  	tc.methodCommentFailed("", "");
	  	tc.methodTodoFailed("", "");
	  	// todo validate response body
	  	
	  	System.out.println("***** end of test case 01 *****");

	 }
	
	@Test(enabled=true)
	public static void Test_002_sameEmailAddress() throws IOException//Users with same email ID
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile(jsonPath+"createUser.JSON"); // fetching bodyData.Json file
		String NameElement = "Hart"; //put any new name 
		String multiple = jsonVariable.jsonVariableReplacement(data, "name", NameElement);// it will take kailash from array first time and after that it will take rishabh
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        Response rs = http.PostMethod("users_Post", multiple ); // first time it will load
		tv.validateSTATUS(rs);
        JsonPath jp = rs.jsonPath();
        System.out.println(jp.get("message"));
//        rs.then().assertThat().statusCode(422).extract().response();
        System.out.println("***** end of test case 02 *****");

        
	}
	
	@Test(enabled=true)
	public void Test_003_invalidEmail() throws IOException
	{
	
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile(jsonPath+"invalidEmail.JSON"); // fetching bodyData.Json file
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
	  	Response rs = http.PostMethod("users_Post", data ); // Json file read for boddy data
		tv.validateSTATUS(rs);
	  	String  errorMessage = rs.getStatusLine().toString();// user email id can be further described 
		rs.then().assertThat().statusCode(422).extract().response();
	    System.out.println("****** end of test case 03 ******");

		
	}
	
	@Test(enabled=true)
	public void Test_004_fetchEntries() throws IOException
	{

		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
      	Response rs = http.getMethod("get_Entries", UserId );
      	tv.validateSTATUS(rs);      	
	  	System.out.println("***** end of test case 04 *****");

 	}
	

}
