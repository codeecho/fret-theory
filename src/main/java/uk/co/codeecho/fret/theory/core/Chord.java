package uk.co.codeecho.fret.theory.core;

import java.util.List;
import java.util.Objects;

public class Chord {

    private final Note root;
    private final ChordType type;

    public Chord(Note root, ChordType type) {
        this.root = root;
        this.type = type;
    }

    public Note getRoot() {
        return root;
    }
    
    public List<Note> getNotes(){
        return type.getNotes(root);
    }

    public String getAbbreviation(){
        if(type.getAbbreviation() == null){
            return root.getAbbreviation() + "?";
        }else{
            return root.getAbbreviation() + type.getAbbreviation();
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Chord other = (Chord) obj;
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
        return getAbbreviation();
    }
    
}
