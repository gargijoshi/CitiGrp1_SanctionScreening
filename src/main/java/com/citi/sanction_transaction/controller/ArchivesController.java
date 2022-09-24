package com.citi.sanction_transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citi.sanction_transaction.repository.FileDBRepository;
import com.citi.sanction_transaction.repository.TransactionDBRepository;

@Controller
public class ArchivesController {
	@Autowired 
	TransactionDBRepository transRepo;
	
	@Autowired
	FileDBRepository fileRepo;
	
//	@GetMapping("/archives")
//    public String archive() {
//		System.out.println("Archives!!");
//        return "archives";
//    }
//	
	@GetMapping({"/archives"})
	public ModelAndView getTransactions(String file) {
		System.out.println("Records: ");
		ModelAndView mav = new ModelAndView("archives");
//		mav.addObject("transactions", transRepo.findAll());
//		mav.addObject("transactions", transRepo.findByFileName(file));
		mav.addObject("files", fileRepo.findAll());
		return mav;
	}
}
