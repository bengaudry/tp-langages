import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class NPIEvaluator extends AbstractParseTreeVisitor<Integer> implements NPIVisitor<Integer> {

    @Override
    /**
     * Fonction appelée pour visiter un noeud étiqueté par le non-terminal Main
     * @param ctx sous-arbre enraciné en le noeud
     * @return l'évaluation de l'expression parsée par le sous-arbre
     */
    public Integer visitMain(NPIParser.MainContext ctx) {
	// ctx.getChild(n) renvoie le n-ème fils
	// visit(arbre) applique visitMain, visiteEntier ou visitOperation selon la racine de "arbre"
        return visit(ctx.getChild(0));
    }

    /**
     * Fonction appelée pour visiter un noeud créé par la règle Entier
     * @param ctx sous-arbre enraciné en le noeud
     * @return l'évaluation de l'expression parsée par le sous-arbre
     */
    @Override
    public Integer visitEntier(NPIParser.EntierContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    /**
     * Fonction appelée pour visiter un noeud créé par la règle Operation
     * @param ctx sous-arbre enraciné en le noeud
     * @return l'évaluation de l'expression parsée par le sous-arbre
     */
    @Override
    public Integer visitOperation(NPIParser.OperationContext ctx) {
        switch (ctx.getChild(2).getText()) {
            case "-":
                return visit(ctx.getChild(0)) - visit(ctx.getChild(1));
            case "+":
                return visit(ctx.getChild(0)) + visit(ctx.getChild(1));
            case "*":
                return visit(ctx.getChild(0)) * visit(ctx.getChild(1));
            case "/":
                return visit(ctx.getChild(0)) / visit(ctx.getChild(1));
            case "%":
                return visit(ctx.getChild(0)) / visit(ctx.getChild(1));
            default:
                return 0;
        }
    }
    
}
