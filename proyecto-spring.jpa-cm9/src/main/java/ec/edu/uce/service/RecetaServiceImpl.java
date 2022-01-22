package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Receta;
import ec.edu.uce.repository.IRecetaRepo;

@Service
public class RecetaServiceImpl implements IRecetaService{

	@Autowired
	private IRecetaRepo recetRepo;
	
	@Override
	public void guardarReceta(Receta receta) {
		// TODO Auto-generated method stub
		this.recetRepo.insertarPReceta(receta);
	}

	
	
}
