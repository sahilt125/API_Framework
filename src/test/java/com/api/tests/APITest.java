package com.api.tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.api.util.ReadEnvProperty;
import com.api.util.ReadWriteInFile;
import com.api.wrapper.APIClass;
import com.jayway.jsonpath.JsonPath;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class APITest extends BaseClass {
	ReadEnvProperty env = new ReadEnvProperty();
	@Test
	public void getPageAPI() {
		String URI = env.getProperties("domain_url") + "unknown";
		String content_type = env.getProperties("content_type");
		Response apiResponse = APIClass.apiGetMethod(URI, content_type, method.getName());

	}

	@Test
	public void postUserAPI() throws Exception {
		String URI = env.getProperties("domain_url") + "users";
		String content_type = env.getProperties("content_type");
		String requestBody = ReadWriteInFile.readRequestFromFileFiles("postUserAPI_request.txt");
		Response apiResponse = APIClass.apiPOSTMethod(URI, content_type, requestBody, method.getName());
	}

}
