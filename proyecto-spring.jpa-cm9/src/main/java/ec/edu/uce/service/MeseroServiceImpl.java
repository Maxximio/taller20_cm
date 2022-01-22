package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Mesero;
import ec.edu.uce.repository.jpa.IMeseroRepo;

@Service
public class MeseroServiceImpl implements IMeseroService{

	@Autowired
	private IMeseroRepo mesRepo;

	@Override
	public void InsertarMeseroService(Mesero mes) {
		// TODO Auto-generated method stub
		this.mesRepo.InsertarMesero(mes);
	}

	@Override
	public Mesero buscarMeseroService(Integer id) {
		// TODO Auto-generated method stub
		return this.mesRepo.buscarMesero(id);
	}

	@Override
	public void ActualizarMeseroService(Mesero mes) {
		// TODO Auto-generated method stub
		this.mesRepo.ActualizarMesero(mes);
	}

	@Override
	public void borrarMeseroService(Integer id) {
		// TODO Auto-generated method stub
		this.mesRepo.borrarMesero(id);
	}

	@Override
	public Mesero buscarMeseroRestauranteService(String restaurante) {
		// TODO Auto-generated method stub
		return this.mesRepo.buscarMeseroRestaurante(restaurante);
	} 
	
}
