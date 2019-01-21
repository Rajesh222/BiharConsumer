package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.CabBookingDao;
import com.db.model.CabBookingPrice;

@Service("cabBookingService")
public class CabBookingService {

	@Autowired
	private CabBookingDao cabBookingDao;
	
	public List<CabBookingPrice> getAllCabBookingPrice() {
		return cabBookingDao.getAllCabBookingPrice();
	}

	public CabBookingPrice getCabBookingPrice(String cabType) {
		return cabBookingDao.getCabBookingPrice(cabType);
	}
	
}
