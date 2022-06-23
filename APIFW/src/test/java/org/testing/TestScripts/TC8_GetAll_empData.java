package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;

public class TC8_GetAll_empData {
	static String resStatus;


	public void testcase8() throws IOException {
		Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
	    HTTPMethods http = new HTTPMethods(p);
	    Response rs = http.getTestMethod("Employee_get");
		resStatus = JsonParsingUsingOrgJson.parseJason(rs.asString(), "status");

	    System.out.println("this is test case 8---------");
	    System.out.println("status code is--");
	    System.out.println(rs.statusCode());

	    try {
			List<Integer> ids = rs.jsonPath().getList("id");

			for(Integer i:ids)
			{

			    System.out.println(i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    
	    
	}
}
