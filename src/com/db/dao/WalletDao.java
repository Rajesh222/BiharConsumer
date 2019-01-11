package com.db.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.model.Wallet;
import com.db.model.mapper.WalletRowMapper;

@Repository("walletDao")
public class WalletDao {

	private static final Logger log = LoggerFactory.getLogger(WalletDao.class);

	@Resource(name = "queriesMap")
	private Map<String, String> queriesMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String GET_WALLET_HISTORY_DETAILS = "GET_WALLET_HISTORY_DETAILS";
	private static final String GET_WALLET_DETAILS = "GET_WALLET_DETAILS";
	private static final String UPDATE_WALLET_DETAILS = "UPDATE_WALLET_DETAILS";

	@Transactional(readOnly = true)
	public List<Wallet> getWalletHistory(String uid) {
		String query = queriesMap.get(GET_WALLET_HISTORY_DETAILS);
		log.debug("Running insert query for getWalletHistory: {}", query);
		return jdbcTemplate.query(query, new Object[] { uid }, new WalletRowMapper());
	}

	@Transactional(readOnly = true)
	public Wallet getWalletDetails(String uid) {
		String query = queriesMap.get(GET_WALLET_DETAILS);
		log.debug("Running insert query for getWalletDetails: {}", query);
		return jdbcTemplate.queryForObject(query, new Object[] { uid }, new WalletRowMapper());
	}

	@Transactional
	public int updateWallet(double addedAmount, String uid) {
		String query = queriesMap.get(UPDATE_WALLET_DETAILS);
		log.debug("Running insert query for updateWallet: {}", query);
		return jdbcTemplate.update(query, addedAmount,uid);
	}

}
