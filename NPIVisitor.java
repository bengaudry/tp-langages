// Generated from NPI.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NPIParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NPIVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code entier}
	 * labeled alternative in {@link NPIParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntier(NPIParser.EntierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operation}
	 * labeled alternative in {@link NPIParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(NPIParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link NPIParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(NPIParser.MainContext ctx);
}