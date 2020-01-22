package com.api.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	protected static ExtentReports reports;
	protected static ExtentTest test;
	Method method;

	@BeforeMethod
	public void beforeMethod(Method method) {
		this.method = method;
		test = reports.startTest(method.getName());
	}

	@AfterMethod
	public void afterMethod() {
		reports.endTest(test);
	}

	@BeforeSuite
	public void beforeSuite() {
		reports = new ExtentReports(System.getProperty("user.dir")+"/target/reports/test-"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "-report.html");
	}

	@AfterSuite
	public void afterSuite() {
		reports.flush();
	}
	
	public static void addLog(String log) {
		test.log(LogStatus.INFO, log);
	}

}
