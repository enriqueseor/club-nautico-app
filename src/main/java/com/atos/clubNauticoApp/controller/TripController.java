package com.atos.clubNauticoApp.controller;

import com.atos.clubNauticoApp.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atos.clubNauticoApp.service.TripService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private TripService tripService;
	
	@GetMapping("/create")
	public String tripCreateForm(Model model) {
		model.addAttribute("trip", new Trip());
		return "trips/create";
	}
	
	@GetMapping("/edit")
	public String tripEditForm(@ModelAttribute Trip trip, Model model) {
		model.addAttribute("trip", trip);
		return "trips/edit";
	}
	
	@PostMapping
	public String createTrip(@ModelAttribute @Valid Trip trip, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "trips/create";
		}
		model.addAttribute("trip", tripService.createTrip(trip));
		return "trips/show";
	}
	
	@PutMapping
	public String editTrip(@ModelAttribute @Valid Trip trip, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "trips/edit";
		}
		model.addAttribute("trip", tripService.createTrip(trip));
		return "trips/show";
	}
	
	@GetMapping("/tripList")
	public String tripList(Model model) {
	    model.addAttribute("trips", tripService.getAllTrips());
	    return "trips/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteTrip(@PathVariable("id") Long id, Model model) {
		Trip trip = tripService.findById(id).orElse(null);
	    tripService.deleteTrip(trip);
	    return "redirect:/trips/tripList";
	}
	
	@GetMapping("/show/{id}")
	public String showTrip(@PathVariable("id") Long id, Model model) {
		Trip trip = tripService.findById(id)
	      .orElse(null);
	    model.addAttribute("trip", trip);
	    return "trips/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editTrip(@PathVariable("id") Long id, Model model) {
		Trip trip = tripService.findById(id).orElse(null);
	    model.addAttribute("trip", trip);
		return "trips/edit";
	}
}

