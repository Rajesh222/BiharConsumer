package com.db.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.db.model.User;

public class UserExtrator implements ResultSetExtractor<List<User>> {
	
	@Override
	public List<User> extractData(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<>();
		while(rs.next()) {
			User user = new User();
			user.setUserId(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setPhoneNumber(rs.getString("phonenumber"));
			user.setPanNumber(rs.getString("pannumber"));
			user.setPassword(rs.getString("password"));
			user.setCity(rs.getString("city"));
			user.setState(rs.getString("state"));
			user.setCountry(rs.getString("country"));
			user.setLock(rs.getBoolean("islock"));
			user.setActive(rs.getBoolean("isactive"));
			user.setAttempt(rs.getInt("attempt"));
			user.setCreatedBy(rs.getString("createdby"));
			user.setCreatedOn(rs.getDate("createdon"));
			user.setModifyBy(rs.getString("modifyby"));
			user.setModifyOn(rs.getDate("modifyon"));
			users.add(user);
		}
		return users;
	}

}
