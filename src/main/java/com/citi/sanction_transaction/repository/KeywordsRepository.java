package com.citi.sanction_transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.sanction_transaction.model.Keywords;
import com.citi.sanction_transaction.model.keywordId;

public interface KeywordsRepository extends JpaRepository<Keywords, keywordId> {

}