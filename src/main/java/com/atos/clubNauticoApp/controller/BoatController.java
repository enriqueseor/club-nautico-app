package com.atos.clubNauticoApp.controller;

import java.util.List;

import com.atos.clubNauticoApp.model.Boat;
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

import com.atos.clubNauticoApp.model.Skipper;
import com.atos.clubNauticoApp.service.BoatService;
import com.atos.clubNauticoApp.service.SkipperService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/boats")
public class BoatController {

	@Autowired
	private BoatService boatService;
	
	@Autowired
	private SkipperService skipperService;
	
	@GetMapping("/create")
	public String boatCreateForm(Model model) {
		model.addAttribute("boat", new Boat());
		List<Skipper> skippersList = skipperService.findAllByOrderByName();
		model.addAttribute("skipperList", skippersList);
		return "boats/create";
	}
	
	@GetMapping("/edit")
	public String boatEditForm(@ModelAttribute Boat boat, Model model) {
		model.addAttribute("boat", boat);
		return "boats/edit";
	}
	
	@PostMapping
	public String createBoat(@ModelAttribute @Valid Boat boat, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "boats/create";
		}
		model.addAttribute("boat", boatService.createBoat(boat));
		return "boats/show";
	}
	
	@PutMapping
	public String editBoat(@ModelAttribute @Valid Boat boat, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "boats/edit";
		}
		model.addAttribute("boat", boatService.createBoat(boat));
		return "boats/show";
	}
	
	@GetMapping("/boatList")
	public String boatList(Model model) {
	    model.addAttribute("boats", boatService.getAllBoats());
	    return "boats/list";
	}

	@GetMapping("/delete/{numeroMatricula}")
	public String deleteBoat(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula).orElse(null);
	    boatService.deleteBoat(boat);
	    return "redirect:/boats/boatList";
	}
	
	@GetMapping("/show/{numeroMatricula}")
	public String showBoat(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula)
	      .orElse(null);
	    model.addAttribute("boat", boat);
	    return "boats/show";
	}
	
	@GetMapping("/edit/{boatRegistration}")
	public String editBoat(@PathVariable("boatRegistration") Long boatRegistration, Model model) {
	    Boat boat = boatService.findById(boatRegistration).orElse(null);
	    model.addAttribute("boat", boat);
		return "boats/edit";
	}
}

