package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.repository.jpa.IDetalleRepo;

@Service
public class DetalleServiceImpl implements IDetalleService{

	@Autowired
	private IDetalleRepo detaRepo;
	
	@Override
	public List<DetalleFactura> buscarPorFechaJOINFetchService(BigDecimal valMin,LocalDateTime fecha) {
		return this.detaRepo.buscarPorFechaJOINFetch(valMin,fecha);
	}

}
