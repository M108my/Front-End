package inter;

import analizadorLexico.*;
import simbolos.*;

public class Arit extends Op{
    public Expr expr1, expr2;
    public Arit(Token tok, Expr x1, Expr x2){
        super(tok, null); expr1 = x1; expr2 = x2;
        tipo = Tipo.max(expr1.tipo, expr2.tipo);
        if(tipo == null) error("error de tipo");
    }
    @Override
    public Expr gen(){
        return new Arit(op, expr1.reducir(), expr2.reducir());
    }
    @Override
    public String toString(){
        return expr1.toString()+" "+op.toString()+" "+expr2.toString();
    }
}
