package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.framework.BaseClass;
import com.automation.framework.Keywords;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;

public class WalletHubLoginPage extends BaseClass{

	public WalletHubLoginPage(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.uioperations = new UIOperations(driver,extentLogger);
		super.propRead = PropertyReader.getInstance();
	}
		
	public void enterLoginUserId(String loginId) throws IOException, Exception {
		uioperations.perform(Keywords.SETTEXT, "wallethubLoginEmail",
				propRead.getORProperty("WalletHubLoginPageOR", "wallethubLoginEmail"), loginId);
	}

	public void enterLoginPassword(String loginPassword) throws IOException, Exception {
		uioperations.perform(Keywords.SETTEXT, "wallethubLoginPassword",
				propRead.getORProperty("WalletHubLoginPageOR", "wallethubLoginPassword"), loginPassword);
	}

	public void clickOnLoginButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubLoginButton",
				propRead.getORProperty("WalletHubLoginPageOR", "wallethubLoginButton"));
	}
	
	public void clickOnRememberMeToggleButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubRememberMeToggle",
				propRead.getORProperty("WalletHubLoginPageOR", "wallethubRememberMeToggle"));
	}
	
	public void verifySignUpButton() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubSignUpButton",
				propRead.getORProperty("WalletHubLoginPageOR", "wallethubSignUpButton"));
	}
		
}
