package com.db.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.User;

@Repository("userDetailsDao")
public class AuthenticationDao {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	public List<User> getUsers() {
		log.info("call getUsers()");
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Transactional
	public void addUser(User user) {
		log.info("call addUser()");
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional
	public boolean lockUser(String userName, boolean isLock, int attempt) {
		sessionFactory.getCurrentSession().createQuery("update User set attempt =:attempt, islock =:lock where userid =:uid")
				.setParameter("attempt", attempt).setParameter("lock", isLock).setParameter("uid", userName)
				.executeUpdate();
		return true;
	}
	
	@Transactional(readOnly=true)
	public User forgotPassword(String email) {
		 return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email).ignoreCase()).setFetchSize(1).setMaxResults(1);
	}
	
	@Transactional
	public boolean changePassword(String email, String pass) {
		sessionFactory.getCurrentSession().createQuery("update User set password =:password where userid =:uid")
		.setParameter("password", pass).setParameter("uid", email)
		.executeUpdate();
		return true;
	}
	
	@Transactional
	public User authUser(String email, String pass) {
		 return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email).ignoreCase()).add(Restrictions.eq("pass", pass).ignoreCase()).setFetchSize(1).setMaxResults(1);
	}
}
