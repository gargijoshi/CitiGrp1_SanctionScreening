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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.citi.sanction_transaction.repository.TransactionDBRepository;
import com.citi.sanction_transaction.service.TransactionServiceImpl;

@Controller
public class TransactionController {
	@Autowired
	private TransactionServiceImpl tsimpl;
	
	@Autowired
	private TransactionDBRepository transRepo;
	
	String file;
	
	@RequestMapping(value="/sanction", method = RequestMethod.GET)
	ModelAndView redirectTo(HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		file =  (String) flashMap.get("file");
        System.out.println("File is: " + file);
		tsimpl.SanctionTransaction(file);
		ModelAndView mv = getTransactions(file); 
		return mv;
	}
	
	@GetMapping({"/list"})
	public ModelAndView getTransactions(String file) {
		System.out.println("Records: ");
		ModelAndView mav = new ModelAndView("sanction");
//		mav.addObject("transactions", transRepo.findAll());
		mav.addObject("transactions", transRepo.findByFileName(file));
		return mav;
	}
	
	@GetMapping({"/visualize"})
	public ModelAndView getCount() {
		int validatePass = transRepo.countByValidateStatus(1);
		int validateFail = transRepo.countByValidateStatus(0);
		int sanctionPass = transRepo.countBySanctionStatus(1);
		int sanctionFail = transRepo.countBySanctionStatus(0);
		ModelAndView mav = new ModelAndView("visualize");
		float validate = (float)(validatePass)/(validatePass + validateFail);
		float sanction = (float)(sanctionPass)/(sanctionPass + sanctionFail);
		float vPer = (float) (validate * 100.0);
		int validatePassPer = (int) vPer;
		int validateFailPer = 100 - validatePassPer;
		float sPer = (float) (sanction * 100.0);
		int sanctionPassPer = (int) sPer;
		int sanctionFailPer = 100 - sanctionPassPer;
//		validate = 80;
//		mav.addObject("validatePassPer", validatePassPer);
		
//		mav.addObject("validateFailPer", validateFailPer);	
		mav.addObject("sanctionPassPer", sanctionPassPer);
		mav.addObject("sanctionFailPer", sanctionFailPer);
		System.out.println("Validate\nPass: " + validatePass + "\tFail: " + validateFail + "\nSanction\nPass: " + sanctionPass + "\tFail: " + sanctionFail);
		System.out.println("Percentage: " + validate + "\t " + sanction + "\t" + vPer + "\t" + sanctionPassPer + "\t" + sanctionFailPer);
		return mav;
	}
}
