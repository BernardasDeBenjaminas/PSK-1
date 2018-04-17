package lt.vu.mif.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "DRIVERS")
@NamedQueries({
    @NamedQuery(name = "Drivers.getAll", query = "SELECT d FROM Driver AS d")
})
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private List<Integer> carIds;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    public Driver() {}
    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return this.name + " " + this.surname;
    }
}
