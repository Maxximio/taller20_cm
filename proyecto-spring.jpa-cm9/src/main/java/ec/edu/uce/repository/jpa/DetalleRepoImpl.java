package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Factura;

@Repository
@Transactional
public class DetalleRepoImpl implements IDetalleRepo{

	private static final Logger LOG= LogManager.getLogger(FacturaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DetalleFactura> buscarPorFechaJOINFetch(BigDecimal precio,LocalDateTime fecha) {
		TypedQuery<DetalleFactura> myQuery=this.entityManager.createQuery("SELECT f FROM DetalleFactura f JOIN FETCH f.factura d Where f.precio<=:precio AND f.factura.fecha<=:fecha",DetalleFactura.class);
		myQuery.setParameter("precio", precio );
		myQuery.setParameter("fecha",fecha );
		
		List<DetalleFactura> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(DetalleFactura f: miLista) {
			LOG.info("detalles: "+f.getPrecio());
			LOG.info("fecha: "+f.getFactura().getFecha());
			LOG.info(f.toString());
		}
		
		return miLista;
	}

}
