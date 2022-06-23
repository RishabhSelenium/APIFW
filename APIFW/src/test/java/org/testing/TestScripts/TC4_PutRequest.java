package org.testing.TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonVariableReplacement;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.LoadPropertiesFiles;
import org.testing.utilities.RandomNumber;

import io.restassured.response.Response;

public class TC4_PutRequest {

	public void testcase4() throws IOException
	{
		Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
		String body = LoadJsonFile.handleJson("../APIFW/src/test/java/org/testing/resources/updateBodyData.json");
		body = JsonVariableReplacement.jsonReplace(body, "id", TC1_PostRequest.respIDvalue);
		HTTPMethods http = new HTTPMethods(p);
		Response rs= http.putRequest(body, "QA_URI_Managers", TC1_PostRequest.respIDvalue);
		System.out.println("test case 4-----");
		System.out.println(rs.statusCode());
		System.out.println("body data is");
		System.out.println(rs.asString());

	}
}

