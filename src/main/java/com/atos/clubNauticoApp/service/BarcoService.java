package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.model.Barco;
import com.atos.clubNauticoApp.repository.BarcoRepository;

@Service
public class BarcoService {

	@Autowired
	private BarcoRepository barcoRepository;
	
	public Barco createBarco(Barco barco) {
		return barcoRepository.save(barco);
	}

	public List<Barco> getAllBarcos() {
		return barcoRepository.findAll();
	}

	public void deleteBarco(Barco barco) {
		barcoRepository.delete(barco);
	}

	public Optional<Barco> findById(Long numeroMatricula) {
		return barcoRepository.findById(numeroMatricula);
	}
}
