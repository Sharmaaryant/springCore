package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rays.bean.Person;
import com.rays.bean.UserBean;

public class TestMultiple {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Multiple.xml");

		// UserBean bean = (UserBean) context.getBean("User");
		
		UserBean bean = context.getBean(UserBean.class);
		
		Person person = (Person) context.getBean("Person");

		System.out.println(bean.getName());

		System.out.println(bean.getLogin());

		System.out.println(bean.getPassword());

		System.out.println(person.getId());

		System.out.println(person.getName());

		System.out.println(person.getSalary());

	}

}
