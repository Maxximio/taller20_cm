package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;

@Repository
@Transactional
public class MeseroRepoImpl implements IMeseroRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarMesero(Mesero mes) {
		// TODO Auto-generated method stub
		this.entityManager.persist(mes);
	}

	@Override
	public Mesero buscarMesero(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Mesero.class, id);
	}

	@Override
	public void ActualizarMesero(Mesero mes) {
		// TODO Auto-generated method stub
		this.entityManager.merge(mes);
	}

	@Override
	public void borrarMesero(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public Mesero buscarMeseroRestaurante(String restaurante) {
		Query miQuery= this.entityManager.createQuery("select g from Mesero g where g.restaurante=:valor");
		miQuery.setParameter("valor", restaurante);
		
		Mesero miMesero=(Mesero) miQuery.getSingleResult();
		
		return miMesero;
	}

	
}
