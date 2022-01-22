package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Doctor;

public interface IDoctorRepo {

	void InsertarDoctor(Doctor doctor);
	
	Doctor buscarDoctor(Integer id);
	
	void ActualizarDoctor(Doctor doctor);
	
	void borrarDoctor(Integer id);
	
	Doctor buscarDoctorEspecialidad(String especial);
}
