package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Turista;

@Repository
@Transactional
public class TuristaRepoImpl implements ITuristaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarTurista(Turista tur) {
		this.entityManager.persist(tur);
	}

	@Override
	public List<Turista> GenerarTuristaCriteria() {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Turista> myQuery=myCriteria.createQuery(Turista.class);
		
		Root<Turista>myTabla=myQuery.from(Turista.class);

		myQuery.select(myTabla);
		TypedQuery<Turista> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getResultList();
	}

}
