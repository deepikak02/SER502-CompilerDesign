package edu.asu.msse.atogani.compiler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.asu.atogani.parser.DAYLexer;
import edu.asu.atogani.parser.DAYParser;
//import edu.asu.msse.progLngs.runtime.v5.RunTime;


public class Main{
	static String fileName = null;

	public static void main(String[] args) throws Exception{
		
		ANTLRInputStream input = new ANTLRFileStream("code.DAY");
		//fileName = args[0].toLowerCase();
		//ANTLRInputStream input = new ANTLRFileStream(fileName+".DAY");
		DAYLexer lexer = new DAYLexer(input);
		CommonTokenStream tokens =  new CommonTokenStream(lexer);
		DAYParser parser = new DAYParser(tokens);
		ParseTree tree = parser.main_prog();
		create_interim_code(new MyVisitor().visit(tree));
		//Create Tree
		//createTree("code.DAY");
		
	}

	private static void create_interim_code(String instructions) {
		// TODO Auto-generated method stub

		System.out.println("PSTART");
		System.out.println(instructions);
		System.out.println("PEND");
		//RunTime.run(instructions);
	}
	
	private static void createTree(String filename) throws IOException{
		final CharStream stream = new ANTLRFileStream(filename);
        final DAYLexer lexer = new DAYLexer(stream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final DAYParser parser = new DAYParser(tokens);
        final ParseTree tree = parser.prog();
        final List<String> ruleNames = Arrays.asList(DAYParser.ruleNames);
        final TreeViewer view = new TreeViewer(ruleNames, tree);
        view.open();
	}

}
