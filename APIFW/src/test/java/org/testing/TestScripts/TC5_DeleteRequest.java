package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;

public class TC5_DeleteRequest {

	public void testCase5() throws IOException
	{
		Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
	    HTTPMethods http = new HTTPMethods(p);
		Response rs =http.deleteMethod("QA_URI_Managers", TC1_PostRequest.respIDvalue);
		System.out.println("test case 5--------");
		System.out.println(rs.getStatusCode());
		
		
	}
}
