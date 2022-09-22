package com.citi.sanction_transaction.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.support.RequestContextUtils;

import com.citi.sanction_transaction.repository.TransactionDBRepository;
import com.citi.sanction_transaction.service.TransactionServiceImpl;

@Controller
public class TransactionController {
	@Autowired
	private TransactionServiceImpl tsimpl;
	
	@Autowired
	private TransactionDBRepository transRepo;
	
	@RequestMapping(value="/sanction", method = RequestMethod.GET)
	ModelAndView redirectTo(HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		String file =  (String) flashMap.get("file");
        System.out.println("File is: " + file);
		tsimpl.SanctionTransaction(file);
		ModelAndView mv = getTransactions(); 
		return mv;
	}
	
	@GetMapping({"/list"})
	public ModelAndView getTransactions() {
		System.out.println("Records: ");
		ModelAndView mav = new ModelAndView("sanction");
		mav.addObject("transactions", transRepo.findAll());		
		return mav;
	}
}
