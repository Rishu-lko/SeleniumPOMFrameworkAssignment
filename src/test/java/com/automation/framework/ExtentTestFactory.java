package com.automation.framework;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {

	private static ExtentTestFactory extentTestFactory = null;

	private ExtentTestFactory() {

	}

	public static ExtentTestFactory getInstance() {
		if (extentTestFactory == null) {
			synchronized (ExtentTestFactory.class) {
				if (extentTestFactory == null) {
					extentTestFactory = new ExtentTestFactory();
				}
			}

		}
		return extentTestFactory;

	}
	
	private ThreadLocal<ExtentTest> extentTestObject = new ThreadLocal<ExtentTest>();
	
	public void setExtentTest(ExtentTest extentTest) {
		extentTestObject.set(extentTest);
	} 
	
	public ExtentTest getExtentTest() {
		return extentTestObject.get();
	} 
	
	public void removeExtentTestObj() {
		extentTestObject.remove();
	}
}
