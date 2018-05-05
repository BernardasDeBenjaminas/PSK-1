package lt.vu.mif.Services.LicensePlateGenerators;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import java.util.concurrent.Future;

public abstract class LicensePlateGenerator implements ILicensePlateGenerator {

    public char generateLetter() {
        return (char)(random.nextInt('z' - 'a') + 'a');
    }

    public int generateNumber() {
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
