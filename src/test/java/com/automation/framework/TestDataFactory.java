package com.automation.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.test.utils.PropertyReader;

public class TestDataFactory extends BaseClass {

	private TestDataFactory() {
		super.propRead = PropertyReader.getInstance();
	}

	private static TestDataFactory testDataFactory = null;

	public static TestDataFactory getInstance() {
		if (testDataFactory == null) {
			synchronized (DriverFactory.class) {
				if (testDataFactory == null) {
					testDataFactory = new TestDataFactory();
				}
			}

		}
		return testDataFactory;

	}

	private ThreadLocal<HashMap<String, String>> testDataLocal = new ThreadLocal<HashMap<String, String>>();

	public synchronized void getApplicationTestData(String testName) throws IOException {
			String sheetName = "";
			String path = "";
			int colIndex = 0;

			HashMap<String, String> testData = new HashMap<String, String>();

			sheetName = propRead.getConfigProperty("environment");
			path = System.getProperty("user.dir") + "/src/test/resources/TestData/" + testName + "_TestData.xlsx";

			FileInputStream fil = null;
			try {
				fil = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			XSSFWorkbook wb = null;
			try {
				wb = new XSSFWorkbook(fil);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Sheet sheet = wb.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			String templateHeading = "";
			Row rowheading = sheet.getRow(0);
			for (int j = 0; j < rowheading.getLastCellNum(); j++) {
				Cell cellheading = rowheading.getCell(j);
				templateHeading = cellheading.getStringCellValue();
				if (templateHeading.toUpperCase().equals(testName.toUpperCase())) {
					colIndex = j;
					break;
				}

			}

			for (int i = 1; i <= lastRow; i++) {
				Row dataRow = sheet.getRow(i);
				String key = dataRow.getCell(0).getStringCellValue();
				String value = dataRow.getCell(colIndex).getStringCellValue();
				testData.put(key, value);

			}
		setTestData(testData);
	}

	public void setTestData(HashMap<String, String> testData) {
		testDataLocal.set(testData);
	}

	public HashMap<String, String> getTestData() {
		return testDataLocal.get();
	}

	public void removeTestData() {
		testDataLocal.remove();
	}

}
