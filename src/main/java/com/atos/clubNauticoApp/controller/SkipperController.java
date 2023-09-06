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
@RequestMapping("/skippers")
public class SkipperController {

	@Autowired
	private SkipperService skipperService;
	
	@GetMapping("/create")
	public String skipperCreateForm(Model model) {
		model.addAttribute("skipper", new Skipper());
		return "skippers/create";
	}
	
	@GetMapping("/edit")
	public String skipperEditForm(@ModelAttribute Skipper skipper, Model model) {
		model.addAttribute("skipper", skipper);
		return "skippers/edit";
	}
	
	@PostMapping
	public String createSkipper(@ModelAttribute @Valid Skipper skipper, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "skippers/create";
		}
		model.addAttribute("skipper", skipperService.createSkipper(skipper));
		return "skippers/show";
	}
	
	@PutMapping
	public String editSkipper(@ModelAttribute @Valid Skipper skipper, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "skippers/edit";
		}
		model.addAttribute("skipper", skipperService.createSkipper(skipper));
		return "skippers/show";
	}
	
	@GetMapping("/skipperList")
	public String skipperList(Model model) {
	    model.addAttribute("skippers", skipperService.getAllSkippers());
	    return "skippers/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteSkipper(@PathVariable("id") Long id, Model model) {
	    Skipper skipper = skipperService.findById(id).orElse(null);
	    skipperService.deleteSkipper(skipper);
	    return "redirect:/skippers/skipperList";
	}
	
	@GetMapping("/show/{id}")
	public String showSkipper(@PathVariable("id") Long id, Model model) {
	    Skipper skipper = skipperService.findById(id)
	      .orElse(null);
	    model.addAttribute("skipper", skipper);
	    return "skippers/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editSkipper(@PathVariable("id") Long id, Model model) {
	    Skipper skipper = skipperService.findById(id).orElse(null);
	    model.addAttribute("skipper", skipper);
		return "skippers/edit";
	}
}