package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBeanAnnotation {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("LifeCycle2.xml");

		MyBeanAnnotation myBean = context.getBean(MyBeanAnnotation.class);

		((ClassPathXmlApplicationContext) context).close();

	}

}
