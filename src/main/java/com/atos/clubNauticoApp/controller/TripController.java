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
@RequestMapping("/salidas")
public class TripController {

	@Autowired
	private TripService tripService;
	
	@GetMapping("/create")
	public String salidaCreateForm(Model model) {
		model.addAttribute("salida", new Trip());
		return "salidas/create";
		
	}
	
	@GetMapping("/edit")
	public String salidaEditForm(@ModelAttribute Trip trip, Model model) {
		model.addAttribute("salida", trip);
		return "salidas/edit";
		
	}
	
	@PostMapping
	public String createSalida(@ModelAttribute @Valid Trip trip, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "salidas/create";
		}
		model.addAttribute("salida", tripService.createSalida(trip));
		return "salidas/show";
		
	}
	
	@PutMapping
	public String editSalida(@ModelAttribute @Valid Trip trip, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "salidas/edit";
		}
		model.addAttribute("salida", tripService.createSalida(trip));
		return "salidas/show";
	}
	
	@GetMapping("/listSalidas")
	public String listStudent(Model model) {
	    model.addAttribute("salidas", tripService.getAllSalidas());
	    return "salidas/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteSalida(@PathVariable("id") Long id, Model model) {
		Trip trip = tripService.findById(id).orElse(null);
	    tripService.deleteSalida(trip);
	    return "redirect:/personas/listSalidas";
	}
	
	@GetMapping("/show/{id}")
	public String showSalida(@PathVariable("id") Long id, Model model) {
		Trip trip = tripService.findById(id)
	      .orElse(null);
	    model.addAttribute("salida", trip);
	    return "salidas/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editSalida(@PathVariable("id") Long id, Model model) {
		Trip trip = tripService.findById(id).orElse(null);
	    model.addAttribute("salida", trip);
		return "salidas/edit";
	}
}

