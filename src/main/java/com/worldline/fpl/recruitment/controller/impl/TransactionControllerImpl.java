package com.worldline.fpl.recruitment.controller.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.fpl.recruitment.controller.TransactionController;
import com.worldline.fpl.recruitment.json.TransactionResponse;
import com.worldline.fpl.recruitment.service.TransactionService;

import io.swagger.annotations.ApiParam;

/**
 * Implementation of {@link TransactionController}
 * 
 * @author A525125
 *
 */
@Slf4j
@RestController
public class TransactionControllerImpl implements TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@Override
	public ResponseEntity<Page<TransactionResponse>> getTransactionsByAccount(
			@PathVariable("accountId") String accountId,
			@PageableDefault Pageable p) {
		Page<TransactionResponse> page = transactionService
				.getTransactionsByAccount(accountId, p);
		if (null == page || page.getTotalElements() == 0) {
			log.debug("Cannot find transaction for account {}", accountId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok().body(page);
	}
	
	@Override
	public void deleteAccount(
			  @PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId) {
		
				transactionService.delete(accountId,transactionId);
	}

	@Override
	public boolean addTrans(String TransactionId, String accountId, String number, BigDecimal balance) {
		transactionService.AddTransaction(TransactionId, accountId, number, balance);
		return true;
	}
	
	@Override
	public boolean PutTrans(String TransactionId, String accountId, String number, BigDecimal balance) {
		transactionService.updateTransaction(TransactionId, accountId, number, balance);
		return true;
	}
	
	
	

	

}
