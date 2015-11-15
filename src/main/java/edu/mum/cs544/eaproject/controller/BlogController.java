package edu.mum.cs544.eaproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.eaproject.domain.User;
import edu.mum.cs544.eaproject.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BlogController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public String redirectRoot() {
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result) {
		String view = "redirect:/login";
		if (!result.hasErrors()) {
			userService.saveUser(user);
		}
		else {
			view="register";
		}
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
}
