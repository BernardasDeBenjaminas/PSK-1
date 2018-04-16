package lt.vu.mif.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "SHOPS")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private List<Integer> carIds;

    @Column(name = "NAME")      private String name;
    @Column(name = "ADDRESS")   private String address;

    public Shop() {}
    public Shop(String name, String address) {
//        this.carIds = carIds;
        this.name = name;
        this.address = address;
    }
}
