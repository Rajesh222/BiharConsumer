package com.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.BusRoutDao;
import com.db.model.BusRoutDetails;

@Service("busRoutService")
public class BusRoutService {

	@Autowired
	private BusRoutDao busRoutDao;

	public List<BusRoutDetails> getTrip() {
		return null;
	}

	public List<BusRoutDetails> searchRoute() {
		return null;
	}

}
