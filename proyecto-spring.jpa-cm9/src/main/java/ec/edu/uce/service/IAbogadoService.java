package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Abogado;

public interface IAbogadoService {

	void InsertarAbogadoService(Abogado abo);
	
	Abogado buscarAbogadoService(Integer id);
	
	void ActualizarAbogadoService(Abogado abo);
	
	void borrarAbogadoService(Integer id);
	
	Abogado buscarAbogadoFirmaService(String firma);
}
