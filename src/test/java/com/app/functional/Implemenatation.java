package com.app.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Implemenatation extends TestBase {
	
	public RequestSpecification setHeaders() {
		// to bypass the SSL certificate
	//	requestSpecBuilder.setRelaxedHTTPSValidation();
		
		RequestSpecification request = RestAssured.given(requestSpecBuilder.build());
		//request.headers("") -> Globalaproperties
		
		//list initiliaze  
		List<Header> headerList = new ArrayList<Header>();
		
		//-> lambda expression in java -8 
		//it will convert the two line of code into single line
		//forach -> loop 
		//enteryset() -> foreachloop
		 GlobalProperties.getGlobalHeaders()
		 .forEach((key,value) -> headerList.add( new Header(key, value)));
		//headerList.add( new Header(key, value)));

		Headers headers= new Headers(headerList);
		return request.headers(headers);
	}
	
	public Response getTest() {
		RequestSpecification request = setHeaders();
		request.log().all();
		Response response = null;
		response= request.get(RestAssured.baseURI+RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setGlobalResponse(response);
		return response;
		
	}
	
	public Response postTest() {
		RequestSpecification request = setHeaders();
		request.body(GlobalProperties.getInputpayload());
		request.log().all();
		Response response = null;
		response= request.post(RestAssured.baseURI+RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setGlobalResponse(response);
		return response;
		
	}
	
	public Response putTest() {
		RequestSpecification request = setHeaders();
		request.body(GlobalProperties.getInputpayload());
		request.log().all();
		Response response = null;
		response= request.put(RestAssured.baseURI+RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setGlobalResponse(response);
		return response;
		
	}

}
