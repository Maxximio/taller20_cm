package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo{

	private static final Logger LOG= LogManager.getLogger(GuardiaRepoImpl.class);
	
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarGuardia(Guardia guardia) {
		this.entityManager.persist(guardia);
	}

	@Override
	public Guardia buscarGuardia(Integer id) {		
		return this.entityManager.find(Guardia.class, id);
	}

	@Override
	public void ActualizarGuardia(Guardia guardia) {
		this.entityManager.merge(guardia);
	}

	@Override
	public void borrarGuardia(Integer id) {
		Guardia guardiaBorrar=this.buscarGuardia(id);
		this.entityManager.remove(guardiaBorrar);
	}

	@Override
	public Guardia buscarGuardiaApellido(String apellido) {
		//SQL NORMAL: select *from guardia where apellido= 'blablabla'
		//JPQL: select g from Guardia g where g.apellido= :valor
		Guardia g=null;
		try {
		Query miQuery= this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		
		 g=(Guardia) miQuery.getSingleResult();
	}catch(NoResultException e) {
		LOG.error("No existe un resultado para: "+apellido,e);
	}	
		return g;
	}
	
	@Override
	public Guardia buscarGuardiaApellidoLista(String apellido) {
		Query miQuery= this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		
		 List<Guardia> g= miQuery.getResultList();
		 
		 if(g.isEmpty()) {
			 LOG.info("Tiene mas de un regidtro"+g.size());
			 return g.get(0);
		 }
		return null;
	}
	
	@Override
	public Guardia buscarGuardiaApellidoIype(String apellido) {
		TypedQuery<Guardia> myTypedQuery =(TypedQuery<Guardia>) this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		myTypedQuery.setParameter("valor", apellido);
		return myTypedQuery.getSingleResult();
	}

	
	/**
	 *Igual que buscar por apellido pero con Named Query
	 */
	@Override
	public Guardia buscarGuardiaApellidoNamed(String apellido) {
		Query miQuery=this.entityManager.createNamedQuery("Guardia.buscarPorApellido");
		miQuery.setParameter("valor", apellido);
		return (Guardia)miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaApellidoNative(String apellido) {
		Query miQuery= this.entityManager.createNativeQuery("select * from guardia g where g.apellido=:valor",Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaApellidoNamedNative(String apellido) {
		Query miQuery=this.entityManager.createNamedQuery("Guardia.buscarPorApellidoNative",Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia)miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaApellidoCriteria(String apellido) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Guardia> myQuery=myCriteria.createQuery(Guardia.class);
		
		//Aqui empiezo a construir mi SQL
		Root<Guardia>myTabla=myQuery.from(Guardia.class);
		
		//where
		Predicate p1=myCriteria.equal(myTabla.get("apellido"),apellido);
		
		//conformacion del select, se pueden crear mas predicados
		myQuery.select(myTabla).where(p1);
		
		
		TypedQuery<Guardia> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaApellidoCriteriaAnd(String apellido, String nombre) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Guardia> myQuery=myCriteria.createQuery(Guardia.class);
		
		//Aqui empiezo a construir mi SQL
		Root<Guardia>myTabla=myQuery.from(Guardia.class);
		
		//where
		Predicate p1=myCriteria.equal(myTabla.get("apellido"),apellido);
		Predicate p2=myCriteria.equal(myTabla.get("nombre"),nombre);
		Predicate and=myCriteria.and(p1,p2);
		
		//conformacion del select, se pueden crear mas predicados
		myQuery.select(myTabla).where(and);
		
		
		TypedQuery<Guardia> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getSingleResult();
	}

	@Override
	public List <Guardia> buscarGuardiaApellidoCriteriaOr(String apellido, String nombre) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Guardia> myQuery=myCriteria.createQuery(Guardia.class);
		
		//Aqui empiezo a construir mi SQL
		Root<Guardia>myTabla=myQuery.from(Guardia.class);
		
		//where
		Predicate p1=myCriteria.equal(myTabla.get("apellido"),apellido);
		Predicate p2=myCriteria.equal(myTabla.get("nombre"),nombre);
		Predicate or=myCriteria.or(p1,p2);
		
		//conformacion del select, se pueden crear mas predicados
		myQuery.select(myTabla).where(or);
		
		
		TypedQuery<Guardia> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getResultList();
	}

	

	
}
