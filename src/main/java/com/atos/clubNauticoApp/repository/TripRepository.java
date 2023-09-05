package com.atos.clubNauticoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.clubNauticoApp.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{

	public Optional<Trip> findById(Long id);
}
