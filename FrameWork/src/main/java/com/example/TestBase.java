package com.example;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestBase {

	ThreadLocal<Config> testConfig=new ThreadLocal<>();
	
	@DataProvider(name = "TestConfig")
	public Object [][] getTestConfig(Method method){
		Config testConfig=new Config(method);
		this.testConfig.set(testConfig);
		return new Config [][] {{testConfig}};
		
		 
	}
}
