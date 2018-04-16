package lt.vu.mif;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Named;
import java.io.Serializable;

@Named
@Getter
@Setter
public class HelloBean implements Serializable {

    public String test() {
        return "Test";
    }
}
