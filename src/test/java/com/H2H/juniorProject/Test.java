package com.H2H.juniorProject;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String args[]){
		ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
			Logger logger = (Logger) context.getBean("logger");
	
			HavaDurumu hd = 	(new HavaDurumu("San_Fransisco"));
			System.out.println(hd.getCurrentObservation());
	}
}
