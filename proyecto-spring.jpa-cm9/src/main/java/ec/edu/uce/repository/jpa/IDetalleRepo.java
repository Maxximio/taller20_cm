package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.DetalleFactura;

public interface IDetalleRepo {

	List <DetalleFactura> buscarPorFechaJOINFetch(BigDecimal valMin,LocalDateTime fecha);
	
}
