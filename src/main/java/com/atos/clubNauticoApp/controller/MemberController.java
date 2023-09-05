package com.atos.clubNauticoApp.controller;

import com.atos.clubNauticoApp.model.Member;
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

import com.atos.clubNauticoApp.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/personas")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/create")
	public String personaCreateForm(Model model) {
		model.addAttribute("persona", new Member());
		return "personas/create";
		
	}
	
	@GetMapping("/edit")
	public String personaEditForm(@ModelAttribute Member member, Model model) {
		model.addAttribute("persona", member);
		return "personas/edit";
		
	}
	
	@PostMapping
	public String createPersona(@ModelAttribute @Valid Member member, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "personas/create";
		}
		model.addAttribute("persona", memberService.createPersona(member));
		return "personas/show";
		
	}
	
	@PutMapping
	public String editPersona(@ModelAttribute @Valid Member member, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "personas/edit";
		}
		model.addAttribute("persona", memberService.createPersona(member));
		return "personas/show";
	}
	
	@GetMapping("/listPersonas")
	public String listStudent(Model model) {
	    model.addAttribute("personas", memberService.getAllPersonas());
	    return "personas/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletePersona(@PathVariable("id") Long id, Model model) {
	    Member member = memberService.findById(id).orElse(null);
	    memberService.deletePersona(member);
	    return "redirect:/personas/listPersonas";
	}
	
	@GetMapping("/show/{id}")
	public String showPersona(@PathVariable("id") Long id, Model model) {
	    Member member = memberService.findById(id)
	      .orElse(null);
	    model.addAttribute("persona", member);
	    return "personas/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editPersona(@PathVariable("id") Long id, Model model) {
	    Member member = memberService.findById(id).orElse(null);
	    model.addAttribute("persona", member);
		return "personas/edit";
	}
}
