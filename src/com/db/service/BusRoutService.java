package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusRoutDao;
import com.db.model.BusRoutDetailsAvailability;
import com.db.model.BusSeatDetailsAvailability;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;

@Service("busRoutService")
public class BusRoutService {

	@Autowired
	private BusRoutDao busRoutDao;

	
	public List<BusRoutDetailsAvailability> getTrip() {
		return null;
	}

	public List<BusRoutDetailsAvailability> searchBusRoutDetails(SearchBusVO busVO) {
		return busRoutDao.searchBusByAvailibleRout(busVO);
	}
	
	public BusSeatDetailsAvailability getSeatAvailability(String busId, String date) {
		BusSeatDetailsAvailability availability = new BusSeatDetailsAvailability();
		availability.setBusSeatDetails(busRoutDao.getSeatsDetails(busId, date));
		availability.setBoardingPoints(busRoutDao.getBusBoadingAndStopingPointDetails(busId));
		availability.setDroppingPoints(busRoutDao.getBusBoadingAndStopingPointDetails(busId));
		return availability;
	}
	
	public CustomerBusTicketVO bookedBusTicket(CustomerBusTicketVO busVO){
		return busRoutDao.bookedBusTicket(busVO);
	}
	
	public List<CustomerBusTicketVO> getHistoryBusTicket(String uid, int limit){
		return busRoutDao.getHistoryBusTicket(uid, limit);
	}

}
