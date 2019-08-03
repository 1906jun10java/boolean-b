package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.service.AuthenticationService;
import com.revature.service.UserService;
@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	UserService us;
	AuthenticationService as = new AuthenticationService();
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewLogin(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("index", new Credentials());
		return mav;
	}
	@RequestMapping(value ="/loginProcess", method= RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("Credentials") Credentials creds) {
		ModelAndView mav =  null;
		User u =  as.authenticateUser(creds);
		if(u != null) {
			mav =  new ModelAndView("index");
			mav.addObject("firstname", u.getFirstName());
		}else {
			mav = new ModelAndView("registration");
			mav.addObject("message", "Invalid credentials");
		}
		return mav;
	}

}
