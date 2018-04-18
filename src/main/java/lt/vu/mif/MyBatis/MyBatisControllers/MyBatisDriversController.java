package lt.vu.mif.MyBatis.MyBatisControllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.MyBatis.Mappers.DriversMapper;
import lt.vu.mif.MyBatis.ViewModels.Drivers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class MyBatisDriversController {

    @Inject
    private DriversMapper driversMapper;

    @Getter @Setter
    private List<Drivers> allDrivers = new ArrayList<>();
    @Getter @Setter
    private Drivers driver = new Drivers();

    @PostConstruct
    private void init() {
        allDrivers = driversMapper.selectAll();
    }
}
