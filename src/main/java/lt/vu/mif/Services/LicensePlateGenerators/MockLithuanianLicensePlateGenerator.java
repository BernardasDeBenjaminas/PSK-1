package lt.vu.mif.Services.LicensePlateGenerators;

import lt.vu.mif.Services.CustomAnnotations.Lithuanian;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.Future;

@Lithuanian
@Alternative
@ApplicationScoped
public class MockLithuanianLicensePlateGenerator extends ILicensePlateGenerator {

    public Future<String> generateLicensePlateNumbers() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {

        }

        return new AsyncResult<>("MOCK");
    }
}
