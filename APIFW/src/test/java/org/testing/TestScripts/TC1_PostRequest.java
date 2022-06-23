package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.JsonVariableReplacement;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.LoadPropertiesFiles;
import org.testing.utilities.RandomNumber;

import io.restassured.response.Response;

public class TC1_PostRequest {
	static String respIDvalue;
	public void testcase1() throws IOException {
		Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
		String data = LoadJsonFile.handleJson("../APIFW/src/test/java/org/testing/resources/bodyData.json");
		data = JsonVariableReplacement.jsonReplace(data, "id", RandomNumber.generateRandom());
		HTTPMethods http=new HTTPMethods(p);
		Response rs= http.postMethod("QA_URI_Managers", data);
		 respIDvalue = JsonParsingUsingOrgJson.parseJason(rs.asString(), "id");
		 System.out.println("--------test case 1");
		 System.out.println(rs.statusCode());
		
	}
}
