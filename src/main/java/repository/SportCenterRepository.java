package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.SportCenter;
@Dependent
public class SportCenterRepository {

	@Inject
	private EntityManager em;

	@Transactional
	public SportCenter createSC(SportCenter s) {

		return em.merge(s);
	}
}
