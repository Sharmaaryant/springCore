package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		test.testAdd();
		// test.testupdate();
		// test.testdelete();
		// test.testsearch();
		// test.findByPk();
		// test.authenticate();
		// test.findByLogin();
	}

	private void findByLogin() {
		UserDTO dto = service.findByLogin("arun123@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());
		} else {
			System.out.println("User not found");
		}
	}

	private void authenticate() {
		UserDTO dto = service.authenticate("arun123@gmail.com", "Arun@123");
		if (dto != null) {
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());
		} else {
			System.out.println("User not found");
		}
	}

	private void findByPk() {
		UserDTO dto = service.findByPk(3);
		if (dto != null) {
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());

		} else {
			System.out.println("User not found");
		}

	}

	private void testsearch() {

		UserDTO dto = new UserDTO();
		List list = service.search(dto);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());
		}

	}

	private void testdelete() {
		UserDTO dto = new UserDTO();
		dto.setId(5);
		service.delete(dto);
		System.out.println("Data deleted");
	}

	private void testupdate() {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setFirstName("Lavish");
		dto.setLastName("ojha");
		dto.setLogin("Lavish123@gmail.com");
		dto.setPassword("Lavish@123");

		service.update(dto);

		System.out.println("Data updated");

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		// dto.setId(5);
		dto.setFirstName("Aditi");
		dto.setLastName("bajai");
		dto.setLogin("aditi123@gmail.com");
		dto.setPassword("Aditi@123");

		service.add(dto);

		System.out.println("Data Inserted...");
	}
}
