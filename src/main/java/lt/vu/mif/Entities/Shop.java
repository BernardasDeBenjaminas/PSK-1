package lt.vu.mif.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "SHOPS")
@NamedQueries({
    @NamedQuery(name = "Shops.getAll", query = "SELECT s FROM Shop AS s")
})
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Car> cars;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    public Shop() {}
    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return this.name + " " + this.address;
    }
}
