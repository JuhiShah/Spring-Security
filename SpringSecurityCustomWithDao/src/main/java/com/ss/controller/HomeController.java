package com.ss.controller;

import java.util.AbstractSequentialList;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.ss.dao.UserDao;
import com.ss.model.Registration;
import com.ss.model.Role;
import com.ss.model.User;
import com.ss.model.UserStatus;

@Controller
public class HomeController {

	@Autowired
	UserDao dao;
 	
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("registration");
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		//System.out.println("successfully authenticated..request for welcome page");
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value="/do.registration", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute(value="reg")Registration registration) {
		System.out.println("registration");
		System.out.println("obj : "+registration.getName());
		
		User user = new User();
		user.setUsername(registration.getUsername());
		user.setPassword(registration.getPassword());
		user.setStatus(UserStatus.ACTIVE);
		
		Role role = new Role();
		role.setRoleName("User");
		ArrayList<Role> list = new ArrayList<Role>();
		list.add(role);
		user.setRoles(list);
		dao.addUser(user);
		
		System.out.println("user added");
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		
		return new ModelAndView("index");
	}
	
	
}
