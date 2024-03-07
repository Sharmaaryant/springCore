package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.rays.bean.UserBean;

public class TestUserBean {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("UserBean.xml"));

		UserBean bean = (UserBean) factory.getBean("User");

		System.out.println(bean.getName());

		System.out.println(bean.getLogin());

		System.out.println(bean.getPassword());

	}
}
