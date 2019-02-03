package com.db.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.BusDetailsObject;
import com.db.model.BusSeatDetailsObject;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;
import com.db.service.BusBookingService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value = "/api/v0/search")
public class BusBookingController {

	private static final Logger log = LoggerFactory.getLogger(BusBookingController.class);

	@Autowired
	private BusBookingService busBookingService;

	@PostMapping(value = "/availableRouts")
	public ResponseEntity<RestResponse<BusDetailsObject>> searchBusRoutDetails(
			@RequestBody(required = true) SearchBusVO searchBusVO) {
		log.info("call search searchBusRoutDetails:{}", searchBusVO);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		BusDetailsObject busDetailsObject = busBookingService.searchBusRoutDetails(searchBusVO);
		if (busDetailsObject.getFilterRouteList() == null || busDetailsObject.getFilterRouteList().isEmpty())
			status = new RestStatus<>(HttpStatus.OK.toString(),
					String.format("There are no buses between these two cities. Please try a different date or search with an alternate route."));
		return new ResponseEntity<>(new RestResponse(busDetailsObject, status), HttpStatus.OK);
	}

	@PostMapping(value = "/availableSeats")
	public ResponseEntity<RestResponse<BusSeatDetailsObject>> getSeatAvailability(
			@RequestParam(name = "busId") String busId, @RequestParam(name = "date") String date) {
		log.info("call search getSeatAvailability:{} {}", busId, date);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		BusSeatDetailsObject busSeatDetailsAvailability = busBookingService.getSeatAvailability(busId, date);
		if (busSeatDetailsAvailability != null) {
			status = new RestStatus<>(HttpStatus.OK.toString(),	"There are no seats available in this bus. Please select a different bus.");
		}
		return new ResponseEntity<>(new RestResponse(busSeatDetailsAvailability, status), HttpStatus.OK);
	}

	@PostMapping(value = "/bookedBusTicket")
	public ResponseEntity<RestResponse<Object>> bookedBusTicket(
			@RequestBody(required = true) CustomerBusTicketVO busTicketVO) {
		log.info("call search bookedBusTicket:{}", busTicketVO);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Bus Ticket booked Successfully");
		CustomerBusTicketVO customerBusTicketVO = busBookingService.bookedBusTicket(busTicketVO);
		if (customerBusTicketVO != null)
			status = new RestStatus<>(HttpStatus.OK.toString(),
					"There are no seats available in this bus. Please select a different bus.");
		return new ResponseEntity<>(new RestResponse(customerBusTicketVO, status), HttpStatus.OK);
	}

	@GetMapping(value = "/getTicketHistory/{uid}")
	public ResponseEntity<RestResponse<List<CustomerBusTicketVO>>> getBusTicketHistory(
			@PathVariable(name = "uid", required = true) String uid,
			@RequestParam(name = "limit", required = false, defaultValue = "5") int limit) {
		log.info("call search getBusTicketHistory:{}", uid);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Bus Ticket booked Successfully");
		List<CustomerBusTicketVO> customerBusTicketVOs = busBookingService.getHistoryBusTicket(uid, limit);
		if (customerBusTicketVOs != null)
			status = new RestStatus<>(HttpStatus.OK.toString(),
					"There are no seats available in this bus. Please select a different bus.");
		return new ResponseEntity<>(new RestResponse(customerBusTicketVOs, status), HttpStatus.OK);
	}
}
