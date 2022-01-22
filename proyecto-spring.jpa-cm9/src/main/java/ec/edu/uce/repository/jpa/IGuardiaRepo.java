package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaRepo {

	void InsertarGuardia(Guardia guardia);
	
	Guardia buscarGuardia(Integer id);
	
	void ActualizarGuardia(Guardia guardia);
	
	void borrarGuardia(Integer id);
	
	Guardia buscarGuardiaApellido(String apellido);

	Guardia buscarGuardiaApellidoLista(String apellido);
	
	Guardia buscarGuardiaApellidoIype(String apellido);
	
	Guardia buscarGuardiaApellidoNamed(String apellido);
}
