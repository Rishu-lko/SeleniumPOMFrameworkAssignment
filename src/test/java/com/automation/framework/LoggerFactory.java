package com.automation.framework;

import org.apache.logging.log4j.Logger;

public class LoggerFactory {

	private static LoggerFactory loggerFactory = null;

	private LoggerFactory() {

	}

	public static LoggerFactory getInstance() {
		if (loggerFactory == null) {
			synchronized (LoggerFactory.class) {
				if (loggerFactory == null) {
					loggerFactory = new LoggerFactory();
				}
			}

		}
		return loggerFactory;

	}

	private ThreadLocal<Logger> APP_LOGS = new ThreadLocal<Logger>();

	public void setCurrentLogger(Logger logger) {
		APP_LOGS.set(logger);
	}

	public Logger getCurrentLogger() {
		return APP_LOGS.get();
	}

	public void removeCurrentLogger() {
		APP_LOGS.remove();
	}

	public String getCallInfo() {

		String callInfo;
		String className = Thread.currentThread().getStackTrace()[3].getClassName();
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();

		callInfo = className + ":" + methodName + " " + lineNumber + "==>  ";
		return callInfo;

	}

	public void trace(Object message) {
		LoggerFactory.getInstance().getCurrentLogger().trace(message);
	}

	public void trace(Object message, Throwable t) {
		LoggerFactory.getInstance().getCurrentLogger().trace(message, t);
	}

	public void debug(Object message) {

		LoggerFactory.getInstance().getCurrentLogger().debug(LoggerFactory.getInstance().getCallInfo() + message);
	}

	public void debug(Object message, Throwable t) {
		LoggerFactory.getInstance().getCurrentLogger().debug(LoggerFactory.getInstance().getCallInfo() + message, t);
	}

	public void error(Object message) {

		LoggerFactory.getInstance().getCurrentLogger().error(LoggerFactory.getInstance().getCallInfo() + message);
	}

	public void error(Object message, Throwable t) {
		LoggerFactory.getInstance().getCurrentLogger().error(LoggerFactory.getInstance().getCallInfo() + message, t);
	}

	public void fatal(Object message) {
		LoggerFactory.getInstance().getCurrentLogger().fatal(LoggerFactory.getInstance().getCallInfo() + message);
	}

	public void fatal(Object message, Throwable t) {
		LoggerFactory.getInstance().getCurrentLogger().fatal(LoggerFactory.getInstance().getCallInfo() + message, t);
	}

	public void info(Object message) {

		LoggerFactory.getInstance().getCurrentLogger().info(LoggerFactory.getInstance().getCallInfo() + message);
	}

	public void info(Object message, Throwable t) {
		LoggerFactory.getInstance().getCurrentLogger().info(LoggerFactory.getInstance().getCallInfo() + message, t);
	}

	public void warn(Object message) {
		LoggerFactory.getInstance().getCurrentLogger().warn(LoggerFactory.getInstance().getCallInfo() + message);
	}

	public void warn(Object message, Throwable t) {
		LoggerFactory.getInstance().getCurrentLogger().warn(LoggerFactory.getInstance().getCallInfo() + message, t);
	}

}
