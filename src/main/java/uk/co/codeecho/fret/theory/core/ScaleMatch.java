package uk.co.codeecho.fret.theory.core;

public class ScaleMatch implements Comparable<ScaleMatch>{

    private final Scale scale;
    private final double rating;

    public ScaleMatch(Scale scale, double rating) {
        this.scale = scale;
        this.rating = rating;
    }

    public Scale getScale() {
        return scale;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(ScaleMatch other) {
        return 0 - new Double(rating).compareTo(other.getRating());
    }

    @Override
    public String toString() {
        return scale.toString() + " [" + rating + "%]";
    }
    
}
