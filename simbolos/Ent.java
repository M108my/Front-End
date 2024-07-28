package simbolos;

import analizadorLexico.*;
import inter.*;
import java.util.*;

public class Ent {
    private final HashMap<Token, Id>tabla;
    protected Ent ant;
    public Ent(Ent n) { tabla = new HashMap<>(); ant = n; }
    public void put(Token w, Id i) { tabla.put(w, i); }
    public Id get(Token w) {
        for( Ent e = this; e != null; e = e.ant ) {
            Id encontro = (Id)(e.tabla.get(w));
            if( encontro != null ) return encontro;
        }
        return null;
    }
}
