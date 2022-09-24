package com.citi.sanction_transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.citi.sanction_transaction.model.TransactionDB;
import com.citi.sanction_transaction.model.User;
import com.citi.sanction_transaction.repository.TransactionDBRepository;

@Controller
public class RecordController {
		@Autowired
		private TransactionDBRepository transRepo;
		
		@Autowired
		TransactionController tc;
		
    @GetMapping("/list-transactions")
	public ModelAndView getSanctionedTransactions() {
	    ModelAndView mav = new ModelAndView("list-transactions");
	    mav.addObject("doc", new TransactionDB());
	    return mav;
	}
    


@PostMapping({"/list-transactions"})
	public ModelAndView getSanctionedTransactions(@ModelAttribute("doc") TransactionDB t) {
		System.out.println("List Archives" + tc.file);
		ModelAndView mav = new ModelAndView("list-transactions");
		System.out.println("Doc: " + t.getFileName());
//		if(doc==null) {
//			mav.addObject("transactions", transRepo.findAll());
//		}
//		else {
//		mav.addObject("transactions", transRepo.findAll());
		mav.addObject("transactions", transRepo.findByFileName(tc.file));
//		}
		return mav;
	}

	
	@GetMapping({"/list-transactions/{file}"})
	public ModelAndView getSanctionedTransactions(@PathVariable(value = "file") String file, Model model) {
		System.out.println("List Archives");
		ModelAndView mav = new ModelAndView("list-transactions");
		System.out.println("Doc: " + file);
		if(file==null) {
			mav.addObject("transactions", transRepo.findAll());
		}
		else {
//		mav.addObject("transactions", transRepo.findAll());
		mav.addObject("transactions", transRepo.findByFileName(file));
		}
		return mav;
	}
}
