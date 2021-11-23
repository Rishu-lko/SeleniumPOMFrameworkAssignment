package com.automation.framework;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.utils.PropertyReader;

public class ExtentReportFactory {
	
	private static ExtentReports extent = null;
	
	public static ExtentReports setUpExtentReport() throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("dd.MMMMM.yyyy hh mm aaa z");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir") +"/src/test/resources/ExtentReports/ExecutionReports_"+actualDate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		sparkReport.config().setDocumentTitle("WalletHubAssignments");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("Assignments");
		
		extent.setSystemInfo("Executed On Environment: ",PropertyReader.getInstance().getConfigProperty("environment"));
		extent.setSystemInfo("Executed On Browser: ",PropertyReader.getInstance().getConfigProperty("browser"));
		extent.setSystemInfo("Executed On OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed By User: ", System.getProperty("user.dir"));
		return extent;		
	}

	
}
