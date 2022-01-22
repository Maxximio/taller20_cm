package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Mesero;

public interface IMeseroRepo {

	void InsertarMesero(Mesero mes);
	
	Mesero buscarMesero(Integer id);
	
	void ActualizarMesero(Mesero mes);
	
	void borrarMesero(Integer id);
	
	Mesero buscarMeseroRestaurante(String restaurante);
	
}
