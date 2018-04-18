package lt.vu.mif.Repositories;

import lt.vu.mif.Entities.Driver;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DriverRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void add(Driver driver) {
        em.persist(driver);
    }

    @Transactional
    public Driver get(Integer id) {
        return em.find(Driver.class, id);
    }

    @Transactional
    public List<Driver> getAll() {
        return em.createNamedQuery("Drivers.getAll", Driver.class).getResultList();
    }

    @Transactional
    public void update(Driver driver) {
        em.merge(driver);
    }

    @Transactional
    public void delete(Driver driver) {
        driver = em.contains(driver) ? driver : em.merge(driver);
        em.remove(driver);
    }
}
