package com.mycompany;

import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSelectorMain {

	public static void main(String[] args) throws Exception {

		// Sending Message to the order Queue
		ApplicationContext context = new ClassPathXmlApplicationContext("camel-application-context-msgselector.xml");
		ProducerTemplate camelTemplate = context.getBean("camelTemplate", ProducerTemplate.class);
		System.out.println("Message Sending started");
		camelTemplate.sendBodyAndHeader("jms:queue:ORDER", "Large pepperoni pizza", "LOCATION", "Hvidovre");
		camelTemplate.sendBodyAndHeader("jms:queue:ORDER", "Medium mexicana pizza", "LOCATION", "Amager");
		camelTemplate.sendBodyAndHeader("jms:queue:ORDER", "Family vegetarian", "LOCATION", "Hvidovre");
                camelTemplate.sendBodyAndHeader("jms:queue:ORDER", "Large Meat feast", "LOCATION", "Horsholm");
                camelTemplate.sendBodyAndHeader("jms:queue:ORDER", "Medium Pulled chicken BBQ", "LOCATION", "Horsholm");
		System.out.println("Message sending completed");

	}

}
