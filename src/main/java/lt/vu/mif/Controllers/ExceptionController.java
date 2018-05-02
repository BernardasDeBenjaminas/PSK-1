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
        car.setManufacturer("Hoo");
        car.setModel("Hoo");
        carRepository.update(car);
    }

    @Transactional()
    public void modifyCarButFaster() {
        Car car = carRepository.get(1);
        // CHANGE THESE VALUES TO NEW ONES IF YOU WANT THE EXCEPTION
        car.setManufacturer("Test");
        car.setModel("Test");
        carRepository.update(car);
    }
}
