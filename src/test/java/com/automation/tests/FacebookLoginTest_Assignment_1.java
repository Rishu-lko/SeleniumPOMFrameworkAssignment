package com.automation.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.framework.BaseClass;
import com.automation.framework.DriverFactory;
import com.automation.framework.ExtentTestFactory;
import com.automation.framework.InitLogger;
import com.automation.framework.LoggerFactory;
import com.automation.framework.MyLogger;
import com.automation.framework.PageManagerClass;
import com.automation.framework.TestDataFactory;
import com.test.utils.PropertyReader;

public class FacebookLoginTest_Assignment_1 extends BaseClass{
	
	@BeforeMethod
	public void beforeEachTest(Method testMethod) throws IOException 
	{
		InitLogger.initializeLogger(testMethod.getName());		
		LoggerFactory.getInstance().debug("Testcase starting ---> "+ testMethod.getName());						
		TestDataFactory.getInstance().getApplicationTestData(testMethod.getName());
		super.testData = TestDataFactory.getInstance().getTestData();
		DriverFactory.getInstance().getDriver().get(super.testData.get("url"));		
	}
	
	@Test(description="Facebook Login Test - Assignment 1")
	public void facebookLoginTest(Method method) throws IOException, Exception {	
		pageObjectManager = new PageManagerClass(DriverFactory.getInstance().getDriver(),ExtentTestFactory.getInstance().getExtentTest());
		pageObjectManager.getFacebookLoginPage().enterLoginUserId(super.testData.get("emailId"));
		pageObjectManager.getFacebookLoginPage().enterLoginPassword(super.testData.get("loginPassword"));
		pageObjectManager.getFacebookLoginPage().clickOnLoginButton();
		pageObjectManager.getFacebookHomePage().verifyWelcomeText();
		pageObjectManager.getFacebookHomePage().clickOnMenuIcon();
		pageObjectManager.getFacebookHomePage().clickOnPostMenuOption();
		pageObjectManager.getFacebookHomePage().enterPostText(super.testData.get("post"));
		pageObjectManager.getFacebookHomePage().clickOnCreatePostButton();
		pageObjectManager.getFacebookHomePage().waitForCreatePostPopUpToDisappear();
		pageObjectManager.getFacebookHomePage().clickOnCreateAccountIcon();
		pageObjectManager.getFacebookHomePage().clickOnSeeYourProfileLink();
		pageObjectManager.getFacebookProfilePage().verifyPost(super.testData.get("post"));
		pageObjectManager.getFacebookProfilePage().clickOnActionOnPostIcon(super.testData.get("post"));
		pageObjectManager.getFacebookProfilePage().clickOnActionOnMoveToRecycleBinLink();
		pageObjectManager.getFacebookProfilePage().clickOnActionOnMoveToRecycleBinConfirmButton();
		pageObjectManager.getFacebookProfilePage().verifyPostNotPresent(super.testData.get("post"));
		pageObjectManager.getFacebookHomePage().clickOnCreateAccountIcon();
		pageObjectManager.getFacebookHomePage().clickOnLogOutLink();
		pageObjectManager.getFacebookLoginPage().verifyCreateNewAccountButton();
	}
	
	@AfterMethod
	public void afterEachTest(Method testMethod) throws IOException 
	{
		InitLogger.endTestCase(testMethod.getName());
		TestDataFactory.getInstance().removeTestData();
		LoggerFactory.getInstance().removeCurrentLogger();
	}

}
