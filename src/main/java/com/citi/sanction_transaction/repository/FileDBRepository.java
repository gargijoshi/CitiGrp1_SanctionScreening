package com.citi.sanction_transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.sanction_transaction.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

//	void saveAll(List<TransactionDB> transactions);

}