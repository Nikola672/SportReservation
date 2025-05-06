package services;

import java.util.List;
import model.Bar;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;

@ApplicationScoped
public class bar_service {

	@Inject
	EntityManager em;



	@Transactional
	public List<Bar> getAllBars() {
		return em.createQuery("SELECT b FROM Bar b", Bar.class).getResultList();
	}

}
