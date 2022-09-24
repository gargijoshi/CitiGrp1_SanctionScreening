package com.citi.sanction_transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.sanction_transaction.model.TransactionDB;

public interface TransactionDBRepository extends JpaRepository<TransactionDB, Integer> {
	List<TransactionDB> findByFileName(String name);
	int countByValidateStatus(int no);
	int countBySanctionStatus(int no);
}
