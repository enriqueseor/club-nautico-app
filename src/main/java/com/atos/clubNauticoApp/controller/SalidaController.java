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

import com.atos.clubNauticoApp.model.Salida;
import com.atos.clubNauticoApp.service.SalidaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/salidas")
public class SalidaController {

	@Autowired
	private SalidaService salidaService;
	
	@GetMapping("/create")
	public String salidaCreateForm(Model model) {
		model.addAttribute("salida", new Salida());
		return "salidas/create";
		
	}
	
	@GetMapping("/edit")
	public String salidaEditForm(@ModelAttribute Salida salida, Model model) {
		model.addAttribute("salida", salida);
		return "salidas/edit";
		
	}
	
	@PostMapping
	public String createSalida(@ModelAttribute @Valid Salida salida, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "salidas/create";
		}
		model.addAttribute("salida", salidaService.createSalida(salida));
		return "salidas/show";
		
	}
	
	@PutMapping
	public String editSalida(@ModelAttribute @Valid Salida salida, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "salidas/edit";
		}
		model.addAttribute("salida", salidaService.createSalida(salida));
		return "salidas/show";
	}
	
	@GetMapping("/listSalidas")
	public String listStudent(Model model) {
	    model.addAttribute("salidas", salidaService.getAllSalidas());
	    return "salidas/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteSalida(@PathVariable("id") Long id, Model model) {
		Salida salida = salidaService.findById(id).orElse(null);
	    salidaService.deleteSalida(salida);
	    return "redirect:/personas/listSalidas";
	}
	
	@GetMapping("/show/{id}")
	public String showSalida(@PathVariable("id") Long id, Model model) {
		Salida salida = salidaService.findById(id)
	      .orElse(null);
	    model.addAttribute("salida", salida);
	    return "salidas/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editSalida(@PathVariable("id") Long id, Model model) {
		Salida salida = salidaService.findById(id).orElse(null);
	    model.addAttribute("salida", salida);
		return "salidas/edit";
	}
}

