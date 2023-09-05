package com.atos.clubNauticoApp.controller;

import com.atos.clubNauticoApp.model.Skipper;
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

import com.atos.clubNauticoApp.service.SkipperService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/socios")
public class SkipperController {

	@Autowired
	private SkipperService skipperService;
	
	@GetMapping("/create")
	public String socioCreateForm(Model model) {
		model.addAttribute("socio", new Skipper());
		return "socios/create";
		
	}
	
	@GetMapping("/edit")
	public String socioEditForm(@ModelAttribute Skipper skipper, Model model) {
		model.addAttribute("socio", skipper);
		return "socios/edit";
		
	}
	
	@PostMapping
	public String createSocio(@ModelAttribute @Valid Skipper skipper, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "socios/create";
		}
		model.addAttribute("socio", skipperService.createSocio(skipper));
		return "socios/show";
		
	}
	
	@PutMapping
	public String editSocio(@ModelAttribute @Valid Skipper skipper, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "socios/edit";
		}
		model.addAttribute("socio", skipperService.createSocio(skipper));
		return "socios/show";
	}
	
	@GetMapping("/listSocio")
	public String listSocio(Model model) {
	    model.addAttribute("socios", skipperService.getAllSocios());
	    return "socios/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteSocio(@PathVariable("id") Long id, Model model) {
	    Skipper skipper = skipperService.findById(id).orElse(null);
	    skipperService.deleteSocio(skipper);
	    return "redirect:/socios/listSocio";
	}
	
	@GetMapping("/show/{id}")
	public String showSocio(@PathVariable("id") Long id, Model model) {
	    Skipper skipper = skipperService.findById(id)
	      .orElse(null);
	    model.addAttribute("socio", skipper);
	    return "socios/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editSocio(@PathVariable("id") Long id, Model model) {
	    Skipper skipper = skipperService.findById(id).orElse(null);
	    model.addAttribute("socio", skipper);
		return "socios/edit";
	}
}