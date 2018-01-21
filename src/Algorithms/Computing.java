package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Computing {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<Spectra> compute(List<Spectra> spectraList, List<String> nameFunction) {
        List<Spectra> resultList = new ArrayList<>();
        List<Divider> dividerList = new ArrayList<>();
        List<Future<Spectra>> futureList;
        for (Spectra spectra : spectraList) {
            dividerList.add(new Divider(spectra,nameFunction));
        }
        try {
            futureList = executorService.invokeAll(dividerList);
            for (Future<Spectra> future : futureList) {
                if (future.isDone()) {
                    resultList.add(future.get());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return resultList;
    }
}
