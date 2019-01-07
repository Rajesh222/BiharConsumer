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

import com.db.model.BusRoutDetails;
import com.db.model.TopCities;
import com.db.service.TopCityService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value="/api/v0/travelHistory")
public class TopCityController {

	private static final Logger log = LoggerFactory.getLogger(TopCityController.class);
	
	@Autowired
	private TopCityService travelHistoryService;

	@GetMapping(value = "/search/{source}/{destination}/{date}")
	public ResponseEntity<RestResponse<List<BusRoutDetails>>> search(@PathVariable(name="source", required=true) String source,
			@PathVariable(name="destination", required=true) String destination,@PathVariable(name="date", required=true) String date) {
		log.info("call search source:{}, destination:{}", source, destination);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<BusRoutDetails>  busHistories = travelHistoryService.searchBusList(source, destination, date);
		return new ResponseEntity<>(new RestResponse(busHistories, status), HttpStatus.OK);
	}
	
	@GetMapping("/cities")
	public ResponseEntity<RestResponse<List<TopCities>>> getAllStation() {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<TopCities> searchStations = travelHistoryService.getAllStation();
		log.debug("Data fetched successfully from media lookup tables");
		return new ResponseEntity<>(new RestResponse(searchStations, status), HttpStatus.OK);
	}
	
	@PostMapping("/cities")
	public ResponseEntity<RestResponse<List<TopCities>>> addSearchStation(@RequestBody TopCities busStop,
			Principal principal) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Search Station Added Successfully");
		travelHistoryService.addStationName(busStop);
		return new ResponseEntity<>(new RestResponse(busStop, status), HttpStatus.OK);
	}
	
	@GetMapping("/cities/{stationName}")
	public ResponseEntity<RestResponse<List<TopCities>>> searchStation(@PathVariable(name="stationName", required=true) String stationName) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<TopCities> searchStations = travelHistoryService.searchStationByStationName(stationName);
		return new ResponseEntity<>(new RestResponse(searchStations, status), HttpStatus.OK);
	}
}
