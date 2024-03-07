package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public List search(UserDTO dto);

	public UserDTO findByPk(Long pk);

	public Integer nextPk(UserDTO dto);

	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);

	public void sendEmail();

}
