package com.citi.sanction_transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.citi.sanction_transaction.service.TransactionServiceImpl;

@Controller
public class TransactionController {
	@Autowired
	private TransactionServiceImpl tsimpl;
	
	@RequestMapping("/sanction")
	void redirectTo() {
		tsimpl.SanctionTransaction();
	}
}
