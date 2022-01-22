package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Arquitecto;

@Repository
@Transactional
public class ArquitectoRepoImpl implements IArquitectoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarArquitecto(Arquitecto arqui) {
		this.entityManager.persist(arqui);
	}

	@Override
	public Arquitecto buscarArquitecto(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Arquitecto.class, id);
	}

	@Override
	public void ActualizarArquitecto(Arquitecto arqui) {
		this.entityManager.merge(arqui);
	}

	@Override
	public void borrarArquitecto(Integer id) {
		Arquitecto arquiBorrar=this.buscarArquitecto(id);
		this.entityManager.remove(arquiBorrar);
	}

	@Override
	public Arquitecto buscarArquitectoApellido(String apellido) {
		Query miQuery= this.entityManager.createQuery("select g from Arquitecto g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		
		Arquitecto miArquitecto=(Arquitecto) miQuery.getSingleResult();
		
		return miArquitecto;
	}
}
