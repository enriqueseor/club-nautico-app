package com.atos.clubNauticoApp.repository;

import java.util.Optional;

import com.atos.clubNauticoApp.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatRepository extends JpaRepository<Boat, Long>{
	
	public Optional<Boat> findByNumeroMatricula(Long numeroMatricula);
}
