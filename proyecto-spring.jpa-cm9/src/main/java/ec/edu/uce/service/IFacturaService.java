package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.Factura;

public interface IFacturaService {

	void insertarFacturaService(Factura factura);
	
	List <Factura> buscarPorFechaJOINService(LocalDateTime fecha);
	
	List <Factura> buscarPorFechaJOINLeftService(LocalDateTime fecha);
	
	List <Factura> buscarPorFechaJOINRigthService(LocalDateTime fecha);
	
	List <Factura> buscarPorFechaWhereService(LocalDateTime fecha);
	
}
