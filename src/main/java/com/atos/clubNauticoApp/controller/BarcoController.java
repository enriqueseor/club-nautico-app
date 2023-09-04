package com.atos.clubNauticoApp.controller;

import java.util.List;

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

import com.atos.clubNauticoApp.model.Barco;
import com.atos.clubNauticoApp.model.Socio;
import com.atos.clubNauticoApp.service.BarcoService;
import com.atos.clubNauticoApp.service.SocioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/barcos")
public class BarcoController {

	@Autowired
	private BarcoService barcoService;
	
	@Autowired
	private SocioService socioService;
	
	@GetMapping("/create")
	public String barcoCreateForm(Model model) {
		model.addAttribute("barco", new Barco());
		List<Socio> listaSocios = socioService.findAllByOrderByNombre();
		model.addAttribute("listaSocios", listaSocios);
		return "barcos/create";
		
	}
	
	@GetMapping("/edit")
	public String barcoEditForm(@ModelAttribute Barco barco, Model model) {
		model.addAttribute("barco", barco);
		return "barcos/edit";
		
	}
	
	@PostMapping
	public String createBarco(@ModelAttribute @Valid Barco barco, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "barcos/create";
		}
		model.addAttribute("barco", barcoService.createBarco(barco));
		return "barcos/show";
		
	}
	
	@PutMapping
	public String editBarco(@ModelAttribute @Valid Barco barco, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "barcos/edit";
		}
		model.addAttribute("barco", barcoService.createBarco(barco));
		return "barcos/show";
	}
	
	@GetMapping("/listBarco")
	public String listBarcos(Model model) {
	    model.addAttribute("barcos", barcoService.getAllBarcos());
	    return "barcos/list";
	}
	
	
	@GetMapping("/delete/{numeroMatricula}")
	public String deleteBarco(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Barco barco = barcoService.findById(numeroMatricula).orElse(null);
	    barcoService.deleteBarco(barco);
	    return "redirect:/barcos/listBarco";
	}
	
	@GetMapping("/show/{numeroMatricula}")
	public String showBarco(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Barco barco = barcoService.findById(numeroMatricula)
	      .orElse(null);
	    model.addAttribute("barco", barco);
	    return "barcos/show";
	}
	
	@GetMapping("/edit/{numeroMatricula}")
	public String editBarco(@PathVariable("numeroMatricula") Long numeroMatricula, Model model) {
	    Barco barco = barcoService.findById(numeroMatricula).orElse(null);
	    model.addAttribute("barco", barco);
		return "barcos/edit";
	}
}

