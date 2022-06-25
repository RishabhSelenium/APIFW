package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;


public class TC01_GetData {


	// get method for Users
public void testCase() throws IOException {
Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
HTTPMethods hm = new HTTPMethods(p);
Response rs = hm.getAllMethod("UsersPost");
System.out.println("test case TC01 Get data--------");
System.out.println(rs.getStatusCode());
System.out.println("response data is --");
System.out.println(rs.asString());

	}	


public void postUsers()
{
	
	
	
	}


}
