package com.db.consumer;

import com.db.exception.BaseException;

public interface DigitalServiceDelegate {

	public DigitalAuthToken generateAuthToken() throws BaseException;

}