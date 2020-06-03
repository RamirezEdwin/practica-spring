package com.proyectospringedwin.proyectospringedwin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringedwin.proyectospringedwin.models.entity.Ciudad;
import com.proyectospringedwin.proyectospringedwin.repository.CiudadRepository;



@Service
public class CiudadServiceImpl implements ICiudadService {
	
	@Autowired
	private CiudadRepository CiudadRepository;
	
	

	@Override
	public List<Ciudad> listaCiudades() {
		
		return (List<Ciudad>) CiudadRepository.findAll();
	}

} 
