package lt.vu.mif.Controllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.Entities.Car;
import lt.vu.mif.Entities.Shop;
import lt.vu.mif.Repositories.CarRepository;
import lt.vu.mif.Repositories.ShopRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class ShopController {

    @Inject private ShopRepository shopRepository;
    @Inject private CarRepository carRepository;

    @Getter @Setter Car car = new Car();
    @Getter @Setter private Shop shop = new Shop();
    @Getter @Setter private List<Shop> allShops = new ArrayList<>();


    @PostConstruct
    private void init() {
        allShops = shopRepository.getAll();
    }

    public String addShop() {
        shopRepository.add(shop);
        return "index?faces-redirect=true";
    }

    public String addCarToShop() {
        car = carRepository.get(car.getId());
        shop = shopRepository.get(shop.getId());

        shop.getCars().add(car);
        shopRepository.update(shop);

        return "index?faces-redirect=true";
    }
}
