package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.BusAmenities;
import com.db.model.BusBoadingStopingDetails;
import com.db.model.BusCancellationPolicies;
import com.db.model.BusDetails;
import com.db.model.BusRoutDetailsAvailability;
import com.db.model.BusSeatDetails;
import com.db.model.BusType;
import com.db.model.mapper.BusAmenitiesExtractor;
import com.db.model.mapper.BusInformationDetailsExtractor;
import com.db.model.mapper.BusRoutDetailsExtrator;
import com.db.model.mapper.BusSeatDetailsExtractor;
import com.db.model.mapper.BusStopLocationDetailsRowMapper;
import com.db.model.mapper.CustomerMapperExtrator;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;
import com.db.utils.DataUtils;

@Repository("busRoutDao")
public class BusRoutDao {

	private static final Logger log = LoggerFactory.getLogger(BusRoutDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_BUS_BOADING_AND_STOPING_POINT_DETAILS_BY_TRIPID = "SELECT_BUS_BOADING_AND_STOPING_POINT_DETAILS_BY_TRIPID";
	private static final String SELECT_BUS_ROUT_DETAILS_BY_SRC_AND_DESC = "SELECT_BUS_ROUT_DETAILS_BY_SRC_AND_DESC";
	private static final String SELECT_BUSTYPE_BY_BUSID = "SELECT_BUSTYPE_BY_BUSID";
	private static final String SELECT_CANCELLATION_POLICIES_BY_BUSID = "SELECT_CANCELLATION_POLICIES_BY_BUSID";
	private static final String SELECT_BUS_AMENITIES_BY_BUSID = "SELECT_BUS_AMENITIES_BY_BUSID";
	private static final String SELECT_BUS_DETAILS_BY_SOURCE_AND_DESTINATION = "SELECT_BUS_DETAILS_BY_SOURCE_AND_DESTINATION";
	private static final String SELECT_BUS_SEATS_DETAILS_BY_BUSID_AND_DATE = "SELECT_BUS_SEATS_DETAILS_BY_BUSID_AND_DATE";
	private static final String INSERT_BOOK_BUS_TICKET = "INSERT_BOOK_BUS_TICKET";
	private static final String SELECT_BUS_TICKET_HISTORY = "SELECT_BUS_TICKET_HISTORY";
	
	@Transactional(readOnly = true)
	public List<BusAmenities> getBusAmenitiesByBusId(String bid) {
		String query = queriesMap.get(SELECT_BUS_AMENITIES_BY_BUSID);
		log.debug("Running insert query for getBusAmenitiesByBusId {}", query);
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
		log.debug("Running insert query for getBusType {}", query);
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
	public List<BusDetails> getBusDetails(String source, String destination) {
		String query = queriesMap.get(SELECT_BUS_DETAILS_BY_SOURCE_AND_DESTINATION);
		log.debug("Running insert query for getCancellationPoliciesByBusId {}", query);
		return jdbcTemplate.query(query, new Object[] { "%" + source + "%", "%" + destination + "%" },
				new BusInformationDetailsExtractor());
	}

	@Transactional(readOnly = true)
	public List<BusRoutDetailsAvailability> searchBusByAvailibleRout(SearchBusVO vo) {
		String query = queriesMap.get(SELECT_BUS_ROUT_DETAILS_BY_SRC_AND_DESC);
		log.debug("Running select query for searchBusByAvailibleRout: {}", query);
		return jdbcTemplate.query(query, new Object[] { vo.getDate(), "%" + vo.getSourceName() + "%",
				"%" + vo.getDestinationName() + "%", vo.getDate() }, new BusRoutDetailsExtrator());
	}

	@Transactional(readOnly = true)
	public List<BusBoadingStopingDetails> getBusBoadingAndStopingPointDetails(String routId) {
		String query = queriesMap.get(SELECT_BUS_BOADING_AND_STOPING_POINT_DETAILS_BY_TRIPID);
		log.debug("Running select query for searchBusByAvailibleRout: {}", query);
		return jdbcTemplate.query(query, new BusStopLocationDetailsRowMapper());
	}

	@Transactional(readOnly = true)
	public List<BusSeatDetails> getSeatsDetails(String busId, String date) {
		String query = queriesMap.get(SELECT_BUS_SEATS_DETAILS_BY_BUSID_AND_DATE);
		log.debug("Running select query for getTripsDetails: {}", query);
		return jdbcTemplate.query(query,
				new Object[] { busId, DataUtils.convertDateToStringFormat(date, "dd-mm-yyyy") },
				new BusSeatDetailsExtractor());
	}

	@Transactional
	public CustomerBusTicketVO bookedBusTicket(CustomerBusTicketVO busVO) {
		String query = queriesMap.get(INSERT_BOOK_BUS_TICKET);
		log.debug("Running insert query for addUser: {}", query);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, busVO.getUserid());
				ps.setString(2, busVO.getBusname());
				ps.setString(3, busVO.getBusnumber());
				ps.setString(4, busVO.getSeatnumber());
				ps.setString(5, busVO.getSrccityname());
				ps.setString(6, busVO.getDestcityname());
				ps.setString(7, busVO.getArrivaldatetime());
				ps.setString(8, busVO.getDeparturedatetime());
				ps.setString(9, busVO.getSeattype());
				ps.setDouble(10, busVO.getTotalfare());
				ps.setString(11, busVO.getCustomername());
				ps.setInt(12, busVO.getAge());
				ps.setString(13, busVO.getEmail());
				ps.setString(13, busVO.getPhonenumber());
				ps.setString(15, busVO.getIdtype());
				ps.setString(16, busVO.getIdnumber());
				ps.setBoolean(17, busVO.isIslicence());
				return ps;
			}
		}, holder);
		return (CustomerBusTicketVO) holder.getKeys();
	}
	
	public List<CustomerBusTicketVO> getHistoryBusTicket(String uid, int limit){
		String query = queriesMap.get(SELECT_BUS_TICKET_HISTORY);
		log.debug("Running insert query for addUser: {}", query);
		return jdbcTemplate.query(query, new Object[] {uid.toLowerCase(),limit}, new CustomerMapperExtrator());
	}
	

}
