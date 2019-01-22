package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusRoutDetailsAvailability;

public class BusRoutDetailsExtrator implements ResultSetExtractor<List<BusRoutDetailsAvailability>> {

	@Override
	public List<BusRoutDetailsAvailability> extractData(ResultSet rs) throws SQLException {

		List<BusRoutDetailsAvailability> amenitiesList = new ArrayList<>();
		while (rs.next()) {
			BusRoutDetailsAvailability busRoutDetails = new BusRoutDetailsAvailability();
			busRoutDetails.setRoutId(rs.getString("routid"));
			busRoutDetails.setClassType("Normal");
			busRoutDetails.setBusId(rs.getString("busid"));
			busRoutDetails.setTravelsName(rs.getString("busname"));
			busRoutDetails.setBusType((rs.getBoolean("isNonAc") == false ? "NON A/C " : "A/C ").concat(rs.getString("seattype")));// to map
			busRoutDetails.setDuration(rs.getString("duration"));
			//busRoutDetails.setIdProofRequired(rs.getBoolean("idProofRequired"));
			busRoutDetails.setAc(rs.getBoolean("isNonAc"));
			busRoutDetails.setRating(rs.getString("rating"));
			busRoutDetails.setSleaper(rs.getBoolean("isSleaper"));
			busRoutDetails.setSourceId(rs.getString("sourceid"));
			busRoutDetails.setDestinationId(rs.getString("destinationid"));
			busRoutDetails.setTotalSeats(rs.getDouble("totalseats"));
			busRoutDetails.setAvalableSeats(rs.getDouble("availableseats"));
			busRoutDetails.setTravelDurationDays(rs.getInt("traveldurationdays"));
			busRoutDetails.setArrivalDate(rs.getTimestamp("arrivaldatetime").toString());
			busRoutDetails.setArrivalTime("");
			busRoutDetails.setDepartureDate(rs.getTimestamp("departuredatetime").toString());
			busRoutDetails.setDepartureTime("");
			busRoutDetails.setTravelDate(rs.getTimestamp("travaldate").toString());
			busRoutDetails.setBusNumber(rs.getString("busnumber"));
			busRoutDetails.setSeatType(rs.getString("seattype"));
			busRoutDetails.setSource(rs.getString("srccityname"));
			busRoutDetails.setDestination(rs.getString("destcityname"));
			busRoutDetails.setBoardingTime("");
			busRoutDetails.setReportingTime("");
			List<Double> list = new ArrayList<>();
			list.add(rs.getDouble("totalfare"));
			busRoutDetails.setFare(list);
			
			amenitiesList.add(busRoutDetails);
		}
		return amenitiesList;
	}
}
