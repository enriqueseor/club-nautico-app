package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.model.Salida;
import com.atos.clubNauticoApp.repository.SalidaRepository;

@Service
public class SalidaService {

	@Autowired
	private SalidaRepository salidaRepository;
	
	public Salida createSalida(Salida salida) {
		return salidaRepository.save(salida);
	}

	public List<Salida> getAllSalidas() {
		return salidaRepository.findAll();
	}

	public void deleteSalida(Salida salida) {
		salidaRepository.delete(salida);
	}

	public Optional<Salida> findById(Long id) {
		return salidaRepository.findById(id);
	}
}
