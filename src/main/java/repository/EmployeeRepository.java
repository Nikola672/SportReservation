package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Employee;
import model.SportCenter;
@Dependent
public class EmployeeRepository {

	@Inject
	private EntityManager em;

	@Transactional
	public Employee createSC(Employee e) {

		return em.merge(e);
	}
}

