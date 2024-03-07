package com.rays.child;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestChild {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Child.xml");
//		BeanFactory context = new XmlBeanFactory(new ClassPathResource("Child.xml"));
		TestBean childBean = (TestBean) context.getBean("DerivedTestBean");

		System.out.println(childBean.toString());
		/*
		 * DerivedTestBean childClass = (DerivedTestBean)
		 * context.getBean("derivedTestBean"); // TestBean childClass =
		 * context.getBean("DerivedTestBean", DerivedTestBean.class); // DerivedTestBean
		 * childClass = context.getBean("DerivedTestBean", DerivedTestBean.class);
		 * 
		 * System.out.println(childClass.toString());
		 */
	}

}
