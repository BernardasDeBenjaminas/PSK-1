package lt.vu.mif.Services.LicensePlateGenerators;

import org.apache.deltaspike.core.api.future.Futureable;
import javax.ejb.AsyncResult;
import java.util.Random;
import java.util.concurrent.Future;

public interface ILicensePlateGenerator {

    Random random = new Random();

    char generateLetter();
    int generateNumber();

    @Futureable
    Future<String> generateLicensePlateNumbers();
}
