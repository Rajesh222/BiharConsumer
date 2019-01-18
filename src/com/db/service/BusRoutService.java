package com.db.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusRoutDao;
import com.db.model.BusRoutDetails;
import com.db.model.BusBoadingStopingDetails;
import com.db.model.BusType;
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
		searchBusRoutDetails.setBusType(busRoutDao.getBusType());
		//searchBusRoutDetails.setSearchResult(getFilterBusRoutDetails(busVO));
		return searchBusRoutDetails;
	}
	
	private List<BusRoutDetails> getFilterBusRoutDetails(SearchBusVO busVO){
		List<BusRoutDetails> busRoutDetails = busRoutDao.searchBusByAvailibleRout(busVO);
		for(BusRoutDetails details : busRoutDetails) {
			//details.setBoardingLocations(busRoutDao.getBusStopDetails(details.getTripId()));
		}
		return busRoutDetails;
	}

}
