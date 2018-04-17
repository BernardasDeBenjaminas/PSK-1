package lt.vu.mif.Controllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.Entities.Driver;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Setter
@Getter
@RequestScoped
public class DriverController {

    @PersistenceContext(unitName = "IndustryPU")
    private EntityManager em;

    private List<Driver> allDrivers;
    private Driver driver;

    @PostConstruct
    private void init() {
        driver = new Driver();
        allDrivers = em.createNamedQuery("Drivers.getAll", Driver.class).getResultList();
    }

    @Transactional
    public void saveChanges() {
        em.persist(driver);
        allDrivers.add(driver);
        driver = new Driver();
    }
}