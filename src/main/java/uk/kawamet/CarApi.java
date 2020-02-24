package uk.kawamet;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarApi {

    @Inject
    EntityManager entityManager;

    List<Car> carList;

    public CarApi() {
        this.carList = new ArrayList<>();
        carList.add(new Car("Fiat", "126p"));
    }

    @GET
    public List<Car> getCarList() {
        return carList;
    }

    @POST
    @Transactional
    public void addCar(Car car){
        carList.add(car);
        entityManager.persist(car);
    }
}