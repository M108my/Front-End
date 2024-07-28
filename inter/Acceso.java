package inter;

import analizadorLexico.*;
import simbolos.*;

public class Acceso extends Op{
    public Id arreglo;
    public Expr indice;
    public Acceso(Id a, Expr i, Tipo p) {
        super(new Palabra("[]", Etiqueta.INDEX), p);
        arreglo = a; indice = i;
    }
    @Override
    public Expr gen() {return new Acceso(arreglo, indice.reducir(), tipo);}
    @Override
    public void salto(int t, int f) { emitirsaltos(reducir().toString(),t,f);}
    @Override
    public String toString(){
        return arreglo.toString() + " [ " + indice.toString() + " ] ";
    }
}

