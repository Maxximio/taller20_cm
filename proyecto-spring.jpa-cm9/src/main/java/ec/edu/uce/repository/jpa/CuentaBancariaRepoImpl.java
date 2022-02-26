package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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
	public void ActualizarCuentaBancaria(CuentaBancaria cuenta){
		this.entityManager.merge(cuenta);
		throw new ArrayIndexOutOfBoundsException();
	}

	@Override
	public CuentaBancaria BuscarPorNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery("select * from cuenta_bancaria c where c.cuba_numero=:valor",CuentaBancaria.class);
		miQuery.setParameter("valor", numero);
		return (CuentaBancaria) miQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ActualizarCuentaBancaria2(CuentaBancaria cuenta) {
		this.entityManager.merge(cuenta);
		
		//try {
			//throw new ArrayIndexOutOfBoundsException();
		//}catch(ArrayIndexOutOfBoundsException e) {
			//LOG.error("Error");
		//}
		
	}

}
