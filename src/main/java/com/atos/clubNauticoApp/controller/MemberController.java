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
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/create")
	public String memberCreateForm(Model model) {
		model.addAttribute("member", new Member());
		return "member/create";
		
	}
	
	@GetMapping("/edit")
	public String memberEditForm(@ModelAttribute Member member, Model model) {
		model.addAttribute("member", member);
		return "member/edit";
	}
	
	@PostMapping
	public String createMember(@ModelAttribute @Valid Member member, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "member/create";
		}
		model.addAttribute("member", memberService.createMember(member));
		return "member/show";
	}
	
	@PutMapping
	public String editMember(@ModelAttribute @Valid Member member, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "member/edit";
		}
		model.addAttribute("member", memberService.createMember(member));
		return "member/show";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
	    model.addAttribute("member", memberService.getAllMembers());
	    return "member/list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteMemeber(@PathVariable("id") Long id, Model model) {
	    Member member = memberService.findById(id).orElse(null);
	    memberService.deleteMember(member);
	    return "redirect:/member/memberList";
	}
	
	@GetMapping("/show/{id}")
	public String showPersona(@PathVariable("id") Long id, Model model) {
	    Member member = memberService.findById(id)
	      .orElse(null);
	    model.addAttribute("member", member);
	    return "member/show";
	}
	
	@GetMapping("/edit/{id}")
	public String editMember(@PathVariable("id") Long id, Model model) {
	    Member member = memberService.findById(id).orElse(null);
	    model.addAttribute("member", member);
		return "member/edit";
	}
}
