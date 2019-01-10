package com.db.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RestController;

import com.db.model.TopCities;
import com.db.service.TopCityService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value = "/api/v0/travelHistory")
public class TopCityController {

	private static final Logger log = LoggerFactory.getLogger(TopCityController.class);

	@Autowired
	private TopCityService travelHistoryService;


	@GetMapping("/cities")
	public ResponseEntity<RestResponse<List<TopCities>>> getAllStation() {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<TopCities> searchStations = travelHistoryService.getAllStation();
		log.debug("Data fetched successfully from Top cities table");
		return new ResponseEntity<>(new RestResponse(searchStations, status), HttpStatus.OK);
	}

	@PostMapping("/cities")
	public ResponseEntity<RestResponse<List<TopCities>>> addSearchStation(@RequestBody TopCities busStop,
			Principal principal) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Top Cities Station Added Successfully");
		long integer = travelHistoryService.addStationName(busStop);
		if (integer == 0)
			status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					"Top Cities not Registered Successfully");
		return new ResponseEntity<>(new RestResponse(busStop, status), HttpStatus.OK);
	}

	@GetMapping("/cities/{stationName}")
	public ResponseEntity<RestResponse<List<TopCities>>> searchStation(
			@PathVariable(name = "stationName", required = true) String stationName) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<TopCities> searchStations = travelHistoryService.searchStationByStationName(stationName);
		return new ResponseEntity<>(new RestResponse(searchStations, status), HttpStatus.OK);
	}
}
