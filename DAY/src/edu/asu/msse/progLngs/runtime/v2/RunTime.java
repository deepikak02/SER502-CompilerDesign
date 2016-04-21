package edu.asu.msse.progLngs.runtime.v2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class RunTime {
	
	public static HashMap<String,Block> blocks; // Create a separate block for global, function, main, if, else etc
	public static HashMap<String,SymbolTableEntry> symbolTable; // Enter into symbol table, values for variables to deal with scoping.
	public static Stack<Integer> params;
	
	public static void main(String args[]){
				
		/**code to open and read intermediate file **/
		try{			
			symbolTable = new HashMap<String, SymbolTableEntry>();
			blocks = new HashMap<String, Block>();
			params = new Stack<Integer>();
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\deepika\\Documents\\ProgLangs\\DAY\\DAY\\src\\edu\\asu\\msse\\progLngs\\runtime\\v2\\HelloWorld.dpp"));
			String currentLine=null;
			Block newBlock = null;
			boolean funcStart = false;
			boolean loopStart = false;
			String funcName = null;
			String loopName = null;
			Block executeBlock = null;
			while((currentLine=br.readLine())!=null){
				currentLine=currentLine.trim();
				Instruction instn = new Instruction(currentLine);
				String keyword = instn.getInstruction();
				//Call the create method of the Block class in case it is FDEC
				//instn.instruction is FDEC, call Block's addToBlock
				if(keyword.equals("FDEC")){
					newBlock = new Block();
					funcStart = true;
					funcName = instn.getValues().get(0).toString();
					newBlock.addToBlock(instn);
					
				}
				else if(keyword.equals("FEND")){
					funcStart = false;
					blocks.put(funcName,newBlock);
					funcName = null;
				}
				else if(funcStart == true){
					newBlock.addToBlock(instn);
				}
				//Can pass mainStart, funcStart and ifStart to this method to help identify scoping 
				//or to push as new value or manipulate same in symbol table
				else{
					instn.execute();
				}
			}		
			executeBlock = blocks.get("MAIN");
			executeBlock.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
