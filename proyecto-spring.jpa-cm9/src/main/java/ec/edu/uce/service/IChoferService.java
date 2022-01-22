package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Chofer;

public interface IChoferService {

	void InsertarChoferService(Chofer cho);
	
	Chofer buscarChoferService(Integer matricula);
	
	void ActualizarChoferService(Chofer cho);
	
	void borrarChoferService(Integer matricula);
	
	Chofer buscarChoferNombreService(String nombre);
}
