package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.example.pojo.GetUser;
import com.example.pojo.UserResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	
	public static Object readJsonAndConvertToPojo(String json, ResponseEnum response) {
		ObjectMapper mapper=new ObjectMapper();
		 switch (response) {
		case USER_CREATION_RESPONSE:
			UserResponse userResponse=null;
			try {
				 userResponse= mapper.readValue(json, UserResponse.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userResponse;
		case GET_USER_RESPONSE:
			GetUser getUser=null;
			try {
				getUser=mapper.readValue(json, GetUser.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getUser;

		default:
			return null;
		}
	}
	
	
	public static Object readJsonFromFileAndConvertToPojo(String filePath, ResponseEnum response) {
		ObjectMapper mapper=new ObjectMapper();
		 switch (response) {
		case USER_CREATION_RESPONSE:
			UserResponse userResponse=null;
			try {
				 userResponse= mapper.readValue(new File(filePath), UserResponse.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userResponse;
		case GET_USER_RESPONSE:
			GetUser getUser=null;
			try {
				getUser=mapper.readValue(new File(filePath), GetUser.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getUser;

		default:
			return null;
		}
	}
	
	public String readJsonFromFile(String filePath) {
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
