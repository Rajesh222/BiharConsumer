package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusBookingDao;
import com.db.model.BusRoutDetailsAvailability;
import com.db.model.BusSeatDetailsAvailability;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;

@Service("busRoutService")
public class BusBookingService {

	@Autowired
	private BusBookingDao busBookingDao;

	public List<BusRoutDetailsAvailability> searchBusRoutDetails(SearchBusVO busVO) {
		List<BusRoutDetailsAvailability> availabilities = busBookingDao.searchBusByAvailibleRout(busVO);
		for(BusRoutDetailsAvailability availability : availabilities) {
			availability.setBoardingLocations(busBookingDao.getBusBoadingAndStopingPointDetails(availability.getRoutId()));
			availability.setDroppingLocations(busBookingDao.getBusBoadingAndStopingPointDetails(availability.getRoutId()));
			//availability.setBusInfo(busBookingDao.getBusDetails(busVO.getSourceName(), busVO.getDestinationName()));
		}
		return availabilities;
	}
	
	public BusSeatDetailsAvailability getSeatAvailability(String busId, String date) {
		BusSeatDetailsAvailability availability = new BusSeatDetailsAvailability();
		availability.setBusSeatDetails(busBookingDao.getSeatsDetails(busId, date));
		availability.setBoardingPoints(busBookingDao.getBusBoadingAndStopingPointDetails(busId));
		availability.setDroppingPoints(busBookingDao.getBusBoadingAndStopingPointDetails(busId));
		return availability;
	}
	
	public CustomerBusTicketVO bookedBusTicket(CustomerBusTicketVO busVO){
		return busBookingDao.bookedBusTicket(busVO);
	}
	
	public List<CustomerBusTicketVO> getHistoryBusTicket(String uid, int limit){
		return busBookingDao.getHistoryBusTicket(uid, limit);
	}

}
