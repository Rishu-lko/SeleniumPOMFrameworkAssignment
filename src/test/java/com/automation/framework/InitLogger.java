package com.automation.framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;

public class InitLogger {

	public InitLogger() {
		
	}

	public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

	public static synchronized void initializeLogger(String testName) {
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/Configurations/log4j2.xml");	    
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		context.setConfigLocation(file.toURI());
		String logDate = now("dd.MMMMM.yyyy_hh_mm_ss aaa");
		String logFileName = System.getProperty("user.dir")+"/src/test/resources/Logs/"+testName+"_"+ logDate;
		ThreadContext.put("logFilename", logFileName);
		LoggerFactory.getInstance().setCurrentLogger(LogManager.getLogger());		
		LoggerFactory.getInstance().info("\n\n************** Execution Started : " + testName + "**************\n");		
	}
	
	public static synchronized void endTestCase(String testName) {
		LoggerFactory.getInstance().info("\n\n************** Execution End : " + testName + "**************\n");
	}
}
