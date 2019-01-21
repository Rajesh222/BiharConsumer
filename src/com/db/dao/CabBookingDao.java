package com.db.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.CabBookingPrice;
import com.db.model.CabDetails;
import com.db.model.mapper.CabBookingPriceExtrator;

@Repository("cabBookingDao")
public class CabBookingDao {

	private static final Logger log = LoggerFactory.getLogger(CabBookingDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_CAB_TICKET_PRICE = "SELECT_CAB_TICKET_PRICE";
	private static final String SELECT_CAB_TICKET_PRICE_BY_TYPE = "SELECT_CAB_TICKET_PRICE_BY_TYPE";

	@Transactional(readOnly = true)
	public List<CabBookingPrice> getAllCabBookingPrice() {
		String query = queriesMap.get(SELECT_CAB_TICKET_PRICE);
		log.debug("Running insert query for getAllCabBookingPrice: {}", query);
		return jdbcTemplate.query(query, new CabBookingPriceExtrator());
	}

	public CabBookingPrice getCabBookingPrice(String cabType) {
		String query = queriesMap.get(SELECT_CAB_TICKET_PRICE_BY_TYPE);
		log.debug("Running insert query for getAllCabBookingPrice: {}", query);
		List<CabBookingPrice> bookingPrices = jdbcTemplate.query(query,
				new Object[] { cabType }, new CabBookingPriceExtrator());
		if (bookingPrices != null && bookingPrices.isEmpty())
			return bookingPrices.get(0);
		else
			return null;
	}

	public List<CabDetails> getCabBookingDetailHistory(String uid, int limit) {
		return null;
	}

	public CabDetails bookCab(CabDetails cabDetails) {
		return null;
	}

}
