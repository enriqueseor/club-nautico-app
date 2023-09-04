package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.model.Socio;
import com.atos.clubNauticoApp.repository.SocioRepository;

@Service
public class SocioService {

	@Autowired
	private SocioRepository socioRepository;
	
	public Socio createSocio(Socio socio) {
		return socioRepository.save(socio);
	}

	public List<Socio> getAllSocios() {
		return socioRepository.findAll();
	}

	public void deleteSocio(Socio socio) {
		socioRepository.delete(socio);
	}

	public Optional<Socio> findById(Long id) {
		return socioRepository.findById(id);
	}
	
	public List<Socio> findAllByOrderByNombre() {
		return socioRepository.findAllByOrderByNombreDesc();
	}
	
	public Optional<Socio> findByDni(String dni) {
		return socioRepository.findByDni(dni);
	}
}
