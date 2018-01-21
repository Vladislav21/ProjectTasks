package Algorithms;

import java.util.List;
import java.util.concurrent.Callable;

public class Divider implements Callable<Spectra> {

    Spectra spectra;
    Function function = new Function();
    List<String> listNameFunctions;

    public Divider(Spectra spectra, List<String> listNameFunctions) {
        this.listNameFunctions = listNameFunctions;
        this.spectra = spectra;
    }

    @Override
    public Spectra call() throws Exception {
        for (String name : listNameFunctions) {
            spectra = ((Algorithm) function.getFunction().get(name)).run(spectra);
        }
        return spectra;
    }
}
