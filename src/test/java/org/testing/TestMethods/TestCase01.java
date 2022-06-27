package org.testing.TestMethods;

import java.io.IOException;
import java.util.Properties;

import org.testing.Assertions.TestCaseValidate;
import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.JsonVariable;

import io.restassured.response.Response;

public class TestCase01 {

	
	  //This method will create new user
       public Response MethodUser(String UserName, String email) throws IOException
      {
 	      
 	        Properties prObject = LoadPropertiesFile.handlePropertyFile("../APIFW/src/URI.properties");//Load Properties file to get the URI 
		String data =  LoadJsonFile.handleJsonFile("../APIFW/src/test/java/org/testing/Resources/createUser.JSON"); // Loading JSON file 
                HttpMethods http = new HttpMethods(prObject); // This require the object of property file
	        String multiple = JsonVariable.jsonVariableReplacement(data, "name", UserName); //replacing value of name in JSON
	        String multiple1 = JsonVariable.jsonVariableReplacement(multiple, "email", email);//replacing value of email in JSON
	  	Response rs = http.PostMethod("users_Post", multiple1 ); // calling post method
               TestCaseValidate.validateSTATUS(rs);
	  	
	       if (rs.statusCode()==422)
                {
	            String  errorMessage = rs.jsonPath().get("message").toString();
	            TestCaseValidate.validateErroMessage(errorMessage, "[can't be blank, can't be blank]");// Validating the errorMessage
                }  


	  	return rs;
      }
	
	//This is method will create new post
	public String methodPost(String UserId, String UserName ) throws IOException 
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../APIFW/src/URI.properties");//Load Properties file to get the URI 
		String data =  LoadJsonFile.handleJsonFile("../APIFW/src/test/java/org/testing/Resources/UserPosts.json"); // Loading JSON file 
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
		String multiple = JsonVariable.jsonVariableReplacement(data, "user", UserName); //replacing value of user in JSON
		String multiple1 = JsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// replacing value of user_id on JSON
                Response rs = http.PostMethod("post_Post", multiple1 );
                String postID = (rs.jsonPath().get("id")).toString();

	        if (rs.statusCode()==422)
	         {
		     String  errorMessage = rs.jsonPath().get("message").toString();
		     TestCaseValidate.validateErroMessage(errorMessage, "[must exist, can't be blank, is not a number]");// Validating the errorMessage
	         }
	    
	  	return postID;
    }
	
	
	//This method will create new Comment
        public void methodComment(String userEmail, String postID) throws IOException
	
	{
		Properties prObject = LoadPropertiesFile.handlePropertyFile("../APIFW/src/URI.properties"); //Load Properties file to get the URI 
		String data =  LoadJsonFile.handleJsonFile("../APIFW/src/test/java/org/testing/Resources/userComment.json"); // Loading JSON file 
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
                String multiple = JsonVariable.jsonVariableReplacement(data, "email", userEmail); //replacing value of email in JSON
		String multiple1 = JsonVariable.jsonVariableReplacement(multiple, "post_id", postID ); //replacing value of post_id in JSON
		Response rs = http.PostMethod("comments_Post", multiple1 );
		
	        if (rs.statusCode()==422)
                {
		     String  errorMessage = rs.jsonPath().get("message").toString();
	             TestCaseValidate.validateErroMessage(errorMessage, "[must exist, can't be blank, is not a number, can't be blank, is invalid]");// Validating the errorMessage
	        }
		
	}
        
        
        //This method will create new Todo
        public void methodTodo(String UserName, String UserId) throws IOException
    	
        {
           	Properties prObject = LoadPropertiesFile.handlePropertyFile("../APIFW/src/URI.properties"); //Load Properties file to get the URI 
        	String data =  LoadJsonFile.handleJsonFile("../APIFW/src/test/java/org/testing/Resources/userTodo.json"); // Loading JSON file
        	HttpMethods http = new HttpMethods(prObject); 
                String multiple = JsonVariable.jsonVariableReplacement(data, "user", UserName);//replacing value of user in JSON
        	String multiple1 = JsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );//replacing value of user_id in JSON
        	Response rs= http.PostMethod("todos_Post", multiple1 ); 
   
                if (rs.statusCode()==422)
                 {
	             String  errorMessage = rs.jsonPath().get("message").toString();
	             TestCaseValidate.validateErroMessage(errorMessage, "[must exist, can't be blank, is not a number]");// Validating the errorMessage
                 }
      
      }
        
      
	

}
