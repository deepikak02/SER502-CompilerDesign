package edu.asu.atogani.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import edu.asu.atogani.parser.DAYBaseVisitor;
import edu.asu.atogani.parser.DAYParser.FuncdeclarationContext;
import edu.asu.atogani.parser.DAYParser.MainblockContext;
import edu.asu.atogani.parser.DAYParser.PrintContext;
import edu.asu.atogani.parser.DAYParser.ProgContext;
import edu.asu.atogani.parser.DAYParser.StatementContext;
import edu.asu.atogani.parser.DAYParser.StringdeclContext;
import edu.asu.atogani.parser.DAYParser.VardeclarationContext;

public class MyVisitor extends DAYBaseVisitor <String>{
	
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
	@Override
	public String visitProg(ProgContext ctx) {
		
		return visit(ctx.vardecl)+visit(ctx.main);
	}
	
	@Override
	public String visitFuncdeclaration(FuncdeclarationContext ctx) {
		return "no fdec";
	}
	@Override
	public String visitMainblock(MainblockContext ctx) {
		return "\r\nMSTA\r\n"+visit(ctx.s)+"\r\nMEND";
	}
	
	@Override
	public String visitStatement(StatementContext ctx) {
		return visit(ctx.vd);
	}
	
	@Override
	public String visitVardeclaration(VardeclarationContext ctx) {
		return visit(ctx.sdec);
	}
	
	@Override
	public String visitStringdecl(StringdeclContext ctx) {
		visitChildren(ctx);
		return "DECLs "+ctx.getChild(1)+"\r\n"+"STOR "+ctx.getChild(1)+" text";
	}
}
