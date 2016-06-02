package uk.co.codeecho.fret.theory.core;

import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Test;

public class ScaleFinderTest {
    
    public ScaleFinderTest() {
    }

    @Test
    public void testFindScales_ByNotes() {
        ScaleFinder scaleFinder = new ScaleFinder();
        List<ScaleMatch> matches = scaleFinder.findScales(Note.A, Note.B, Note.C);
        assertContainsScaleMatch(matches, new Scale(Note.C, ScaleType.MAJOR), 100);
    }
    
    @Test
    public void testFindScales_ByChords() {
        ScaleFinder scaleFinder = new ScaleFinder();
        List<ScaleMatch> matches = scaleFinder.findScales(new Chord(Note.D, ChordType.MAJOR), new Chord(Note.C, ChordType.MAJOR), new Chord(Note.G, ChordType.MAJOR));
        assertContainsScaleMatch(matches, new Scale(Note.G, ScaleType.MAJOR), 100);
    }
    
    private void assertContainsScaleMatch(List<ScaleMatch> matches, Scale scale, double rating){
        for(ScaleMatch match: matches){
            if(match.getScale().equals(scale) && match.getRating() == rating){
                return;
            }
        }
        fail("Match for " + scale + " [" + rating + "] not found");
    }
    
}
