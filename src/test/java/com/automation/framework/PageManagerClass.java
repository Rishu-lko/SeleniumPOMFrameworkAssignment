package com.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.pages.FacebookHomePage;
import com.automation.pages.FacebookLoginPage;
import com.automation.pages.FacebookProfilePage;
import com.automation.pages.WalletHubProfileHomePage;
import com.automation.pages.WalletHubReviewPage;
import com.automation.pages.WalletHubLoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;

public class PageManagerClass extends BaseClass{

	private FacebookLoginPage facebookLoginPage = null;
	private FacebookHomePage facebookHomePage = null;
	private FacebookProfilePage facebookProfilePage = null;
	private WalletHubLoginPage wallethubLoginPage = null;
	private WalletHubProfileHomePage wallethubProfileHomePage = null;
	private WalletHubReviewPage wallethubReviewPage = null;
	
			
	public PageManagerClass(WebDriver driver,ExtentTest extentLogger){
		super.driver = driver;
		super.extentLogger = extentLogger;
	}
 
	
	public FacebookLoginPage getFacebookLoginPage() {

		return (facebookLoginPage == null) ? facebookLoginPage = new FacebookLoginPage(super.driver,super.extentLogger) : facebookLoginPage;

	}
	
	public FacebookHomePage getFacebookHomePage() {

		return (facebookHomePage == null) ? facebookHomePage = new FacebookHomePage(super.driver,super.extentLogger) : facebookHomePage;

	}

	public FacebookProfilePage getFacebookProfilePage() {

		return (facebookProfilePage == null) ? facebookProfilePage = new FacebookProfilePage(super.driver,super.extentLogger) : facebookProfilePage;

	}

	public WalletHubLoginPage getWalletHubLoginPage() {

		return (wallethubLoginPage == null) ? wallethubLoginPage = new WalletHubLoginPage(super.driver,super.extentLogger) : wallethubLoginPage;

	}
	
	public WalletHubProfileHomePage getWalletHubProfileHomePage() {

		return (wallethubProfileHomePage == null) ? wallethubProfileHomePage = new WalletHubProfileHomePage(super.driver,super.extentLogger) : wallethubProfileHomePage;

	}
	

	public WalletHubReviewPage getWalletHubReviewPage() {

		return (wallethubReviewPage == null) ? wallethubReviewPage = new WalletHubReviewPage(super.driver,super.extentLogger) : wallethubReviewPage;

	}
}
