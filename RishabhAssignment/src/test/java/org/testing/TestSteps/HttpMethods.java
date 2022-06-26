package org.testing.TestSteps;

// iska explanation
import static io.restassured.RestAssured.given;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HttpMethods {


	Properties prObject;
	public HttpMethods(Properties prObject) { // creating a cunstrutor to fetch the UriKey from propertiesFile

		this.prObject=prObject; // local value of prObject to global
	}

	public Response PostMethod(String uriKey, String bodyData)
	{
		Response res =
		given()
		.headers(
	              "Authorization",
	              "Bearer " + "3f2c904d827497149daaab07f336fb946ab9d18dc4daa3a55f5bc334f48dc29f",
	              "Content-Type",
	              ContentType.JSON,
	              "Accept",
	              ContentType.JSON)

		//.oauth2("3f2c904d827497149daaab07f336fb946ab9d18dc4daa3a55f5bc334f48dc29f")
		.body(bodyData)
		.when()
		.post(prObject.getProperty(uriKey));
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asPrettyString());
		return res;
	}
	
	public Response getMethod(String uriKey, String endPoint)
	{
//		String uri = prObject.getProperty(uriKey)+"/"+endPoint;
//		Response rs =
//		given()
//		.headers(
//	              "Authorization",
//	              "Bearer " + "3f2c904d827497149daaab07f336fb946ab9d18dc4daa3a55f5bc334f48dc29f",
//	              "Content-Type",
//	              ContentType.JSON,
//	              "Accept",
//	              ContentType.JSON)
//		.when()
//		.get(uri);
		String uri = prObject.getProperty(uriKey)+"/"+endPoint;
		Response rs =
				 given()
				.headers(
			              "Authorization",
			              "Bearer " + "3f2c904d827497149daaab07f336fb946ab9d18dc4daa3a55f5bc334f48dc29f",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				.when()
				.get(uri).prettyPeek().then().extract().response();
		return rs;
	}

	

}
