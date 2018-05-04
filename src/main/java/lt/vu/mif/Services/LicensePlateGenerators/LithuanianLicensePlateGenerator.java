package lt.vu.mif.Services.LicensePlateGenerators;

import lt.vu.mif.Services.CustomAnnotations.Lithuanian;
import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.Future;

@Lithuanian
@ApplicationScoped
public class LithuanianLicensePlateGenerator extends ILicensePlateGenerator {

    public Future<String> generateLicensePlateNumbers() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {

        }

        StringBuilder sb = new StringBuilder();
        // Three letters
        for (int i = 0; i < 3; i++) {
            sb.append(Character.toUpperCase(generateLetter()));
        }
        sb.append(" ");
        // Three numbers
        for (int i = 0; i < 3; i++) {
            sb.append(generateNumber());
        }

        return new AsyncResult<>(sb.toString());
    }
}
