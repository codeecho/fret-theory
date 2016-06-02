package uk.co.codeecho.fret.theory.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChordType {

    public static final ChordType MAJOR = new ChordType("Major", "", Interval.ROOT, Interval.MAJOR_THIRD, Interval.PERFECT_FIFTH);
    public static final ChordType MINOR = new ChordType("Minor", "m", Interval.ROOT, Interval.MINOR_THIRD, Interval.PERFECT_FIFTH);
    public static final ChordType DIMINISHED = new ChordType("Diminished", "dim", Interval.ROOT, Interval.MINOR_THIRD, Interval.DIMINISHED_FIFTH);

    private final String name;
    private final String abbreviation;
    private final List<Integer> noteIndexes;
    
    public ChordType(Interval... intervals) {
        this(null, null, intervals);
    }

    public ChordType(String name, String abbreviation, Interval... intervals) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.noteIndexes = new ArrayList<>();
        Arrays.asList(intervals).forEach((interval) -> this.noteIndexes.add(interval.getIndex()));
    }
    
    public ChordType(int... noteIndexes){
        this(null, null, noteIndexes);
    }
    
    public ChordType(String name, String abbreviation, int... noteIndexes){
        this(name, abbreviation, new ArrayList<Integer>(){{
            for(int noteIndex: noteIndexes){
                add(noteIndex);
            }
        }});
    }
    
    public ChordType(String name, String abbreviation, List<Integer> noteIndexes){
        this.name = name;
        this.abbreviation = abbreviation;
        this.noteIndexes = noteIndexes;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public List<Note> getNotes(Note root) {
        List<Note> notes = new ArrayList<>();
        noteIndexes.forEach((noteIndex) -> notes.add(Note.getNote(root, noteIndex)));
        return notes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.noteIndexes);
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
        final ChordType other = (ChordType) obj;
        if (this.noteIndexes.size() != other.noteIndexes.size()) {
            return false;
        }
        for(int noteIndex: this.noteIndexes){
            if(!other.noteIndexes.contains(noteIndex)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name == null ? "Unknown" : name;
    }

}
