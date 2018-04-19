package lt.vu.mif.MyBatis.MyBatisControllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.MyBatis.Mappers.CarsMapper;
import lt.vu.mif.MyBatis.ViewModels.Cars;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class MyBatisCarsController {

    @Inject
    private CarsMapper carsMapper;

    @Getter @Setter
    private List<Cars> allCars = new ArrayList<>();
    @Getter @Setter
    private Cars car = new Cars();

    @PostConstruct
    private void init() {

        allCars = carsMapper.selectAll();
    }

    public String addCar() {
        carsMapper.insert(car);
        return "mybatis?faces-redirect=true";
    }
}
