package lt.vu.mif.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private ObjectMapper mapper = new ObjectMapper();

    @GET
    public String getAll() throws JsonProcessingException {
        List<Car> cars = carRepository.getAll();
        return mapper.writeValueAsString(cars);
    }

    @GET
    @Path("/{id}")
    public String get(@PathParam("id") int id) throws JsonProcessingException {
        Car car = carRepository.get(id);
        return mapper.writeValueAsString(car);
    }

    @PUT
    @Path("/create")
    @Transactional
    public String create(@QueryParam("manufacturer") String manufacturer,
                      @QueryParam("model") String model) throws JsonProcessingException {
        Car car = new Car(manufacturer, model);
        carRepository.add(car);
        return mapper.writeValueAsString(car);
    }

    @POST
    @Path("/update/{id}")
    @Transactional
    public String update(@PathParam("id") Integer id,
                           @QueryParam("manufacturer") String manufacturer,
                           @QueryParam("model") String model) throws JsonProcessingException {
        Car car = carRepository.get(id);
        if (car != null) {
            car.setManufacturer(manufacturer);
            car.setModel(model);
            carRepository.update(car);
            return mapper.writeValueAsString(car);
        }
        return null;
    }
}
