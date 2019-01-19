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
import org.springframework.web.bind.annotation.RestController;

import com.db.model.BusRoutDetails;
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

	@PostMapping(value = "/availability")
	public ResponseEntity<RestResponse<List<BusRoutDetails>>> searchBusRoutDetails(
			@RequestBody(required = true) SearchBusVO searchBusVO) {
		log.info("call search searchBusRoutDetails:{}", searchBusVO);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<BusRoutDetails> busRoutDetails = busRoutService.searchBusRoutDetails(searchBusVO);
		if (busRoutDetails != null)
			status = new RestStatus<>(HttpStatus.OK.toString(),
					String.format("No bus found between '%s' and '%s' on '%s", searchBusVO.getSourceName(),
							searchBusVO.getDestinationName(), searchBusVO.getDate()));
		return new ResponseEntity<>(new RestResponse(busRoutDetails, status), HttpStatus.OK);
	}
}
