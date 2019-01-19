package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusAmenities;

public class BusAmenitiesExtractor implements ResultSetExtractor<List<BusAmenities>> {

	@Override
	public List<BusAmenities> extractData(ResultSet rs) throws SQLException {
		List<BusAmenities> amenitiesList = new ArrayList<>();
		while (rs.next()) {
			BusAmenities busAmenities = new BusAmenities();
			busAmenities.setId(rs.getString("id"));
			busAmenities.setBusid(rs.getString("busid"));
			busAmenities.setLabel(rs.getString("label"));
			busAmenities.setName(rs.getString("name"));
			busAmenities.setIcon(rs.getString("icon"));
			amenitiesList.add(busAmenities);
		}
		return amenitiesList;
	}

}
