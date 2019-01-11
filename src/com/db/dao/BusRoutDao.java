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

import com.db.model.BusRoutDetails;
import com.db.model.BusStopLocationDetails;
import com.db.model.BusTripDetails;
import com.db.model.mapper.RoutDetailsRowMapper;

@Repository("busRoutDao")
public class BusRoutDao {

	private static final Logger log = LoggerFactory.getLogger(BusRoutDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String GET_BUS_ROUT_STOP_DETAILS_BY_TRIPID = "GET_BUS_ROUT_STOP_DETAILS_BY_TRIPID";
	private static final String GET_BUS_ROUT_DETAILS_BY_SRC_AND_DESC = "GET_BUS_ROUT_DETAILS_BY_SRC_AND_DESC";

	@Transactional(readOnly = true)
	public List<BusTripDetails> getTripDetails() {
		return null;
	}

	@Transactional(readOnly = true)
	public List<BusRoutDetails> searchBusByAvailibleRout(String srcName, String destName) {
		String query = queriesMap.get(GET_BUS_ROUT_DETAILS_BY_SRC_AND_DESC);
		log.debug("Running select query for searchBusByAvailibleRout: {}", query);
		List<BusRoutDetails> busRoutDetails = jdbcTemplate.query(query, new Object[] { "%" + srcName + "%", "%" + destName + "%" },
				new RoutDetailsRowMapper());
		return busRoutDetails;
	}

	public List<BusStopLocationDetails> getBusStopDetails() {
		return null;
	}
}
