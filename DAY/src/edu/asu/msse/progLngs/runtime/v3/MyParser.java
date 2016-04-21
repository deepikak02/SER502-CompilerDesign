package edu.asu.msse.progLngs.runtime.v3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.asu.msse.progLngs.runtime3.Data;
import edu.asu.msse.progLngs.runtime3.Type;

public class MyParser {
	
	Stack<Block> programStack;
	HashMap<String, Variable> globalSymbolTable;
	
	
	MyParser(){
		programStack = new Stack<>(); 
		globalSymbolTable = new HashMap<>();
		
	}
	public void parse(ArrayList<String> programCode,ArrayList<String> globalCode,HashMap<String,Integer> functionInfo){
		int instructionPtr=0;
		String currentLine=null;
		int intDefaultValue = 0;
		Boolean boolDefaultVaule = false;
		
		
		
		for(;instructionPtr<globalCode.size();instructionPtr++){
			
			ArrayList<String> tokens = new ArrayList<>();
			currentLine=globalCode.get(instructionPtr);
			//adding the global variables to globalSymbolTable;
			Matcher matched = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(currentLine);
			while (matched.find()){
				String curr=matched.group(1);	
				tokens.add(curr);		
			}
			if(tokens.size()==3 && Pattern.matches("true|false", tokens.get(2))){
				globalSymbolTable.put(tokens.get(1), new Variable("BOOL",tokens.get(2)));
				//System.out.println("added Type.BOOLVALUE "+ curr);
			}
			else if(tokens.size()==3 && Pattern.matches("(-)?[0-9]+", tokens.get(2))){
				globalSymbolTable.put(tokens.get(1), new Variable("INTEGER",tokens.get(2)));
				//System.out.println("added Type.BOOLVALUE "+ curr);
			}
			else if(tokens.size()==3 && Pattern.matches("\".*\"", tokens.get(2))){
				globalSymbolTable.put(tokens.get(1), new Variable("STRING",tokens.get(2)));
				//System.out.println("added Type.BOOLVALUE "+ curr);
			}
			else if(tokens.size()==2){
				globalSymbolTable.put(tokens.get(1), null);
			}
			
			
		
		}
		System.out.println(globalSymbolTable);
	}
}
	

	


