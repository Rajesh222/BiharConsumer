package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.db.model.BusRoutDetails;

public class RoutDetailsRowMapper implements RowMapper<BusRoutDetails> {

	@Override
	public BusRoutDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BusRoutDetails busRoutDetails = new BusRoutDetails();
		busRoutDetails.setRoutId(rs.getString("routid"));
		busRoutDetails.setUserId(rs.getString("userid"));
		busRoutDetails.setTravelsName(rs.getString("travelsname"));
		busRoutDetails.setBusNumber(rs.getString("busnumber"));
		busRoutDetails.setAvailableSeats(rs.getDouble("availableseats"));
		busRoutDetails.setTotalSeats(rs.getDouble("totalseats"));
		busRoutDetails.setBusType(rs.getString("bustype"));
		busRoutDetails.setDirection(rs.getString("direction"));
		busRoutDetails.setSourceName(rs.getString("sourceName"));
		busRoutDetails.setSrcCityName(rs.getString("srcCityName"));
		busRoutDetails.setSourceName(rs.getString("sourceName"));
		busRoutDetails.setDestCityName(rs.getString("destCityName"));
		busRoutDetails.setDestinationName(rs.getString("destinationName"));
		busRoutDetails.setTraveldate(rs.getDate("traveldate"));
		busRoutDetails.setCreatedOn(rs.getDate("createdon"));
		busRoutDetails.setCreatedBy(rs.getString("createdby"));
		busRoutDetails.setModifyOn(rs.getDate("modifyon"));
		busRoutDetails.setModifyBy(rs.getString("modifyby"));
		
		busRoutDetails.setTripId(rs.getString("tripId"));
		busRoutDetails.setBasefare(rs.getDouble("basefare"));
		busRoutDetails.setServicetax(rs.getDouble("servicetax"));
		busRoutDetails.setTotalfare(rs.getDouble("totalfare"));
		busRoutDetails.setTravelDurationDays(rs.getInt("travelDurationDays"));
		busRoutDetails.setArrivalDate(rs.getDate("arrivalDate"));
		busRoutDetails.setDepartureDate(rs.getDate("departureDate"));
		busRoutDetails.setDistance(rs.getDouble("distance"));
		busRoutDetails.setDuration(rs.getString("duration"));
		return busRoutDetails;
	}
}
