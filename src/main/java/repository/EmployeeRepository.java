package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Bar;
import model.Employee;
import model.SportCenter;
@Dependent
public class EmployeeRepository {

	@Inject
	private EntityManager em;

	
	@Transactional
	public Employee addEmployee(String name, long barId) {
		Bar br = em.find(Bar.class, barId);
        if (br == null) {
            throw new IllegalArgumentException("Bar with ID " + barId + " not found");
        }

        Employee e = new Employee();
        e.setName(name);
        e.setBar(br);
        em.persist(e);
        return e;
	}
}

