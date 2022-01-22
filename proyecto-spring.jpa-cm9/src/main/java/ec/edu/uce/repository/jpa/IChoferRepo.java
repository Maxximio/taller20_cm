package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Chofer;

public interface IChoferRepo {

void InsertarChofer(Chofer cho);
	
	Chofer buscarChofer(Integer matricula);
	
	void ActualizarChofer(Chofer cho);
	
	void borrarChofer(Integer matricula);
	
	Chofer buscarChoferNombre(String nombre);
}
