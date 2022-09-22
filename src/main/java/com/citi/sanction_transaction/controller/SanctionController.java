package com.citi.sanction_transaction.controller;

import org.springframework.web.bind.annotation.RestController;

import com.citi.sanction_transaction.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class SanctionController {
	private TransactionRepository tr;
	
	@PutMapping("/uploadForm/")
	public ResponseEntity<String> sanctiontransactions(){
		return new ResponseEntity<String>(tr.sanctiontransactions()+" record(s) updated.", HttpStatus.OK);
	}
}