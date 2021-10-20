package com.example;

import java.io.IOException;

import com.example.pojo.GetUser;
import com.example.pojo.UserResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class PojoBase {

	
	private Response response;
	public PojoBase(Response response) {
		this.response=response;
	}
	
	
	
	
	public Response getResponse() {
		return response;
	}




	public void setResponse(Response response) {
		this.response = response;
	}




	
}
