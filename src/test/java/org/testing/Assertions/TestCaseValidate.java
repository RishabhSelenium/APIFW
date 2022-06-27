package org.testing.Assertions;

import org.testng.Assert;

import io.restassured.response.Response;

public class TestCaseValidate {
	
	public static void validateSTATUS(Response rs)
	{
		
		int userResponse_STATUS = rs.getStatusCode();
		if(userResponse_STATUS==201)
		{
		    Assert.assertEquals(userResponse_STATUS, 201,"Success TestCases");

		}
		else if(userResponse_STATUS==422)
		{
		    Assert.assertEquals(userResponse_STATUS, 422, "Negative TestCases");
		    

		}
		else if(userResponse_STATUS==200)
		{
		    Assert.assertEquals(userResponse_STATUS, 200, "Success TestCases");

		}
		
	}
	
	public static void validateErroMessage(String errorMessage, String expectedMsg)
	
	{
	    Assert.assertEquals(errorMessage, expectedMsg );

		
	}
	
	
	
	
}
