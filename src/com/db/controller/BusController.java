package com.db.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.BusBoadingHistory;
import com.db.model.BusRoutDetails;
import com.db.model.vo.SearchBusVO;
import com.db.service.BusRoutService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value = "/api/v0")
public class BusController {

	private static final Logger log = LoggerFactory.getLogger(BusController.class);
	
	@Autowired
	private BusRoutService busRoutService;
	
	@GetMapping(value = "/trip/{sourceName}/{destinationName}/{date}")
	public ResponseEntity<RestResponse<List<BusBoadingHistory>>> getTrip(
			@PathVariable(name = "sourceName", required = true) String sourceName,
			@PathVariable(name = "destinationName", required = true) String destionationName,
			@PathVariable(name = "date", required = true) String date) {
		
		return new ResponseEntity<>(new RestResponse(null, null), HttpStatus.OK);
	}

	/*@GetMapping(value = "/search")
	public ResponseEntity<RestResponse<List<BusRoutDetails>>> searchBus(
			@RequestBody(required = true) SearchBusVO searchBusVO) {
		log.info("call search source:{}", searchBusVO);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<BusRoutDetails> busHistories = travelHistoryService.searchBusList(source, destination, date);
		if (busHistories.isEmpty())
			status = new RestStatus<>(HttpStatus.OK.toString(),
					String.format("No bus found between '%s' and '%s' on '%s", source, destination, date));
		return new ResponseEntity<>(new RestResponse(busHistories, status), HttpStatus.OK);
	}*/

}
