package com.automation.framework;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserFactory{
				
	public static WebDriver createInstance(String browser){
		WebDriver driver = null;
		try {
			if(browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			    options.addArguments("--start-maximized");
			    options.addArguments("--disable-notifications");
			    options.addArguments("--incognito");
			    driver=new ChromeDriver(options);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return driver;
		}
		return driver;
	}

	
}
