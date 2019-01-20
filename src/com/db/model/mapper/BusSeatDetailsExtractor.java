package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.BusSeatDetails;

public class BusSeatDetailsExtractor implements ResultSetExtractor<List<BusSeatDetails>>{

	@Override
	public List<BusSeatDetails> extractData(ResultSet rs) throws SQLException {
		return null;
	}

}
