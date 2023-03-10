package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"}) // para vincular el forntend con el backend
@RestController  // como es un api rest va con RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;

	// retorna todos los clientes
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	//retorna el id
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	// crea el cliente
	@PostMapping("/clientes")
	@ResponseStatus(value = HttpStatus.CREATED) // para que nos diga 201 que se a creado nuestro cliente efectivamente!
	public Cliente create(@RequestBody Cliente cliente) {
		//asignamos la fecha de creacion del cliente en la clase cliente
		//cliente.setCreateAt(new Date());
		return clienteService.save(cliente);
	}
	
	// para actualizar 
	@PutMapping("/clientes/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		//optenemos primero el id del cliente que queremos actualziar modificar
		Cliente clienteActual = clienteService .findById(id);
		
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		
		// el save se puede usar para hacer un merge(actualizar o modifica) o tambien para guardar el nuevo cliente creado
		return clienteService.save(clienteActual);
	}
	
	// eliminar borrar cliente
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
	
}
