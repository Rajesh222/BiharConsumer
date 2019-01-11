package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.db.model.BusStopLocationDetails;

public class BusStopLocationDetailsRowMapper implements RowMapper<BusStopLocationDetails> {

	@Override
	public BusStopLocationDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BusStopLocationDetails locationDetails = new BusStopLocationDetails();
		locationDetails.setId(rs.getString("id"));
		locationDetails.setLocationName(rs.getString("locationName"));
		locationDetails.setLocationAddress(rs.getString("locationAddress"));
		locationDetails.setLandmark(rs.getString("landmark"));
		locationDetails.setDateTime(rs.getString("dateTime"));
		locationDetails.setLat(rs.getDouble("lat"));
		locationDetails.setLng(rs.getDouble("lng"));
		locationDetails.setBoardingDate(rs.getDate("boardingDate"));
		locationDetails.setReportingTime(rs.getDate("reportingtime"));
		locationDetails.setContactNumber(rs.getString("contactNumber"));
		return locationDetails;
	}
}