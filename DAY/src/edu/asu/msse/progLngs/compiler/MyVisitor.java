package edu.asu.atogani.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import edu.asu.atogani.parser.DAYBaseVisitor;
import edu.asu.atogani.parser.DAYParser.AssignmentContext;
import edu.asu.atogani.parser.DAYParser.DivContext;
import edu.asu.atogani.parser.DAYParser.EQContext;
import edu.asu.atogani.parser.DAYParser.Func_call_exprContext;
import edu.asu.atogani.parser.DAYParser.FunccallContext;
import edu.asu.atogani.parser.DAYParser.FuncdeclarationContext;
import edu.asu.atogani.parser.DAYParser.GThanEContext;
import edu.asu.atogani.parser.DAYParser.GthanContext;
import edu.asu.atogani.parser.DAYParser.LessThanContext;
import edu.asu.atogani.parser.DAYParser.LessThanEContext;
import edu.asu.atogani.parser.DAYParser.MinusContext;
import edu.asu.atogani.parser.DAYParser.MulContext;
import edu.asu.atogani.parser.DAYParser.NEQContext;
import edu.asu.atogani.parser.DAYParser.NumbContext;
import edu.asu.atogani.parser.DAYParser.ParamdecContext;
import edu.asu.atogani.parser.DAYParser.PlusContext;
import edu.asu.atogani.parser.DAYParser.PrintContext;
import edu.asu.atogani.parser.DAYParser.ProgContext;
import edu.asu.atogani.parser.DAYParser.SelectionContext;
import edu.asu.atogani.parser.DAYParser.VardeclarationContext;
import edu.asu.atogani.parser.DAYParser.VariableContext;

public class MyVisitor extends DAYBaseVisitor <String>{
	
	private int selcounter = 0;
	private Map<String, Integer> variables = new HashMap <>();
	@Override
	public String visitProg(ProgContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public String visitPrint(PrintContext ctx) {
		return  visit(ctx.argument) + "\r\n" + "PRINT temp1";
	}
	
	@Override
	public String visitPlus(PlusContext ctx) {
		return "ADD temp1," + ctx.left.getText() + "," + ctx.right.getText();  
	}
	
	@Override
	public String visitMinus(MinusContext ctx) {
		return "SUB temp1," + ctx.left.getText() + "," + ctx.right.getText();  
	}
	
	@Override
	public String visitMul(MulContext ctx) {
		return "MUL temp1," + ctx.left.getText() + "," + ctx.right.getText();  
	}
	
	@Override
	public String visitDiv(DivContext ctx) {
		return "DIV temp1," + ctx.left.getText() + "," + ctx.right.getText();  
	}
	
	@Override
	public String visitNumb(NumbContext ctx) {
		return ctx.number.getText();
	}
	
	@Override
	public String visitVariable(VariableContext ctx) {
		return ctx.var.getText();
	}
	
	@Override
	public String visitVardeclaration(VardeclarationContext ctx) {
		variables.put(ctx.var2.getText(),variables.size());
		return "DECi "+ ctx.var2.getText();
	}
	
	@Override
	public String visitAssignment(AssignmentContext ctx) {
		return visit(ctx.expr)+"\r\n"+"STOR " + ctx.var1.getText() +",temp1";
	}
	
	@Override
	public String visitFunc_call_expr(Func_call_exprContext ctx) {
		return visit(ctx.funccall());
	}
	
	@Override
	public String visitFunccall(FunccallContext ctx) {
		return visit(ctx.args) +"\r\n"+ "FCALL " + ctx.func.getText(); 
	}
	
	@Override
	public String visitFuncdeclaration(FuncdeclarationContext ctx) {
		String state_list = visit(ctx.stat);
		return "FDEC " + ctx.func.getText() + " " + visit(ctx.params) +"\r\n" +
				(state_list == null ? "" : state_list + "\r\n")+ "RET " + visit(ctx.ret) + "\r\nFEND";
	}
	
	@Override
	public String visitParamdec(ParamdecContext ctx) {
		int a = ctx.getChildCount();
		String result = "";
		for(int i = 0; i < a; i++)
		{
			result = result + ctx.getChild(i).getText() + " ";
		}
		return result;
	}
	
	@Override
	public String visitSelection(SelectionContext ctx) {
		String condInst = visit(ctx.condition);
		String onTrueInst = visit(ctx.onTrue);
		String onFalseInst = visit(ctx.onFalse);
		int selNum = selcounter;
		++selcounter;
		return condInst + "\r\n" + "IFT F" + selNum + "\r\n" + onTrueInst + "\r\n" + "ENDC F" + selNum + "\r\n" + "IFF F" + selNum + "\r\n" + onFalseInst + "\r\n" + "ENDC F" + selNum;
	}
	
	@Override
	public String visitLessThan(LessThanContext ctx) {
		return "LT " + ctx.left.getText() + "," + ctx.right.getText();
	}
	
	@Override
	public String visitLessThanE(LessThanEContext ctx) {
		return "LE " + ctx.left.getText() + "," + ctx.right.getText();
	}
	
	@Override
	public String visitGthan(GthanContext ctx) {
		return "GT " + ctx.left.getText() + "," + ctx.right.getText();
	}
	
	@Override
	public String visitGThanE(GThanEContext ctx) {
		return "GE " + ctx.left.getText() + "," + ctx.right.getText();
	}
	
	@Override
	public String visitEQ(EQContext ctx) {
		return "EQ " + ctx.left.getText() + "," + ctx.right.getText();
	}
	
	@Override
	public String visitNEQ(NEQContext ctx) {
		return "NEQ " + ctx.left.getText() + "," + ctx.right.getText();
	}
	
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if(aggregate == null)
		{
			return nextResult;
		}
		if(nextResult == null)
		{
			return aggregate;
		}
		return aggregate + "\r\n" + nextResult;
	}
	
}
