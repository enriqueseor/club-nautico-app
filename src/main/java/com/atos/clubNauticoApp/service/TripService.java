package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import com.atos.clubNauticoApp.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.repository.TripRepository;

@Service
public class TripService {

	@Autowired
	private TripRepository tripRepository;
	
	public Trip createSalida(Trip trip) {
		return tripRepository.save(trip);
	}

	public List<Trip> getAllSalidas() {
		return tripRepository.findAll();
	}

	public void deleteSalida(Trip trip) {
		tripRepository.delete(trip);
	}

	public Optional<Trip> findById(Long id) {
		return tripRepository.findById(id);
	}
}
