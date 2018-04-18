package lt.vu.mif.Controllers;

import lt.vu.mif.Entities.Car;
import lt.vu.mif.Entities.Driver;
import lt.vu.mif.Repositories.CarRepository;
import lt.vu.mif.Repositories.DriverRepository;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class CarController {

    @Inject private CarRepository carRepository;
    @Inject private DriverRepository driverRepository;

    @Getter @Setter Driver driver = new Driver();
    @Getter @Setter private Car car = new Car();
    @Getter @Setter private List<Car> allCars;
    @Getter @Setter private List<Car> carsInRepair = new ArrayList<>();
    @Getter @Setter private List<Car> carsNotInRepair = new ArrayList<>();
    @Getter @Setter private List<Car> carsWithDrivers = new ArrayList<>();
    @Getter @Setter private List<Car> carsWithoutDrivers = new ArrayList<>();


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
        return "index?faces-redirect=true";
    }
}
