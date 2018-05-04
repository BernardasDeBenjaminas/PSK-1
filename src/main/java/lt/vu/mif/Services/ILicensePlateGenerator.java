package lt.vu.mif.Services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.Future;

public abstract class ILicensePlateGenerator {

    protected Random random = new Random();

    protected char generateLetter() {
        return (char)(random.nextInt('z' - 'a') + 'a');
    }

    protected int generateNumber() {
        return random.nextInt(9);
    }

    @Futureable
    public Future<String> generateLicensePlateNumbers() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {

        }

        StringBuilder sb = new StringBuilder();
        // Three letters
        for (int i = 0; i < 3; i++) {
            sb.append(generateLetter());
        }
        // Three numbers
        for (int i = 0; i < 3; i++) {
            sb.append(generateNumber());
        }

        return new AsyncResult<>(sb.toString());
    }
}
