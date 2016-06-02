package uk.co.codeecho.fret.theory.core;

import java.util.ArrayList;
import java.util.List;

public class Interval {

    public static final Interval ROOT = new Interval(1);
    public static final Interval MINOR_THIRD = new Interval(3, -1);
    public static final Interval MAJOR_THIRD = new Interval(3);
    public static final Interval DIMINISHED_FIFTH = new Interval(5, -1);
    public static final Interval PERFECT_FIFTH = new Interval(5);
    public static final Interval MINOR_SEVENTH = new Interval(7, 1);
    public static final Interval MAJOR_SEVENTH = new Interval(7);
    
    private static final int[] MAJOR_SCALE_INTERVALS = new int[]{0, 2, 4, 5, 7, 9, 11};
    
    private final int major;
    private final int modifier;

    public Interval(int major) {
        this(major, 0);
    }
    
    public Interval(int major, int modifier) {
        this.major = major;
        this.modifier = modifier;
    }
    
    public int getIndex(){
        return MAJOR_SCALE_INTERVALS[major-1] + modifier;
    }
    
    public static List<Interval> convert(int... intervals){
        List<Interval> intervalList = new ArrayList<>();
        for(int interval: intervals){
            intervalList.add(new Interval(interval));
        }
        return intervalList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.major;
        hash = 23 * hash + this.modifier;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interval other = (Interval) obj;
        if (this.major != other.major) {
            return false;
        }
        if (this.modifier != other.modifier) {
            return false;
        }
        return true;
    }
    
}
