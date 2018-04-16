package lt.vu.mif.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "DRIVERS")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private List<Integer> carIds;

    @Column(name = "NAME")    private String name;
    @Column(name = "SURNAME") private String surname;

    public Driver() {}
    public Driver(String name, String surname) {
        //        this.carIds = carIds;
        this.name = name;
        this.surname = surname;
    }
}
