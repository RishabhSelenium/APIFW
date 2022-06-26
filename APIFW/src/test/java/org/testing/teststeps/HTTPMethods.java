package org.testing.teststeps;

import static io.restassured.RestAssured.*;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPMethods {
	Properties prObject;
	public HTTPMethods(Properties prObject) {
		this.prObject=prObject;
	
		// TODO Auto-generated constructor stub
	}
public Response postMethod(String uriKey, String bodyData)
{
	Response rs= 
	given()
	.contentType(ContentType.JSON)
	.body(bodyData)
	.when()
	.post(prObject.getProperty(uriKey));
	return rs;
	
	}

public Response getMethod(String uriKey, String endPoint)
{
	String uri = prObject.getProperty(uriKey)+"/"+endPoint;
	Response rs =
	given()
	.contentType(ContentType.JSON)
	.when()
	.get(uri);
	return rs;
}
	
	// for realtime api 
	public Response getMethod(String uriKey, int i, int j)
	{
		String uri = prObject.getProperty(uriKey)+"?"+"noofRecords="+i+"&"+"idStarts="+j;
		Response rs =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uri);
		return rs;
		
	
}
	
	public Response getOneMethod(String uriKey, int i)
	{
		String uri = prObject.getProperty(uriKey);
		Response rs =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uri);
		return rs;
		
	
}
	public Response getTestMethod(String uriKey)
	{
		String uri = prObject.getProperty(uriKey);
		Response rs =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uri);
		return rs;
	}
	
public Response getAllMethod(String uriKey)
{
	String uri = prObject.getProperty(uriKey);
	Response rs =
	given()
	.contentType(ContentType.JSON)
	.when()
	.get(uri);
	return rs;
	
}
public Response putRequest(String bodyData,String uriKey,String endPoint)
{
	String uri = prObject.getProperty(uriKey)+"/"+endPoint;
	Response rs=
	given()
	.contentType(ContentType.JSON)
	.body(bodyData)
	.when()
	.put(uri);
	return rs;
	
}

public Response deleteMethod(String uriKey, String endPoint)
{
	String uri = prObject.getProperty(uriKey)+"/"+endPoint;
	Response rs =
	given()
	.contentType(ContentType.JSON)
	.when()
	.delete(uri);
	return rs;
	
}

}
