package com.rays.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	@Autowired
	private JavaMailSender mailSender = null;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		dao.delete(dto);
	}

	public UserDTO findByPk(Long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

	public List search(UserDTO dto) {
		List list = dao.search(dto);
		return list;
	}

	public Integer nextPk(UserDTO dto) {
		int pk = dao.nextPk(dto);
		return pk;
	}

	public UserDTO findByLogin(String login) {
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO dto = dao.authenticate(login, password);
		return dto;
	}


	public void sendEmail() {

		MimeMessage msg = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo("arunojha876@gmail.com");
			helper.setSubject("Test Subject");
			helper.setText("Test Msg", true);

			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
