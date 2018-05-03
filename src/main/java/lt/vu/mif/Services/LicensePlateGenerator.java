package lt.vu.mif.Services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class LicensePlateGenerator {

    private Random random = new Random();

    @Futureable
    public Future<String> generateLicensePlateNumber() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {

        }
        char letter1 = (char)(random.nextInt('z' - 'a') + 'a');
        char letter2 = (char)(random.nextInt('z' - 'a') + 'a');
        char letter3 = (char)(random.nextInt('z' - 'a') + 'a');
        int number1 = random.nextInt(9);
        int number2 = random.nextInt(9);
        int number3 = random.nextInt(9);
        StringBuilder sb = new StringBuilder();
        sb.append(letter1).append(letter2).append(letter3).append(number1).append(number2).append(number3);
        return new AsyncResult<>(sb.toString());
    }
}
