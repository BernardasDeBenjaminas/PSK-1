package lt.vu.mif.Controllers;

import lombok.Getter;
import lt.vu.mif.Models.AuthorViewModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Getter
public class AuthorController {

    private AuthorViewModel author;

    @PostConstruct
    public void init() {
        author = new AuthorViewModel("Benas");
    }
}
