package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService{

	@Autowired
	private IPacienteService pacienteServic;
	
	@Autowired
	private IRecetaService recetaServic;
	
	//transferencia
	@Override
	public void registratNuevaConsulta(Paciente paciente, Receta receta) {
		// sacar dinero
		// poner dinero
		this.pacienteServic.InsertarPacienteServicio(paciente);
		this.recetaServic.guardarReceta(receta);
	}

}
