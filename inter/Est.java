package inter;

//import analizadorLexico.*;
import simbolos.*;

public class Est extends Instr {
    public Id id; public Expr expr;

    public Est(Id i, Expr x) {
        id = i; expr = x;
        if ( comprobar(id.tipo, expr.tipo) == null ) error("error de tipo");
    }

    public Tipo comprobar(Tipo p1, Tipo p2) {
        if ( Tipo.numerico(p1) && Tipo.numerico(p2) ) return p2;
        else if ( p1 == Tipo.Bool && p2 == Tipo.Bool ) return p2;
        else return null;
    }

    @Override
    public void gen(int b, int a) {
        emitir(id.toString() + " = " + expr.gen().toString());
    }
}
