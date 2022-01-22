package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Chofer;
import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class ChoferRepoImpl implements IChoferRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarChofer(Chofer cho) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cho);
	}

	@Override
	public Chofer buscarChofer(Integer matricula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Chofer.class, matricula);
	}

	@Override
	public void ActualizarChofer(Chofer cho) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cho);
	}

	@Override
	public void borrarChofer(Integer matricula) {
		Chofer choBorrar =this.buscarChofer(matricula);
		this.entityManager.remove(choBorrar);
	}

	@Override
	public Chofer buscarChoferNombre(String nombre) {
		Query miQuery= this.entityManager.createQuery("select g from Chofer g where g.nombre=:valor");
		miQuery.setParameter("valor", nombre);
		
		Chofer miChofer=(Chofer) miQuery.getSingleResult();
		
		return miChofer;
	}
	
}
