package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static PropertyReader propReader = null;

	private PropertyReader() {

	}

	public static PropertyReader getInstance() {
		if (propReader == null) {
			synchronized (PropertyReader.class) {
				if (propReader == null) {
					propReader = new PropertyReader();
				}
			}

		}
		return propReader;

	}

	public String getConfigProperty(String key) throws IOException {
		Properties prop = new Properties();
		InputStream stream = new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/test/resources/Configurations/config.properties"));
		prop.load(stream);
		return prop.getProperty(key);
	}

	public String getTestData(String key) throws IOException {
		Properties prop = new Properties();
		InputStream stream = new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.properties"));
		prop.load(stream);
		return prop.getProperty(key);
	}

	public String getORProperty(String orFileName, String key) throws IOException {
		Properties prop = new Properties();
		InputStream stream = new FileInputStream(new File(
				System.getProperty("user.dir") + "/src/test/resources/ObjectRepository/" + orFileName + ".properties"));
		prop.load(stream);
		return prop.getProperty(key);
	}
}
