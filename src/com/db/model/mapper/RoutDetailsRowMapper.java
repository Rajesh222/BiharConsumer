package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusRoutDetailsAvailability;

public class RoutDetailsRowMapper implements ResultSetExtractor<List<BusRoutDetailsAvailability>> {
	
	@Override
	public List<BusRoutDetailsAvailability> extractData(ResultSet rs) throws SQLException {
		
		List<BusRoutDetailsAvailability> amenitiesList = new ArrayList<>();
		while (rs.next()) {
			BusRoutDetailsAvailability busRoutDetails = new BusRoutDetailsAvailability();
			busRoutDetails.setRoutId(rs.getString("routid"));
			busRoutDetails.setTravelsName(rs.getString("travelsname"));
			busRoutDetails.setBusNumber(rs.getString("busnumber"));
			busRoutDetails.setAvalableSeats(rs.getDouble("availableseats"));
			busRoutDetails.setTotalSeats(rs.getDouble("totalseats"));
			busRoutDetails.setBusType(rs.getString("bustype"));
			busRoutDetails.setCreatedOn(rs.getDate("createdon"));
			busRoutDetails.setCreatedBy(rs.getString("createdby"));
			busRoutDetails.setModifyOn(rs.getDate("modifyon"));
			busRoutDetails.setModifyBy(rs.getString("modifyby"));
			
			busRoutDetails.setTravelDurationDays(rs.getInt("travelDurationDays"));
			busRoutDetails.setArrivalDate(rs.getDate("arrivalDate").toString());
			busRoutDetails.setDepartureDate(rs.getDate("departureDate").toString());
			busRoutDetails.setDuration(rs.getString("duration"));
			amenitiesList.add(busRoutDetails);
		}
		return amenitiesList;
	}
}
