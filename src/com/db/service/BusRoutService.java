package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusRoutDao;
import com.db.model.BusRoutDetails;
import com.db.model.vo.SearchBusVO;

@Service("busRoutService")
public class BusRoutService {

	@Autowired
	private BusRoutDao busRoutDao;

	
	public List<BusRoutDetails> getTrip() {
		return null;
	}

	public List<BusRoutDetails> searchBusRoutDetails(SearchBusVO busVO) {
		//BusRoutDetailsObject searchBusRoutDetails = new BusRoutDetailsObject();
		//searchBusRoutDetails.setBusType(busRoutDao.getBusType());
		//searchBusRoutDetails.setSearchResult(getFilterBusRoutDetails(busVO));
		return null;
	}
	
	private List<BusRoutDetails> getFilterBusRoutDetails(SearchBusVO busVO){
		List<BusRoutDetails> busRoutDetails = busRoutDao.searchBusByAvailibleRout(busVO);
		for(BusRoutDetails details : busRoutDetails) {
			//details.setBoardingLocations(busRoutDao.getBusStopDetails(details.getTripId()));
		}
		return busRoutDetails;
	}

}
