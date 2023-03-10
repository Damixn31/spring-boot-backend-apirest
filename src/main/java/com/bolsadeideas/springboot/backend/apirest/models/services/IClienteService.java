package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	
	//aca hacemos el CRUD

	public List<Cliente> findAll(); //busca todos los clientes
	
	public Cliente findById(Long id); //busca un cliente
	
	public Cliente save(Cliente cliente); // guarda un cliente
	
	public void delete(Long id); //borra un cliente
}
