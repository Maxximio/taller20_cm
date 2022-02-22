package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{

	private static final Logger LOG= LogManager.getLogger(CuentaBancariaRepoImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarCuentaBancaria(CuentaBancaria cuenta) {
		this.entityManager.persist(cuenta);
	}

	@Override
	public void ActualizarCuentaBancaria(CuentaBancaria cuenta) {
		this.entityManager.merge(cuenta);
	}

}
