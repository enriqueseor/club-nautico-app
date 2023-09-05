package com.atos.clubNauticoApp.service;

import java.util.List;
import java.util.Optional;

import com.atos.clubNauticoApp.model.Skipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.clubNauticoApp.repository.SkipperRepository;

@Service
public class SkipperService {

	@Autowired
	private SkipperRepository skipperRepository;
	
	public Skipper createSocio(Skipper skipper) {
		return skipperRepository.save(skipper);
	}

	public List<Skipper> getAllSocios() {
		return skipperRepository.findAll();
	}

	public void deleteSocio(Skipper skipper) {
		skipperRepository.delete(skipper);
	}

	public Optional<Skipper> findById(Long id) {
		return skipperRepository.findById(id);
	}
	
	public List<Skipper> findAllByOrderByNombre() {
		return skipperRepository.findAllByOrderByNombreDesc();
	}
	
	public Optional<Skipper> findByDni(String dni) {
		return skipperRepository.findByDni(dni);
	}
}
