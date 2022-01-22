package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.modelo.jpa.Guardia;

public interface IArquitectoSerivce {

	void InsertarArquitectoService(Arquitecto arq);
	
	Arquitecto buscarArquitectoService(Integer id);
	
	void ActualizarArquitectoService(Arquitecto arq);
	
	void borrarArquitectoService(Integer id);
	
	Arquitecto buscarArquitectoApellidoService(String apellido);
	
}
