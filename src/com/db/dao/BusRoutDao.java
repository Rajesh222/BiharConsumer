package com.db.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.db.model.BusTripDetails;

@Repository("busRoutDao")
public class BusRoutDao {

	private static final Logger log = LoggerFactory.getLogger(BusRoutDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SEARCH_BUS_BY_ROUT = "SEARCH_BUS_BY_ROUT";

	public List<BusTripDetails> getTripDetails() {
		return null;
	}

	public List<BusTripDetails> searchBusByAvailibleRout() {
		return null;
	}
}
