package main;

import java.io.*;
import analizador.*;
import analizadorLexico.*;

public class Main {
    public static void main(String[] args) throws IOException{
        AnalizadorLexico lex= new AnalizadorLexico();
        Analizador analizar = new Analizador(lex);
        analizar.programa();
        System.out.println('\n');
    }
}
