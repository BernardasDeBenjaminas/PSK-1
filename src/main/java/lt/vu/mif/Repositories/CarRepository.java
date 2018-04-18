package lt.vu.mif.Repositories;

import lt.vu.mif.Entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CarRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void add(Car car) {
        em.persist(car);
    }

    @Transactional
    public Car get(Integer id) {
        return em.find(Car.class, id);
    }

    @Transactional
    public List<Car> getAll() {
        return em.createNamedQuery("Cars.getAll", Car.class).getResultList();
    }

    @Transactional
    public void update(Car car) {
        em.merge(car);
    }

    @Transactional
    public void delete(Car car) {
        car = em.contains(car) ? car : em.merge(car);
        em.remove(car);
    }
}
