package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Bar;
import model.SportCenter;

@ApplicationScoped
public class BarRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Bar addBar(String name, long sportCenterId) {
        SportCenter sc = em.find(SportCenter.class, sportCenterId);
        if (sc == null) {
            throw new IllegalArgumentException("SportCenter with ID " + sportCenterId + " not found");
        }

        Bar bar = new Bar();
        bar.setName(name);
        bar.setSportCenter(sc);
        em.persist(bar);
        return bar;
    }

    public List<Bar> getAllBars() {
        return em.createQuery("SELECT b FROM Bar b", Bar.class).getResultList();
    }
}
