package Algorithms;

public class IncrementSpectraOnTwo implements Algorithm {
    @Override
    public Spectra run(Spectra spectra) {
        Spectra resultSpectra = new Spectra();
        int x;
        int y;
        for (Point point:spectra.getPoints()){
            x = point.getX();
            y = point.getY();
            resultSpectra.getPoints().add(new Point(x+2,y+2));
        }
        return resultSpectra;
    }
}
