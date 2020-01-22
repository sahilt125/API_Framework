package com.api.wrapper;

import com.api.tests.BaseClass;
import com.api.util.ReadWriteInFile;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIClass extends BaseClass {

	public static Response apiGetMethod(String URI, String header_content_type, String scenarioName) {
		addLog("Request URL : " + URI);
		addLog("Header Content : " + header_content_type);
		addLog("Method : GET");
		Response API_response = RestAssured.given().header("content-type", header_content_type).get(URI);
		addLog("Response Status Code : " + API_response.getStatusCode());
		addLog("Response Body : "+API_response.asString());
		if (API_response.getStatusCode() == 200) {
			
		} else {
			try {
				throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ReadWriteInFile.writeResponseInFile(API_response.asString(), scenarioName);
		return API_response;
	}

	public static Response apiPOSTMethod(String URI, String header_content_type, String request_body, String scenarioName) {
		addLog("Request URL : " + URI);
		addLog("Header Content : " + header_content_type);
		addLog("Method : POST");
		addLog("Request Body : "+ request_body);
		Response API_response = RestAssured.given().header("content-type", header_content_type).body(request_body)
				.post(URI);
		addLog("Response Status Code : " + API_response.getStatusCode());
		addLog("Response Body : "+API_response.asString());
		if (API_response.getStatusCode() == 200 || API_response.getStatusCode() == 201) {
			
		} else {
			try {
				throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ReadWriteInFile.writeResponseInFile(API_response.asString(), scenarioName);
		return API_response;
	}

	public static Response apiDeleteMethod(String URI, String header_content_type, String scenarioName) {
		addLog("Request URL : " + URI);
		addLog("Header Content : " + header_content_type);
		addLog("Method : DELETE");
		Response API_response = RestAssured.given().header("content-type", header_content_type).delete(URI);
		addLog("Response Status Code : " + API_response.getStatusCode());
		addLog("Response Body : "+API_response.asString());
		if (API_response.getStatusCode() == 200 || API_response.getStatusCode() == 201) {
			
		} else {
			try {
				throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ReadWriteInFile.writeResponseInFile(API_response.asString(), scenarioName);
		return API_response;
	}

}
