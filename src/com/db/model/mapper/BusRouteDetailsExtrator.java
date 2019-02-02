package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusRouteDetails;

public class BusRouteDetailsExtrator implements ResultSetExtractor<List<BusRouteDetails>> {

	@Override
	public List<BusRouteDetails> extractData(ResultSet rs) throws SQLException {

		List<BusRouteDetails> amenitiesList = new ArrayList<>();
		while (rs.next()) {
			BusRouteDetails busRoutDetails = new BusRouteDetails();
			busRoutDetails.setInclTaxes(true);
			busRoutDetails.setClassType("Normal");
			busRoutDetails.setBusId(rs.getString("busid"));
			busRoutDetails.setTravelsName(rs.getString("busname"));
			busRoutDetails.setBusType(rs.getString("bustype"));
			busRoutDetails.setDuration(rs.getDouble("duration"));
			busRoutDetails.setIdProofRequired(true);
			busRoutDetails.setAc(true);
			busRoutDetails.setRefundable(true);
			busRoutDetails.setRating(rs.getDouble("rating"));
			busRoutDetails.setSleaper(true);
			busRoutDetails.setRoutId(rs.getString("routid"));
			busRoutDetails.setTotalSeats(rs.getDouble("totalseats"));
			//busRoutDetails.setAvailableSeats(rs.getDouble("availableseats"));
			busRoutDetails.setArrivalDate(rs.getDate("arrivaldate").toString());
			busRoutDetails.setArrivalTime(rs.getTime("arrivaltime").toString());
			busRoutDetails.setDepartureDate(rs.getDate("departuredate").toString());
			busRoutDetails.setDepartureTime(rs.getTime("departuretime").toString());
			busRoutDetails.setSource(rs.getString("srccityname"));
			busRoutDetails.setDestination(rs.getString("destcityname"));
			List<Double> list = new ArrayList<>();
			list.add(rs.getDouble("basefare"));
			busRoutDetails.setFares(list);

			amenitiesList.add(busRoutDetails);
		}
		return amenitiesList;
	}
}
