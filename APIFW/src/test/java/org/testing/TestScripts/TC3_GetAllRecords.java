package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;

public class TC3_GetAllRecords {
	public void testcase3() throws IOException {
		Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
	    HTTPMethods http = new HTTPMethods(p);
	    Response rs = http.getAllMethod("QA_URI_Managers");
	    System.out.println("this is test case 3---------");
	    System.out.println("status code is--");
	    System.out.println(rs.statusCode());
	    
	    
	}
}
