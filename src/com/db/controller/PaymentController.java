package com.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.service.PaymentService;

@Controller
@RequestMapping(value="/api/v0")
public class PaymentController {

	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService busTicketService;
	
	@PostMapping("/busbooking")
	public String busBooking(@RequestParam(name="name", required=true) String name,
			@RequestParam(name="phone", required=true) String phone,
			@RequestParam(name="email", required=true) String email) {
		log.info("call busBooking");
		busTicketService.busBooked();
		return "bus/busBookingSuccess";
	}
	
	@GetMapping("/bus-tickets")
	public String busTickets(@RequestParam(name="source", required=true) String source,
			@RequestParam(name="destination", required=true) String destination,
			@RequestParam(name="date", required=true) String date) {
		log.info("call busBooking");
		busTicketService.busBooked();
		return "bus/bus-tickets";
	}

	
}
