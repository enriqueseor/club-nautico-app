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
@RequestMapping("/boat")
public class BoatController {

	@Autowired
	private BoatService boatService;
	
	@Autowired
	private SkipperService skipperService;
	
	@GetMapping("/create")
	public String boatCreateForm(Model model) {
		model.addAttribute("boat", new Boat());
		List<Skipper> skippersList = skipperService.findAllByOrderByNombre();
		model.addAttribute("memberList", skippersList);
		return "boat/create";
		
	}
	
	@GetMapping("/edit")
	public String boatEditForm(@ModelAttribute Boat boat, Model model) {
		model.addAttribute("boat", boat);
		return "boat/edit";
		
	}
	
	@PostMapping
	public String createBoat(@ModelAttribute @Valid Boat boat, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "boat/create";
		}
		model.addAttribute("boat", boatService.createBoat(boat));
		return "boat/show";
		
	}
	
	@PutMapping
	public String editBoat(@ModelAttribute @Valid Boat boat, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "boat/edit";
		}
		model.addAttribute("boat", boatService.createBoat(boat));
		return "boat/show";
	}
	
	@GetMapping("/boatList")
	public String boatList(Model model) {
	    model.addAttribute("boat", boatService.getAllBarcos());
	    return "boat/list";
	}
	
	
	@GetMapping("/delete/{numeroMatricula}")
	public String deleteBoat(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula).orElse(null);
	    boatService.deleteBarco(boat);
	    return "redirect:/boat/boatList";
	}
	
	@GetMapping("/show/{numeroMatricula}")
	public String showBoat(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula)
	      .orElse(null);
	    model.addAttribute("boat", boat);
	    return "boat/show";
	}
	
	@GetMapping("/edit/{numeroMatricula}")
	public String editBoat(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula).orElse(null);
	    model.addAttribute("boat", boat);
		return "boat/edit";
	}
}

