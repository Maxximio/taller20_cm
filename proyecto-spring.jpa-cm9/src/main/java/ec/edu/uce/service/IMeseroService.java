package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;

public interface IMeseroService {

	void InsertarMeseroService(Mesero mes);
	
	Mesero buscarMeseroService(Integer id);
	
	void ActualizarMeseroService(Mesero mes);
	
	void borrarMeseroService(Integer id);
	
	Mesero buscarMeseroRestauranteService(String restaurante);
}
