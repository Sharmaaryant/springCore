package com.rays.instance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdk.internal.org.xml.sax.Locator;

public class TestServiceLocator {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Instance.xml");

		ServiceLocator locator = (ServiceLocator) context.getBean("locator");

		locator.getInstance();

	}

}
