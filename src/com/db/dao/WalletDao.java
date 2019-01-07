package com.db.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.Wallet;

@Repository("walletDao")
public class WalletDao {

	private static final Logger log = LoggerFactory.getLogger(WalletDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOG = LoggerFactory.getLogger(WalletDao.class);

	@Transactional(readOnly = true)
	public List<Wallet> getWalletHistory(String uid) {
		LOG.info("call getWalletHistoryByUser {}", uid);
		return this.sessionFactory.getCurrentSession().createCriteria(Wallet.class)
				.add(Restrictions.eq("uid", uid).ignoreCase()).addOrder(Order.desc("modifiedOn")).list();
	}
	
	@Transactional(readOnly = true)
	public List<Wallet> getWalletDetails(String uid) {
		LOG.info("call getWalletDetailsByUser {}", uid);
		return this.sessionFactory.getCurrentSession().createCriteria(Wallet.class)
				.add(Restrictions.eq("uid", uid).ignoreCase()).setFetchSize(1).addOrder(Order.desc("modifiedOn")).list();
	}

	@Transactional(readOnly = true)
	public boolean updateWallet(double addedAmount, String uid) {
		int i = this.sessionFactory.getCurrentSession().createQuery(
				"UPDATE Wallet set addedBalance=:addedBalance, currentBalance=currentBalance+=:addedBalance,previousBalance=currentBalance where uid=:uid")
				.setParameter("addedBalance", addedAmount).setParameter("uid", uid).executeUpdate();
		if (i > 0)
			return true;
		else
			return false;
	}
	
}
