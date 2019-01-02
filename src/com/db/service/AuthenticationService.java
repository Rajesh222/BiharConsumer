package com.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.AuthenticationDao;
import com.db.model.User;

@Service("authenticationService")
public class AuthenticationService {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

	@Autowired
	private AuthenticationDao authenticationDao;

	public User authUser(String email, String pass) {
		log.info("call authUser()");
		return authenticationDao.authUser(email, pass);
	}

	public void addUser(User user) {
		log.info("call addUser()");
		authenticationDao.addUser(user);
	}

	public User forgotPassword(String email) {
		log.info("call forgotPassword()");
		return authenticationDao.forgotPassword(email);
	}

	public boolean changePassword(String email, String pass) {
		log.info("call changePassword()");
		return authenticationDao.changePassword(email, pass);
	}

	public boolean lockUser(String userName, boolean isLock, int attempt) {
		log.info("call lockUser()");
		return authenticationDao.lockUser(userName, isLock, attempt);
	}

	public List<User> getUsers() {
		log.info("call getUsers()");
		return authenticationDao.getUsers();
	}
}
