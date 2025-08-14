package com.app.functional;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GenerateOauth extends TestBase {
	
	public String getOauthOkenEndpoint() {
		RestAssured.proxy("http:proxy.tcs.com",8000);
		requestSpecBuilder.setRelaxedHTTPSValidation();
		String res="";
		Response response = RestAssured.given(requestSpecBuilder.build())
		.baseUri("")
		.formParam("", "")
		.formParam("", "")
		.formParam("", "")
		.formParam("", "").contentType(ContentType.URLENC)
		.accept(ContentType.JSON).post();
		return response.jsonPath().getString("access_token");
		
		/*
		 * //Raw - > body, form K V -> formparam
		 * RestAssured.given().baseUri("").formParam("", "")
		 * .contentType(ContentType.URLENC) .accept(ContentType.JSON).post()
		 */
		
	}

}
