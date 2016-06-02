package uk.co.codeecho.fret.theory.core;

import uk.co.codeecho.fret.theory.core.Note;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NoteTest {

    @Test
    public void testGetNotes() {
        List<Note> notes = Note.getNotes(Note.C, Arrays.asList(new Integer[]{0, 2}));
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.D));
    }
    
}
