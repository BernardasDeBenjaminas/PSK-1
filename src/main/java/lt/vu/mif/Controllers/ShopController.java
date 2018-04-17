package lt.vu.mif.Controllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.Entities.Car;
import lt.vu.mif.Entities.Shop;
import lt.vu.mif.Repositories.CarRepository;
import lt.vu.mif.Repositories.ShopRepository;

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
public class ShopController implements Serializable {

    @Inject
    private ShopRepository shopRepository;

    @Inject
    private CarRepository carRepository;

    private Car car = new Car();
    private Shop shop = new Shop();
    private List<Shop> allShops = new ArrayList<>();


    @PostConstruct
    private void init() {
        allShops = shopRepository.getAll();
    }

    public String addShop() {
        shopRepository.add(shop);
        return "index";
    }

    public String addCarToShop() {
        car = carRepository.get(car.getId());
        shop = shopRepository.get(shop.getId());

        shop.getCars().add(car);
        shopRepository.update(shop);

        return "index";
    }
}
