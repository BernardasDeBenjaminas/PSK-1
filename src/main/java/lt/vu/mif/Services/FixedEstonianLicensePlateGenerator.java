package lt.vu.mif.Services;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.concurrent.Future;

@Specializes
@ApplicationScoped
public class FixedEstonianLicensePlateGenerator extends EstonianLicensePlateGenerator {

    public Future<String> generateLicensePlateNumbers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[EU]");
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
