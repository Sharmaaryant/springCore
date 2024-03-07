package com.rays.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceImpl;

@Controller
@RequestMapping(value = "Login")
public class LoginCtl {

	@Autowired
	public UserServiceImpl service;

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model m) {
		return "Login";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") LoginForm form, Model m, HttpSession session) {
		UserDTO dto = service.authenticate(form.getLogin(), form.getPassword());
		if (dto == null) {
			System.err.println("Invalid LoginID password...!!!");
		} else {
			session.setAttribute("msg", dto.getFirstName());
		}

		return "Welcome";
	}
}
