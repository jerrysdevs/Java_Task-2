package com.task2;
import org.apache.logging.log4j.*;

public class Log4j {
private static Logger demoLogger = LogManager.getLogger(Log4j.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("asdasdas");
demoLogger.error("asdasd");
	}

}
