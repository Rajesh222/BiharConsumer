package com.db.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ticketService")
public class PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	public boolean busBooked() {
		return true;
	}

	
}
