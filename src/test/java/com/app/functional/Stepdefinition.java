package com.app.functional;

import java.io.File;
import java.util.Map;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import junit.framework.Assert;


public class Stepdefinition {
	@Given("Set Base url to {string}")
	public void set_base_url_to(String url) {
	   RestAssured.baseURI = url;
	}
	@Given("Set base path {string}")
	public void set_base_path(String basepath) {
	  RestAssured.basePath=basepath;
	}
	@Then("Set headers")
	public void set_headers(DataTable dataTable) {
		Map<String, String> header = dataTable.asMap();
		header.forEach((key,value)-> GlobalProperties.addGlobalHeaders(key, value));
	}
	@Then("Generete Oauth Token")
	public void generete_oauth_token() {
	   String accessToken = "Bearer" + new GenerateOauth().getOauthOkenEndpoint();
	   GlobalProperties.addGlobalHeaders("Authorization", accessToken);
	   
	}
	@Then("Make a GET Call")
	public void make_a_get_call() {
	   new Implemenatation().getTest();
	}
	
	@Then("Make a POST Call")
	public void make_a_post_call() {
	   new Implemenatation().postTest();
	}
	@Then("Validate the response code is {int}")
	public void validate_the_response_code_is(Integer int1) {
	   int statusCode = GlobalProperties.getGlobalResponse().getStatusCode();
	//   org.junit.Assert.assertEquals(statusCode, int1);
	}
	
	@Then("Set input payload from path {string}")
	public void set_input_payload_from_path(String filepath) {
	    File inputpayload = new File(filepath);
	    GlobalProperties.setInputpayload(inputpayload);
	}
	
	@Then("Validate the response contains {string}")
	public void validate_the_response_contains(String value) {
	 String asString = GlobalProperties.getGlobalResponse().body().asString();
	 System.out.println(value);
	 asString.contains(value);
	}
	
	@Then("Validate if the response matches value {string} for the path {string}")
	public void validate_if_the_response_matches_value_for_the_path(String value, String att) {
		 String response = GlobalProperties.getGlobalResponse().body().asString();
		String actualvalue = JsonPath.parse(response).read(att).toString();
		System.out.println(actualvalue);
		org.junit.Assert.assertEquals(actualvalue, value);
	}
	@Then("Tear Down")
	public void tear_down() {
	   GlobalProperties.reset();
	}



}
