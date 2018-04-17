package lt.vu.mif.Controllers;


import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.Entities.Car;
import lt.vu.mif.Entities.Driver;
import lt.vu.mif.Repositories.CarRepository;
import lt.vu.mif.Repositories.DriverRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Getter
@Setter
@ViewScoped
public class CarAndDriverController implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private CarRepository carRepository;
    @Inject
    private DriverRepository driverRepository;

    private Car car = new Car();
    private List<Car> allCars;
    private List<Car> carsWithDrivers = new ArrayList<>();
    private List<Car> carsWithoutDrivers = new ArrayList<>();

    private Driver driver = new Driver();
    private List<Driver> allDrivers = new ArrayList<>();


    @PostConstruct
    public void init() {
        allDrivers = driverRepository.getAll();
        allCars = carRepository.getAll();

        for (Car car : allCars) {
            if (car.getDriver() == null) {
                carsWithoutDrivers.add(car);
            } else {
                carsWithDrivers.add(car);
            }
        }
    }

    public void addCar() {
        if (driver.getId() != null) {
            driver = driverRepository.get(driver.getId());
        } else {
            driver = null;
        }
        car.setDriver(driver);
        carRepository.add(car);
        carsWithDrivers.add(car);

        driver = new Driver();
        car = new Car();
    }

    public void addDriver() {
        driverRepository.add(driver);
        allDrivers.add(driver);

        driver = new Driver();
    }

    public void attachCarToDriver() {
        driver = driverRepository.get(driver.getId());
        car = carRepository.get(car.getId());

        car.setDriver(driver);
        carRepository.update(car);

        driver = new Driver();
        car = new Car();
    }
}
