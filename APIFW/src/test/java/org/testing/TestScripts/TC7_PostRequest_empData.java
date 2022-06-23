package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;

public class TC7_PostRequest_empData {
static String resStatus;

public void testCase7() throws IOException

{
	Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
	String data = LoadJsonFile.handleJson("../APIFW/src/test/java/org/testing/resources/empData.json");
	HTTPMethods http=new HTTPMethods(p);
	Response rs= http.postMethod("Employee_Post", data);
	resStatus = JsonParsingUsingOrgJson.parseJason(rs.asString(), "status");
	 System.out.println("--------test case 1");
	 System.out.println(rs.statusCode());
	 if(resStatus.equals("success"))
	 {
		 System.out.println("Success");
	 }
	 else {
		System.out.println("Failed");
	}
	 
		 
		
}
}
