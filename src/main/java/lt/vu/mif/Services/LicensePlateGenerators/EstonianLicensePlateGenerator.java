package lt.vu.mif.Services.LicensePlateGenerators;

import lt.vu.mif.Services.CustomAnnotations.Estonian;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.Future;

@Estonian
@ApplicationScoped
public class EstonianLicensePlateGenerator extends LicensePlateGenerator {

    @Override
    @Futureable
    public Future<String> generateLicensePlateNumbers() {
        try { Thread.sleep(4000); } catch (Exception e) {}

        StringBuilder sb = new StringBuilder();
        // Three numbers
        for (int i = 0; i < 3; i++) {
            sb.append(generateNumber());
        }
        // Space between numbers and letters
        sb.append(" ");
        // Three uppercased letters
        for (int i = 0; i < 3; i++) {
            char letter = generateLetter();
            sb.append(Character.toUpperCase(letter));
        }

        return new AsyncResult<>(sb.toString());
    }
}
