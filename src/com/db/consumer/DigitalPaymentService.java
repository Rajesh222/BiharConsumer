package com.db.consumer;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.db.spring.model.RestResponse;

@Service
public class DigitalPaymentService extends DigitalService<RestResponse> {

	private static final Logger logger = Logger.getLogger(DigitalPaymentService.class);

	
	@Override
	public String getEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterizedTypeReference<RestResponse> buildParameterizedTypeReference() {
		// TODO Auto-generated method stub
		return null;
	}

}
