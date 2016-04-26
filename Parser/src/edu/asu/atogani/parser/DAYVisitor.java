// Generated from DAY.g4 by ANTLR 4.5.3
package edu.asu.atogani.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DAYParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DAYVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DAYParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(DAYParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DAYParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(DAYParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DAYParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(DAYParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GThanE}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGThanE(DAYParser.GThanEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanE}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanE(DAYParser.LessThanEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQ}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQ(DAYParser.EQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numb}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumb(DAYParser.NumbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(DAYParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(DAYParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Gthan}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGthan(DAYParser.GthanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(DAYParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEQ}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEQ(DAYParser.NEQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_call_expr}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call_expr(DAYParser.Func_call_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(DAYParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link DAYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(DAYParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#vardeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardeclaration(DAYParser.VardeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(DAYParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#funcdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdeclaration(DAYParser.FuncdeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#paramdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamdec(DAYParser.ParamdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#statementlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementlist(DAYParser.StatementlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#funccall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(DAYParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#expressionlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionlist(DAYParser.ExpressionlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(DAYParser.PrintContext ctx);
}