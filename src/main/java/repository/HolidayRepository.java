package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.client.HolidayClient;



@Dependent
public class HolidayRepository {

	@Inject
    EntityManager em;

	@Transactional
	public void saveHoliday(HolidayClient holiday) {
        if (holiday.getId() == null) {
            em.persist(holiday);
        } else {
            em.merge(holiday);
        }
    }
 
	
}