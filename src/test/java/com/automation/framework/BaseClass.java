package com.automation.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.test.utils.PropertyReader;
import com.test.utils.UIOperations;
import com.test.utils.Utility;

public class BaseClass {

	protected WebDriver driver = null;
	protected PageManagerClass pageObjectManager = null;
	protected UIOperations uioperations = null;
	protected PropertyReader propRead = null;
	protected Utility util = null;
	protected LoggerFactory logger = null;
	protected HashMap<String,String> testData=null;
	protected ExtentTest extentLogger = null;
	protected static ConcurrentHashMap<String,String> sharedDataMap = new ConcurrentHashMap<String,String>();
	
	@BeforeClass
	protected void prepareTest(ITestContext a) throws IOException {
		propRead = PropertyReader.getInstance();
		driver=BrowserFactory.createInstance(propRead.getConfigProperty("browser"));
		DriverFactory.getInstance().setDriver(driver);
	}

	@AfterClass
	protected void tearDown() {
		DriverFactory.getInstance().removeDriver();
	}
	
	
}
