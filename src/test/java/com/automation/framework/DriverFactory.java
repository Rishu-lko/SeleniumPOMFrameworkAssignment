package com.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.utils.PropertyReader;

public class DriverFactory {

	private static DriverFactory driverFactory = null;

	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		if (driverFactory == null) {
			synchronized (DriverFactory.class) {
				if (driverFactory == null) {
					driverFactory = new DriverFactory();
				}
			}

		}
		return driverFactory;

	}
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public void setDriver(WebDriver remoteDriver) {
		driver.set(remoteDriver);
	} 
	
	public WebDriver getDriver() {
		return driver.get();
	} 
	
	public void removeDriver() {
		driver.get().quit();
		driver.remove();
	}
}
