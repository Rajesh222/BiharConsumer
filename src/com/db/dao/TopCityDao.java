package com.db.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;

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
import com.db.model.TopCities;

@Repository("searchStationDao")
public class TopCityDao {

	private static final Logger log = LoggerFactory.getLogger(TopCityDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<BusRoutDetails> searchBusList(String source, String destination, String date) {
		Session session = this.sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder query = new StringBuilder("from BusHistory ");
		if (sdf != null)
			query.append(" where date >= '" + sdf.format(date) + "'");
		else
			query.append(" where date >= now()");
		query.append(" order by date");
		Query result = session.createQuery(query.toString());
		return result.getResultList();
	}

	@Transactional
	public List<TopCities> getAllStation() {
		log.info("getAllStation ");
		List<TopCities> list = this.sessionFactory.getCurrentSession().createCriteria(TopCities.class)
				.addOrder(Order.desc("id")).list();
		return list;
	}

	@Transactional
	public List<TopCities> searchStationByStationName(String stationName) {
		log.info("searchStationByStationName : {}", stationName);
		Session session = this.sessionFactory.getCurrentSession();
		Criteria query = session.createCriteria(TopCities.class)
				.add(Restrictions.like("displayName", stationName, MatchMode.ANYWHERE).ignoreCase());
		return query.list();
	}

	@Transactional
	public boolean addStationName(TopCities searchStation) {
		log.info("addStationName : {}", searchStation);
		Session session = this.sessionFactory.getCurrentSession();
		long id = (long) session.save(searchStation);
		return id > 0 ? true : false;
	}

}
