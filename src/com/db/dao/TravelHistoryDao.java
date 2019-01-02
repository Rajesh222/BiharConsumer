package com.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.BusRoutDetails;
import com.db.model.TravelHistory;

@Repository("searchStationDao")
public class TravelHistoryDao {
	
	private static final Logger log = LoggerFactory.getLogger(TravelHistoryDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<BusRoutDetails> searchBusList(String source,String destination, String date){
		return this.sessionFactory.getCurrentSession().createQuery("from BusHistory").list();
	}
	
	@Transactional
	public List<TravelHistory> getAllStation() {
		log.info("getAllStation ");
		List<TravelHistory> list = this.sessionFactory.getCurrentSession().createCriteria(TravelHistory.class).addOrder(Order.desc("id")).list();
		return list;
	}
	
	@Transactional
	public List<TravelHistory> searchStationByStationName(String stationName) {
		log.info("searchStationByStationName : {}", stationName);
		Session session = this.sessionFactory.getCurrentSession();
		Criteria query = session.createCriteria(TravelHistory.class);
		query.add(Restrictions.like("displayName", stationName, MatchMode.ANYWHERE).ignoreCase());
		return query.list();
	}
	
	@Transactional
	public boolean addStationName(TravelHistory searchStation) {
		log.info("addStationName : {}", searchStation);
		Session session = this.sessionFactory.getCurrentSession();
		long id = (long) session.save(searchStation);
		return id > 0 ? true : false;
	}
	
}
