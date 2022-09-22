package com.citi.sanction_transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.sanction_transaction.model.TransactionDB;

public interface TransactionDBRepository extends JpaRepository<TransactionDB, Integer> {
	
}
