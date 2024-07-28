package analizadorLexico;

public class Num extends Token{
    public final int valor;
    public Num(int v) {super(Etiqueta.NUM); valor = v;}
    @Override
    public String toString() {return "" + valor;}
}
