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
@RequestMapping("/barcos")
public class BoatController {

	@Autowired
	private BoatService boatService;
	
	@Autowired
	private SkipperService skipperService;
	
	@GetMapping("/create")
	public String barcoCreateForm(Model model) {
		model.addAttribute("barco", new Boat());
		List<Skipper> listaSkippers = skipperService.findAllByOrderByNombre();
		model.addAttribute("listaSocios", listaSkippers);
		return "barcos/create";
		
	}
	
	@GetMapping("/edit")
	public String barcoEditForm(@ModelAttribute Boat boat, Model model) {
		model.addAttribute("barco", boat);
		return "barcos/edit";
		
	}
	
	@PostMapping
	public String createBarco(@ModelAttribute @Valid Boat boat, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "barcos/create";
		}
		model.addAttribute("barco", boatService.createBarco(boat));
		return "barcos/show";
		
	}
	
	@PutMapping
	public String editBarco(@ModelAttribute @Valid Boat boat, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "barcos/edit";
		}
		model.addAttribute("barco", boatService.createBarco(boat));
		return "barcos/show";
	}
	
	@GetMapping("/listBarco")
	public String listBarcos(Model model) {
	    model.addAttribute("barcos", boatService.getAllBarcos());
	    return "barcos/list";
	}
	
	
	@GetMapping("/delete/{numeroMatricula}")
	public String deleteBarco(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula).orElse(null);
	    boatService.deleteBarco(boat);
	    return "redirect:/barcos/listBarco";
	}
	
	@GetMapping("/show/{numeroMatricula}")
	public String showBarco(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula)
	      .orElse(null);
	    model.addAttribute("barco", boat);
	    return "barcos/show";
	}
	
	@GetMapping("/edit/{numeroMatricula}")
	public String editBarco(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Boat boat = boatService.findById(numeroMatricula).orElse(null);
	    model.addAttribute("barco", boat);
		return "barcos/edit";
	}
}

