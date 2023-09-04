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

import com.atos.clubNauticoApp.model.Persona;
import com.atos.clubNauticoApp.service.PersonaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/create")
	public String personaCreateForm(Model model) {
		model.addAttribute("persona", new Persona());
		return "personas/create";
		
	}
	
	@GetMapping("/edit")
	public String personaEditForm(@ModelAttribute Persona persona, Model model) {
		model.addAttribute("persona", persona);
		return "personas/edit";
		
	}
	
	@PostMapping
	public String createPersona(@ModelAttribute @Valid Persona persona, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "personas/create";
		}
		model.addAttribute("persona", personaService.createPersona(persona));
		return "personas/show";
		
	}
	
	@PutMapping
	public String editPersona(@ModelAttribute @Valid Persona persona, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "personas/edit";
		}
		model.addAttribute("persona", personaService.createPersona(persona));
		return "personas/show";
	}
	
	@GetMapping("/listPersonas")
	public String listStudent(Model model) {
	    model.addAttribute("personas", personaService.getAllPersonas());
	    return "personas/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletePersona(@PathVariable("id") Long id, Model model) {
	    Persona persona = personaService.findById(id).orElse(null);
	    personaService.deletePersona(persona);
	    return "redirect:/personas/listPersonas";
	}
	
	@GetMapping("/show/{id}")
	public String showPersona(@PathVariable("id") Long id, Model model) {
	    Persona persona = personaService.findById(id)
	      .orElse(null);
	    model.addAttribute("persona", persona);
	    return "personas/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editPersona(@PathVariable("id") Long id, Model model) {
	    Persona persona = personaService.findById(id).orElse(null);
	    model.addAttribute("persona", persona);
		return "personas/edit";
	}
}
