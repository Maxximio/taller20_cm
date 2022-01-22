package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Chofer;
import ec.edu.uce.repository.jpa.IChoferRepo;

@Service
public class ChoferServiceImpl implements IChoferService{

	@Autowired
	private IChoferRepo choRepo;

	@Override
	public void InsertarChoferService(Chofer cho) {
		// TODO Auto-generated method stub
		this.choRepo.InsertarChofer(cho);
	}

	@Override
	public Chofer buscarChoferService(Integer matricula) {
		// TODO Auto-generated method stub
		return this.choRepo.buscarChofer(matricula);
	}

	@Override
	public void ActualizarChoferService(Chofer cho) {
		// TODO Auto-generated method stub
		this.choRepo.ActualizarChofer(cho);
	}

	@Override
	public void borrarChoferService(Integer matricula) {
		// TODO Auto-generated method stub
		this.choRepo.borrarChofer(matricula);
	}

	@Override
	public Chofer buscarChoferNombreService(String nombre) {
		// TODO Auto-generated method stub
		return this.choRepo.buscarChoferNombre(nombre);
	}
	
}
