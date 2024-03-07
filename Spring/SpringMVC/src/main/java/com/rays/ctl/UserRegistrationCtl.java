package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceImpl;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "UserRegistration")
public class UserRegistrationCtl {

	@Autowired
	public UserServiceImpl service;

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model m) {
		System.out.println("Welcome to display...");
		return "UserRegistration";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserRegistrationForm form, Model m) {
		UserDTO dto = new UserDTO();
		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		service.add(dto);
		/*
		 * System.out.println(form.getFirstName());
		 * System.out.println(form.getLastName()); System.out.println(form.getLogin());
		 * System.out.println(form.getPassword()); System.out.println(form.getDob());
		 * System.out.println(form.getAddress());
		 */
		return "UserRegistration";
	}

}
