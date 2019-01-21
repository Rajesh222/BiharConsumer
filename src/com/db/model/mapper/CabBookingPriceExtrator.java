package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.CabBookingPrice;

public class CabBookingPriceExtrator implements ResultSetExtractor<List<CabBookingPrice>> {

	@Override
	public List<CabBookingPrice> extractData(ResultSet rs) throws SQLException {
		List<CabBookingPrice> bookingPrices =  new ArrayList<>();
		while(rs.next()) {
			CabBookingPrice locationDetails = new CabBookingPrice();
			locationDetails.setId(rs.getString("id"));
			locationDetails.setKilometer(rs.getString("kilometer"));
			locationDetails.setFarerate(rs.getDouble("farerate"));
			locationDetails.setCity(rs.getString("city"));
			locationDetails.setState(rs.getString("state"));
			locationDetails.setCountry(rs.getString("country"));
			bookingPrices.add(locationDetails);
		}
		return bookingPrices;
	}

}
