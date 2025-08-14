package com.app.functional;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

	/*
	 * public TestBase() {
	 * 
	 * handleProxy();
	 * 
	 * }
	 */

	/*
	 * protected void handleProxy() { String proxyip = "http.proxy.tcs.com"; String
	 * proxyPort = "8000"; if (proxyip != null && proxyPort != null) {
	 * requestSpecBuilder.setProxy(proxyip, Integer.valueOf(proxyPort)); } }
	 */

	protected RequestSpecification getRequest() {
		return RestAssured.given(requestSpecBuilder.build()).relaxedHTTPSValidation().contentType(ContentType.JSON);

	}

}
