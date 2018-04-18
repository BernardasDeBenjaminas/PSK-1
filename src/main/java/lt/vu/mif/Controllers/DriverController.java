package lt.vu.mif.Controllers;

import lt.vu.mif.Entities.Car;
import lt.vu.mif.Entities.Driver;
import lt.vu.mif.Repositories.CarRepository;
import lt.vu.mif.Repositories.DriverRepository;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class DriverController {

    @Inject private DriverRepository driverRepository;
    @Inject private CarRepository carRepository;

    @Getter @Setter Car car = new Car();
    @Getter @Setter private Driver driver = new Driver();
    @Getter @Setter private List<Driver> allDrivers;


    @PostConstruct
    private void init() {
        allDrivers = driverRepository.getAll();
    }

    public String addDriver() {
        driverRepository.add(driver);
        return "index?faces-redirect=true";
    }

    public String attachCarToDriver() {
        driver = driverRepository.get(driver.getId());
        car = carRepository.get(car.getId());

        car.setDriver(driver);
        carRepository.update(car);

        return "index?faces-redirect=true";
    }
}
