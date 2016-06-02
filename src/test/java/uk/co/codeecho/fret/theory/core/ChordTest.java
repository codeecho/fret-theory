package uk.co.codeecho.fret.theory.core;

import uk.co.codeecho.fret.theory.core.Interval;
import uk.co.codeecho.fret.theory.core.ChordType;
import uk.co.codeecho.fret.theory.core.Note;
import uk.co.codeecho.fret.theory.core.Chord;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ChordTest {

    @Test
    public void testMajorChord() {
        Chord cMajor = new Chord(Note.C, ChordType.MAJOR);
        List<Note> notes = cMajor.getNotes();
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.E));
        assertTrue(notes.contains(Note.G));
        
        Chord dMajor = new Chord(Note.D, ChordType.MAJOR);
        notes = dMajor.getNotes();
        assertTrue(notes.contains(Note.D));
        assertTrue(notes.contains(Note.F_SHARP));
        assertTrue(notes.contains(Note.A));
    }
    
    @Test
    public void testMinorChord() {
        Chord aMinor = new Chord(Note.A, ChordType.MINOR);
        List<Note> notes = aMinor.getNotes();
        assertTrue(notes.contains(Note.A));
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.E));
    }
    
    @Test
    public void testEquals(){
        assertTrue(new Chord(Note.C, ChordType.MAJOR).equals(new Chord(Note.C, ChordType.MAJOR)));
        assertTrue(new Chord(Note.C, ChordType.MAJOR).equals(new Chord(Note.C, new ChordType("Unknown", "?", new Interval(1), new Interval(3), new Interval(5)))));
        assertTrue(new Chord(Note.C, ChordType.MAJOR).equals(new Chord(Note.C, new ChordType(new Interval(3), new Interval(5), new Interval(1)))));
    }
    
}
