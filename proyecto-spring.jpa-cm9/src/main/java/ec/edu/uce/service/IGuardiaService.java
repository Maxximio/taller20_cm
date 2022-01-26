package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaService {

	void InsertarGuardiaService(Guardia guardia);
	
	Guardia buscarGuardiaService(Integer id);
	
	void ActualizarGuardiaService(Guardia guardia);
	
	void borrarGuardiaService(Integer id);
	
	Guardia buscarGuardiaApellidoService(String apellido);
	
	Guardia buscarGuardiaApellidoListaService(String apellido);
	
	Guardia buscarGuardiaApellidoIype(String apellido);
	
	Guardia buscarGuardiaApellidoNamedService(String apellido);
	
	Guardia buscarGuardiaApellidoNativeService(String apellido);
	
	Guardia buscarGuardiaApellidoNamedNativeService(String apellido);
	
	Guardia buscarGuardiaApellidoCriteriaService(String apellido);
	
	Guardia buscarGuardiaApellidoCriteriaAndService(String apellido,String nombre);
	
	List <Guardia> buscarGuardiaApellidoCriteriaOrService(String apellido,String nombre);
}
