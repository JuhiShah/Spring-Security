package com.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		System.out.println("successfully authenticated..request for welcome page");
		return "redirect:welcome"; 
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		//System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		//System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("index");
	}
	
	
}
