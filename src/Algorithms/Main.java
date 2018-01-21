package Algorithms;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Computing computing = new Computing();

        List<Point> sp1 = Arrays.asList(new Point(1,2),new Point(2,4));
        List<Point> sp2 = Arrays.asList(new Point(4,2),new Point(5,4));
        List<Point> sp3 = Arrays.asList(new Point(2,2),new Point(6,4));
        List<Point> sp4 = Arrays.asList(new Point(1,1),new Point(1,4));

        List<Spectra> spectraList = Arrays.asList(new Spectra(sp1),new Spectra(sp2),new Spectra(sp3),new Spectra(sp4));

        List<String> nameFunction = Arrays.asList("FunctionOne","FunctionTwo");
        List<Spectra> spectraListResult = computing.compute(spectraList,nameFunction);

        System.out.println("Primary list of spectra:\n"+spectraList);
        System.out.println("Result list os spectra:\n"+spectraListResult);

    }
}
