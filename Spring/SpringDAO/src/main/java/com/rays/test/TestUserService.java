package com.rays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService") // bean ki trh treate kregi (class ko bean bna deta h)
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		// test.testAdd();
		// test.testUpdate();
		// test.testdelete();
		// test.findByPk();
		// test.testsearch();
		// test.testFindByLogin();
		// test.testAuthentication();

		test.testmail();
	}

	private void testmail() {
		service.sendEmail();
		System.out.println("mail send");
	}

	private void testFindByLogin() {
		UserDTO dto = service.findByLogin("Aditi123@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());
		} else {
			System.err.println("User not exist...!!!");
		}

	}

	private void testAuthentication() {
		UserDTO dto = service.authenticate("Urwashi123@gmail.com", "Urwashi@123");
		if (dto != null) {
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());
		} else {
			System.err.println("User not exist...!!!");
		}
	}

	private void testsearch() {
		UserDTO dto = new UserDTO();
		List<UserDTO> list = service.search(dto);
		Iterator<UserDTO> it = list.iterator();
		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());

		}

	}

	private void findByPk() {
		UserDTO dto = service.findByPk((long) 5);

		if (dto != null) {

			System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t"
					+ dto.getLogin() + "\t" + dto.getPassword());

		} else {
			System.out.println("User not found");
		}

	}

	private void testdelete() {
		UserDTO dto = new UserDTO();

		dto.setId(3);

		service.delete(dto);
		System.out.println("Data deleted");
	}

	private void testUpdate() {

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

		dto.setId(7);
		dto.setFirstName("Urwashi");
		dto.setLastName("Upadhaya");
		dto.setLogin("Urwashi123@gmail.com");
		dto.setPassword("Urwashi@123");

		long pk = service.add(dto);

		System.out.println("Data Inserted... pk " + pk);

	}

}
