package uk.co.codeecho.fret.theory.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScaleFinder {

    public List<ScaleMatch> findScales(Note... notes) {
        return findScales(Arrays.asList(notes));
    }
    
    public List<ScaleMatch> findScales(Collection<Note> notes){
        List<ScaleMatch> scaleMatches = new ArrayList<>();
        ScaleTypeLibrary.getScaleTypes().forEach((scaleType) -> scaleMatches.addAll(scaleType.getMatches(notes)));
        Collections.sort(scaleMatches);
        return scaleMatches;
    }
    
    public List<ScaleMatch> findScales(Chord... chords){
        Set<Note> notes = new HashSet<>();
        for(Chord chord: chords){
            chord.getNotes().forEach((note) -> notes.add(note));
        }
        return findScales(notes);
    }

}
