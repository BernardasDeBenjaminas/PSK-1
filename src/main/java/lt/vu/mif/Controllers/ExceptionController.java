package lt.vu.mif.Controllers;

import lt.vu.mif.Entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Named
@ApplicationScoped
public class ExceptionController {

    @PersistenceUnit(name = "IndustryPU")
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;



    @Transactional()
    public void modifyCar() throws InterruptedException {
        Car car = em.find(Car.class, 1);
        Thread.sleep(5000);
        car.setModel("test2");
        em.merge(car);
    }

    @Transactional()
    public void modifyCarButFaster() {
        Car car = em.find(Car.class, 1);
        car.setModel("real2");
        em.merge(car);
    }






    @Transactional
    public void modifyCarSafe() throws InterruptedException {
        Car car = em.find(Car.class, 1);
        Thread.sleep(5000);
        car.setModel("test8");
        try {
            em.merge(car);
            em.flush();
        } catch (OptimisticLockException e) {
            persistSafely(car);
        }
    }

    @Transactional
    public void modifyCarButFasterAndSafer() {
        Car car = em.find(Car.class, 1);
        car.setModel("real8");
        em.merge(car);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void persistSafely(Car car) {
        EntityManager manager = emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
        Car originalCar = manager.find(Car.class, 1);
        car.setVersion(originalCar.getVersion());
        manager.merge(car);
        manager.flush();
    }
}
