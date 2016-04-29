package edu.asu.msse.atogani.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import edu.asu.atogani.parser.DAYBaseVisitor;
import edu.asu.atogani.parser.DAYParser.AssignmentContext;
import edu.asu.atogani.parser.DAYParser.Bool_valContext;
import edu.asu.atogani.parser.DAYParser.Boolean1Context;
import edu.asu.atogani.parser.DAYParser.Cond_whileContext;
import edu.asu.atogani.parser.DAYParser.DivContext;
import edu.asu.atogani.parser.DAYParser.EQContext;
import edu.asu.atogani.parser.DAYParser.Expr1Context;
import edu.asu.atogani.parser.DAYParser.ExpressionlistContext;
import edu.asu.atogani.parser.DAYParser.Func_call_exprContext;
import edu.asu.atogani.parser.DAYParser.FunccallContext;
import edu.asu.atogani.parser.DAYParser.FuncdeclarationContext;
import edu.asu.atogani.parser.DAYParser.GThanEContext;
import edu.asu.atogani.parser.DAYParser.GthanContext;
import edu.asu.atogani.parser.DAYParser.Ident1Context;
//import edu.asu.atogani.parser.DAYParser.Ident_paramContext;
import edu.asu.atogani.parser.DAYParser.LessThanContext;
import edu.asu.atogani.parser.DAYParser.LessThanEContext;
import edu.asu.atogani.parser.DAYParser.Main_blockContext;
import edu.asu.atogani.parser.DAYParser.Main_progContext;
import edu.asu.atogani.parser.DAYParser.MinusContext;
import edu.asu.atogani.parser.DAYParser.MulContext;
import edu.asu.atogani.parser.DAYParser.NEQContext;
import edu.asu.atogani.parser.DAYParser.NumbContext;
import edu.asu.atogani.parser.DAYParser.ParamdecContext;
import edu.asu.atogani.parser.DAYParser.PlusContext;
import edu.asu.atogani.parser.DAYParser.PrintContext;
import edu.asu.atogani.parser.DAYParser.ProgContext;
import edu.asu.atogani.parser.DAYParser.Ret_funcContext;
import edu.asu.atogani.parser.DAYParser.Return1Context;
import edu.asu.atogani.parser.DAYParser.SelectionContext;
import edu.asu.atogani.parser.DAYParser.Stack_declarationContext;
import edu.asu.atogani.parser.DAYParser.Stack_popContext;
import edu.asu.atogani.parser.DAYParser.Stack_pushContext;
import edu.asu.atogani.parser.DAYParser.Str1Context;
import edu.asu.atogani.parser.DAYParser.VardeclarationContext;
import edu.asu.atogani.parser.DAYParser.VariableContext;
import edu.asu.atogani.parser.DAYParser.While_listContext;
import edu.asu.atogani.parser.DAYParser.While_loopContext;

public class MyVisitor extends DAYBaseVisitor <String>{
	
	private int selcounter = 0;
	private int whilecounter = 0;
	private Map<String, Integer> variables = new HashMap <>();
	
	@Override
	public String visitMain_prog(Main_progContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public String visitMain_block(Main_blockContext ctx) {
		return "FDEC MAIN"+ "\r\n" + visitChildren(ctx) + "\r\nFEND";
	}
	@Override
	public String visitProg(ProgContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public String visitStack_declaration(Stack_declarationContext ctx) {
		return "DECst " + ctx.var.getText();
	}
	
	@Override
	public String visitStack_push(Stack_pushContext ctx) {
		return "PUSH " + ctx.val.getText() + "," + ctx.var.getText();
	}
	
	@Override
	public String visitStack_pop(Stack_popContext ctx) {
		return "POP " + ctx.var2.getText() + "," + ctx.var.getText();
	}
	
	@Override
	public String visitPrint(PrintContext ctx) {
		String result = "";
		for(int i = 0; i < ctx.getChildCount(); ++i) {
			ParseTree child = ctx.getChild(i);
			String instructions = visit(child);
			if (child instanceof PlusContext) {
				result = instructions + "\r\n" + "PRIN temp1";
			} 
			else if (child instanceof MinusContext) {
				result = instructions + "\r\n" + "PRIN temp1";
			}
			else if (child instanceof MulContext) {
				result = instructions + "\r\n" + "PRIN temp1";
			}
			else if (child instanceof DivContext) {
				result = instructions + "\r\n" + "PRIN temp1";
			}
			else if (child instanceof PlusContext) {
				result = instructions + "\r\n" + "PRIN temp1";
			}
			else if (child instanceof LessThanContext) {
				result = "ERR Cannot be printed";
			}
			else if (child instanceof LessThanEContext) {
				result = "ERR Cannot be printed";
			}
			else if (child instanceof GthanContext) {
				result = "ERR Cannot be printed";
			}
			else if (child instanceof GThanEContext) {
				result = "ERR Cannot be printed";
			}
			else if (child instanceof EQContext) {
				result = "ERR Cannot be printed";
			}
			else if (child instanceof NEQContext) {
				result = "ERR Cannot be printed";
			}
			else if (child instanceof NumbContext) {
				result = "PRIN "+instructions;
			}
			else if (child instanceof VariableContext) {
				result = "PRIN "+instructions;
			}
			else if (child instanceof Str1Context)
			{
				result = "PRIN "+instructions;
			}
			else if (child instanceof Boolean1Context)
			{
				result = "PRIN "+instructions;
			}
			
		}
		return result;
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
	public String visitBoolean1(Boolean1Context ctx) {
		return ctx.bool1.getText();
	}
	
	@Override
	public String visitStr1(Str1Context ctx) {
		return ctx.str.getText();
	}
	
	@Override
	public String visitRet_func(Ret_funcContext ctx) {
		String args = visit(ctx.right1);
		return args + "\r\nMUL temp1," + ctx.left1.getText() + ",temp1";
	}
	
	@Override
	public String visitVardeclaration(VardeclarationContext ctx) {
		variables.put(ctx.var2.getText(),variables.size());
		if(ctx.getChild(0).getText().equals("numb"))
		{
			return "DECi "+ ctx.var2.getText();
		}
		else if(ctx.getChild(0).getText().equals("bool"))
		{
			return "DECb "+ ctx.var2.getText();
		}
		else
		{
			return "DECs "+ ctx.var2.getText();
		}
	}
	
	@Override
	public String visitAssignment(AssignmentContext ctx) {
		String result = "";
		ParseTree child = ctx.getChild(2);
		String instructions = visit(child);
		if (child instanceof NumbContext) {
			result = "STOR "+ctx.var1.getText()+","+instructions;
		}
		else if (child instanceof VariableContext) {
			result = "STOR "+ctx.var1.getText()+","+instructions;
		}
		else if (child instanceof Boolean1Context) {
			result = "STOR "+ctx.var1.getText()+","+instructions;
		}
		else if (child instanceof Str1Context) {
			result = "STOR "+ctx.var1.getText()+","+instructions;
		}
		else if (child instanceof Func_call_exprContext)
		{
			result = instructions + "\r\nPOP a";
		}
		else{
			result = instructions+"\r\n"+"STOR " + ctx.var1.getText() +",temp1";
		}
		return result;
	}
	
	@Override
	public String visitFunc_call_expr(Func_call_exprContext ctx) {
		return visit(ctx.funccall());
	}
	
	@Override
	public String visitFunccall(FunccallContext ctx) {
		if(ctx.getChildCount()>3)
		{
			return visitChildren(ctx) + "FCALL " + ctx.func.getText();
		}
		else{
			return "FCALL " + ctx.func.getText();
		}
	}
	
	@Override
	public String visitExpressionlist(ExpressionlistContext ctx) {
		String result = "";
		for(int i = ctx.getChildCount()-1; i >= 0; i--) {
			ParseTree child = ctx.getChild(i);
			String instructions = visit(child);
			if(ctx.getChild(i).getText().equals(","))
			{
				result = result + "";
			}
			else if(child instanceof Expr1Context){
				result = result + instructions + "\r\n" + "PUSH temp1\r\n";
			}
			else{
				result = result + "PUSH " + instructions + "\r\n";
			}
		}
		return result;
	}
	
	@Override
	public String visitIdent1(Ident1Context ctx) {
		return ctx.id.getText();
	}
	
	@Override
	public String visitExpr1(Expr1Context ctx) {
		return visit(ctx.exp1);
	}
	
	@Override
	public String visitReturn1(Return1Context ctx) {
		String result = "";
		for(int i = 0; i < ctx.getChildCount(); ++i) {
			ParseTree child = ctx.getChild(i);
			String instructions = visit(child);
			if (child instanceof PlusContext) {
				result = instructions + "\r\n" + "RET temp1";
			} 
			else if (child instanceof MinusContext) {
				result = instructions + "\r\n" + "RET temp1";
			}
			else if (child instanceof MulContext) {
				result = instructions + "\r\n" + "RET temp1";
			}
			else if (child instanceof DivContext) {
				result = instructions + "\r\n" + "RET temp1";
			}
			else if (child instanceof PlusContext) {
				result = instructions + "\r\n" + "RET temp1";
			}
			else if (child instanceof LessThanContext) {
				result = "ERR Cannot be returned";
			}
			else if (child instanceof LessThanEContext) {
				result = "ERR Cannot be returned";
			}
			else if (child instanceof GthanContext) {
				result = "ERR Cannot be returned";
			}
			else if (child instanceof GThanEContext) {
				result = "ERR Cannot be returned";
			}
			else if (child instanceof EQContext) {
				result = "ERR Cannot be returned";
			}
			else if (child instanceof NEQContext) {
				result = "ERR Cannot be returned";
			}
			else if (child instanceof NumbContext) {
				result = "RET " +instructions+"\r\n";
			}
			else if (child instanceof VariableContext) {
				result = "RET " +instructions+"\r\n";
			}
			else if (child instanceof Boolean1Context ) {
				result = "RET " +instructions+"\r\n";
			}
			else if (child instanceof Str1Context ) {
				result = "RET " +instructions+"\r\n";
			}
			else if (child instanceof Func_call_exprContext ) {
				result = instructions;
			}
			else if (child instanceof Ret_funcContext)
			{
				result = instructions;
			}
		}
		return result;
	}
	@Override
	public String visitFuncdeclaration(FuncdeclarationContext ctx) {
		String state_list = visit(ctx.stat);
		return "FDEC " + ctx.func.getText()+ visit(ctx.params) + 
				(state_list == null ? "" : state_list + "\r\n")+ "FEND";
	}
	
	@Override
	public String visitParamdec(ParamdecContext ctx) {
		int a = ctx.getChildCount();
		String result = "";
		if (ctx.getChild(0).getText().equals("NO PARAM"))
		{
			result=result + "\r\n";
			return result;
		}
		else{
		for(int i = 0; i < a; i++)
		{
			if(ctx.getChild(i).getText().equals(","))
			{
				result = result + "";
			}
			else{
				String a1 = ctx.getChild(i).getText();
				String a2 = a1.replace("numb","");
				result = result+ "\r\nPOP " + a2;
			}
		}
		return result+"\r\n";
		}
	}
	
	@Override
	public String visitWhile_loop(While_loopContext ctx) {
		String condInst = visit(ctx.list1);
		String statList = visit(ctx.list2);
		int whileNum = whilecounter;
		++whilecounter;
		return "LOOP L" + whileNum + "\r\n" + statList + "\r\n" + condInst + "\r\n" + "IFT" + "\r\n" + "JMP L" + whileNum + "\r\nENDL" + "\r\n" + condInst + "\r\n" + "IFT" + "\r\n" + "JMP L" + whileNum + "\r\nENDC";
	}
	
	@Override
	public String visitCond_while(Cond_whileContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public String visitWhile_list(While_listContext ctx) {
		return visitChildren(ctx);
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
