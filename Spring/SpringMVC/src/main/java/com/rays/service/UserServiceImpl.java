package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOImpl;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDAOImpl dao = null;

	// @Transactional(propagation = Propagation.REQUIRED)
	public void add(UserDTO dto) {
		dao.add(dto);
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		dao.delete(dto);
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public List search(UserDTO dto) {
		List list = dao.search(dto);
		return list;
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public UserDTO findByPk(long id) {
		UserDTO dto = dao.findByPk(id);
		return dto;
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public UserDTO authenticate(String login, String password) {
		UserDTO dto = dao.authenticate(login, password);
		return dto;
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public UserDTO findByLogin(String login) {
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}

}
