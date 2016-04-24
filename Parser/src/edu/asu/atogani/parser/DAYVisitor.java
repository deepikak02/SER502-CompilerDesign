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
	 * Visit a parse tree produced by {@link DAYParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(DAYParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#vardeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardeclaration(DAYParser.VardeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#mainblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainblock(DAYParser.MainblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vdec_statement}
	 * labeled alternative in {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVdec_statement(DAYParser.Vdec_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code label_print}
	 * labeled alternative in {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel_print(DAYParser.Label_printContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fcall}
	 * labeled alternative in {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFcall(DAYParser.FcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cstate}
	 * labeled alternative in {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCstate(DAYParser.CstateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code label_loop}
	 * labeled alternative in {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel_loop(DAYParser.Label_loopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link DAYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(DAYParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#stringdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringdecl(DAYParser.StringdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#intdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntdecl(DAYParser.IntdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#booldecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooldecl(DAYParser.BooldeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(DAYParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(DAYParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#additionExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExp(DAYParser.AdditionExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#multiplyExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExp(DAYParser.MultiplyExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#atomExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(DAYParser.AtomExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#funccall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(DAYParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#funcdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdeclaration(DAYParser.FuncdeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(DAYParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DAYParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(DAYParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(DAYParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#condnstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondnstatement(DAYParser.CondnstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#condn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondn(DAYParser.CondnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(DAYParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DAYParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DAYParser#boolvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolvalue(DAYParser.BoolvalueContext ctx);
}