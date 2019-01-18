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

import com.db.model.BusAmenities;
import com.db.model.BusBoadingStopingDetails;
import com.db.model.BusCancellationPolicies;
import com.db.model.BusRoutDetails;
import com.db.model.BusType;
import com.db.model.mapper.BusAmenitiesExtractor;
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
	private static final String SELECT_BUSTYPE_BY_BUSID = "SELECT_BUSTYPE_BY_BUSID";
	private static final String SELECT_CANCELLATION_POLICIES_BY_BUSID = "SELECT_CANCELLATION_POLICIES_BY_BUSID";
	private static final String SELECT_BUS_AMENITIES_BY_BUSID = "SELECT_BUS_AMENITIES_BY_BUSID";

	@Transactional(readOnly = true)
	public List<BusAmenities> getBusAmenitiesByBusId(String bid) {
		String query = queriesMap.get(SELECT_BUS_AMENITIES_BY_BUSID);
		log.debug("Running insert query for getCancellationPoliciesByBusId {}", query);
		return jdbcTemplate.query(query, new BusAmenitiesExtractor());
	}
	
	@Transactional(readOnly = true)
	public List<BusCancellationPolicies> getCancellationPoliciesByBusId(String bid) {
		String query = queriesMap.get(SELECT_CANCELLATION_POLICIES_BY_BUSID);
		log.debug("Running insert query for getCancellationPoliciesByBusId {}", query);
		return jdbcTemplate.query(query, new RowMapper<BusCancellationPolicies>() {
			public BusCancellationPolicies mapRow(ResultSet rs, int rowNum) throws SQLException {
				BusCancellationPolicies busCancellation = new BusCancellationPolicies();
				busCancellation.setRuleId(rs.getString("ruleid"));
				busCancellation.setBusid(rs.getString("busid"));
				busCancellation.setDepartureheading(rs.getString("departureheading"));
				busCancellation.setPolicyheading(rs.getString("policyheading"));
				return busCancellation;
			}
		});
	}

	@Transactional(readOnly = true)
	public List<BusType> getBusType() {
		String query = queriesMap.get(SELECT_BUSTYPE_BY_BUSID);
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

	public List<BusBoadingStopingDetails> getBusStopDetails(String routId) {
		String query = queriesMap.get(GET_BUS_ROUT_STOP_DETAILS_BY_TRIPID);
		log.debug("Running select query for searchBusByAvailibleRout: {}", query);
		return jdbcTemplate.query(query, new Object[] { routId }, new BusStopLocationDetailsRowMapper());
	}
}
