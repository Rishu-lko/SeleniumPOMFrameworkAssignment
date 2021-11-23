package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.framework.BaseClass;
import com.automation.framework.Keywords;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;

public class FacebookHomePage extends BaseClass{
	
	public FacebookHomePage(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.uioperations = new UIOperations(driver,extentLogger);
		super.propRead = PropertyReader.getInstance();
	}

	public void verifyWelcomeText() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "facebookHomePageWelcomeText",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageWelcomeText"));
	}

	public void clickOnMenuIcon() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookHomePageMenuIcon",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageMenuIcon"));
	}

	public void clickOnPostMenuOption() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookHomePagePostOption",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePagePostOption"));
	}
	
	public void enterPostText(String postText) throws IOException, Exception {
		uioperations.perform(Keywords.SETTEXT, "facebookHomePageCreatePostTextArea",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageCreatePostTextArea"), postText);
	}
	
	public void clickOnCreatePostButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookHomePageCreatePostButton",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageCreatePostButton"));
	}
	
	public void clickOnCreateAccountIcon() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookHomePageAccountIcon",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageAccountIcon"));
	}
	
	public void clickOnSeeYourProfileLink() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookHomePageSeeYourProfileLink",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageSeeYourProfileLink"));
	}
	
	public void clickOnLogOutLink() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "facebookHomePageLogOutLink",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageLogOutLink"));
	}
	
	public void waitForCreatePostPopUpToDisappear() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTNOTPRESENT, "facebookHomePageCreatePostPopUp",
				propRead.getORProperty("FacebookHomePageOR", "facebookHomePageCreatePostPopUp"));
	}
}
