package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.repository.jpa.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo cliRepo;

	@Override
	public void InsertarClienteService(Cliente cli) {
		this.cliRepo.insertarCliente(cli);		
	}
	
}
