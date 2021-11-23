package com.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.automation.framework.BaseClass;
import com.automation.framework.DriverFactory;
import com.automation.framework.ExtentTestFactory;
import com.automation.framework.LoggerFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UIOperations extends BaseClass {

	public UIOperations(WebDriver driver,ExtentTest extentLogger) {
		super.driver = driver;
		super.util = Utility.getInstance();
		super.logger = LoggerFactory.getInstance();
		super.extentLogger= extentLogger;
	}

	public String perform(String operation, String objectName, String objectValue, String... data)
			throws InterruptedException, Exception {
		logger.info("Performing ----> " + operation + " on Element ---> " + objectName);
		String result = null;
		Actions actions = null;
		switch (operation) {
		case "CLICK":
			try {
				util.waitForElementToBeClickable(DriverFactory.getInstance().getDriver(), this.getObject(objectValue))
						.click();
				logger.debug("CLICK operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS, "CLICK operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform CLICK Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform CLICK Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
		case "SETTEXT":
			try {
				util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(), this.getObject(objectValue))
						.sendKeys(data[0]);
				logger.debug("SETTEXT operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS, "SETTEXT operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform SETTEXT Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform SETTEXT Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
		case "SETTEXTBYACTION":
			try {
				actions = new Actions(DriverFactory.getInstance().getDriver());
				actions.moveToElement(util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(),
						this.getObject(objectValue)))
						.sendKeys(util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(),
								this.getObject(objectValue)), data[0])
						.pause(2000).sendKeys(Keys.TAB).build().perform();
				logger.debug("SETTEXTBYACTION operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS, "SETTEXTBYACTION operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform SETTEXTBYACTION Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform SETTEXTBYACTION Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
		case "GOTOURL":
			try {
				DriverFactory.getInstance().getDriver().get(data[0]);
				logger.debug("GOTOURL operation performed Successfully for URL:---> " + data[0]);
				extentLogger.log(Status.PASS, "GOTOURL operation performed Successfully for URL:---> " + data[0]);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform GOTOURL Operation for URL:---> " + data[0]);
				extentLogger.log(Status.FAIL,"Failed to perform GOTOURL Operation for URL:---> " + data[0]);
				throw new Exception(e.toString());
			}
		case "GETTEXT":
			try {
				result = util
						.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(), this.getObject(objectValue))
						.getText();
				logger.debug("GETTEXT operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS,"GETTEXT operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform GETTEXT Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform GETTEXT Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
		case "VERIFYELEMENTPRESENT":
			try {
				util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(), this.getObject(objectValue));
				logger.debug("VERIFYELEMENTPRESENT operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS,"VERIFYELEMENTPRESENT operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform VERIFYELEMENTPRESENT Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform VERIFYELEMENTPRESENT Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
			
		case "VERIFYELEMENTNOTPRESENT":
			try {
				util.waitForInvisibilityOfElement(DriverFactory.getInstance().getDriver(), this.getObject(objectValue));
				logger.debug("VERIFYELEMENTNOTPRESENT operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS,"VERIFYELEMENTNOTPRESENT operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform VERIFYELEMENTNOTPRESENT Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform VERIFYELEMENTNOTPRESENT Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
			
		case "MOUSEHOVER":
			try {
				actions = new Actions(DriverFactory.getInstance().getDriver());
				actions.moveToElement(util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(),
						this.getObject(objectValue)))
						.pause(2000).build().perform();
				logger.debug("MOUSEHOVER operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS, "MOUSEHOVER operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform MOUSEHOVER Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform MOUSEHOVER Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}

		case "ACTIONCLICKBYOFFSET":
			try {
				actions = new Actions(DriverFactory.getInstance().getDriver());
				actions.moveToElement(util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(),
						this.getObject(objectValue)),Integer.parseInt(data[0]),Integer.parseInt(data[1]))
						.pause(2000).click().build().perform();
				logger.debug("ACTIONCLICKBYOFFSET operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS, "ACTIONCLICKBYOFFSET operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform ACTIONCLICKBYOFFSET Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform ACTIONCLICKBYOFFSET Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
			
		case "CLEARTEXTBYACTION":
			try {
				actions = new Actions(DriverFactory.getInstance().getDriver());
				actions.moveToElement(util.waitForPresenceOfElement(DriverFactory.getInstance().getDriver(),
						this.getObject(objectValue))).click()
				            .keyDown(Keys.CONTROL)
			                .sendKeys("a")
			                .keyUp(Keys.CONTROL)
			                .sendKeys(Keys.BACK_SPACE).build().perform();
				logger.debug("CLEARTEXTBYACTION operation performed Successfully on Element:---> " + objectName);
				extentLogger.log(Status.PASS, "CLEARTEXTBYACTION operation performed Successfully on Element:---> " + objectName);
				break;
			} catch (Exception e) {
				logger.error("Failed to perform CLEARTEXTBYACTION Operation on Element:---> " + objectName);
				extentLogger.log(Status.FAIL,"Failed to perform CLEARTEXTBYACTION Operation on Element:---> " + objectName);
				throw new Exception(e.toString());
			}
			
		default:
			break;
		}
		return result;
	}

	private By getObject(String objectName) throws Exception {
		String objectArray[] = objectName.split("->");
		if (objectArray[0].equalsIgnoreCase("XPATH")) {

			return By.xpath(objectArray[1]);
		}

		else if (objectArray[0].equalsIgnoreCase("CSSSELECTOR")) {

			return By.cssSelector(objectArray[1]);

		}

		else if (objectArray[0].equalsIgnoreCase("ID")) {

			return By.name(objectArray[1]);

		}

		else if (objectArray[0].equalsIgnoreCase("CLASSNAME")) {

			return By.className(objectArray[1]);

		}

		else if (objectArray[0].equalsIgnoreCase("NAME")) {

			return By.name(objectArray[1]);

		}

		else if (objectArray[0].equalsIgnoreCase("LINKTEXT")) {

			return By.linkText(objectArray[1]);

		}

		else if (objectArray[0].equalsIgnoreCase("PARTIALLINKTEXT")) {

			return By.partialLinkText(objectArray[1]);

		} else if (objectArray[0].equalsIgnoreCase("TAGNAME")) {

			return By.tagName(objectArray[1]);

		}

		else {
			throw new Exception("Wrong object type");
		}
	}

}
