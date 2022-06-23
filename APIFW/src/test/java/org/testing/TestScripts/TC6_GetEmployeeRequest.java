package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFiles;

import io.restassured.response.Response;

public class TC6_GetEmployeeRequest {
public void testCase6() throws IOException
{
	Properties p = LoadPropertiesFiles.hadnlePropertieFile("../APIFW/URI.properties");
    HTTPMethods http = new HTTPMethods(p);
    Response rs = http.getTestMethod("QA_URI_Employee");
    System.out.println("this is test case 6---------");
    System.out.println("status code is--");
    System.out.println(rs.statusCode());
   // System.out.println(rs.asString());
    
    List<Integer> ids = rs.jsonPath().getList("id");

    for(Integer i:ids)
    {

        System.out.println(i);
    }
    
	}
}
