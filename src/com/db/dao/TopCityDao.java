package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.TopCities;
import com.db.model.TopCityRowMapper;

@Repository("topCityDao")
public class TopCityDao {

	private static final Logger log = LoggerFactory.getLogger(TopCityDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String TOP_CITIES_LOGS = "TOP_CITIES_LOGS";
	private static final String SEARCH_TOP_CITIES_LOGS = "SEARCH_TOP_CITIES_LOGS";
	private static final String INSERT_TOP_CITIES = "INSERT_TOP_CITIES";

	/*
	 * @Transactional public List<BusRoutDetails> searchBusList(String source,
	 * String destination, String date) { Session session =
	 * this.sessionFactory.getCurrentSession(); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); StringBuilder query = new
	 * StringBuilder("from BusHistory "); if (sdf != null)
	 * query.append(" where date >= '" + sdf.format(date) + "'"); else
	 * query.append(" where date >= now()"); query.append(" order by date"); Query
	 * result = session.createQuery(query.toString()); return
	 * result.getResultList(); }
	 */

	@Transactional(readOnly = true)
	public List<TopCities> getAllStation() {
		String query = queriesMap.get(TOP_CITIES_LOGS);
		log.debug("Running insert query for getAllStation {}", query);
		return jdbcTemplate.query(query, new TopCityRowMapper());
	}

	@Transactional
	public List<TopCities> searchStationByStationName(String stationName) {
		String query = queriesMap.get(SEARCH_TOP_CITIES_LOGS);
		log.debug("Running insert query for getAllStation {}", query);
		return jdbcTemplate.query(query, new Object[] { "%"+stationName+"%" }, new TopCityRowMapper());
	}

	@Transactional
	public Long addStationName(TopCities topCities) {
		String query = queriesMap.get(INSERT_TOP_CITIES);
		log.debug("Running insert query for addStationName {}", query);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, topCities.getCity());
				ps.setString(2, topCities.getDisplayName());
				ps.setString(3, topCities.getState());
				return ps;
			}
		}, holder);
		return (Long) holder.getKeys().get("refnumber");
	}
}
