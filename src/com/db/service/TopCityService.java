package com.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.TopCityDao;
import com.db.model.TopCities;

@Service
public class TopCityService {
	
	private static final Logger log = LoggerFactory.getLogger(TopCityService.class);
	
	@Autowired
	private TopCityDao topCityDao;
	
	public List<TopCities> getAllStation() {
		log.info("call getAllStation()");
		return topCityDao.getAllStation();
	}
	
	public List<TopCities> searchStationByStationName(String stationName) {
		log.info("call searchStationByStationName [{}]",stationName);
		return topCityDao.searchStationByStationName(stationName);
	}
	
	public long addStationName(TopCities searchStation) {
		log.info("call addStationName [{}]",searchStation);
		return topCityDao.addStationName(searchStation);
	}
}
