package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {
	
	void InsertarPacienteServicio(Paciente paciente);
	
	Paciente buscarPacienteServicio(Integer id);
	
	void actualizarPacienteServicio(Paciente paciente);
	
	void borrarPacienteServicio(Integer id);
	
}
