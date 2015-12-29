package com.yash.log;

import java.io.IOException;
//import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MessgaeWriterService {

	static final Logger LOGGER = Logger.getLogger(MessgaeWriterService.class.getName());  //factory method getlogger
	public void writeMessage() throws Exception, IOException{
		LOGGER.info("writeMessage() begins ");
		LOGGER.setLevel(Level.FINE);
		/*Handler handler = new ConsoleHandler();
		LOGGER.addHandler(handler);*/
		
		Handler handler = new FileHandler("message.log");
		LOGGER.addHandler(handler);
		
		Formatter formatter = new SimpleFormatter();
		handler.setFormatter(formatter);
		LOGGER.info("writeMessage() ENDS ");
	}
}
