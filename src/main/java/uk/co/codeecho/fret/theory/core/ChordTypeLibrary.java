package uk.co.codeecho.fret.theory.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChordTypeLibrary {

    private static final List<ChordType> knownChordTypes;

    static {
        knownChordTypes = new ArrayList<>();
        knownChordTypes.add(ChordType.MAJOR);
        knownChordTypes.add(ChordType.MINOR);
        knownChordTypes.add(ChordType.DIMINISHED);
    }
    
    public static void addChordType(ChordType chordType){
        knownChordTypes.add(chordType);
    }
    
    public static List<ChordType> getChordTypes(){
        return Collections.unmodifiableList(knownChordTypes);
    }
    
}
