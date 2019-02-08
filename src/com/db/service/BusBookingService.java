package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusBookingDao;
import com.db.model.BusDetailsObject;
import com.db.model.BusRouteDetails;
import com.db.model.BusSeatDetailsObject;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchTripVO;
import com.db.utils.DataUtils;

@Service
public class BusBookingService {

	@Autowired
	private BusBookingDao busBookingDao;

	public BusDetailsObject searchBusRoutDetails(String source, String destination, String date) {
		BusDetailsObject busDetailsObject = new BusDetailsObject();
		List<BusRouteDetails> filterRoutes = busBookingDao.searchBusBySrcDescAndDate(source, destination, date);
		for(BusRouteDetails route : filterRoutes) {
			//route.setBoardingLocations(busBookingDao.getBusBoadingAndStopingPointDetails(route.getOperatorId(),busVO.getSourceName().toLowerCase()));
			//route.setDroppingLocations(busBookingDao.getBusBoadingAndStopingPointDetails(route.getBusId(),busVO.getDestinationName().toLowerCase()));
		    route.setCancellationPolicy(busBookingDao.getCancellationPolicy(route.getOperatorId()));
		    route.setAmenities(busBookingDao.getBusFilterAmenitiesByBusId(route.getOperatorId()));
		}
		busDetailsObject.setFilterRouteList(filterRoutes);
		busDetailsObject.setAmenityList(busBookingDao.getAllAmenities());
		List<String> timeList = DataUtils.getTimeList();
		busDetailsObject.setArrivalTimeList(timeList);
		busDetailsObject.setDepartureTimeList(timeList);
		return busDetailsObject;
	}
	
	//@Cacheable("tripsDetails")
	public BusSeatDetailsObject getSeatAvailability(SearchTripVO tripVO) {
		BusSeatDetailsObject availability = new BusSeatDetailsObject();
		//availability.setBusSeatDetails(busBookingDao.getSeatsDetails(busId, date));
		//availability.setBoardingPoints(busBookingDao.getBusBoadingAndStopingPointDetails(busId));
		//availability.setDroppingPoints(busBookingDao.getBusBoadingAndStopingPointDetails(busId));
		return availability;
	}
	
	public CustomerBusTicketVO bookedBusTicket(CustomerBusTicketVO busVO){
		return busBookingDao.bookedBusTicket(busVO);
	}
	
	public List<CustomerBusTicketVO> getHistoryBusTicket(String uid, int limit){
		return busBookingDao.getHistoryBusTicket(uid, limit);
	}

}
