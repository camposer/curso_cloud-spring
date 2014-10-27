package cloudspring.personarest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cloudspring.personarest.model.Persona;

@Component
@Scope("singleton")
public class PersonaDaoImpl implements PersonaDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void agregar(Persona p) {
		entityManager.persist(p);
	}

	@Override
	public void modificar(Persona p) {
		entityManager.merge(p);
	}

	@Override
	public void eliminar(Integer id) {
		Query q = entityManager.createQuery("DELETE FROM Persona p "
				+ "WHERE p.id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@Override
	public Persona obtener(Integer id) {
		return entityManager.find(Persona.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> obtenerTodos() {
		return entityManager.createQuery("SELECT p FROM Persona p").getResultList();
	}

}
