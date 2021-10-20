package com.example.tst;

import org.testng.annotations.Test;

import com.example.Config;
import com.example.JsonConverter;
import com.example.PojoBase;
import com.example.ResponseEnum;
import com.example.Rest;
import com.example.TestBase;
import com.example.pojo.GetUser;
import com.example.pojo.UserResponse;

public class TestClass extends TestBase {

	@Test(dataProvider = "TestConfig")
	public void createTest(Config testConfig) {
		
		/* Test Cases are failing because API is not giving Correct Response. */
		
		String uri="/api/users";
		PojoBase pojoBase=Rest.build(testConfig).setBody("name", "morpheus").setBody("job", "leader").POST(uri);
		System.out.println(pojoBase.getResponse().asString());
		UserResponse userResponse=(UserResponse) JsonConverter.readJsonAndConvertToPojo(pojoBase.getResponse().asString(), ResponseEnum.USER_CREATION_RESPONSE);
		
		
		testConfig.softAssert.assertEquals(201, pojoBase.getResponse().getStatusCode());
		testConfig.softAssert.assertEquals("morpheus",userResponse.getName() );
		testConfig.softAssert.assertEquals("leader",userResponse.getJob());
		
		String Id=userResponse.getId();
		String getUserUrl="/api/users/"+Id;
		pojoBase= Rest.build(testConfig).GET(getUserUrl);
		GetUser user = (GetUser) JsonConverter.readJsonAndConvertToPojo(pojoBase.getResponse().asString(), ResponseEnum.GET_USER_RESPONSE);
		
		testConfig.softAssert.assertEquals(200, pojoBase.getResponse().getStatusCode());
		testConfig.softAssert.assertEquals("janet.weaver@reqres.in", user.getData().getEmail());
		
		
	}
}
