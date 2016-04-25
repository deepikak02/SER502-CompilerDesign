package edu.asu.msse.progLngs.runtime.v5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * Runtime class - which specifies the execution model of our programming language
 */
public class RunTime {
	
	/**
	 * blocks - global variable which holds references for all function, if, while etc blocks
	 */
	public static final HashMap<String,Block> blocks = new HashMap<String,Block>(); 
	
	/**
	 * globalSymbolTable - global variable which holds all global variables
	 */	
	public static final HashMap<String,Object> globalSymbolTable = new HashMap<String,Object>(); 
	
	/**
	 * tempStack - Stack used by function calls and expression evaluations
	 */
	public static final Stack<Object> tempStack= new Stack<Object>(); 
	
	/**
	 * localSymblTbl - Stack used to store HashMap of local variables according to the scope
	 */	
	public static final Stack<BlockValues> localSymblTbl = new Stack<BlockValues>();
	

	/**
	 * temp registers - to note temporary evaluated values
	 */
	public static final String[] tempRegisters = new String[2];
	
	/**
	 * intDefaultValue - default value for integer variables
	 */	
	public static final int intDefaultValue = 0 ;
	
	/**
	 * boolDefaultValue - default value for boolean variables
	 */
	public static final Boolean boolDefaultValue = false ;
	
	/**
	 * strDefaultValue - default value for string variables
	 */
	public static final String strDefaultValue = null ;
	
	
	/**
	 * function checks the file and passes it to RunTime.parser function
	 */
	public static void main(String args[]){
		
		/*
		 * if (args.length < 1) {
			System.out.println("Usage: java RunTime <file.dpp>");			
			return;
			
		}*/
		try{
			
			//String path = "E:\\Visu\\ASU\\SecondSem\\prgmngLangs\\LanguageDevelopment\\EclipseWorkspace\\DAY\\src\\edu\\asu\\msse\\progLngs\\intermediateCode\\";
			String path = "C:\\Users\\deepika\\Documents\\GitHub\\SER502-CompilerDesign\\DAY\\src\\edu\\asu\\msse\\progLngs\\intermediateCode\\";
			//String filename = filepath + args[0];
			String filepath = path + "FactorialRecursion.dpp";
			if(!(new File(filepath)).isFile())
				throw new Exception(filepath + " file does not exist.");
			
			fileParser(filepath);			
		}
		catch(Exception e){
			
			System.out.println(e.toString());
		}		
	}
	
	
	/**
	 * function parses the file, stores global variables and function references 
	 */
	public static void fileParser(String filepath){	
		
		try{	
			
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String currentLine=null;
			Block newBlock = null;
			boolean funcScope = false;	
			
			while((currentLine=br.readLine())!=null){
				
				currentLine=currentLine.trim();
				Instruction instn = new Instruction(currentLine);
				String keyword = instn.getInstruction();
				
				/**
				 * if "FDEC" is encountered then new block with function name is built.
				 */
				if("FDEC".equals(keyword)){
					newBlock = new Block();
					funcScope = true;
					blocks.put(instn.getValues().get(0),newBlock);										
				}
				
				/**
				 * if instructions present in a function are added to the corresponding function block.
				 */
				if(funcScope){
					newBlock.addToBlock(instn);
				}	
				
				/**
				 * otherwise instruction is executed to update the global variables
				 */
				else{					
					instn.execute();
				}
				
				/**
				 * reached to the end of the function block hence func scope is set to false.
				 */
				if("FEND".equals(keyword)){
					funcScope = false;					
				}								
			}
			if(br!=null) br.close();
			
			/**
			 * start execution from main block
			 */
			if(blocks.containsKey("MAIN")){
				Block mainblock = blocks.get("MAIN");
				//System.out.println(globalSymbolTable);
				System.out.println(blocks);
				//System.out.println(blocks.get("example").getLocalvars());
				mainblock.execute();
				//System.out.println(blocks.get("example").getLocalvars());
			}
			else throw new Exception("Program must contain atleast one main block");
		}
		catch(Exception e){
			System.out.println("Exception encountered while parsing the file "+e.toString());
		}		
		
	}
	
	
}
