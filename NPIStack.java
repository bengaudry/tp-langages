import java.util.Stack;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NPIStack
        extends AbstractParseTreeVisitor<Void>
        implements NPIVisitor<Void> {

    private Stack<Integer> stack;

    public NPIStack() {
        this.stack = new Stack<Integer>();
    }

    @Override
    public Void visitEntier(NPIParser.EntierContext ctx) {
        stack.push(Integer.parseInt(ctx.getText()));
        return null;
    }

    @Override
    public Void visitMain(NPIParser.MainContext ctx) {
        visit(ctx.getChild(0));
        Integer res = stack.pop();
        System.out.println(res);
        return null;
    }

    @Override
    public Void visitOperation(NPIParser.OperationContext ctx) {
        visit(ctx.getChild(0));
        visit(ctx.getChild(1));

        Integer b = stack.pop();
        Integer a = stack.pop();
        Integer res = 0;

        switch (ctx.getChild(2).getText()) {
            case "-":
                res = a - b;
                break;
            case "+":
                res = a + b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            case "%":
                res = a % b;
                break;
        }

        stack.push(res);

        return null;
    }

}
