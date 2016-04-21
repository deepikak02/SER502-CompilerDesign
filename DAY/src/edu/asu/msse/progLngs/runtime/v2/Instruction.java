package edu.asu.msse.progLngs.runtime.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Instruction {
	
	private String instruction;
	private List values;
	static boolean ifStart = false;
	static String blockName = null;
	static Block newBlock = null;
	static Block executeBlock = null;
	static int conditionCheck = 2;
	static boolean loopStart = false;
	static String funcName = null;
	static String loopName = null;
	
	public Instruction(String currentLine){
		String[] tokens = currentLine.split(" ");
		instruction = tokens[0];
		values = new ArrayList<String>();
		for(int i=1;i<tokens.length;i++)
			values.add(tokens[i]);
	}
	
	// This function can be called from Runtime.java or execute() of Block class
	public void execute(){
		
		String keyword = this.getInstruction();
		
		
		if(keyword.equals("PRIN") && !ifStart && !loopStart){
			String symbol = this.getValues().get(0).toString();
			System.out.println(RunTime.symbolTable.get(symbol).getTop());
		}
		else if(keyword.equals("STOR") && !ifStart && !loopStart){
			if(null == RunTime.symbolTable.get(this.getValues().get(1))){
				RunTime.symbolTable.put(this.getValues().get(0).toString(),new SymbolTableEntry(this.getValues().get(1).toString()));
			}
			else{
				SymbolTableEntry symbolTableEntry = RunTime.symbolTable.get(this.getValues().get(0));
				symbolTableEntry.push(this.getValues().get(1).toString());
			}
		}
		else if(keyword.equals("ADD") && !ifStart && !loopStart){
			String answer = this.getValues().get(0).toString();
			String operand1 = this.getValues().get(1).toString();
			String operand2 = this.getValues().get(2).toString();
			Integer ans = Integer.parseInt(RunTime.symbolTable.get(operand1).getTop()) + Integer.parseInt(RunTime.symbolTable.get(operand2).getTop());
			RunTime.symbolTable.get(answer).push(ans.toString());
			
			//Get the value from symbol table and add them and store in answer variable and push to symbol table again
		}
		else if(keyword.equals("LOOP")){
			loopStart = true;
			loopName = this.getValues().get(0).toString();
			newBlock = new Block();
		}
		else if(keyword.equals("ENDL")){
			loopStart = false;
			RunTime.blocks.put(loopName, newBlock);
			loopName = null;
			newBlock.execute();
		}
		
		//Similarly do for all the mathematical operations
		else if(keyword.equals("JMP") && !ifStart && !loopStart){
			blockName = this.getValues().get(0).toString();
			executeBlock = RunTime.blocks.get(blockName);
			executeBlock.execute();
		}
		else if(keyword.equals("CHK") && !ifStart && !loopStart){
			String operand1 = this.getValues().get(0).toString();
			String operand2 = this.getValues().get(1).toString();
			int ope1 = Integer.parseInt(RunTime.symbolTable.get(operand1).getTop());
			int ope2 = Integer.parseInt(RunTime.symbolTable.get(operand2).getTop());
			if(ope1==ope2)
				conditionCheck = 0;
			else if(ope1<ope2)
				conditionCheck = -1;
			else
				conditionCheck = +1;
			//Compare the values in the two operands and store as -1, 0 and +1 for lesser, equal and greater conditions
		}
		else if(keyword.equals("IFLT")){
			newBlock = new Block();
			ifStart = true;
			blockName = "IFLT";	
		}
		else if(keyword.equals("IFGT")){
			newBlock = new Block();
			ifStart = true;
			blockName = "IFGT";	
		}
		else if(keyword.equals("IFEQ")){
			newBlock = new Block();
			ifStart = true;
			blockName = "IFEQ";	
		}
		else if(keyword.equals("CHE")){
			ifStart = false;
			RunTime.blocks.put(blockName,newBlock);
		}
		else if(keyword.equals("ENDI") && !ifStart && !loopStart){
			//Set blockName based on values from condition check
			switch(conditionCheck){
			case 0: blockName = "IFEQ";
					break;
			case 1: blockName = "IFGT";
					break;
			case -1: blockName = "IFLT";
					break;
			}
			executeBlock = RunTime.blocks.get(blockName);
			executeBlock.execute();
		}
		else if(keyword.equals("FCAL") && !ifStart && !loopStart){
			executeBlock = RunTime.blocks.get(this.getValues().get(0).toString());
			executeBlock.execute();
		}
		else if(loopStart == true){
			newBlock.addToBlock(this);
		}
			
	}
	
	public String getInstruction() {
		return instruction;
	}



	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}



	public List getValues() {
		return values;
	}



	public void setValues(List values) {
		this.values = values;
	}

	
}
