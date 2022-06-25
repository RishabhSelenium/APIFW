package org.testing.TestScript;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.testing.TestSteps.HttpMethods;
import org.testing.Utility.JsonParsing;
import org.testing.Utility.LoadJsonFile;
import org.testing.Utility.LoadPropertiesFile;
import org.testing.Utility.RandomData;
import org.testing.Utility.jsonVariable;

import io.restassured.response.Response;

public class TestCases {

		
			
	String UserId,UserName;
	
	public void TC01() throws IOException // Create new User
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/TC01userData.json"); // fetching bodyData.Json file 
		
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
//		String name = "Avi";
//		String name_var = jsonVariable.jsonVariableReplacement(data, "name", name);// it will take kailash from array first time and after that it will take rishabh
       
//		String  userBody = jsonVariable.jsonVariableReplacement(name_var, "id", RandomData.randomvalue());
	  	Response rs = http.PostMethod("users_Post", data ); // Json file read for boddy data 
	  	UserId = (rs.jsonPath().get("id")).toString();
	  	UserName = rs.jsonPath().get("name").toString();
	  	System.out.println(UserId + UserName);
	  	System.out.println("we are inside 01");
	  	TC01_Post(UserId,UserName);
	  	
//	  	return Arrays.asList(UserId,UserName);
	  	
//	  	String id = JsonParsing.parseJson(rs.asString(), "id");
//	  	System.out.println(id);
	  
	}
	
	public static void TC01_Post(String UserId, String UserName ) throws IOException // Create new User
	
	{
//		TestCases tc01 = new TestCases();
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/UserPosts.json"); // fetching bodyData.Json file 
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
		
		String multiple = jsonVariable.jsonVariableReplacement(data, "user", UserName);// it will take kailash from array first time and after that it will take rishabh
		String multiple1 = jsonVariable.jsonVariableReplacement(multiple, "user_id", UserId );// it will take kailash from array first time and after that it will take rishabh
        http.PostMethod("post_Post", multiple1 );
        System.out.println("we are in 02");
	  	System.out.println(UserId + UserName);

        
	}
	
	
	
	public void TC02_() throws IOException//Users with same email ID 
	{
		Properties prObject =	LoadPropertiesFile.handlePropertyFile("../RishabhAssignment/src/URI.properties"); // this is returning the Object of properties file
		String data =  LoadJsonFile.handleJsonFile("../RishabhAssignment/src/test/java/org/testing/Resources/bodyData.JSON"); // fetching bodyData.Json file 
		
		// save multiple name as a array of string
		String[] name= {"Kailash1","Rishabh2"};
		
		for(int i =0;i<name.length;i++) {
		String multiple = jsonVariable.jsonVariableReplacement(data, "name", name[i]);// it will take kailash from array first time and after that it will take rishabh
		String id = jsonVariable.jsonVariableReplacement(multiple, "id", RandomData.randomvalue());// every time generate random number id 
		
		
		
		HttpMethods http = new HttpMethods(prObject); // this require the object of property file
		
		
		http.PostMethod("users_Post", id ); // first time it will load
		
	}
		
	}
}
