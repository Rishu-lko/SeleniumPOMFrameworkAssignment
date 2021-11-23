package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.framework.BaseClass;
import com.automation.framework.Keywords;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;

public class FacebookProfilePage extends BaseClass{
	
	public FacebookProfilePage(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.uioperations = new UIOperations(driver,extentLogger);
		super.propRead = PropertyReader.getInstance();
	}

	public void verifyPost(String postText) throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "facebookProfilePagePost",
				propRead.getORProperty("FacebookProfilePageOR", "facebookProfilePagePost").replace("parameterizedText", postText));
	}
	
	public void clickOnActionOnPostIcon(String postText) throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookProfilePageActionOnPostIcon",
				propRead.getORProperty("FacebookProfilePageOR", "facebookProfilePageActionOnPostIcon").replace("parameterizedText", postText));
	}
	
	public void clickOnActionOnMoveToRecycleBinLink() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookProfilePageMoveToRecycleBinPostLink",
				propRead.getORProperty("FacebookProfilePageOR", "facebookProfilePageMoveToRecycleBinPostLink"));
	}
	
	public void clickOnActionOnMoveToRecycleBinConfirmButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookProfilePageMoveToRecycleBinConfirmButton",
				propRead.getORProperty("FacebookProfilePageOR", "facebookProfilePageMoveToRecycleBinConfirmButton"));
	}
	
	public void verifyPostNotPresent(String postText) throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTNOTPRESENT, "facebookProfilePagePost",
				propRead.getORProperty("FacebookProfilePageOR", "facebookProfilePagePost").replace("parameterizedText", postText));
	}

}
