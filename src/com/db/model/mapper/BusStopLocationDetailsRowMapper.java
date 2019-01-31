package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusBoadingStopingDetails;

public class BusStopLocationDetailsRowMapper implements ResultSetExtractor<List<BusBoadingStopingDetails>> {

	@Override
	public List<BusBoadingStopingDetails> extractData(ResultSet rs) throws SQLException {
		List<BusBoadingStopingDetails> boadingStopingDetails =  new ArrayList<>();
		while(rs.next()) {
			BusBoadingStopingDetails locationDetails = new BusBoadingStopingDetails();
			locationDetails.setLocationId(rs.getString("id"));
			locationDetails.setCityId(rs.getString("cityid"));
			locationDetails.setLocationName(rs.getString("locationname"));
			locationDetails.setLocationAddress(rs.getString("locationaddress"));
			locationDetails.setLandmark(rs.getString("landmark"));
			locationDetails.setLat(rs.getDouble("lat"));
			locationDetails.setLng(rs.getDouble("lng"));
			locationDetails.setBoardingDate(rs.getDate("boardingDate"));
			locationDetails.setReportingTime(rs.getDate("reportingtime"));
			locationDetails.setContactNumber(rs.getString("contactNumber"));
			locationDetails.setBusid(rs.getString("busid"));
			boadingStopingDetails.add(locationDetails);
		}
		return boadingStopingDetails;
	}
}
