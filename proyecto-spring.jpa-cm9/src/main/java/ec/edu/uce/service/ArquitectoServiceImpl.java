package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.repository.jpa.IArquitectoRepo;

@Service
public class ArquitectoServiceImpl implements IArquitectoSerivce{

	@Autowired
	private IArquitectoRepo arqRepo;

	@Override
	public void InsertarArquitectoService(Arquitecto arq) {
		// TODO Auto-generated method stub
		this.arqRepo.InsertarArquitecto(arq);
	}

	@Override
	public Arquitecto buscarArquitectoService(Integer id) {
		// TODO Auto-generated method stub
		return this.arqRepo.buscarArquitecto(id);
	}

	@Override
	public void ActualizarArquitectoService(Arquitecto arq) {
		// TODO Auto-generated method stub
		this.arqRepo.ActualizarArquitecto(arq);
	}

	@Override
	public void borrarArquitectoService(Integer id) {
		// TODO Auto-generated method stub
		this.arqRepo.borrarArquitecto(id);
	}

	@Override
	public Arquitecto buscarArquitectoApellidoService(String apellido) {
		// TODO Auto-generated method stub
		return this.arqRepo.buscarArquitectoApellido(apellido);
	}
	
}
