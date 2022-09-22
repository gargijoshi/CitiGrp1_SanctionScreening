package com.citi.sanction_transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citi.sanction_transaction.repository.TransactionDBRepository;

@Controller
public class RecordController {
		@Autowired
		private TransactionDBRepository transRepo;
	
	@PostMapping({"/list-transactions"})
	public ModelAndView getSanctionedTransactions() {
		ModelAndView mav = new ModelAndView("list-transactions");
		mav.addObject("transactions", transRepo.findAll());
		return mav;
	}
}
