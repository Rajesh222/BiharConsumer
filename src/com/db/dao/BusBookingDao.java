package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.BusAmenity;
import com.db.model.BusBoadingStopingDetails;
import com.db.model.BusCancellationPolicies;
import com.db.model.BusDetails;
import com.db.model.BusRouteDetails;
import com.db.model.BusSeatDetails;
import com.db.model.BusType;
import com.db.model.mapper.BusAmenitiesExtractor;
import com.db.model.mapper.BusInformationDetailsExtractor;
import com.db.model.mapper.BusRouteDetailsExtrator;
import com.db.model.mapper.BusSeatDetailsExtractor;
import com.db.model.mapper.BusStopLocationDetailsRowMapper;
import com.db.model.mapper.CustomerMapperExtrator;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;
import com.db.utils.DataUtils;

@Repository("busRoutDao")
public class BusBookingDao {

	private static final Logger log = LoggerFactory.getLogger(BusBookingDao.class);

	@Value("${select_route_by_src_desc}")
    private String selectSearchBusBySrcAndDescDateQuery;
	@Value("${select_boadingstopping_details}")
    private String selectBoadingStoppingDetailQuery;
	@Value("${select_bustype}")
    private String selectBusTypeQuery;
	@Value("${select_bus_cancellation}")
    private String selectBusCancellationPolicyQuery;
	@Value("${select_filter_aminities}")
    private String selectFilterAminitiesQuery;
	@Value("${select_all_aminities}")
    private String selectAllAminitiesQuery;
	@Value("${select_businfomation_detail}")
    private String selectBusInfoQuery;
	@Value("${insert_customer_ticket}")
    private String insertCustomerBookTicketQuery;
	@Value("${select_bus_seat_details}")
    private String selectBusSeatDetailsQuery;
	@Value("${select_customer_book_ticket}")
    private String selectCustomerBookTicketQuery;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<BusRouteDetails> searchBusBySrcDescAndDate(SearchBusVO vo) {
		log.debug("Running select query for searchBusByAvailibleRout: {}", selectSearchBusBySrcAndDescDateQuery);
		return jdbcTemplate.query(selectSearchBusBySrcAndDescDateQuery, new Object[] { "%" + vo.getSourceName() + "%",
				"%" + vo.getDestinationName() + "%", vo.getDate() }, new BusRouteDetailsExtrator());
	}

	@Transactional(readOnly = true)
	public List<BusBoadingStopingDetails> getBusBoadingAndStopingPointDetails(String busId, String sourceName) {
		log.debug("Running select query for searchBusByAvailibleRout: {}", selectBoadingStoppingDetailQuery);
		return jdbcTemplate.query(selectBoadingStoppingDetailQuery, new Object[] { sourceName , busId}, new BusStopLocationDetailsRowMapper());
	}
	
	@Transactional(readOnly = true)
	public List<BusType> getBusType() {
		log.debug("Running insert query for getBusType {}", selectBusTypeQuery);
		return jdbcTemplate.query(selectBusTypeQuery, new RowMapper<BusType>() {
			public BusType mapRow(ResultSet rs, int rowNum) throws SQLException {
				BusType busType = new BusType();
				busType.setId(rs.getInt("id"));
				busType.setBusType(rs.getString("bustype"));
				return busType;
			}

		});
	}
	
	@Transactional(readOnly = true)
	public List<BusCancellationPolicies> getCancellationPolicy() {
		log.debug("Running insert query for getCancellationPoliciesByBusId {}", selectBusCancellationPolicyQuery);
		return jdbcTemplate.query(selectBusCancellationPolicyQuery, new RowMapper<BusCancellationPolicies>() {
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
	public List<BusAmenity> getBusAmenitiesByBusId(String bid) {
		log.debug("Running insert query for getBusAmenitiesByBusId {}", selectFilterAminitiesQuery);
		return jdbcTemplate.query(selectFilterAminitiesQuery, new BusAmenitiesExtractor());
	}
	
	@Transactional(readOnly = true)
	public List<BusAmenity> getAllAmenities() {
		log.debug("Running insert query for getBusAmenitiesByBusId {}", selectAllAminitiesQuery);
		return jdbcTemplate.query(selectFilterAminitiesQuery, new BusAmenitiesExtractor());
	}
	
	@Transactional(readOnly = true)
	public List<BusDetails> getBusDetails(String source, String destination) {
		log.debug("Running insert query for getCancellationPoliciesByBusId {}", selectBusInfoQuery);
		return jdbcTemplate.query(selectBusInfoQuery, new Object[] { "%" + source + "%", "%" + destination + "%" },
				new BusInformationDetailsExtractor());
	}

	@Transactional(readOnly = true)
	public List<BusSeatDetails> getSeatsDetails(String busId, String date) {
		log.debug("Running select query for getTripsDetails: {}", selectBusSeatDetailsQuery);
		return jdbcTemplate.query(selectBusSeatDetailsQuery,
				new Object[] { busId, DataUtils.convertDateToStringFormat(date, "dd-mm-yyyy") },
				new BusSeatDetailsExtractor());
	}

	@Transactional
	public CustomerBusTicketVO bookedBusTicket(CustomerBusTicketVO busVO) {
		log.debug("Running insert query for addUser: {}", insertCustomerBookTicketQuery);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(insertCustomerBookTicketQuery, Statement.RETURN_GENERATED_KEYS);
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
		log.debug("Running insert query for addUser: {}", selectCustomerBookTicketQuery);
		return jdbcTemplate.query(selectCustomerBookTicketQuery, new Object[] {uid.toLowerCase(),limit}, new CustomerMapperExtrator());
	}
}
