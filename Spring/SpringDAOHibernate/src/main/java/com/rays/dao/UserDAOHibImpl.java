package com.rays.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) {
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
	}

	public void delete(UserDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);
	}

	public List search(UserDTO dto) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		List list = criteria.list();
		return list;
	}

	public UserDTO findByPk(long id) {
		// Criteria c = (Criteria)
		// sessionFactory.getCurrentSession().getCriteriaBuilder();
		UserDTO dto = sessionFactory.getCurrentSession().get(UserDTO.class, id);
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		/*
		 * Query q = sessionFactory.getCurrentSession().
		 * createQuery("FROM USER WHERE LOGIN=? AND PASSWORD=?"); q.setString(0, login);
		 * q.setString(1, password); UserDTO dto = (UserDTO) q.list(); return dto;
		 */
		Session session = sessionFactory.getCurrentSession();

		String hql = "FROM UserDTO WHERE login = ? AND password = ?";
		Query<UserDTO> query = session.createQuery(hql, UserDTO.class);
		query.setParameter(0, login);
		query.setParameter(1, password);

		UserDTO dto = query.uniqueResult();
		return dto;
	}

	public UserDTO findByLogin(String login) {
		/*
		 * UserDTO dto = sessionFactory.getCurrentSession().get(UserDTO.class, login);
		 * return dto;
		 */
		Session session = sessionFactory.getCurrentSession();

		String hql = "FROM UserDTO WHERE login = ?";
		Query<UserDTO> query = session.createQuery(hql, UserDTO.class);
		query.setParameter(0, login);

		UserDTO dto = query.uniqueResult();
		return dto;
	}

}