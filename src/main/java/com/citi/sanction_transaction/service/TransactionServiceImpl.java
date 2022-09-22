package com.citi.sanction_transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.citi.sanction_transaction.model.TransactionDB;
import com.citi.sanction_transaction.repository.TransactionRepository;


@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Override
	public List<TransactionDB> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@PostMapping("/sanction")
	@Override
	public void SanctionTransaction() {
		System.out.println("Mapping!");
		transactionRepository.sanctiontransactions();
	}	
	
	@Override
	public int checkIfValid(TransactionDB transaction) {
		return transaction.getValidateStatus();
	}

}