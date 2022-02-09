package ec.edu.uce.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencilla;


@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo{

	private static final Logger LOG= LogManager.getLogger(FacturaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarFactura(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJOIN(LocalDateTime fecha) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d Where f.fecha<=:fecha",Factura.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarPorFechaJOINLeft(LocalDateTime fecha) {
		TypedQuery<Factura> myQuery=this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d Where f.fecha<=:fecha",Factura.class);
		myQuery.setParameter("fecha", fecha);
		
		List<Factura> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Factura f: miLista) {
			LOG.info("detalles: "+f.getDetalles());
			LOG.info(f.toString());
		}
		
		return miLista;
	}

	@Override
	public List<Factura> buscarPorFechaJOINRigth(LocalDateTime fecha) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles d Where f.fecha<=:fecha",Factura.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarPorFechaWhere(LocalDateTime fecha) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND f.fecha<=:fecha",Factura.class);
		myQuery.setParameter("fecha", fecha);
		
		List<Factura> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Factura f: miLista) {
			LOG.info("detalles: "+f.getDetalles());
			LOG.info(f.toString());
		}
		
		return miLista;
	}

	@Override
	public List<Factura> buscarPorFechaJOINFetch(LocalDateTime fecha) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles d Where f.fecha<=:fecha",Factura.class);
		myQuery.setParameter("fecha", fecha);

		List<Factura> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Factura f: miLista) {
			LOG.info("detalles: "+f.getDetalles());
			LOG.info(f.toString());
		}
		
		return miLista;
	}

	@Override
	public List<FacturaSencilla> buscarSencillaPorFechaJOINFetch(LocalDateTime fecha) {
		TypedQuery<FacturaSencilla> myQuery=this.entityManager.createQuery("SELECT NEW ec.edu.uce.modelo.jpa.FacturaSencilla(f.numero,f.cedula) FROM Factura f JOIN f.detalles d Where f.fecha<=:fecha",FacturaSencilla.class);
		myQuery.setParameter("fecha", fecha);
		
		return myQuery.getResultList();
	}

	
}
