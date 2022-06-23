package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;

public class TC9_GetParticular_emp {
	public void testcase9() throws IOException {
		Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
	    HTTPMethods http = new HTTPMethods(p);
//	    Response rs = http.getMethod("Employee_get",3);
//
//	    System.out.println("this is test case 8---------");
	    System.out.println("status code is--");
//	    System.out.println(rs.statusCode());
//	    System.out.println(rs.asString());
//	  
//	    
	    
	}
}
