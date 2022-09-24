package com.citi.sanction_transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
//
import org.springframework.transaction.annotation.Transactional;

import com.citi.sanction_transaction.model.TransactionDB;

public interface TransactionRepository extends JpaRepository<TransactionDB, Integer> {
	@Transactional
	@Modifying
//	@Query("UPDATE TransactionDB JOIN Keywords k1 on (TransactionDB.PayeeName = k1.name and TransactionDB.PayeeAccountNo = k1.AccountNo) or (TransactionDB.PayerName = k1.name and TransactionDB.PayerAccountNo = k1.AccountNo) set sanctionStatus = if( (TransactionDB.PayeeName = k1.name and TransactionDB.PayeeAccountNo = k1.AccountNo) or (TransactionDB.PayerName = k1.name and TransactionDB.PayerAccountNo = k1.AccountNo) ,1,0) where validateStatus = 1")
//	@Query("UPDATE TransactionDB SET sanctionStatus=1 WHERE validateStatus = 1")
//	@Query("SELECT count(PayerName) FROM TransactionDB INNER JOIN Keywords ON TransactionDB.PayerAccountNo = Keywords.AccountNo WHERE TransactionDB.PayerAccountNo = Keywords.AccountNo ")
//	@Query("UPDATE TransactionDB T, Keywords K SET T.sanctionStatus = 1 WHERE (T.PayeeName = K.name OR T.PayeeAccountNo = K.AccountNo OR T.PayerName = K.name OR T.PayerAccountNo = K.AccountNo) AND validateStatus = 1")
	@Query("update TransactionDB t set t.sanctionStatus = 1 where (t.PayeeAccountNo not in (select k.AccountNo from Keywords k where k.AccountNo = t.PayeeAccountNo) and (t.PayeeName not in (select k.name from Keywords k where k.name = t.PayeeName) and (t.PayerName not in (select k.name from Keywords k where k.name = t.PayerName) and (t.PayerAccountNo not in (select k.AccountNo from Keywords k where k.AccountNo = t.PayerAccountNo)))) and validateStatus = 1)")
	Integer sanctiontransactions();
}
