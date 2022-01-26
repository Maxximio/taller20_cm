package ec.edu.uce.repository.jpa;

import java.util.List;

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
	
	Guardia buscarGuardiaApellidoNative(String apellido);
	
	Guardia buscarGuardiaApellidoNamedNative(String apellido);
	
	Guardia buscarGuardiaApellidoCriteria(String apellido);
	
	Guardia buscarGuardiaApellidoCriteriaAnd(String apellido,String nombre);
	
	List<Guardia> buscarGuardiaApellidoCriteriaOr(String apellido,String nombre);
}
