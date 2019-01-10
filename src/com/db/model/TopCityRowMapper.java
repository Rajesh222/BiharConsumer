package com.db.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TopCityRowMapper implements RowMapper<TopCities> {
	
	@Override
	public TopCities mapRow(ResultSet rs, int rowNum) throws SQLException {
		TopCities user = new TopCities();
		user.setId(rs.getInt("refnumber"));
		user.setDisplayName(rs.getString("displayname"));
		user.setCity(rs.getString("cityname"));
		user.setState(rs.getString("statename"));
		return user;
	}
}
