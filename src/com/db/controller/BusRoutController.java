package com.db.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.BusRoutDetailsAvailability;
import com.db.model.BusSeatDetailsAvailability;
import com.db.model.vo.CustomerBusTicketVO;
import com.db.model.vo.SearchBusVO;
import com.db.service.BusRoutService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value = "/api/v0/search")
public class BusRoutController {

	private static final Logger log = LoggerFactory.getLogger(BusRoutController.class);

	@Autowired
	private BusRoutService busRoutService;

	@PostMapping(value = "/routs")
	public ResponseEntity<RestResponse<List<BusRoutDetailsAvailability>>> searchBusRoutDetails(
			@RequestBody(required = true) SearchBusVO searchBusVO) {
		log.info("call search searchBusRoutDetails:{}", searchBusVO);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<BusRoutDetailsAvailability> busRoutDetails = busRoutService.searchBusRoutDetails(searchBusVO);
		if (busRoutDetails == null)
			status = new RestStatus<>(HttpStatus.OK.toString(),
					String.format("No bus found between '%s' and '%s' on '%s", searchBusVO.getSourceName(),
							searchBusVO.getDestinationName(), searchBusVO.getDate()));
		return new ResponseEntity<>(new RestResponse(busRoutDetails, status), HttpStatus.OK);
	}

	@PostMapping(value = "/seats")
	public ResponseEntity<RestResponse<BusSeatDetailsAvailability>> getSeatAvailability(
			@RequestParam(name = "busId") String busId, @RequestParam(name = "date") String date) {
		log.info("call search getSeatAvailability:{} {}", busId, date);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		BusSeatDetailsAvailability busSeatDetailsAvailability = busRoutService.getSeatAvailability(busId, date);
		if (busSeatDetailsAvailability != null)
			status = new RestStatus<>(HttpStatus.OK.toString(),"There are no seats available in this bus. Please select a different bus.");
		return new ResponseEntity<>(new RestResponse(busSeatDetailsAvailability, status), HttpStatus.OK);
	}
	
	@PostMapping(value = "/bookedBusTicket")
	public ResponseEntity<RestResponse<Object>> bookedBusTicket(@RequestBody(required=true)CustomerBusTicketVO busTicketVO) {
		log.info("call search bookedBusTicket:{}", busTicketVO);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Bus Ticket booked Successfully");
		CustomerBusTicketVO customerBusTicketVO = busRoutService.bookedBusTicket(busTicketVO);
		if (customerBusTicketVO != null)
			status = new RestStatus<>(HttpStatus.OK.toString(),"There are no seats available in this bus. Please select a different bus.");
		return new ResponseEntity<>(new RestResponse(customerBusTicketVO, status), HttpStatus.OK);
	}
}
