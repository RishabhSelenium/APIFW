package org.testing.TestScript;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.RandomData;
import org.testing.Utility.jsonVariable;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestCases {



	String UserId, UserName, userEmail;
	
	
	@Test(enabled=true)
	public void createUser() throws IOException // Create new User
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/createUser.JSON"); // fetching bodyData.Json file
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
	  	Response rs = http.PostMethod("users_Post", data ); // Json file read for boddy data
		validateSTATUS(rs);
	  	UserId = rs.jsonPath().get("id").toString(); // user id 
	  	UserName = rs.jsonPath().get("name").toString(); // user name 
	  	userEmail = rs.jsonPath().get("email").toString();// user email id
	  	System.out.println(UserId + UserName);
	  	System.out.println("we are inside 01");
	  	String postID = methodPost(UserId,UserName);
	  	methodComment(userEmail, postID);
	  	methodTodo(UserName, UserId);
	  	System.out.println("*****************************");
	  	methodPostFailed("", "");
	  	//methodCommentFailed
	  	//methodTodofailed
	  		 
	}

	
	public static String methodPost(String UserId, String UserName ) throws IOException // Create new User

	{
		
//		TestCases tc01 = new TestCases();
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
//		Properties prObject = PropertyUtil.handlePropertyFile(System.getProperty("user.dir"+"/RishabhAssignment/src/URI.properties"));
		//todo same for JSON Handle
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/UserPosts.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// 
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
        Response rs = http.PostMethod("post_Post", multiple1 );
		 validateSTATUS(rs);
        String postID = (rs.jsonPath().get("id")).toString();
//	  	if (UserId.equals(""))
//	  	{
//	  		errorBody(rs, "postNegative.JSON");
//	  	}
	  	return postID;
   
	}
	
	public static String methodPostFailed(String UserId, String UserName ) throws IOException // Create new User

	{
		
//		TestCases tc01 = new TestCases();
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
//		Properties prObject = PropertyUtil.handlePropertyFile(System.getProperty("user.dir"+"/RishabhAssignment/src/URI.properties"));
		//todo same for JSON Handle
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/UserPosts.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// 
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
        Response rs = http.PostMethod("post_Post", multiple1 );
		 validateSTATUS(rs);
        String postID = (rs.jsonPath().get("id")).toString();
        String  errorMessage = rs.jsonPath().get("message").toString();// user email id can be further described 
	    System.out.println(errorMessage+"\\\\\\\\\\\\\\\\\\");
	    Assert.assertEquals(errorMessage, "[must exist, can't be blank, is not a number]" );
	    
	    
//	  	if (UserId.equals(""))
//	  	{
//	  		errorBody(rs, "postNegative.JSON");
//	  	}
	  	return postID;
   
	}
	
	public static void methodComment(String userEmail, String postID) throws IOException
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userComment.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "email", userEmail);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "post_id", postID );// it will take kailash from array first time and after that it will take rishabh
		 Response rs = http.PostMethod("comments_Post", multiple1 );
		 validateSTATUS(rs);		 
		
	}
	
	public static void methodTodo(String UserName, String UserId) throws IOException
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userTodo.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
		Response rs= http.PostMethod("todos_Post", multiple1 );
		 validateSTATUS(rs);
		
	}
	
	public static void validateSTATUS(Response rs)
	{
		
		int userResponse_STATUS = rs.getStatusCode();
		if(userResponse_STATUS==201)
		{
		    Assert.assertEquals(userResponse_STATUS, 201,"Success TestCases");

		}
		else if(userResponse_STATUS==422)
		{
		    Assert.assertEquals(userResponse_STATUS, 422, "Negative TestCases");

		}
		else if(userResponse_STATUS==200)
		{
		    Assert.assertEquals(userResponse_STATUS, 200, "Success TestCases");

		}
		
	}
	
	 
	
	
	
	@Test(enabled=false)
	public void userFieldsMissing() throws IOException // Create new User
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/createUser.JSON"); // fetching bodyData.Json file
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
	  	Response rs = http.PostMethod("users_Post", "" ); // Json file read for boddy data
//	  	UserId = rs.jsonPath().get("id").toString(); // user id 
//	  	UserName = rs.jsonPath().get("name").toString(); // user name 
//	  	userEmail = rs.jsonPath().get("email").toString();// user email id
//	  	System.out.println(UserId + UserName);
//	  	System.out.println("we are inside 01");
	  	methodPost("","");
	  	
	  	methodComment("", "");
	  	
	  	methodTodo("", "");
	  	
	  	int userResponse_STATUS = rs.getStatusCode();
	    Assert.assertEquals(userResponse_STATUS, 422);
	    String  errorMessage = rs.jsonPath().get("message").toString();// user email id can be further described 
	    System.out.println(errorMessage);
	    Assert.assertEquals(errorMessage, "[can't be blank, can't be blank, can't be blank, can be male or female, can't be blank]" );

	    

	 }
	
	public static void errorBody(Response rs, String fileName) throws FileNotFoundException
	{
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/"+fileName);
		String body = rs.jsonPath().get().toString();
		System.out.println("*******");
		System.out.println(data.toString()+"---------========");
		Assert.assertTrue(body.contains(rs.toString()), "error body does not matches");
		
	}
	
	
	 public static void validateResponseMessage(Response rs, String errorMessage)
		{ 
			
		    if(errorMessage.equals("has already been taken"))
			Assert.assertEquals(errorMessage, "", "Success" );
		    
		}
	 

	

	@Test(enabled=false)
	public static void TC02_() throws IOException//Users with same email ID
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/createUser.JSON"); // fetching bodyData.Json file

		// save multiple name as a array of string
//		String[] name= {"Kailash40","Rishabh4"};
//		for (String element : name) {
		String NameElement = "Hart";
		
		String multiple = jsonVariable.jsonVariableReplacement(data, "name", NameElement);// it will take kailash from array first time and after that it will take rishabh
//		String id = jsonVariable.jsonVariableReplacement(multiple, "id", RandomData.randomvalue());// every time generate random number id
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        Response rs = http.PostMethod("users_Post", multiple ); // first time it will load
//		String  errorMessage = rs.jsonPath().get("message").toString();// user email id can be further described 
        JsonPath jp = rs.jsonPath();
        System.out.println(jp.get("message"));
        rs.then().assertThat().statusCode(422).extract().response();
//        com.jayway.jsonpath.JsonPath.read(rs.asString());
//        System.out.println("____________+++++++++++"+jp.get("$[0].message").toString());
//        ArrayList<String> message =jp.get("$.message");
//        message.get(0);
//        message.size();
//        System.out.println(message.size());
//        System.out.println(message.get(0));


//        ArrayList<String> message =jp.get("$.message");
//        System.out.println(message+"____________+++++++++++"+jp.get("$.message") );
//
//        message.get(0);
//        System.out.println(message+"____________+++++++++++"+ message.get(0));
//       validateResponseMessage(rs, message);
        
        // "message": "has already been taken"
        
//		String  errorMessage = rs.getStatusLine().toString();// user email id can be further described 
//				System.out.println(errorMessage);


//       validateSTATUS(rs);
//       validateSameEmail(rs, errorMessage);
        
     
		
}
	
	@Test(enabled=false)
	public void invalidEmail() throws IOException
	{
	
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/invalidEmail.JSON"); // fetching bodyData.Json file
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
	  	Response rs = http.PostMethod("users_Post", data ); // Json file read for boddy data
	  	String  errorMessage = rs.getStatusLine().toString();// user email id can be further described 
		System.out.println(errorMessage);
		System.out.println(rs.then().assertThat().statusCode(422).extract().response());
	  	
	  	
	}
	
	@Test(enabled=false)
	public void fetchEntries() throws IOException
	{

		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file

//       System.out.println(prObject.get("get_Entries")+ "@@@@@@@@@@@@@@@@");
//       https://gorest.co.in/public/v2/users/
        System.out.println(UserId);
        
       System.out.println("before URI*************************************"+http.getMethod("get_Entries", UserId ));

       
  	Response rs = http.getMethod("get_Entries", UserId );// Json file read for boddy data
//    JsonPath jp = rs.jsonPath();
//    System.out.println(jp.get("message")+"&&&&&&&&&&&&&");
    
  	//		resStatus = JsonParsing.parseJson(rs.getBody).asString(), "name");
//	System.out.println(rs.jsonPath().get("name").toString());
//	System.err.println(rs.body());
//  	String uri = prObject.getProperty();
       
//	Response rs =
//	 given()
//	.headers(
//              "Authorization",
//              "Bearer " + "3f2c904d827497149daaab07f336fb946ab9d18dc4daa3a55f5bc334f48dc29f",
//              "Content-Type",
//              ContentType.JSON,
//              "Accept",
//              ContentType.JSON)
//	.when()
//	.get("https://gorest.co.in/public/v2/users/"+UserId);
//	rs.prettyPeek();
//	validateSTATUS(rs);
    //rs.prettyPeek().then().assertThat().statusCode(200).extract().response();
	
//  	;
	
	}

	
}







