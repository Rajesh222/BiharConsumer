package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusRoutDao;
import com.db.model.BusRoutDetails;
import com.db.model.BusStopLocationDetails;
import com.db.model.SearchBusRoutDetails;
import com.db.model.vo.SearchBusVO;

@Service("busRoutService")
public class BusRoutService {

	@Autowired
	private BusRoutDao busRoutDao;

	public List<BusRoutDetails> getTrip() {
		return null;
	}

	public SearchBusRoutDetails searchBusRoutDetails(SearchBusVO busVO) {
		SearchBusRoutDetails searchBusRoutDetails = new SearchBusRoutDetails();
		List<BusRoutDetails> busRoutDetails = busRoutDao.searchBusByAvailibleRout(busVO);
		searchBusRoutDetails.setSearchResult(busRoutDetails);
		List<BusStopLocationDetails> locationDetails = busRoutDao.getBusStopDetails(busRoutDetails.isEmpty() ? null:busRoutDetails.get(0).getTripId());
        searchBusRoutDetails.setBoardingLocations(locationDetails);
        searchBusRoutDetails.setDroppingLocations(locationDetails);
		return null;
	}

}
