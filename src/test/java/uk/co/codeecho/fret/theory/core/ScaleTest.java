package uk.co.codeecho.fret.theory.core;

import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ScaleTest {
 
    @Test
    public void testMajorScale() {
        Scale cMajor = new Scale(Note.C, ScaleType.MAJOR);
        List<Note> notes = cMajor.getNotes();
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.D));
        assertTrue(notes.contains(Note.E));
        assertTrue(notes.contains(Note.F));
        assertTrue(notes.contains(Note.G));
        assertTrue(notes.contains(Note.A));
        assertTrue(notes.contains(Note.B));
    }
    
    @Test
    public void testMinorScale() {
        Scale aMinor = new Scale(Note.A, ScaleType.MINOR);
        List<Note> notes = aMinor.getNotes();
        assertTrue(notes.contains(Note.A));
        assertTrue(notes.contains(Note.B));
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.D));
        assertTrue(notes.contains(Note.E));
        assertTrue(notes.contains(Note.F));
        assertTrue(notes.contains(Note.G));
    }
    
    @Test
    public void testAeolianScale() {
        Scale aAeolian = new Scale(Note.A, ScaleType.AEOLIAN);
        List<Note> notes = aAeolian.getNotes();
        assertTrue(notes.contains(Note.A));
        assertTrue(notes.contains(Note.B));
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.D));
        assertTrue(notes.contains(Note.E));
        assertTrue(notes.contains(Note.F));
        assertTrue(notes.contains(Note.G));
    }
    
    @Test
    public void testGetChords(){
        Scale cMajor = new Scale(Note.C, ScaleType.MAJOR);
        List<Chord> chords = cMajor.getChords();
        assertTrue(chords.contains(new Chord(Note.C, ChordType.MAJOR)));
        assertTrue(chords.contains(new Chord(Note.D, ChordType.MINOR)));
        assertTrue(chords.contains(new Chord(Note.E, ChordType.MINOR)));
        assertTrue(chords.contains(new Chord(Note.F, ChordType.MAJOR)));
        assertTrue(chords.contains(new Chord(Note.G, ChordType.MAJOR)));
        assertTrue(chords.contains(new Chord(Note.A, ChordType.MINOR)));
        assertTrue(chords.contains(new Chord(Note.B, ChordType.DIMINISHED)));
    }
    
}
