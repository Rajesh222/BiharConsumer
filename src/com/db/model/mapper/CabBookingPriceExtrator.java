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
			CabBookingPrice bookingPrice = new CabBookingPrice();
			bookingPrice.setId(rs.getString("id"));
			bookingPrice.setKilometer(rs.getString("kilometer"));
			bookingPrice.setFarerate(rs.getDouble("farerate"));
			bookingPrice.setCity(rs.getString("city"));
			bookingPrice.setState(rs.getString("state"));
			bookingPrice.setCountry(rs.getString("country"));
			bookingPrice.setCabtype(rs.getString("cabtype"));
			bookingPrices.add(bookingPrice);
		}
		return bookingPrices;
	}

}
