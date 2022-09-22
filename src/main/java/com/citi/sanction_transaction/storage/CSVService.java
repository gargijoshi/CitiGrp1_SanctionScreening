package com.citi.sanction_transaction.storage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.citi.sanction_transaction.helper.CSVHelper;
import com.citi.sanction_transaction.model.TransactionDB;
import com.citi.sanction_transaction.repository.TransactionDBRepository;


@Service
public class CSVService {
	@Autowired
	private TransactionDBRepository tdb;
	
	public void save(MultipartFile file, String fileName) {
//		System.out.print("File: "  + StringUtils.cleanPath(file.getOriginalFilename()));
		  try {
			  System.out.println("File name: " + file.getName());
		      List<TransactionDB> transactions = CSVHelper.csvToDB(file.getInputStream(), fileName);
		      tdb.saveAll(transactions);
		    } catch (Exception e) {
		      throw new RuntimeException("Failed to store csv data: " + e.getMessage());
		    }
	}
}