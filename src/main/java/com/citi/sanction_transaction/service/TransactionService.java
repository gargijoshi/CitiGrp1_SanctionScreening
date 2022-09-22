package com.citi.sanction_transaction.service;

import java.util.List;

import com.citi.sanction_transaction.model.TransactionDB;

public interface TransactionService {
	List<TransactionDB> getAllTransactions();
	void SanctionTransaction(String file);
	int checkIfValid(TransactionDB transaction);
}
