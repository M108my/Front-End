package inter;

import analizadorLexico.*;
import simbolos.*;

public class Unario extends Op {
    public Expr expr;
    public Unario(Token tok, Expr x){
        super(tok,null); expr = x;
        tipo = Tipo.max(Tipo.Int, expr.tipo);
        if(tipo == null) error ("error de tipo");
    }
    @Override
    public Expr gen() {return new Unario(op, expr.reducir());}
    @Override
    public String toString() {return op.toString()+" "+expr.toString();}
}
