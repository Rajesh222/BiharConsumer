package com.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.enums.PrevilageType;
import com.db.model.User;
import com.db.model.mapper.UserRowMapper;
import com.db.utils.SecurityDigester;

@Repository("userDetailsDao")
public class AuthenticationDao {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_USER_LOGS = "INSERT_USER_LOGS";
	private static final String INSERT_MODULE_LOGS = "INSERT_MODULE_LOGS";
	private static final String UPDATE_LOCK_USER = "UPDATE_LOCK_USER";
	private static final String GET_USER_DETAIL_BY_PHONE = "GET_USER_DETAIL_BY_PHONE";
	private static final String GET_USER_DETAIL_BY_EMAIL = "GET_USER_DETAIL_BY_EMAIL";
	private static final String UPDATE_USER_PASS = "UPDATE_USER_PASSWORD";
	private static final String AUTH_USER_BY_EMAIL = "AUTH_USER_BY_EMAIL";
	private static final String AUTH_USER_BY_PHONE = "AUTH_USER_BY_PHONE";

	@Transactional(readOnly = true)
	public List<User> findAllUser() {
		return jdbcTemplate.query("select * from user_module", new UserRowMapper());
	}

	@Transactional
	public User addUser(User user) {
		String query = queriesMap.get(INSERT_USER_LOGS);
		log.debug("Running insert query for addUser: {}", query);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getAddress());
				ps.setString(4, user.getPhoneNumber());
				ps.setString(5, user.getPanNumber());
				ps.setString(6, user.getPassword());
				ps.setString(7, user.getCity());
				ps.setString(8, user.getState());
				return ps;
			}
		}, holder);
		String newUserId = (String) holder.getKeys().get("userid");
		user.setUserId(String.valueOf(newUserId));
		String query1 = queriesMap.get(INSERT_MODULE_LOGS);
		log.debug("Running insert query for addUser {}", query);
		KeyHolder holder1 = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, newUserId);
				ps.setString(2, PrevilageType.RETAILER.toString());
				return ps;
			}
		}, holder1);
		return user;
	}

	@Transactional
	public int lockUser(String userName, boolean isLock, int attempt) {
		String query = queriesMap.get(UPDATE_LOCK_USER);
		log.debug("Running insert query for addUser {}", query);
		return jdbcTemplate.update(query, userName, isLock, attempt);
	}

	@Transactional(readOnly = true)
	public User getUserDetails(String email) {
		User user = null;
		if (validatePhoneNumber(email)) {
			String query = queriesMap.get(GET_USER_DETAIL_BY_PHONE);
			log.debug("Running insert query for getUserDetails : {}", query);
			user = jdbcTemplate.queryForObject(query, new Object[] { email }, new UserRowMapper());
		} else {
			String query = queriesMap.get(GET_USER_DETAIL_BY_EMAIL);
			log.debug("Running insert query for getUserDetails: {}", query);
			user = jdbcTemplate.queryForObject(query, new Object[] { email }, new UserRowMapper());
		}
		return user;
	}

	@Transactional
	public int changePassword(String uid, String pass) throws UnsupportedEncodingException {
		String query = queriesMap.get(UPDATE_USER_PASS);
		log.debug("Running insert query for getUserDetails {}", query);
		return jdbcTemplate.update(query, SecurityDigester.decrypt(pass), uid);
	}

	@Transactional
	public User authUser(User user) throws UnsupportedEncodingException {
		if (validatePhoneNumber(user.getEmail())) {
			String query = queriesMap.get(AUTH_USER_BY_PHONE);
			log.debug("Running insert query for authUser {}", query);
			user = jdbcTemplate.queryForObject(query,
					new Object[] { user.getEmail(), SecurityDigester.encrypt(user.getPassword()) },
					new UserRowMapper());
		} else {
			String query = queriesMap.get(AUTH_USER_BY_EMAIL);
			log.debug("Running insert query for authUser {}", query);
			user = jdbcTemplate.queryForObject(query,
					new Object[] { user.getEmail(), SecurityDigester.encrypt(user.getPassword()) },
					new UserRowMapper());
		}
		return user;
	}

	private static boolean validatePhoneNumber(String phoneNo) {
		// validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;
	}

}
