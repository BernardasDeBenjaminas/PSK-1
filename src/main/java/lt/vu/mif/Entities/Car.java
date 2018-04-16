package lt.vu.mif.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "CARS")
@NamedQueries({
        @NamedQuery(name = "Cars.getAll",
                    query = "SELECT c FROM Car AS c")
})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private Integer driverId;
//    private List<Integer> shopIds;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "MODEL")
    private String model;

    public Car() {}
    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }
}