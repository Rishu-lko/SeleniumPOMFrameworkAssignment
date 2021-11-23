package com.test.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.BaseClass;

public class Utility extends BaseClass{
	private static Utility util = null;

	private Utility() {
		propRead = PropertyReader.getInstance();
	}

	public static Utility getInstance() {
		if (util == null) {

			synchronized (Utility.class) {
				if (util == null) {
					util = new Utility();
				}
			}

		}
		return util;

	}

	public WebElement waitForPresenceOfElement(WebDriver driver, By locator) throws InterruptedException, NumberFormatException, IOException {
		Wait wait = new WebDriverWait(driver, Integer.parseInt(propRead.getConfigProperty("waitTimeOut")));
		WebElement element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		this.highlight(driver, element);
		return element;
	}
	
	public void waitForInvisibilityOfElement(WebDriver driver, By locator) throws NumberFormatException, IOException  {
		Wait wait = new WebDriverWait(driver, Integer.parseInt(propRead.getConfigProperty("waitTimeOut")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(WebDriver driver, By locator) throws InterruptedException, NumberFormatException, IOException {
		Wait wait = new WebDriverWait(driver, Integer.parseInt(propRead.getConfigProperty("waitTimeOut")));
		WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
		this.highlight(driver, element);
		return element;
	}

	public void highlight(WebDriver driver, WebElement element) throws InterruptedException {
		final int wait1 = 120;
		final int wait2 = 60;
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"background-color: yellow; outline: 1px solid rgb(136, 255, 136);");
		TimeUnit.MILLISECONDS.sleep(wait1);

		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
		TimeUnit.MILLISECONDS.sleep(wait2);

		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"background-color: yellow; outline: 1px solid rgb(136, 255, 136);");
		TimeUnit.MILLISECONDS.sleep(wait1);

		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
		TimeUnit.MILLISECONDS.sleep(wait2);

	}
	
	public String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}
}
