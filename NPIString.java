import java.util.Stack;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NPIString
        extends AbstractParseTreeVisitor<Void>
        implements NPIVisitor<Void> {

    private Stack<Integer> stack;

    public NPIString() {}

    @Override
    public Void visitEntier(NPIParser.EntierContext ctx) {
        System.out.println("ADDi R0 R0 1");
        System.out.println("XOR R1 R1 R1");
        System.out.println("ADDi R1 R1 " + ctx.getText());
        System.out.println("LD R1 R0");
        return null;
    }

    @Override
    public Void visitMain(NPIParser.MainContext ctx) {
        System.out.println("XOR R0 R0 R0");
        visit(ctx.getChild(0));
        System.out.println("LD R1 R0");
        System.out.println("SUBi R0 R0 1");
        System.out.println("PRINT R1");
        return null;
    }

    @Override
    public Void visitOperation(NPIParser.OperationContext ctx) {
        visit(ctx.getChild(0));
        visit(ctx.getChild(1));

        String op = "";

        Integer b = stack.pop();
        Integer a = stack.pop();
        Integer res = 0;

        switch (ctx.getChild(2).getText()) {
            case "-":
                op = "SUB";
                break;
            case "+":
                op = "ADD";
                break;
            case "*":
                op = "MUL";
                break;
            case "/":
                op = "DIV";
                break;
            case "%":
                op = "MOD";
                break;
        }

        stack.push(res);

        return null;
    }

}
