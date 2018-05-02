package lt.vu.mif.Controllers;

import lt.vu.mif.Entities.Car;
import lt.vu.mif.Repositories.CarRepository;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class ExceptionController {

    @Inject
    private CarRepository carRepository;

    @Transactional()
    public void modifyCar() throws InterruptedException {
        Car car = carRepository.get(1);
        Thread.sleep(5000);
        // CHANGE THESE VALUES TO NEW ONES IF YOU WANT THE EXCEPTION
        // 1. Kas nutinka su einamąja transakcija gavus klaidą?
        //      - the transaction is marked for rollback;
        // 2. Kas nutinka su einamuoju EntityManager, kai gauna klaida?
        //      - managed instances become detached.
        car.setModel("aqw");
        carRepository.update(car); // Optimistic locking is used implicitly for writting
    }

    @Transactional()
    public void modifyCarButFaster() {
        Car car = carRepository.get(1);
        // CHANGE THESE VALUES TO NEW ONES IF YOU WANT THE EXCEPTION
        car.setModel("dsa");
        carRepository.update(car);
    }


    public void modifyCarSafe() throws InterruptedException {
        Car car = carRepository.get(1);
        Thread.sleep(5000);
        try {
            car.setModel("Menuliukas3");
            carRepository.update(car);
        } catch (Exception e) {
            // Kitas būdas su session
            car = carRepository.get(1);
            car.setModel("Menuliukas3");
            carRepository.update(car);
        }
    }

    public void modifyCarButFasterAndSafer() {
        Car car = carRepository.get(1);
        car.setModel("Debeselis3");
        carRepository.update(car);
    }
}
