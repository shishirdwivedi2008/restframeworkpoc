package com.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest {


	private Config testConfig;
	
	private Rest() {
		
	}
	
	public static RestBuilder build(Config testConfig) {
		return new RestBuilder(testConfig);
	}
	
	public static class RestBuilder{
		private Config testConfig;
		private Map<String, String> body=new HashMap<>();
		private Map<String, String> header=new HashMap<>();
		String jsonBody=null;
		
		
		public RestBuilder(Config testConfig) {
			this.testConfig=testConfig;
		}
		
		public PojoBase GET(String uri) {
			String finalUrl=testConfig.getRunTimeProperty("app.baseUrl")+uri;
			testConfig.log("Starting GET Rest Call on URL"+ finalUrl);
			Response response=RestAssured.given().headers(getHeader()).body(getBody()).get(finalUrl);
			testConfig.log("Response Received "+ response.asString());
			return new PojoBase(response);
		}
		
		
		public PojoBase POST(String uri) {
			String finalUrl=testConfig.getRunTimeProperty("app.baseUrl")+uri;
			testConfig.log("Starting POST Rest Call on URL"+ finalUrl);
			Response response=RestAssured.given().headers(getHeader()).body(getBody()).post(finalUrl);
			testConfig.log("Response Received "+ response.asString());
			return new PojoBase(response);
		}


		public Map<String, String> getBody() {
			return body;
		}


		public RestBuilder setBody(String key, String value) {
			this.body.put(key, value);
			return this;
		}
		
		public RestBuilder setHeader(String key,String value) {
			this.header.put(key, value);
			return this;
		}
		
		public Map<String, String> getHeader(){
			return header;
		}
		
		
		public RestBuilder setJsonBody(String json) {
			this.jsonBody=json;
			return this;
		}
		
		public String getJsonBody() {
			return this.jsonBody;
		}
		
		
	}
}
