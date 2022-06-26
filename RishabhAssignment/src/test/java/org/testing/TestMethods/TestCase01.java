package org.testing.TestMethods;

import java.io.IOException;
import java.util.Properties;

import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.jsonVariable;
import org.testng.Assert;

import io.restassured.response.Response;

public class TestCase01 {
	
	
	
	
	//this is method will create new post
	public String methodPost(String UserId, String UserName ) throws IOException // Create new User

	{
		//Load Properties file to get the URI 
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		//Load JSON file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/UserPosts.json"); // fetching bodyData.Json file
		//Creating object of HttpMethods() to access the post method
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
		String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
        Response rs = http.PostMethod("post_Post", multiple1 );
        String postID = (rs.jsonPath().get("id")).toString();
	  	return postID;
   }
	
        public void methodComment(String userEmail, String postID) throws IOException
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userComment.json"); // fetching bodyData.Json file
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "email", userEmail);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "post_id", postID );// it will take kailash from array first time and after that it will take rishabh
		Response rs = http.PostMethod("comments_Post", multiple1 );
		
	}
        
        public void methodTodo(String UserName, String UserId) throws IOException
    	
    {
    	Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
    	String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userTodo.json"); // fetching bodyData.Json file
    	HttpMethods http = new HttpMethods(prObject); // this require the object of property file
        String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// it will take kailash from array first time and after that it will take rishabh
    	String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
    	Response rs= http.PostMethod("todos_Post", multiple1 );     
    		
    }
        
        public String methodPostFailed(String UserId, String UserName ) throws IOException // Create new User

        {
    		
    		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
    		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/UserPosts.json"); // fetching bodyData.Json file
    		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
            String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// 
    		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
            Response rs = http.PostMethod("post_Post", multiple1 );
            String postID = (rs.jsonPath().get("id")).toString();
            String  errorMessage = rs.jsonPath().get("message").toString();// user email id can be further described 
//    	    System.out.println(errorMessage+"\\\\\\\\\\\\\\\\\\");
    	    Assert.assertEquals(errorMessage, "[must exist, can't be blank, is not a number]" );

    	  	return postID;
       
    	}
        
        public void methodCommentFailed(String userEmail, String postID) throws IOException
    	
    	{
    		Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
    		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userComment.json"); // fetching bodyData.Json file
    		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
            String multiple = jsonVariable.jsonVariableReplacement(data, "email", userEmail);
    		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "post_id", postID );
    		Response rs = http.PostMethod("comments_Post", multiple1 );
    		String  errorMessage = rs.jsonPath().get("message").toString();// user email id can be further described 
//    	    System.out.println(errorMessage+"this is CommentFailed-------");
    	    Assert.assertEquals(errorMessage, "[must exist, can't be blank, is not a number, can't be blank, is invalid]" );
    		
    	}
            
            public void methodTodoFailed(String UserName, String UserId) throws IOException
        	
        {
        	Properties prObject = LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
        	String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/userTodo.json"); // fetching bodyData.Json file
        	HttpMethods http = new HttpMethods(prObject); // this require the object of property file
            String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// it will take kailash from array first time and after that it will take rishabh
        	String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
        	Response rs= http.PostMethod("todos_Post", multiple1 );  
        	String  errorMessage = rs.jsonPath().get("message").toString();// user email id can be further described 
//    	    System.out.println(errorMessage+"this is todo failed----------");
    	    Assert.assertEquals(errorMessage, "[must exist, can't be blank, is not a number]" );
        		
        }	
	
	

}
