package analizadorLexico;
import java.io.*;
import java.util.*;
import simbolos.*;

public class AnalizadorLexico {
    public static int linea = 1;
    char preanalisis = ' ';
    HashMap<String, Palabra> palabras = new HashMap<>();
    
    void reservar(final Palabra w) {
        palabras.put(w.lexema, w);
    }

    public AnalizadorLexico(){
        inicializarPalabrasReservadas();
    }

    private void inicializarPalabrasReservadas(){
        reservar(new Palabra("if", Etiqueta.IF));
        reservar(new Palabra("else", Etiqueta.ELSE));
        reservar(new Palabra("while", Etiqueta.WHILE));
        reservar(new Palabra("do", Etiqueta.DO));
        reservar(new Palabra("break", Etiqueta.BREAK));
        reservar(Palabra.True);
        reservar(Palabra.False);
        reservar(Tipo.Int);
        reservar(Tipo.Char);
        reservar(Tipo.Bool);
        reservar(Tipo.Float);
    }

    void readch() throws IOException { preanalisis = (char) System.in.read(); }
    boolean readch(char c) throws IOException {
        readch();
        if( preanalisis != c) return false;
        preanalisis = ' ';
        return true;
    }

    public Token explorar() throws IOException{
        for(; ; readch()){
            if(preanalisis == ' '|| preanalisis == '\t') {
                continue;
            }else if(preanalisis == '\n') {
                linea = linea +1;
            }
            else break;
        }
        return switch (preanalisis){
            case '&' -> {
                if(readch('&')) yield Palabra.and;
                else yield new Token('&');
            }
            case '|' -> {
                if(readch('|')) yield Palabra.or;
                else yield new Token('|');
            }
            case '=' -> {
                if(readch('=')) yield Palabra.eq;
                else yield new Token('=');
            }
            case '!' -> {
                if(readch('!')) yield Palabra.ne;
                else yield new Token('!');
            }
            case '<' -> {
                if(readch('=')) yield Palabra.le;
                else yield new Token('<');
            }
            case '>' -> {
                if(readch('=')) yield Palabra.ge;
                else yield new Token('>');
            }
            default -> {
                if (Character.isDigit(preanalisis)) {
                    int v = 0;
                    do {
                        v = 10 * v + Character.digit(preanalisis, 10);
                        readch();
                    } while (Character.isDigit(preanalisis));
                    if (preanalisis != '.') yield new Num(v);
                    float x = v;
                    float d = 10;
                    for (; ; ) {
                        readch();
                        if (!Character.isDigit(preanalisis)) break;
                        x = x + Character.digit(preanalisis, 10) / d;
                        d = d * 10;
                    }
                    yield new Real(x);
                } else if (Character.isLetter(preanalisis)) {
                    StringBuilder b = new StringBuilder();
                    do {
                        b.append(preanalisis);
                        readch();
                    } while (Character.isLetterOrDigit(preanalisis));
                    String s = b.toString();
                    Palabra w = palabras.get(s);
                    if (w != null) yield w;
                    w = new Palabra(s, Etiqueta.ID);
                    palabras.put(s, w);
                    yield w;
                } else {
                    Token tok = new Token(preanalisis);
                    preanalisis = ' ';
                    yield tok;
                }
            }
        };
    }
}

