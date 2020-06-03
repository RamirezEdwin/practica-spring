package com.proyectospringedwin.proyectospringedwin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringedwin.proyectospringedwin.models.entity.Cliente;
import com.proyectospringedwin.proyectospringedwin.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements IClienteService {

	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	@Override
	public List<Cliente> listarTodos() {
		
		return (List<Cliente>) ClienteRepository.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		ClienteRepository.save(cliente);
		

	}

	@Override
	public Cliente buscarPorId(Long id) {
		
		return ClienteRepository.findById(id).orElse(null) ;
	}

	@Override
	public void eliminar(Long id) {
		ClienteRepository.deleteById(id);

	}

}
