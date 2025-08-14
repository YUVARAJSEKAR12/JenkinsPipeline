package com.app.functional;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class GlobalProperties {
	
	private static Map<String, String> globalHeaders = new HashMap<String, String>();
	private static Response globalResponse = null;
	private static File inputpayload= null;
	public static Map<String, String> getGlobalHeaders() {
		return globalHeaders;
	}
	public static void setGlobalHeaders(Map<String, String> globalHeaders) {
		GlobalProperties.globalHeaders = globalHeaders;
	}
	public static Response getGlobalResponse() {
		return globalResponse;
	}
	public static void setGlobalResponse(Response globalResponse) {
		GlobalProperties.globalResponse = globalResponse;
	}
	public static File getInputpayload() {
		return inputpayload;
	}
	public static void setInputpayload(File inputpayload) {
		GlobalProperties.inputpayload = inputpayload;
	}
	public static void addGlobalHeaders(String key, String value) {
		globalHeaders.put(key, value);
	}
	
	public static void reset() {
		globalHeaders = new HashMap<String, String>();
		globalResponse= null;
		inputpayload= null;
	}
	

}
