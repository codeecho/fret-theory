package uk.co.codeecho.fret.theory.core;

import java.util.ArrayList;
import java.util.List;

public enum Note {

    C("C"),
    C_SHARP("C#"),
    D("D"),
    E_FLAT("Eb"),
    E("E"),
    F("F"),
    F_SHARP("F#"),
    G("G"),
    A_FLAT("Ab"),
    A("A"),
    B_FLAT("Bb"),
    B("B");

    private String abbreviation;
    
    private Note(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
    
    public static List<Note> getNotes(Note root, List<Integer> intervals) {
        List<Note> notes = new ArrayList<>();
        int rootIndex = root.ordinal();
        intervals.stream().forEach((interval) -> notes.add(getNote(rootIndex + interval)));
        return notes;
    }

    public static Note getNote(Note note, int modifier) {
        return getNote(note.ordinal() + modifier);
    }

    public static Note getNote(int index) {
        int n = Note.values().length;
        if (index < 0) {
            index = index + n;
        } else if (index >= n) {
            index = index - (n * (index / n));
        }
        return Note.values()[index];
    }
}
