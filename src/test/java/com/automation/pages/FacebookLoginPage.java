package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.framework.BaseClass;
import com.automation.framework.Keywords;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;

public class FacebookLoginPage extends BaseClass{

	public FacebookLoginPage(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.uioperations = new UIOperations(driver,extentLogger);
		super.propRead = PropertyReader.getInstance();
	}
		
	public void enterLoginUserId(String loginId) throws IOException, Exception {
		uioperations.perform(Keywords.SETTEXT, "facebookLoginEmail",
				propRead.getORProperty("FacebookLoginPageOR", "facebookLoginEmail"), loginId);
	}

	public void enterLoginPassword(String loginPassword) throws IOException, Exception {
		uioperations.perform(Keywords.SETTEXT, "facebookLoginPassword",
				propRead.getORProperty("FacebookLoginPageOR", "facebookLoginPassword"), loginPassword);
	}

	public void clickOnLoginButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookLoginButton",
				propRead.getORProperty("FacebookLoginPageOR", "facebookLoginButton"));
	}
	
	public void verifyCreateNewAccountButton() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "facebookCreateNewAccountButton",
				propRead.getORProperty("FacebookLoginPageOR", "facebookCreateNewAccountButton"));
	}
	
	
}
