package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.DetalleFactura;

public interface IDetalleService {

	List <DetalleFactura> buscarPorFechaJOINFetchService(BigDecimal valMin,LocalDateTime fecha);
	
}
