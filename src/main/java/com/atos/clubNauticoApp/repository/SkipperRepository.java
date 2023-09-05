package com.atos.clubNauticoApp.repository;

import java.util.List;
import java.util.Optional;

import com.atos.clubNauticoApp.model.Skipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkipperRepository extends JpaRepository<Skipper, Long>{

	public Optional<Skipper> findByDni(String dni);
	
	public List<Skipper> findAllByOrderByNombreDesc();
}
