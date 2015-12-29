package com.yash.maven;

import org.apache.log4j.Logger;


public class LogClass {

	static final Logger LOGGER = Logger.getLogger(LogClass.class.getName());
	public void showLog() {
		LOGGER.info("INSIDE LOG METHOD");
	}

}
