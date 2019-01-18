package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.db.model.BusBoadingStopingDetails;

public class BusStopLocationDetailsRowMapper implements RowMapper<BusBoadingStopingDetails> {

	@Override
	public BusBoadingStopingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BusBoadingStopingDetails locationDetails = new BusBoadingStopingDetails();
		locationDetails.setLocationId(rs.getString("id"));
		locationDetails.setLocationName(rs.getString("locationName"));
		locationDetails.setLocationAddress(rs.getString("locationAddress"));
		locationDetails.setLandmark(rs.getString("landmark"));
		locationDetails.setLat(rs.getDouble("lat"));
		locationDetails.setLng(rs.getDouble("lng"));
		locationDetails.setBoardingDate(rs.getDate("boardingDate"));
		locationDetails.setReportingTime(rs.getDate("reportingtime"));
		locationDetails.setContactNumber(rs.getString("contactNumber"));
		
		return locationDetails;
	}
}
