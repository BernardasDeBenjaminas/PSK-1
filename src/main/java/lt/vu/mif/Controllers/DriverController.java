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
import java.util.List;

@Named
@Getter
@Setter
@ViewScoped
public class DriverController implements Serializable {

    @Inject
    private DriverRepository driverRepository;
    @Inject
    private CarRepository carRepository;

    private Car car = new Car();
    private Driver driver = new Driver();
    private List<Driver> allDrivers;


    @PostConstruct
    private void init() {
        allDrivers = driverRepository.getAll();
    }

    public String addDriver() {
        driverRepository.add(driver);
        return "index";
    }

    public String attachCarToDriver() {
        driver = driverRepository.get(driver.getId());
        car = carRepository.get(car.getId());

        car.setDriver(driver);
        carRepository.update(car);

        return "index";
    }
}
