import java.util.Stack;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NPIString
        extends AbstractParseTreeVisitor<Void>
        implements NPIVisitor<Void> {

    private String str = "";
    private Stack<Integer> stack;

    private int curr_reg = 0;

    public NPIString() {
        this.stack = new Stack<Integer>();
    }


    @Override
    public Void visitEntier(NPIParser.EntierContext ctx) {
        System.out.println("XOR R0 R0 R0");
        System.out.println("ADDi R0 R0 " + ctx.getText());
        System.out.println("ADDi R2 R2 1");
        System.out.println("ST R0 R2");

        return null;
    }

    @Override
    public Void visitMain(NPIParser.MainContext ctx) {
        System.out.println("XOR R2 R2 R2");
        visit(ctx.getChild(0));
        System.out.println("LD R0 R2");
        System.out.println("SUBi R2 R2 1");
        System.out.println("OUT R0");
        System.out.println("STOP");
        return null;
    }
    
    @Override
    public Void visitOperation(NPIParser.OperationContext ctx) {
        visit(ctx.getChild(0));
        visit(ctx.getChild(1));

        System.out.println("LD R1 R2");
        System.out.println("SUBi R2 R2 1");

        System.out.println("LD R0 R2");
        System.out.println("SUBi R2 R2 1");

        switch (ctx.getChild(2).getText()) {
            case "-":
                System.out.println("SUB R0 R1 R0");
                break;
            case "+":
                System.out.println("ADD R0 R1 R0");
                break;
            case "*":
                System.out.println("MUL R0 R1 R0");
                break;
            case "/":
                System.out.println("DIV R0 R1 R0");
                break;
            case "%":
                System.out.println("MOD R0 R1 R0");
                break;
        }

        return null;
    }

}
