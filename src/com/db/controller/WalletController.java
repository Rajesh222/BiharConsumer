package com.db.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.model.Wallet;
import com.db.service.WalletService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;
/**
 * @author Satyam Kumar
 *
 */
@Controller
@RequestMapping(value = "/api/v0/wallet")
public class WalletController {

	private static final Logger log = LoggerFactory.getLogger(WalletController.class);

	@Autowired
	private WalletService walletService;

	@PutMapping(value = "/{addedAmount}")
	public ResponseEntity<RestResponse<Object>> updateWallet(
			@PathVariable(name = "addedAmount", required = true) Double addedAmount,
			@RequestParam(name = "uid", required = true) String uid) {
		log.info("call addWallet updateWallet:{}, uid:{}", addedAmount, uid);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Wallet Updated Successfully");
		int row = walletService.updateWallet(addedAmount, uid);
		if (row == 0) {
			status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					"Currently this service is unavailable. We regret the inconvenience caused. Please try after some time.");
			return new ResponseEntity<>(new RestResponse(row, status), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new RestResponse(row, status), HttpStatus.OK);
	}

	@GetMapping(value = "/{uid}")
	public ResponseEntity<RestResponse<List<Wallet>>> getWalletHistory(
			@PathVariable(name = "uid", required = true) String uid) {
		log.info("call getWalletHistory uid:{}", uid);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
		List<Wallet> wallets = walletService.getWalletHistory(uid);
		return new ResponseEntity<>(new RestResponse(wallets, status), HttpStatus.OK);
	}

	@GetMapping(value = "/customuserbalance/{uid}")
	public ResponseEntity<RestResponse<Wallet>> getWalletDetails(
			@PathVariable(name = "uid", required = true) String uid) {
		log.info("call getWalletDetails uid:{}", uid);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "All Records Fetched Successfully");
	    Wallet wallets = walletService.getWalletDetails(uid);
		return new ResponseEntity<>(new RestResponse(wallets, status), HttpStatus.OK);
	}

}
