package lt.vu.mif.Controllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.Entities.Car;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@Setter
@Getter
@RequestScoped
public class CarController {

    @PersistenceContext(unitName = "IndustryPU")
    private EntityManager em;

    private List<Car> allCars;
    private Car car;

    @PostConstruct
    public void init() {
        allCars = em.createNamedQuery("Cars.getAll", Car.class).getResultList();
        car = new Car();
    }

    @Transactional
    public void saveChanges() {
        em.persist(car);
        allCars.add(car);
        car = new Car();
    }
}
