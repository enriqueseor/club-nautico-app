package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import com.atos.clubNauticoApp.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public Member createPersona(Member member) {
		return memberRepository.save(member);
	}

	public List<Member> getAllPersonas() {
		return memberRepository.findAll();
	}

	public void deletePersona(Member member) {
		memberRepository.delete(member);
	}

	public Optional<Member> findById(Long id) {
		return memberRepository.findById(id);
	}
	
	public Optional<Member> findByDni(String dni) {
		return memberRepository.findByDni(dni);
	}
}
