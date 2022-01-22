package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Abogado;
import ec.edu.uce.repository.jpa.IAbogadoRepo;

@Service
public class AbogadoServiceImpl implements IAbogadoService{

	@Autowired
	private IAbogadoRepo aboRepo;
	
	@Override
	public void InsertarAbogadoService(Abogado abo) {
		// TODO Auto-generated method stub
		this.aboRepo.InsertarAbogado(abo);
	}

	@Override
	public Abogado buscarAbogadoService(Integer id) {
		// TODO Auto-generated method stub
		return this.aboRepo.buscarAbogado(id);
	}

	@Override
	public void ActualizarAbogadoService(Abogado abo) {
		// TODO Auto-generated method stub
		this.aboRepo.ActualizarAbogado(abo);
	}

	@Override
	public void borrarAbogadoService(Integer id) {
		// TODO Auto-generated method stub
		this.aboRepo.borrarAbogado(id);
	}

	@Override
	public Abogado buscarAbogadoFirmaService(String firma) {
		// TODO Auto-generated method stub
		return this.aboRepo.buscarAbogadoFirma(firma);
	}

}
