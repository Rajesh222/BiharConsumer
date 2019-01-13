package com.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.BusRoutDetails;
import com.db.model.BusStopLocationDetails;
import com.db.model.BusTripDetails;
import com.db.model.BusType;
import com.db.model.mapper.BusStopLocationDetailsRowMapper;
import com.db.model.mapper.RoutDetailsRowMapper;
import com.db.model.vo.SearchBusVO;

@Repository("busRoutDao")
public class BusRoutDao {

	private static final Logger log = LoggerFactory.getLogger(BusRoutDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String GET_BUS_ROUT_STOP_DETAILS_BY_TRIPID = "GET_BUS_ROUT_STOP_DETAILS_BY_TRIPID";
	private static final String GET_BUS_ROUT_DETAILS_BY_SRC_AND_DESC = "GET_BUS_ROUT_DETAILS_BY_SRC_AND_DESC";
	private static final String GET_BUS_TYPE = "GET_BUS_TYPE";

	@Transactional(readOnly = true)
	public List<BusTripDetails> getTripDetails() {
		return null;
	}

	@Transactional(readOnly = true)
	public List<BusType> getBusType() {
		String query = queriesMap.get(GET_BUS_TYPE);
		log.debug("Running insert query for getAllStation {}", query);
		return jdbcTemplate.query(query, new RowMapper<BusType>() {
			public BusType mapRow(ResultSet rs, int rowNum) throws SQLException {
				BusType busType = new BusType();
				busType.setId(rs.getInt("id"));
				busType.setBusType(rs.getString("bustype"));
				return busType;
			}

		});
	}

	@Transactional(readOnly = true)
	public List<BusRoutDetails> searchBusByAvailibleRout(SearchBusVO vo) {
		String query = queriesMap.get(GET_BUS_ROUT_DETAILS_BY_SRC_AND_DESC);
		log.debug("Running select query for searchBusByAvailibleRout: {}", query);
		return jdbcTemplate.query(query,
				new Object[] { "%" + vo.getSourceName() + "%", "%" + vo.getDestinationName() + "%" },
				new RoutDetailsRowMapper());
	}

	public List<BusStopLocationDetails> getBusStopDetails(String routId) {
		String query = queriesMap.get(GET_BUS_ROUT_STOP_DETAILS_BY_TRIPID);
		log.debug("Running select query for searchBusByAvailibleRout: {}", query);
		return jdbcTemplate.query(query, new Object[] { routId }, new BusStopLocationDetailsRowMapper());
	}
}
