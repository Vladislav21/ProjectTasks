package Algorithms;

public class IncrementSpectraOnOne implements Algorithm {
    @Override
    public Spectra run(Spectra spectra) {
        Spectra resultSpectra = new Spectra();
        int x;
        int y;
        for (Point point:spectra.getPoints()){
            x = point.getX();
            y = point.getY();
            resultSpectra.getPoints().add(new Point(x+1,y+1));
        }
        return resultSpectra;
    }
}
