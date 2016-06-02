package uk.co.codeecho.fret.theory.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ScaleType {

    public static final ScaleType MAJOR = new ScaleType("Major", 0, 2, 4, 5, 7, 9, 11);
    public static final ScaleType MINOR = new ScaleType("Minor", 0, 2, 3, 5, 7, 8, 10);
    public static final ScaleType AEOLIAN  = new ScaleType("Aeolian", MAJOR, 3);

    private final String name;
    private final List<Integer> intervals;

    public ScaleType(String name, ScaleType relativeScale, int modifier){
        this.name = name;
        this.intervals = new ArrayList<Integer>() {
            {
                relativeScale.intervals.stream().forEach((interval) -> add(interval+modifier));
            }
        };
    }
    
    public ScaleType(String name, int... intervals) {
        this.name = name;
        this.intervals = new ArrayList<Integer>() {
            {
                for (int i : intervals) {
                    add(i);
                }
            }
        };
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes(Note root) {
        return Note.getNotes(root, intervals);
    }
    
    public List<Chord> getChords(Note root){
        List<Chord> chords = new LinkedList<>();
        for(int i=0; i<intervals.size(); i++){
            chords.add(getChord(root, i));
        }
        return chords;
    }
    
    public List<ScaleMatch> getMatches(Collection<Note> notes){
        List<ScaleMatch> matches = new ArrayList<>();
        BigDecimal ratingDelta = new BigDecimal("100").setScale(4).divide(new BigDecimal(notes.size()), RoundingMode.HALF_UP);
        for(Note rootNote: Note.values()){
            List<Note> scaleNotes = getNotes(rootNote);
            BigDecimal rating = BigDecimal.ZERO;
            for(Note note: notes){
                if(scaleNotes.contains(note)){
                    rating = rating.add(ratingDelta);
                }
            }
            if(rating.compareTo(new BigDecimal(50)) > 0){
                matches.add(new ScaleMatch(new Scale(rootNote, this), rating.setScale(2, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        return matches;
    }
    
    private Chord getChord(Note root, int index){
        int rootInterval = getInterval(index);
        Note chordRoot = Note.getNote(root, rootInterval);
        int secondNoteInterval = getInterval(index+2) - rootInterval;
        if(secondNoteInterval < 0){
            secondNoteInterval = secondNoteInterval + Note.values().length;
        }
        int thirdNoteInterval = getInterval(index+4) - rootInterval;
        if(thirdNoteInterval < 0){
            thirdNoteInterval = thirdNoteInterval + Note.values().length;
        }
        Chord chord = new Chord(chordRoot, ChordTypeFactory.getChordType(0, secondNoteInterval, thirdNoteInterval));
        return chord;
    }
    
    private int getInterval(int index){
        if(index >= intervals.size()){
            index = index - intervals.size();
        }
        return intervals.get(index);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.intervals);
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
        final ScaleType other = (ScaleType) obj;
        if (this.intervals.size() != other.intervals.size()) {
            return false;
        }
        for(int interval: this.intervals){
            if(!other.intervals.contains(interval)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if(name == null){
            return "Unknown Scale";
        }else{
            return name + " Scale";
        }
    }
}
