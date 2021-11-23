package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.framework.BaseClass;
import com.automation.framework.Keywords;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;

public class WalletHubProfileHomePage extends BaseClass{
	
	public WalletHubProfileHomePage(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.uioperations = new UIOperations(driver,extentLogger);
		super.propRead = PropertyReader.getInstance();
	}

	public void verifyAccountNameText(String accountName) throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageAccountName",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageAccountName").replace("parameterizedText", accountName));
	}
	
	public void navigateToReviewProfile(String reviewreviewProfileURL) throws IOException, Exception {
		uioperations.perform(Keywords.GOTOURL, "wallethubReviewPageURL",null,reviewreviewProfileURL);
	}

	public void clickOnReviewNavMenu() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubProfileHomePageReviewsNavMenu",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewsNavMenu"));
	}
	
	public void moveHoverOnFourStarRating() throws IOException, Exception {
		uioperations.perform(Keywords.MOUSEHOVER, "wallethubProfileHomePageFourStarRating",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageFourStarRating"));
	}
	
	public void verifyAllFourRatingStarHighlightedOnMouseHover() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageOneStarRatingHighlighted",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageOneStarRatingHighlighted"));
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageTwoStarRatingHighlighted",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageTwoStarRatingHighlighted"));
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageThreeStarRatingHighlighted",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageThreeStarRatingHighlighted"));
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageFourStarRatingHighlighted",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageFourStarRatingHighlighted"));
	}
	
	public void clickOnFourStarRating() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubProfileHomePageFourStarRating",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageFourStarRating"));
	}
	
	public void verifyLatestReviewFeedOnSelfProfile(String reviewCompanyName) throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageLatestReviewFeed",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageLatestReviewFeed").replace("parameterizedText", reviewCompanyName));
	}
	
	public void clickOnLatestReviewFeedOnSelfProfile(String reviewCompanyName) throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubProfileHomePageLatestReviewFeed",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageLatestReviewFeed").replace("parameterizedText", reviewCompanyName));
	}
	
	public void verifyReviewText(String reviewText) throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTPRESENT, "wallethubProfileHomePageReviewText",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewText").replace("parameterizedText", sharedDataMap.get("ReviewTimeStamp")+" "+reviewText));
	}
	
	public void clickOnReviewTextEditButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubProfileHomePageReviewTextEditButton",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewTextEditButton"));
	}
	
	public void clearReviewTextArea() throws IOException, Exception {
		uioperations.perform(Keywords.CLEARTEXTBYACTION, "wallethubProfileHomePageReviewTextArea",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewTextArea"));
	}

	public void clickOnReviewTextSubmitButton() throws IOException, Exception {
		uioperations.perform(Keywords.CLICK, "wallethubProfileHomePageReviewTextSubmitButton",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewTextSubmitButton"));
	}
	
	public void waitForReviewTextAreaDisappeared() throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTNOTPRESENT, "wallethubProfileHomePageReviewTextArea",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewTextArea"));
	}
	
	public void verifyReviewTextRemoved(String reviewText) throws IOException, Exception {
		uioperations.perform(Keywords.VERIFYELEMENTNOTPRESENT, "wallethubProfileHomePageReviewText",
				propRead.getORProperty("WalletHubProfileHomePageOR", "wallethubProfileHomePageReviewText").replace("parameterizedText", sharedDataMap.get("ReviewTimeStamp")+" "+reviewText));
	}
	
}
