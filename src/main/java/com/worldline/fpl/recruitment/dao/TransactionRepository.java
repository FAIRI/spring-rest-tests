package com.worldline.fpl.recruitment.dao;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.worldline.fpl.recruitment.entity.Transaction;

/**
 * Transaction repository
 * 
 * @author A525125
 *
 */
public interface TransactionRepository {

	/**
	 * Get transactions by account
	 * 
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable information
	 * @return
	 */
	Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);
	
	// Delete transaction 
	public void deleteTransaction(String accountIdTransaction,String idTransaction);
	public boolean AddTransaction(String idTransaction,String idAccount,String number,BigDecimal balance);
	public boolean updateTransaction(String idTransaction,String idAccount,String number,BigDecimal balance);
	
}
