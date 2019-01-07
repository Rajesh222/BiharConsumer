package com.db.dao;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.User;
import com.db.utils.SecurityDigester;

import net.sf.ehcache.constructs.scheduledrefresh.OverseerJob;

@Repository("userDetailsDao")
public class AuthenticationDao {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
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
		sessionFactory.getCurrentSession()
				.createQuery("update User set attempt =:attempt, islock =:lock where uid =:uid")
				.setParameter("attempt", attempt).setParameter("lock", isLock).setParameter("uid", userName)
				.executeUpdate();
		return true;
	}

	@Transactional(readOnly = true)
	public User forgotPassword(String email) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email).ignoreCase()).setFetchSize(1).setMaxResults(1);
	}

	@Transactional
	public boolean changePassword(String email, String pass) {
		sessionFactory.getCurrentSession().createQuery("update User set password =:password where userid =:uid")
				.setParameter("password", pass).setParameter("uid", email).executeUpdate();
		return true;
	}

	@Transactional
	public User authUser(User user) throws UnsupportedEncodingException {
		if (validatePhoneNumber(user.getEmail())) {
			user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("phone", user.getEmail()).ignoreCase())
					.add(Restrictions.eq("password", SecurityDigester.encrypt(user.getPassword())).ignoreCase())
					.add(Restrictions.eq("isLock", Boolean.FALSE)).add(Restrictions.eq("isActive", Boolean.TRUE))
					.setMaxResults(1).uniqueResult();
		}else {
			user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("email", user.getEmail()).ignoreCase())
					.add(Restrictions.eq("password", SecurityDigester.encrypt(user.getPassword())).ignoreCase())
					.add(Restrictions.eq("isLock", Boolean.FALSE)).add(Restrictions.eq("isActive", Boolean.TRUE))
					.setMaxResults(1).uniqueResult();
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
