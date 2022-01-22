package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;

public interface IGestorCitaService {
	void registratNuevaConsulta(Paciente paciente,Receta receta);
	
}
