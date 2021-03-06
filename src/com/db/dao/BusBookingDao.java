package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
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
import com.db.model.mapper.BusTripDetailsExtrator;
import com.db.model.mapper.BusSeatDetailsExtractor;
import com.db.model.mapper.BusStopLocationDetailsRowMapper;
import com.db.model.mapper.CustomerMapperExtrator;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchTripVO;
import com.db.utils.DataUtils;
/**
 * @author Satyam Kumar
 *
 */
@Repository("busRoutDao")
public class BusBookingDao {

	private static final Logger log = LoggerFactory.getLogger(BusBookingDao.class);

	@Value("${select_trip_by_city}")
	private String selectSearchTripBySrcAndDescDateQuery;
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
	public List<BusRouteDetails> searchTriBySrcDescAndDate(String source,String destination, String date) {
		log.debug("Running select query for searchTriBySrcDescAndDate: {}", selectSearchTripBySrcAndDescDateQuery);
		return jdbcTemplate.query(selectSearchTripBySrcAndDescDateQuery,
				new Object[] { "%" + source.toLowerCase() + "%", "%" + destination.toLowerCase() + "%", DataUtils.convertFormat(date) },
				new BusTripDetailsExtrator());
	}

	@Transactional(readOnly = true)
	public List<BusBoadingStopingDetails> getBusBoadingAndStopingPointDetails(String trip) {
		log.debug("Running select query for getBusBoadingAndStopingPointDetails: {}", selectBoadingStoppingDetailQuery);
		return jdbcTemplate.query(selectBoadingStoppingDetailQuery, new Object[] { trip },
				new BusStopLocationDetailsRowMapper());
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
	public List<BusCancellationPolicies> getCancellationPolicy(String operatorId) {
		log.debug("Running insert query for getCancellationPolicy {}", selectBusCancellationPolicyQuery);
		return jdbcTemplate.query(selectBusCancellationPolicyQuery,new Object[] {operatorId}, new RowMapper<BusCancellationPolicies>() {
			public BusCancellationPolicies mapRow(ResultSet rs, int rowNum) throws SQLException {
				BusCancellationPolicies busCancellation = new BusCancellationPolicies();
				busCancellation.setRuleId(rs.getString("policyid"));
				busCancellation.setBusid(rs.getString("busid"));
				busCancellation.setDepartureheading(rs.getString("departureheading"));
				busCancellation.setPolicyheading(rs.getString("policyheading"));
				return busCancellation;
			}
		});
	}

	@Transactional(readOnly = true)
	public List<Integer> getBusFilterAmenitiesByBusId(String bid) {
		log.debug("Running insert query for getBusAmenitiesByBusId {}", selectFilterAminitiesQuery);
		return jdbcTemplate.query(selectFilterAminitiesQuery, new Object[] { bid },	new ResultSetExtractor<List<Integer>>() {
					@Override
					public List<Integer> extractData(ResultSet rs) throws SQLException {
						List<Integer> amenitiesList = new ArrayList<>();
						while (rs.next()) {
							amenitiesList.add(rs.getInt("amenityid"));
						}
						return amenitiesList;
					}
		});
	}

	@Transactional(readOnly = true)
	public List<BusAmenity> getAllAmenities() {
		log.debug("Running insert query for getAllAmenities {}", selectAllAminitiesQuery);
		return jdbcTemplate.query(selectAllAminitiesQuery, new BusAmenitiesExtractor());
	}

	@Transactional(readOnly = true)
	public List<BusDetails> getBusDetails(String source, String destination) {
		log.debug("Running insert query for getBusDetails {}", selectBusInfoQuery);
		return jdbcTemplate.query(selectBusInfoQuery, new Object[] { "%" + source + "%", "%" + destination + "%" },
				new BusInformationDetailsExtractor());
	}

	@Transactional(readOnly = true)
	public List<BusSeatDetails> getSeatsDetails(SearchTripVO tripVO) {
		log.debug("Running select query for getSeatsDetails: {}", selectBusSeatDetailsQuery);
		Integer startStop = Integer.parseInt(tripVO.getTripId().split("::")[2]);
		Integer endStop = Integer.parseInt(tripVO.getTripId().split("::")[3]);
		return jdbcTemplate.query(selectBusSeatDetailsQuery,
				new Object[] { startStop, endStop, startStop, endStop, tripVO.getOperatorId().toLowerCase() },
				new BusSeatDetailsExtractor());
	}

	@Transactional
	public CustomerBusTicketVO bookedBusTicket(CustomerBusTicketVO busVO) {
		log.debug("Running insert query for bookedBusTicket: {}", insertCustomerBookTicketQuery);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(insertCustomerBookTicketQuery,
						Statement.RETURN_GENERATED_KEYS);
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

	public List<CustomerBusTicketVO> getHistoryBusTicket(String uid, int limit) {
		log.debug("Running insert query for getHistoryBusTicket: {}", selectCustomerBookTicketQuery);
		return jdbcTemplate.query(selectCustomerBookTicketQuery, new Object[] { uid.toLowerCase(), limit },
				new CustomerMapperExtrator());
	}
}
