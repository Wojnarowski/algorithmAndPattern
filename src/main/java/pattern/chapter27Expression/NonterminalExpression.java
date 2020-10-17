package pattern.chapter27Expression;

public class NonterminalExpression extends Expression{

    //每个非终结符表达式都会对其他表达式产生依赖
    public NonterminalExpression(Expression... expression){ }


    public Object interpreter(Context ctx) {
        return null;
    }
}
