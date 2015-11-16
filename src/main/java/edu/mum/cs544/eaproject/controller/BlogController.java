package edu.mum.cs544.eaproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;
import edu.mum.cs544.eaproject.service.UserService;
import edu.mum.cs544.eaproject.util.Utils;

/**
 * @author baopham
 * Handles requests for the application home page.
 */

@Controller
public class BlogController {

	@Autowired
	private UserService userService;

	public BlogController() {
		System.out.println("Constructor BlogController");
	}
	
	@RequestMapping(value = "/")
	public String redirectRoot() {
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@Valid Users user, BindingResult result) {
		String view = "redirect:/login";
		if (!result.hasErrors()) {
			Users encodedUser = Utils.encodePassword(user);
			Role role = userService.getRole("ROLE_USER");
			role.grantUser(encodedUser);
			userService.saveRole(role);
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
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", true);
		return "login";

	}
}
