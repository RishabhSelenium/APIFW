package org.testing.TestScript;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.RandomData;
import org.testing.Utility.jsonVariable;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestCases {



	String UserId, UserName, userEmail;
	
	
	@Test(enabled=false)
	public void createUser() throws IOException // Create new User
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/TC01userData.json"); // fetching bodyData.Json file
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
	  	
	 
	}

	
	public static String methodPost(String UserId, String UserName ) throws IOException // Create new User

	{
		
//		TestCases tc01 = new TestCases();
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/UserPosts.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
        Response rs = http.PostMethod("post_Post", multiple1 );
		 validateSTATUS(rs);
        String postID = (rs.jsonPath().get("id")).toString();
	  	if (UserId.equals(""))
	  	{
	  		errorBody(rs, "postNegative.JSON");
	  	}
	  	return postID;

     

	}
	
	
	public static void methodComment(String userEmail, String postID) throws IOException
	
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userComment.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "email", userEmail);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "post_id", postID );// it will take kailash from array first time and after that it will take rishabh
		 Response rs = http.PostMethod("comments_Post", multiple1 );
		 validateSTATUS(rs);
		
	}
	
	public static void methodTodo(String UserName, String UserId) throws IOException
	
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userTodo.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
		Response rs= http.PostMethod("todos_Post", multiple1 );
		
			
        
		
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
				
		  	
	}
	
	
	
	@Test
	public void userFieldsMissing() throws IOException // Create new User
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/TC01userData.json"); // fetching bodyData.Json file
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
	
	
	


	@Test(enabled=false)
	public void TC02_() throws IOException//Users with same email ID
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/bodyData.JSON"); // fetching bodyData.Json file

		// save multiple name as a array of string
		String[] name= {"Kailash1","Rishabh2"};
		for (String element : name) {
		String multiple = jsonVariable.jsonVariableReplacement(data, "name", element);// it will take kailash from array first time and after that it will take rishabh
		String id = jsonVariable.jsonVariableReplacement(multiple, "id", RandomData.randomvalue());// every time generate random number id
        HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        http.PostMethod("users_Post", id ); // first time it will load

	}
		
}
}
