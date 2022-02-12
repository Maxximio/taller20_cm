package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Turista;

public interface ITuristaService {

	void insertarTuristasService(Turista turista);
	
	List<Turista> obtenerTuristas();
}
