package com.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.TravelHistoryDao;
import com.db.model.BusRoutDetails;
import com.db.model.TravelHistory;

@Service
public class TravelHistoryService {
	
	private static final Logger log = LoggerFactory.getLogger(TravelHistoryService.class);
	
	@Autowired
	private TravelHistoryDao searchStationDao;
	
	public List<BusRoutDetails> searchBusList(String source, String destination, String date) {
		log.info("call searchTravel [source :{}, destination : {}, date : {}]", source, destination, date);
		return searchStationDao.searchBusList(source , destination, date);
	}
	
	public List<TravelHistory> getAllStation() {
		log.info("call getAllStation()");
		return searchStationDao.getAllStation();
	}
	
	public List<TravelHistory> searchStationByStationName(String stationName) {
		log.info("call searchStationByStationName [{}]",stationName);
		return searchStationDao.searchStationByStationName(stationName);
	}
	
	public boolean addStationName(TravelHistory searchStation) {
		log.info("call addStationName [{}]",searchStation);
		return searchStationDao.addStationName(searchStation);
	}
}
