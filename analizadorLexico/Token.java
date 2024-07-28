package analizadorLexico;
public class Token {
    public final int etiqueta;
    public Token(int t) {etiqueta = t;}
    @Override
    public String toString() {return "" + (char)etiqueta;}
}


