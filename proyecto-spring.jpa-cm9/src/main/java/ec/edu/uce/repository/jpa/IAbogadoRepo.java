package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Abogado;

public interface IAbogadoRepo {

	void InsertarAbogado(Abogado abo);
	
	Abogado buscarAbogado(Integer id);
	
	void ActualizarAbogado(Abogado abo);
	
	void borrarAbogado(Integer id);
	
	Abogado buscarAbogadoFirma(String firma);
	
}
