package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Config {

	
	Properties runTimePropety;
	private String methodName;
	public String log;
	public SoftAssert softAssert=new SoftAssert();
	public Config(Method method) {
		runTimePropety=new Properties();
		try {
			runTimePropety.load(new FileInputStream(new File("C:\\PayoutAutomation\\FrameWork\\application.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		methodName=method.getName();
	}
	
	
	public String getRunTimeProperty(String key) {
		return (String) runTimePropety.get("app.baseUrl");
	}
	
	public void logPass(String msg) {
		System.out.println(msg);
		String message= "<font color='Green'>" + msg + "</font></br>";
		Reporter.log(message);
	}
	
	public void log(String msg) {
		System.out.println(msg);
		String message= "<font color='Black'>" + msg + "</font></br>";
		Reporter.log(message);
	}
	public void logFail(String msg) {
		System.out.println(msg);
		String message= "<font color='Red'>" + msg + "</font></br>";
		Reporter.log(message);
	}
	
}
