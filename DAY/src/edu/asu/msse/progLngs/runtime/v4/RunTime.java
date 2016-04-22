package edu.asu.msse.progLngs.runtime.v4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class RunTime {
	
	/*
	 * Class which specifies the execution model of our programming language. 
	 */
	
	public static HashMap<String,Block> blocks = new HashMap<String,Block>(); // Holds block references of all global, function, main, if, else etc.
	public static HashMap<String,Variable> globalSymbolTable = new HashMap<String,Variable>(); // Holds information of all global variables.
	public static Stack<Variable> tempStack= new Stack<Variable>(); // 
	public static int intDefaultValue = 0 ;
	public static Boolean boolDefaultValue = false ;
	public static String strDefaultValue = null;
	
	
	public static void main(String args[]){
				
		/*
		 * if(args.length<1){
		 * 			
		 * }			
		 * code to open and read intermediate file 
		 * 
		 */
		
		try{
			String filepath = "C:\\Users\\deepika\\Documents\\ProgLangs\\DAY\\DAY\\src\\edu\\asu\\msse\\progLngs\\runtime\\v4\\";
			String filename = filepath + "LoopExample.dpp";
			//String filepath = "E:\\Visu\\ASU\\SecondSem\\prgmngLangs\\LanguageDevelopment\\EclipseWorkspace\\DAY\\src\\edu\\asu\\msse\\progLngs\\runtime\\v4\\";
			//String filename = filepath + "PrintExample.dpp";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String currentLine=null;
			Block newBlock = null;
			boolean funcScope = false;	
			
			while((currentLine=br.readLine())!=null){
				currentLine=currentLine.trim();
				Instruction instn = new Instruction(currentLine);
				String keyword = instn.getInstruction();
				//Call the create method of the Block class in case it is FDEC
				//instn.instruction is FDEC, call Block's addToBlock
				if("FDEC".equals(keyword)){
					newBlock = new Block();
					funcScope = true;
					blocks.put(instn.getValues().get(0),newBlock);
					//newBlock.addToBlock(instn);					
				}	
				if(funcScope){
					newBlock.addToBlock(instn);
				}				
				else{
					//Call the execute method of the Block class in case is it after Main or if it STOR etc under PSTART
					//Call Block's execute if instn is other
					instn.execute(null,globalSymbolTable,tempStack,blocks);
				}
				if("FEND".equals(keyword)){
					funcScope = false;					
				}
								
			}	
			br.close();
			
			//start Execution from main
			if(blocks.containsKey("MAIN")){
				Block mainblock = blocks.get("MAIN");
				//System.out.println(globalSymbolTable);
				//System.out.println(blocks);
				//System.out.println(blocks.get("example").getLocalvars());
				mainblock.execute();
				//System.out.println(blocks.get("example").getLocalvars());
			}
			else throw new Exception("Program must contain atleast one main block");
			
		}
		catch(Exception e){
			System.out.println("Exception= "+ e);
			e.printStackTrace();
		}
	}
	

}
