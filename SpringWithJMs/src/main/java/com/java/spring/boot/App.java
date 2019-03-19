package com.java.spring.boot;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.boot.sender.JmsMessageSender;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// init spring context
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
	        
	    // get bean from context
	    JmsMessageSender jmsMessageSender = (JmsMessageSender)ctx.getBean("jmsMessageSender");
	        
	    // send to default destination 
	    jmsMessageSender.send("hello JMS");
	        
	    // send to a code specified destination
	    Queue queue = new ActiveMQQueue("AnotherDest");
	    jmsMessageSender.send(queue, "hello Another Message");
	  
	    // close spring application context
	    ((ClassPathXmlApplicationContext)ctx).close();
	}
}
