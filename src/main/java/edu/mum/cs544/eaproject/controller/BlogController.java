package edu.mum.cs544.eaproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.eaproject.domain.Comment;
import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Trip;
import edu.mum.cs544.eaproject.domain.Users;
import edu.mum.cs544.eaproject.service.TripService;
import edu.mum.cs544.eaproject.service.UserService;
import edu.mum.cs544.eaproject.util.Utils;

/**
 * @author baopham Handles requests for the application home page.
 */

@Controller
public class BlogController {

	@Autowired
	private UserService userService;

	@Autowired
	private TripService tripService;

	public BlogController() {
		System.out.println("Constructor BlogController");
	}

	@RequestMapping(value = "/")
	public String redirectRoot() {
		System.out.println("At root");
		return "login";
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
		} else {
			view = "register";
		}
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("At login");
		return "login";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		System.out.println("Add main page");
		List<Trip> trips = tripService.getAllTrips();
		for (Trip trip : trips) {
			System.out.println("Trip comments = ");
			for(Comment c: trip.getComments()) {
				System.out.println(c.getCommentText());
			}
		}
		model.addAttribute("trips", trips);
		System.out.println("Trips = " + trips);
		return "main";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", true);
		return "login";

	}

	@RequestMapping(value = "addTrip", method = RequestMethod.POST)
	public String addTrip(@Valid Trip trip, BindingResult result) {
		String view = "redirect:/main";
		if (!result.hasErrors()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName(); // get logged in username
			Users user = userService.getUser(username);
			trip.setUser(user);
			tripService.saveTrip(trip);
		}
		return view;
	}

	@RequestMapping(value = "addComment/{tripId}", method = RequestMethod.POST)
	public String addComment(@PathVariable int tripId, @Valid Comment comment, BindingResult result) {
		String view = "redirect:/main";
		if (!result.hasErrors()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName(); // get logged in username
			Users user = userService.getUser(username);
			comment.setUser(user);
			Trip trip = tripService.getTrip(tripId);
			if (trip == null) {
				System.out.println("Trip is null");
			}
			System.out.println("Comment = " + comment.getCommentText());
			trip.addComment(comment);
			tripService.updateTrip(trip);
		}
		return view;
	}
	
	@RequestMapping(value="trip/{tripId}")
	public String editTrip(@PathVariable int tripId, Model model) {
		Trip trip = tripService.getTrip(tripId);
		trip.setEditable(true);
		tripService.updateTrip(trip);
		return "redirect:/main";
	}
	
	@RequestMapping(value="updateTrip/{id}")
	public String updateTrip(@PathVariable int id, @Valid Trip trip, Model model) {
		model.addAttribute("editTrip", false);
		Trip existingTrip = tripService.getTrip(id);
		existingTrip.setTripText(trip.getTripText());
		existingTrip.setEditable(false);
		tripService.updateTrip(existingTrip);
		return "redirect:/main";
	}
	
	@RequestMapping(value="deleteTrip/{tripId}")
	public String editTrip(@PathVariable int tripId) {
		tripService.deleteTrip(tripId);
		return "redirect:/main";
	}

}
