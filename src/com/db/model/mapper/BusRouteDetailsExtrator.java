package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusRoutDetailsObject;

public class BusRouteDetailsExtrator implements ResultSetExtractor<List<BusRoutDetailsObject>> {

	@Override
	public List<BusRoutDetailsObject> extractData(ResultSet rs) throws SQLException {

		List<BusRoutDetailsObject> amenitiesList = new ArrayList<>();
		while (rs.next()) {
			BusRoutDetailsObject busRoutDetails = new BusRoutDetailsObject();
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
			busRoutDetails.setAvalableSeats(rs.getDouble("availableseats"));
			busRoutDetails.setArrivalDate(rs.getDate("arrivaldate").toString());
			busRoutDetails.setArrivalTime(rs.getTime("arrivaltime").toString());
			busRoutDetails.setDepartureDate(rs.getDate("departuredate").toString());
			busRoutDetails.setDepartureTime(rs.getTimestamp("departuretime").toString());
			busRoutDetails.setSource(rs.getString("srccityname"));
			busRoutDetails.setDestination(rs.getString("destcityname"));
			List<Double> list = new ArrayList<>();
			list.add(rs.getDouble("totalBaseFare"));
			busRoutDetails.setFare(list);

			amenitiesList.add(busRoutDetails);
		}
		return amenitiesList;
	}
}
