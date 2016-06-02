package uk.co.codeecho.fret.theory.core;

import java.util.List;
import java.util.Objects;

public class Scale {
    
    private final Note root;
    private final ScaleType type;

    public Scale(Note root, ScaleType type) {
        this.root = root;
        this.type = type;
    }
    
    public List<Note> getNotes(){
        return type.getNotes(root);
    }
    
    public List<Chord> getChords(){
        return type.getChords(root);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.root);
        hash = 97 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scale other = (Scale) obj;
        if (this.root != other.root) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return root.getAbbreviation() + " " + type.getName();
    }
    
}
