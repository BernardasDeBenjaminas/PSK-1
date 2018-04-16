package lt.vu.mif.Models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthorViewModel implements Serializable {

    private String name;

    public AuthorViewModel() {}

    public AuthorViewModel(String name) {
        this.name = name;
    }
}
