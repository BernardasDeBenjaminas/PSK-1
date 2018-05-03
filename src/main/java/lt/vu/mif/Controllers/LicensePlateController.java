package lt.vu.mif.Controllers;

import lt.vu.mif.Services.LicensePlateGenerator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named
@SessionScoped
public class LicensePlateController implements Serializable {

    @Inject
    private LicensePlateGenerator licensePlateGenerator;

    @Getter
    private String licensePlate = "";

    private Future<String> licensePlateAsync = null;

    public String generateLicensePlateNumbers() throws ExecutionException, InterruptedException {
        if (licensePlateAsync == null) {
            licensePlate = "Calling the generator.";
            licensePlateAsync = licensePlateGenerator.generateLicensePlateNumber();
            return "index?faces-redirect=true";
        } else {
            if (licensePlateAsync.isDone()) {
                String result = licensePlateAsync.get();
                licensePlateAsync = null;
                licensePlate = "The generated license plate number: " + result;
                return "index?faces-redirect=true";
            } else {
                licensePlate = "Still waiting to finish generating.";
                return "index?faces-redirect=true";
            }
        }
    }
}
