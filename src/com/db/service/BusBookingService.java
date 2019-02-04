package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.db.dao.BusBookingDao;
import com.db.model.BusDetailsObject;
import com.db.model.BusRouteDetails;
import com.db.model.BusSeatDetailsObject;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;
import com.db.utils.DataUtils;

@Service("busRoutService")
public class BusBookingService {

	@Autowired
	private BusBookingDao busBookingDao;

	//@Cacheable("routesDetails")
	public BusDetailsObject searchBusRoutDetails(SearchBusVO busVO) {
		BusDetailsObject busDetailsObject = new BusDetailsObject();
		List<BusRouteDetails> filterRoutes = busBookingDao.searchBusBySrcDescAndDate(busVO);
		for(BusRouteDetails route : filterRoutes) {
			route.setBoardingLocations(busBookingDao.getBusBoadingAndStopingPointDetails(route.getBusId(),busVO.getSourceName().toLowerCase()));
			route.setDroppingLocations(busBookingDao.getBusBoadingAndStopingPointDetails(route.getBusId(),busVO.getDestinationName().toLowerCase()));
		    route.setCancellationPolicy(busBookingDao.getCancellationPolicy());
		    route.setAmenities(busBookingDao.getBusFilterAmenitiesByBusId(route.getBusId()));
		}
		busDetailsObject.setFilterRouteList(filterRoutes);
		busDetailsObject.setAmenityList(busBookingDao.getAllAmenities());
		List<String> timeList = DataUtils.getTimeList();
		busDetailsObject.setArrivalTimeList(timeList);
		busDetailsObject.setDepartureTimeList(timeList);
		return busDetailsObject;
	}
	
	//@Cacheable("tripsDetails")
	public BusSeatDetailsObject getSeatAvailability(String busId, String date) {
		BusSeatDetailsObject availability = new BusSeatDetailsObject();
		availability.setBusSeatDetails(busBookingDao.getSeatsDetails(busId, date));
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
