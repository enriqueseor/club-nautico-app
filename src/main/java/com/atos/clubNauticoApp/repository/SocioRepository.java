package com.atos.clubNauticoApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.clubNauticoApp.model.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long>{

	public Optional<Socio> findByDni(String dni);
	
	public List<Socio> findAllByOrderByNombreDesc();
}
