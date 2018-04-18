package lt.vu.mif.MyBatis.MyBatisControllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.MyBatis.Mappers.ShopsMapper;
import lt.vu.mif.MyBatis.ViewModels.Shops;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class MyBatisShopsController {

    @Inject
    private ShopsMapper shopsMapper;

    @Getter @Setter
    private List<Shops> allShops = new ArrayList<>();
    @Getter @Setter
    private Shops shop = new Shops();

    @PostConstruct
    private void init() {
        allShops = shopsMapper.selectAll();
    }
}
