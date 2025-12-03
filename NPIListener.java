// Generated from NPI.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NPIParser}.
 */
public interface NPIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code entier}
	 * labeled alternative in {@link NPIParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEntier(NPIParser.EntierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code entier}
	 * labeled alternative in {@link NPIParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEntier(NPIParser.EntierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operation}
	 * labeled alternative in {@link NPIParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperation(NPIParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operation}
	 * labeled alternative in {@link NPIParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperation(NPIParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NPIParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(NPIParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPIParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(NPIParser.MainContext ctx);
}