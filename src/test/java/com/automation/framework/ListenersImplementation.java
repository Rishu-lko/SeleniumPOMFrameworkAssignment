package com.automation.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.commons.io.FileUtils;

public class ListenersImplementation implements ITestListener {
	private static ExtentReports report = null;
	private ExtentTest test = null;

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getDescription());
		ExtentTestFactory.getInstance().setExtentTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestFactory.getInstance().getExtentTest().log(Status.PASS,
				"Test Case : -" + result.getMethod().getDescription() + " is Passed");
		ExtentTestFactory.getInstance().removeExtentTestObj();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL,
				"Test Case : -" + result.getMethod().getDescription() + " is Failed");
		ExtentTestFactory.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());

		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getInstance().getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);

		SimpleDateFormat format = new SimpleDateFormat("dd.MMMMM.yyyy hh mm aaa z");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir") + "/src/test/resources/ErrorScreenshots/"
				+ result.getMethod().getDescription() + "Error_" + actualDate + ".jpeg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExtentTestFactory.getInstance().getExtentTest().addScreenCaptureFromPath(screenshotPath,"Test Case Failure Screenshot");
		ExtentTestFactory.getInstance().removeExtentTestObj();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestFactory.getInstance().getExtentTest().log(Status.SKIP,
				"Test Case : -" + result.getMethod().getDescription() + " is Skipped");
		ExtentTestFactory.getInstance().removeExtentTestObj();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		try {
			report = ExtentReportFactory.setUpExtentReport();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
