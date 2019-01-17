package com.db.service;

import java.io.UnsupportedEncodingException;
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

	public User authUser(User user) throws UnsupportedEncodingException {
		log.info("call authUser()");
		return authenticationDao.authUser(user);
	}

	public User addUser(User user) {
		log.info("call addUser()");
		return authenticationDao.addUser(user);
	}

	public User getUserDetails(String email) {
		log.info("call forgotPassword()");
		return authenticationDao.getUserDetails(email);
	}

	public int changePassword(String email, String pass) throws UnsupportedEncodingException {
		log.info("call changePassword()");
		return authenticationDao.changePassword(email, pass);
	}

	public int lockUser(String userName, boolean isLock, int attempt) {
		log.info("call lockUser()");
		return authenticationDao.lockUser(userName, isLock, attempt);
	}

	public List<User> getUsers() {
		log.info("call getUsers()");
		return authenticationDao.findAllUser();
	}
	
	public int logOut(String uid) {
		log.info("call logOut()");
		return authenticationDao.logOut(uid);
	}
}
