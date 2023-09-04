package com.atos.clubNauticoApp.controller;

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

import com.atos.clubNauticoApp.model.Socio;
import com.atos.clubNauticoApp.service.SocioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/socios")
public class SocioController {

	@Autowired
	private SocioService socioService;
	
	@GetMapping("/create")
	public String socioCreateForm(Model model) {
		model.addAttribute("socio", new Socio());
		return "socios/create";
		
	}
	
	@GetMapping("/edit")
	public String socioEditForm(@ModelAttribute Socio socio, Model model) {
		model.addAttribute("socio", socio);
		return "socios/edit";
		
	}
	
	@PostMapping
	public String createSocio(@ModelAttribute @Valid Socio socio, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "socios/create";
		}
		model.addAttribute("socio", socioService.createSocio(socio));
		return "socios/show";
		
	}
	
	@PutMapping
	public String editSocio(@ModelAttribute @Valid Socio socio, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "socios/edit";
		}
		model.addAttribute("socio", socioService.createSocio(socio));
		return "socios/show";
	}
	
	@GetMapping("/listSocio")
	public String listSocio(Model model) {
	    model.addAttribute("socios", socioService.getAllSocios());
	    return "socios/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteSocio(@PathVariable("id") Long id, Model model) {
	    Socio socio = socioService.findById(id).orElse(null);
	    socioService.deleteSocio(socio);
	    return "redirect:/socios/listSocio";
	}
	
	@GetMapping("/show/{id}")
	public String showSocio(@PathVariable("id") Long id, Model model) {
	    Socio socio = socioService.findById(id)
	      .orElse(null);
	    model.addAttribute("socio", socio);
	    return "socios/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editSocio(@PathVariable("id") Long id, Model model) {
	    Socio socio = socioService.findById(id).orElse(null);
	    model.addAttribute("socio", socio);
		return "socios/edit";
	}
}