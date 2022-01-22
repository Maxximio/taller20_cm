package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Abogado;
import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class AbogadoRepoImpl implements IAbogadoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarAbogado(Abogado abo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(abo);
	}

	@Override
	public Abogado buscarAbogado(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Abogado.class, id);
	}

	@Override
	public void ActualizarAbogado(Abogado abo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(abo);
	}

	@Override
	public void borrarAbogado(Integer id) {
		Abogado BorrarAbo=this.buscarAbogado(id);
		this.entityManager.remove(BorrarAbo);
	}

	@Override
	public Abogado buscarAbogadoFirma(String firma) {
		Query miQuery= this.entityManager.createQuery("select g from Abogado g where g.firma=:valor");
		miQuery.setParameter("valor", firma);
		
		Abogado miAbo=(Abogado) miQuery.getSingleResult();
		
		return miAbo;
	}
	
}
