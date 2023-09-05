package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import com.atos.clubNauticoApp.model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.repository.BoatRepository;

@Service
public class BoatService {

	@Autowired
	private BoatRepository boatRepository;
	
	public Boat createBarco(Boat boat) {
		return boatRepository.save(boat);
	}

	public List<Boat> getAllBarcos() {
		return boatRepository.findAll();
	}

	public void deleteBarco(Boat boat) {
		boatRepository.delete(boat);
	}

	public Optional<Boat> findById(Long numeroMatricula) {
		return boatRepository.findById(numeroMatricula);
	}
}
