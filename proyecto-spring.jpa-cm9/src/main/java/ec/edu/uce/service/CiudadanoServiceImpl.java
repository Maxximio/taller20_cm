package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Ciudadano;
import ec.edu.uce.repository.jpa.ICiudadanoRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepo ciuRepo;
	
	@Override
	public void insertarCiudadanoService(Ciudadano ciu) {
		// TODO Auto-generated method stub
		this.ciuRepo.insertarCiudadano(ciu);
	}

}
