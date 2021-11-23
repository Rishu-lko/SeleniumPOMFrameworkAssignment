package com.automation.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
import com.test.utils.Utility;

public class WalletHubReviewTest_Assignment_2 extends BaseClass {

	@BeforeMethod
	public void beforeTest(Method testMethod) throws IOException 
	{
		InitLogger.initializeLogger(testMethod.getName());		
		LoggerFactory.getInstance().debug("Testcase starting ---> "+ testMethod.getName());						
		TestDataFactory.getInstance().getApplicationTestData(testMethod.getName());
		super.testData = TestDataFactory.getInstance().getTestData();
		DriverFactory.getInstance().getDriver().get(super.testData.get("url"));
	}
	
	@Test(description="WalletHub Review Test - Assignment 2")
	public void wallethubReviewTest(Method method) throws IOException, Exception {
		pageObjectManager = new PageManagerClass(DriverFactory.getInstance().getDriver(),ExtentTestFactory.getInstance().getExtentTest());
		pageObjectManager.getWalletHubLoginPage().enterLoginUserId(super.testData.get("emailId"));
		pageObjectManager.getWalletHubLoginPage().enterLoginPassword(super.testData.get("loginPassword"));
		pageObjectManager.getWalletHubLoginPage().clickOnRememberMeToggleButton();
		pageObjectManager.getWalletHubLoginPage().clickOnLoginButton();
		pageObjectManager.getWalletHubProfileHomePage().verifyAccountNameText(super.testData.get("accountName"));
		pageObjectManager.getWalletHubProfileHomePage().navigateToReviewProfile(super.testData.get("reviewProfileURL"));
		pageObjectManager.getWalletHubProfileHomePage().clickOnReviewNavMenu();
		pageObjectManager.getWalletHubProfileHomePage().moveHoverOnFourStarRating();
		pageObjectManager.getWalletHubProfileHomePage().verifyAllFourRatingStarHighlightedOnMouseHover();
		pageObjectManager.getWalletHubProfileHomePage().clickOnFourStarRating();
		pageObjectManager.getWalletHubReviewPage().clickOnPolicyDropdown();
		pageObjectManager.getWalletHubReviewPage().clickOnPolicyDropdownValue(super.testData.get("policyDropdownValueToBeSelected"));
		pageObjectManager.getWalletHubReviewPage().enterReviewText(super.testData.get("reviewText"));
		pageObjectManager.getWalletHubReviewPage().clickOnReviewSubmitButton();
		pageObjectManager.getWalletHubReviewPage().verifyReviewPostedSuccessMessage();
		pageObjectManager.getWalletHubReviewPage().mouseHoverOnUserDropdownMenu();
		pageObjectManager.getWalletHubReviewPage().clickOnUserDropdownProfileLink();
		pageObjectManager.getWalletHubProfileHomePage().verifyLatestReviewFeedOnSelfProfile(super.testData.get("reviewCompanyName"));
		pageObjectManager.getWalletHubProfileHomePage().clickOnLatestReviewFeedOnSelfProfile(super.testData.get("reviewCompanyName"));
		pageObjectManager.getWalletHubProfileHomePage().verifyReviewText(super.testData.get("reviewText"));
		pageObjectManager.getWalletHubProfileHomePage().clickOnReviewTextEditButton();
		pageObjectManager.getWalletHubProfileHomePage().clearReviewTextArea();
		pageObjectManager.getWalletHubProfileHomePage().clickOnReviewTextSubmitButton();
		pageObjectManager.getWalletHubProfileHomePage().waitForReviewTextAreaDisappeared();
		pageObjectManager.getWalletHubProfileHomePage().verifyReviewTextRemoved(super.testData.get("reviewText"));
		pageObjectManager.getWalletHubReviewPage().mouseHoverOnUserDropdownMenu();
		pageObjectManager.getWalletHubReviewPage().clickOnUserDropdownLogoutLink();
		pageObjectManager.getWalletHubLoginPage().verifySignUpButton();
	}

	@AfterMethod
	public void afterEachTest(Method testMethod) throws IOException 
	{
		InitLogger.endTestCase(testMethod.getName());
		TestDataFactory.getInstance().removeTestData();
		LoggerFactory.getInstance().removeCurrentLogger();
	}
}
