package inter;

import analizadorLexico.*;
//import simbolos.*;

public class Not extends Logica {
    public Not(Token tok, Expr x2) { super(tok, x2, x2);}
    @Override
    public void salto(int t, int f) { expr2.salto(f,t);}
    @Override
    public String toString() {return op.toString()+" "+expr2.toString();}
}
