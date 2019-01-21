package com.db.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.CabBookingPrice;
import com.db.service.CabBookingService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value = "/api/v0")
public class CabBookingController {

	private static final Logger log = LoggerFactory.getLogger(CabBookingController.class);
	@Autowired
	private CabBookingService cabBookingService;

	@GetMapping("/cabPrices")
	public ResponseEntity<RestResponse<List<CabBookingPrice>>> getAllStation() {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<CabBookingPrice> bookingPrices = cabBookingService.getAllCabBookingPrice();
		log.debug("Data fetched successfully from Top cities table");
		return new ResponseEntity<>(new RestResponse(bookingPrices, status), HttpStatus.OK);
	}

	@GetMapping("/cabPrices/{type}")
	public ResponseEntity<RestResponse<CabBookingPrice>> getAllStation(
			@PathVariable(name = "type", required = true) String type) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		CabBookingPrice bookingPrices = cabBookingService.getCabBookingPrice(type);		
		log.debug("Data fetched successfully from Top cities table");
		return new ResponseEntity<>(new RestResponse(bookingPrices, status), HttpStatus.OK);
	}
}
