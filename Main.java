import org.antlr.v4.runtime.*;



public class Main {
    public static void main(String[] args) {
		String s = "1 6 + 5 4 3 * + *";
		NPILexer lexer = new NPILexer(CharStreams.fromString(s)); // analyse lexicale de la String s
		CommonTokenStream tokens = new CommonTokenStream(lexer); // récupération des terminaux
		
		NPIParser parser = new NPIParser(tokens); // constructeur de l'analyseur syntaxique
		NPIParser.MainContext tree = parser.main(); // création de l'AST
		
		NPIEvaluator visitor = new NPIEvaluator(); // lancement de l'évaluateur
		System.out.println(visitor.visit(tree));

		// NPIStack stack = new NPIStack();
		// stack.visit(tree);

		// NPIString asmParser = new NPIString();
		// asmParser.visit(tree);
	}
};

