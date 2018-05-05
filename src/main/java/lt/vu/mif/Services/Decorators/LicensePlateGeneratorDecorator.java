package lt.vu.mif.Services.Decorators;

import lt.vu.mif.Services.CustomAnnotations.Estonian;
import lt.vu.mif.Services.CustomAnnotations.Lithuanian;
import lt.vu.mif.Services.LicensePlateGenerators.ILicensePlateGenerator;
import lt.vu.mif.Services.LicensePlateGenerators.LicensePlateGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class LicensePlateGeneratorDecorator extends LicensePlateGenerator {

    @Inject @Delegate @Estonian
    ILicensePlateGenerator generator;

    public char generateLetter() {
        return 'A';
    }
}