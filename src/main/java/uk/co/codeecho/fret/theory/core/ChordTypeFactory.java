package uk.co.codeecho.fret.theory.core;

public class ChordTypeFactory {

    public static ChordType getChordType(int... intervals) {
        ChordType chordType = new ChordType(intervals);
        for (ChordType knownChordType : ChordTypeLibrary.getChordTypes()) {
            if (knownChordType.equals(chordType)) {
                return knownChordType;
            }
        }
        return chordType;
    }

}
