package com.yash.log;

import java.io.IOException;

public class Test {
	public static void main(String args[]) throws IOException, Exception{
		MessgaeWriterService ws = new MessgaeWriterService();
		ws.writeMessage(); 
	}

}
