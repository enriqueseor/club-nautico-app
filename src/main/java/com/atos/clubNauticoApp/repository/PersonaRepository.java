package com.atos.clubNauticoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.clubNauticoApp.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	public Optional<Persona> findByDni(String dni);

}
