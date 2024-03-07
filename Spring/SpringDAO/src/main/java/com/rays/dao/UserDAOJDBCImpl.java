package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public long add(UserDTO dto) {

		String sql = "insert into st_user values(?, ?, ?, ? ,?)";
		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());

		return pk;

	}

	public void update(UserDTO dto) {
		String sql = "update st_user set first_name = ?, last_name = ?, login = ? , password = ? where id = ?";
		int pk = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

	}

	public void delete(UserDTO dto) {
		String sql = "delete from st_user where id = ?";
		int pk = jdbcTemplate.update(sql, dto.getId());
	}

	public UserDTO findByPk(long pk) {
		String sql = "SELECT * FROM ST_USER WHERE ID = ?";
		Object[] param = { pk };
		List list = jdbcTemplate.query(sql, param, new UserMapper());

		UserDTO dto = null;

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);

		}
		return dto;
	}

	public List search(UserDTO dto) {
		String sql = "SELECT * FROM ST_USER";
		List list = jdbcTemplate.query(sql, new UserMapper());

		return list;
	}

	public UserDTO authenticate(String login, String password) {
		String sql = "select * from st_user where login=? and password=?";
		Object[] param = { login, password };
		List list = jdbcTemplate.query(sql, param, new UserMapper());
		UserDTO dto = null;
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public Integer nextPk(UserDTO dto) {
		String sql = "select max(id) from st_user";
		int pk = jdbcTemplate.update(sql);
		return pk + 1;
	}

	public UserDTO findByLogin(String login) {
		String sql = "select * from st_user where login = ?";
		Object[] param = { login };
		List list = jdbcTemplate.query(sql, param, new UserMapper());
		UserDTO dto = null;
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

}
