package edu.asu.atogani.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import edu.asu.atogani.parser.DAYBaseVisitor;
import edu.asu.atogani.parser.DAYParser.BooldeclContext;
import edu.asu.atogani.parser.DAYParser.DeclarationContext;
//import edu.asu.atogani.parser.DAYParser.FdecContext;
import edu.asu.atogani.parser.DAYParser.FuncdeclarationContext;
import edu.asu.atogani.parser.DAYParser.IntdeclContext;
import edu.asu.atogani.parser.DAYParser.MainblockContext;
import edu.asu.atogani.parser.DAYParser.PrintContext;
import edu.asu.atogani.parser.DAYParser.ProgContext;
//import edu.asu.atogani.parser.DAYParser.SdecContext;
import edu.asu.atogani.parser.DAYParser.StatementContext;
import edu.asu.atogani.parser.DAYParser.StringdeclContext;
import edu.asu.atogani.parser.DAYParser.VardeclarationContext;
//import edu.asu.atogani.parser.DAYParser.VdecContext;
import edu.asu.atogani.parser.DAYParser.Vdec_statementContext;

public class MyVisitor extends DAYBaseVisitor <String>{
	
	
	@Override
	public String visitProg(ProgContext ctx) {
		return visitChildren(ctx);
	}
	
	public String visitDeclaration(DeclarationContext ctx) {
		return visitChildren(ctx);
	}
	
	public String visitVarDeclaration(VardeclarationContext ctx) {
		return visitChildren(ctx);
	}
	@Override
	public String visitIntdecl(IntdeclContext ctx) {
		if(ctx.getChildCount() > 3)
		{
			return "DECi " + ctx.var.getText() + "\r\n" + "STOR " + ctx.var.getText() + " " + ctx.numb_val.getText();
		}
		else{
			return "DECi " + ctx.var.getText();
		}
	
	}
	@Override
	public String visitStringdecl(StringdeclContext ctx) {
		if(ctx.getChildCount() > 3)
		{
			return "DECs " + ctx.var.getText() + "\r\n" + "STOR " + ctx.var.getText() + " " + ctx.val.getText();
		}
		else{
			return "DECs " + ctx.var.getText();
		}
	}
	@Override
	public String visitBooldecl(BooldeclContext ctx) {
		if(ctx.getChildCount() > 3)
		{
			return "DECb " + ctx.var.getText() + "\r\n" + "STOR " + ctx.var.getText() + " " + ctx.val.getText();
		}
		else{
			return "DECb " + ctx.var.getText();
		}
	}
	
	@Override
	public String visitPrint(PrintContext ctx) {
		return "PRINLN " + 
	}
	
	@Override
	public String visitFuncdeclaration(FuncdeclarationContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public String visitMainblock(MainblockContext ctx) {
		
		return "FDEC MAIN" + "\r\n" + visitChildren(ctx)+ "\r\nFEND";
	}
	
	public String visitStatement(StatementContext ctx) {
		return visitChildren(ctx);
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
	public void write_to_file(String instructions) throws IOException{
		String text = instructions;
	    BufferedWriter output = null;
	    try {
	        File file = new File("example.dpp");
	        output = new BufferedWriter(new FileWriter(file));
	        output.write(text);
	    } catch ( IOException e ) {
	        e.printStackTrace();
	    } finally {
	      if ( output != null ) {
	        output.close();
	      }
	    }
	}
}
