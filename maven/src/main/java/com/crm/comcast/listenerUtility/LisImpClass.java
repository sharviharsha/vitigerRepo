package com.crm.comcast.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseUtility.BaseClassTest;

public class LisImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM test suit result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report bakeUP");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====" + result.getMethod().getMethodName() + ">===start====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "==>STARTED<===");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====" + result.getMethod().getMethodName() + ">===end====");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + "==>COMPLETED<===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClassTest.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "==>FAILED<===");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}
