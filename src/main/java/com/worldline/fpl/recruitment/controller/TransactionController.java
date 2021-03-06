package com.worldline.fpl.recruitment.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.worldline.fpl.recruitment.json.ErrorResponse;
import com.worldline.fpl.recruitment.json.TransactionResponse;

/**
 * Transaction controller
 * 
 * @author A525125
 *
 */
@RequestMapping(value = "/accounts/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TransactionController {

	/**
	 * Get transaction list by account
	 * 
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable information
	 * @return the transaction list
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation(value = "Get transaction list related to an account", response = TransactionResponse.class, responseContainer = "List")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Account not found", response = ErrorResponse.class),
			@ApiResponse(code = 204, message = "No transactions", response = ErrorResponse.class) })
	ResponseEntity<Page<TransactionResponse>> getTransactionsByAccount(
			@ApiParam("Account ID") @PathVariable("accountId") String accountId,
			@ApiParam("Pageable information") @PageableDefault Pageable p);
	
	@RequestMapping(value = "/{transactionId}", method = RequestMethod.DELETE)
	@ApiResponses({ @ApiResponse(code = 404, message = "Account not found", response = ErrorResponse.class) })
	public void deleteAccount(
			 @ApiParam("Account ID") @PathVariable("accountId") String accountId, @ApiParam("Account") @PathVariable("transactionId") String transactionId);
	
	//Exemple de requete qui fonctionne 
	//http://localhost:8080/api/accounts/1/transactions/add?TransactionId=10&accountId=1&number=50&balance=16
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addTrans(@RequestParam String TransactionId, 
			@RequestParam String accountId,
			  @RequestParam String number,
			  @RequestParam BigDecimal balance
			 );
	//Exemple de requete qui fonctionne
	//http://localhost:8080/api/accounts/1/transactions/Modification?TransactionId=10&accountId=1&number=50&balance=20
	@RequestMapping(value = "/Modification", method = RequestMethod.PUT)
	public boolean PutTrans(@RequestParam String TransactionId, 
			@RequestParam String accountId,
			  @RequestParam String number,
			  @RequestParam BigDecimal balance
			 );
	
	
	

}
