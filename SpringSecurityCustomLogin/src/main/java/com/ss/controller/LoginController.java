package com.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String home() {
		System.out.println("successfully authenticated..request for welcome page");
		return "redirect:login.success"; 
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		//System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("login");
	}
	
	@RequestMapping("/login.success")
	public ModelAndView loginsuccess() {
		//System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("welcome");
	}
		
	@RequestMapping("/errorPage")
	public ModelAndView errorPage() {
		//System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("errorPage");
	}
	
}
