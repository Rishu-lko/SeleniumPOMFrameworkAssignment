package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.framework.BaseClass;
import com.automation.framework.Keywords;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;
import com.test.utils.Utility;

public class WalletHubReviewPage extends BaseClass{
	
	public WalletHubReviewPage(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.uioperations = new UIOperations(driver,extentLogger);
		super.propRead = PropertyReader.getInstance();
	}

	public void clickOnPolicyDropdown() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubReviewPagePolicyDropdown",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPagePolicyDropdown"));
	}
	
	public void clickOnPolicyDropdownValue(String dropdownValue) throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubReviewPagePolicyDropdownValue",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPagePolicyDropdownValue").replace("parameterizedText", dropdownValue));
	}

	public void enterReviewText(String reviewText) throws IOException, Exception {
		sharedDataMap.put("ReviewTimeStamp", Utility.getInstance().now("dd-MMMMM-yyyy hh:mm:ss aaa z"));
		uioperations.perform(Keywords.SETTEXT, "wallethubReviewPageReviewTextArea",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPageReviewTextArea"), sharedDataMap.get("ReviewTimeStamp")+" "+reviewText);
	}
		
	public void clickOnReviewSubmitButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubReviewPageSubmitButton",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPageSubmitButton"));
    }
	
	public void verifyReviewPostedSuccessMessage() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubReviewPageReviewSuccessfullyPostedMessage",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPageReviewSuccessfullyPostedMessage"));
	}
	
	public void mouseHoverOnUserDropdownMenu() throws IOException, Exception {
		uioperations.perform(Keywords.MOUSEHOVER, "wallethubReviewPageUserDropdownMenu",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPageUserDropdownMenu"));
    }
	
	public void clickOnUserDropdownProfileLink() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubReviewPageUserDropdownProfileLink",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPageUserDropdownProfileLink"));
    }
	
	public void clickOnUserDropdownLogoutLink() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubReviewPageUserDropdownLogoutLink",
				propRead.getORProperty("WalletHubReviewPageOR", "wallethubReviewPageUserDropdownLogoutLink"));
    }
	
}
