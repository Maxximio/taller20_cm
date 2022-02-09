package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencilla;
import ec.edu.uce.repository.jpa.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepo factRepo;
	
	@Override
	public void insertarFacturaService(Factura factura) {
		this.factRepo.insertarFactura(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJOINService(LocalDateTime fecha) {
		return this.factRepo.buscarPorFechaJOIN(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaJOINLeftService(LocalDateTime fecha) {
		return this.factRepo.buscarPorFechaJOINLeft(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaJOINRigthService(LocalDateTime fecha) {
		return this.factRepo.buscarPorFechaJOINRigth(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaWhereService(LocalDateTime fecha) {
		return this.factRepo.buscarPorFechaWhere(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaJOINFetchService(LocalDateTime fecha) {
		return this.factRepo.buscarPorFechaJOINFetch(fecha);
	}

	@Override
	public List<FacturaSencilla> buscarSencillaPorFechaJOINFetchService(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.factRepo.buscarSencillaPorFechaJOINFetch(fecha);
	}

}
