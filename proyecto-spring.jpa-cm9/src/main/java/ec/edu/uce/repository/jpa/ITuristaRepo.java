package ec.edu.uce.repository.jpa;

import java.util.List;

import ec.edu.uce.modelo.Turista;

public interface ITuristaRepo {

	void insertarTurista(Turista tur);
	
	List<Turista> GenerarTuristaCriteria();
	
}
