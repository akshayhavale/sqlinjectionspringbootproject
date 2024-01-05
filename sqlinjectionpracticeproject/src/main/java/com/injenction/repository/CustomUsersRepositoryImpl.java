package com.injenction.repository;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.injenction.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository(value = "customUsersRepository")
public class CustomUsersRepositoryImpl implements CustomUsersRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CustomUsersRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Users> searchUsersByUsername(String username) {
		log.debug("Inside CustomUsersRepositoryImpl.searchUsersByUsername() for username : {}", username);
		try {
			// Worst coding this is but still to practice sql injection i am writing this
			// query
			/**
			 * Successfully hql injection done http://localhost:8151/api/users/user1' OR 1=1
			 * OR u.username='u
			 */
			/*
			 * String qry = "select u from Users u where u.username like'%" + username
			 * +"%'"; TypedQuery<Users> createQuery = entityManager.createQuery(qry,
			 * Users.class); return createQuery.getResultList();
			 */

			/**
			 * Successfully SQL injected http://localhost:8151/api/users/user1' OR 1=1 OR
			 * us.username='u
			 */
			/*
			 * String sqlQuery =
			 * "SELECT * FROM USERS_SQL_INJECTION us WHERE us.USERNAME = '"+username+"'";
			 * return jdbcTemplate.query(sqlQuery, new RowMapper<Users>() { public Users
			 * mapRow(ResultSet rs, int rowNum) throws SQLException { return new
			 * Users(rs.getLong(1),rs.getString(2),rs.getString(3));
			 * 
			 * } });
			 */

			/**
			 * How to avoid hql/sql injection by making parameterized queries
			 */

			String qry = "select u from Users u where u.username =:username";
			TypedQuery<Users> createQuery = entityManager.createQuery(qry, Users.class);
			createQuery.setParameter("username", username);
			return createQuery.getResultList();

		} catch (Exception e) {
			log.error("Exception while CustomUsersRepositoryImpl.searchUsersByUsername() for username : {} due to : ",
					username, e);
		}
		return null;
	}

}
