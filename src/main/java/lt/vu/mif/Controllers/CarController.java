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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Getter
@Setter
@ViewScoped
public class CarController implements Serializable {

    @Inject
    private CarRepository carRepository;
    @Inject
    private DriverRepository driverRepository;

    private Driver driver = new Driver();
    private Car car = new Car();
    private List<Car> allCars;
    private List<Car> carsInRepair = new ArrayList<>();
    private List<Car> carsNotInRepair = new ArrayList<>();
    private List<Car> carsWithDrivers = new ArrayList<>();
    private List<Car> carsWithoutDrivers = new ArrayList<>();


    @PostConstruct
    private void init() {
        allCars = carRepository.getAll();

        for (Car item : allCars) {
            // With/without drivers
            if (item.getDriver() == null) {
                carsWithoutDrivers.add(item);
            } else {
                carsWithDrivers.add(item);
            }

            // [Not] in repair
            if (item.getShops().isEmpty()) {
                carsNotInRepair.add(item);
            } else {
                carsInRepair.add(item);
            }
        }
    }

    public String addCar() {
        driver = driver.getId() == null ? null : driverRepository.get(driver.getId());
        car.setDriver(driver);
        carRepository.add(car);
        return "index";
    }
}
