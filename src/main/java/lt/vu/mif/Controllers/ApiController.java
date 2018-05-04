package lt.vu.mif.Controllers;

import lt.vu.mif.Entities.Car;
import lt.vu.mif.Repositories.CarRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/car")
@ApplicationScoped
public class ApiController {

    @Inject
    private CarRepository carRepository;

    @GET
    public List<Car> getAll() {
        return carRepository.getAll();
    }

    @GET
    @Path("/{id}")
    public Car get(@PathParam("id") int id) {
        return carRepository.get(id);
    }

    @PUT
    @Path("/create")
    @Transactional
    public Car create(@QueryParam("manufacturer") String manufacturer,
                      @QueryParam("model") String model) {
        Car car = new Car(manufacturer, model);
        carRepository.add(car);
        return car;
    }

    @POST
    @Path("/update/{id}")
    @Transactional
    public Car update(@PathParam("id") Integer id,
                           @QueryParam("manufacturer") String manufacturer,
                           @QueryParam("model") String model) {
        Car car = carRepository.get(id);
        if (car != null) {
            car.setManufacturer(manufacturer);
            car.setModel(model);
            carRepository.update(car);
            return car;
        }
        return null;
    }
}
