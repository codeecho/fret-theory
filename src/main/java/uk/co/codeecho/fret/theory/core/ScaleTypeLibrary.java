package uk.co.codeecho.fret.theory.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScaleTypeLibrary {

    private static final List<ScaleType> knownScaleTypes;
    
    static {
        knownScaleTypes = new ArrayList<>();
        knownScaleTypes.add(ScaleType.MAJOR);
        knownScaleTypes.add(ScaleType.MINOR);
        knownScaleTypes.add(ScaleType.AEOLIAN);
    }
    
    public static List<ScaleType> getScaleTypes(){
        return Collections.unmodifiableList(knownScaleTypes);
    }
    
}
