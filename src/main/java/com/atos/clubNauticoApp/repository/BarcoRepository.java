package com.atos.clubNauticoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.clubNauticoApp.model.Barco;

public interface BarcoRepository extends JpaRepository<Barco, Long>{
	
	public Optional<Barco> findByNumeroMatricula(Long numeroMatricula);
}
