package ec.edu.uce.repository;

import ec.edu.uce.modelo.Receta;

public interface IRecetaRepo {

	void insertarPReceta(Receta receta);
	
	Receta buscarPaciente(Integer id);
	
	void actualizarReceta(Receta receta);
	
	void borrarReceta(Integer id);
	
}
