package com.citi.sanction_transaction.controller;

import java.util.Objects;

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

import com.citi.sanction_transaction.model.User;
import com.citi.sanction_transaction.service.UserService;




@Controller
public class UserController {

@Autowired
    private UserService userService;
 
                                 
    @GetMapping("/login")
         
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
   
   
    @GetMapping({"/loginfail", "/loginfail"})
    public String loginfail()
    {
    return "loginfail";
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user ) {
   
     User oauthUser = userService.login(user.getUsername(), user.getPassword());
   
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
 
     return "redirect:/uploadForm";
   
   
     }
     else
     {
    return "redirect:/login";
   
    }
 
}
   
}