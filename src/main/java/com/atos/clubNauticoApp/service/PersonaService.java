package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.model.Persona;
import com.atos.clubNauticoApp.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public Persona createPersona(Persona persona) {
		return personaRepository.save(persona);
	}

	public List<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}

	public void deletePersona(Persona persona) {
		personaRepository.delete(persona);
	}

	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id);
	}
	
	public Optional<Persona> findByDni(String dni) {
		return personaRepository.findByDni(dni);
	}
}
