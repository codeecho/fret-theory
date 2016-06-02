package uk.co.codeecho.fret.theory.core;

import uk.co.codeecho.fret.theory.core.ChordTypeFactory;
import uk.co.codeecho.fret.theory.core.ChordType;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChordTypeFactoryTest {
    
    public ChordTypeFactoryTest() {
    }

    @Test
    public void testGetChordType() {
        ChordType chordType = ChordTypeFactory.getChordType(0, 4, 7);
        assertEquals(ChordType.MAJOR, chordType);
        assertEquals(ChordType.MAJOR.getName(), chordType.getName());
    }
    
}
