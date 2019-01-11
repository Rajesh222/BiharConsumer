package com.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.dao.WalletDao;
import com.db.model.Wallet;

@Service("walletService")
public class WalletService {

	private static final Logger log = LoggerFactory.getLogger(WalletService.class);

	@Autowired
	private WalletDao walletDao;

	public List<Wallet> getWalletHistory(String uid) {
		log.info("call getWalletHistory {}", uid);
		return walletDao.getWalletHistory(uid);
	}

	public Wallet getWalletDetails(String uid) {
		log.info("call getWalletDetails {}", uid);
		return (Wallet) walletDao.getWalletDetails(uid);
	}

	public int updateWallet(double addedAmount, String uid) {
		log.info("call updateWallet addedAmount: {}, UserId: {}", addedAmount, uid);
		return walletDao.updateWallet(addedAmount, uid);
	}
}
