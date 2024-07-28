package inter;
import analizadorLexico.*;
public class Nodo {
    int linealex = 0;
    Nodo() {linealex = AnalizadorLexico.linea;}
    void error(String s) {throw new Error("cerca de la linea" +linealex+": "+s); }
    static int etiquetas = 0;
    public int nuevaEtiqueta() {return ++etiquetas;}
    public void emitirEtiqueta(int i) { System.out.print("L" + i + ":");}
    public void emitir(String s) { System.out.print("\t" + s);}
}
