package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Spectra {
    List<Point> points;

    public Spectra() {
        points = new ArrayList<>();
    }

    public Spectra(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Spectra{" +
                "points=" + points +
                '}';
    }
}
