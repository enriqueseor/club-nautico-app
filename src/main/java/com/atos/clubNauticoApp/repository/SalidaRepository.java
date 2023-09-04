package com.atos.clubNauticoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.clubNauticoApp.model.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Long>{

	public Optional<Salida> findById(Long id);
}
