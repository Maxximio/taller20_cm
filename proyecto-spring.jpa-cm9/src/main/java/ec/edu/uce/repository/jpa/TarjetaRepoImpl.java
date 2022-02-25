package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.TarjetaCredito;

@Repository
@Transactional
public class TarjetaRepoImpl implements ITarjetaRepo{

	private static final Logger LOG= LogManager.getLogger(TarjetaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarTarjeta(TarjetaCredito tarjeta) {
		this.entityManager.persist(tarjeta);
	}

	@Override
	public void ActualizarTarjeta(TarjetaCredito tarjeta) {
		this.entityManager.merge(tarjeta);
		try {
			throw new RuntimeException();
			}catch(ArrayIndexOutOfBoundsException e) {
				LOG.error("Error en Repo");
			}
	}

	@Override
	public TarjetaCredito BuscarNumero(String numero) {
		TypedQuery<TarjetaCredito> myTypedQuery =(TypedQuery<TarjetaCredito>) 
				this.entityManager.
				createQuery("select t from TarjetaCredito t where t.numero=:valor");
		myTypedQuery.setParameter("valor", numero);
		return myTypedQuery.getSingleResult();
	}

}
