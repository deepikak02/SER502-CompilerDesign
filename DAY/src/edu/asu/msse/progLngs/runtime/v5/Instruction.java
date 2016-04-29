package edu.asu.msse.progLngs.runtime.v5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import edu.asu.msse.progLngs.runtime.v2.SymbolTableEntry;

/**
 * Class which tokenizes and executes each and every instruction
 */
public class Instruction {

	private String instruction;
	private List<String> values;
	String operand1 = null;
	String operand2 = null;
	String answer;
	static boolean conditionTrue = false;
	static boolean loopScope = false;
	static boolean exec = true;
	static boolean checkFalse = false;
	static Block newBlock;
	Object operandValue1;
	Object operandValue2;
	Integer answerValue;
	HashMap<String, Object> symblTbl = null;
	static Stack<Boolean> conditionChecks = new Stack<Boolean>();
	BlockValues currentBlockValues;
	static String loopName = null;
	static String label = null;

	public Instruction() {
		instruction = null;
		values = new ArrayList<String>();
	}

	public Instruction(String currentLine) {
		String[] instn = currentLine.split(" +", 2);
		instruction = instn[0];
		if (instn.length > 1)
			values = Arrays.asList(instn[1].split(","));
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public static HashMap<String, Object> getSymblTbl(BlockValues currBlockValues, String varname) throws Exception {

		while (currBlockValues != null) {
			if (currBlockValues.getLocalvars().containsKey(varname)) {
				return currBlockValues.getLocalvars();
			} else
				currBlockValues = currBlockValues.getParentBlock();
		}
		if (currBlockValues == null) {
			if (RunTime.globalSymbolTable.containsKey(varname))
				return RunTime.globalSymbolTable;
			else
				throw new Exception("variable " + varname + " is used before it is declared");
		}
		return null;
	}

	public static String getValue(BlockValues currBlockValues, String varName) {

		if (currBlockValues == null)
			return RunTime.globalSymbolTable.get(varName).toString();

		return null;
	}

	public void execute() {
		currentBlockValues = RunTime.localSymblTbl.isEmpty() ? null : RunTime.localSymblTbl.peek();
		String opcode = instruction;
		try {
			if(loopScope && !(opcode.equals("ENDL") && loopName.equals(values.get(0)))){
				newBlock.addToBlock(this);
				return;
			}
			if(!exec && !(opcode.contains("END") && label.equals(values.get(0))))
				return;
			switch (opcode) {

			case "PSTART":
				return;
			case "PEND":
				return;

			case "DECi":
				if (values.size() < 1)
					throw new Exception("Invalid DECi usage, usage must be DECLi <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, new Integer(RunTime.intDefaultValue));
				else
					currentBlockValues.getLocalvars().put(operand1, new Integer(RunTime.intDefaultValue));
				return;

			case "DECb":
				if (values.size() < 1)
					throw new Exception("Invalid DECb usage, usage must be DECLb <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, new Boolean(RunTime.boolDefaultValue));
				else
					currentBlockValues.getLocalvars().put(operand1, new Boolean(RunTime.boolDefaultValue));
				return;

			case "DECs":
				if (values.size() < 1)
					throw new Exception("Invalid DECs usage, usage must be DECLs <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, RunTime.strDefaultValue);
				else
					currentBlockValues.getLocalvars().put(operand1, RunTime.strDefaultValue);
				return;
				
			case "DECst":
				if (values.size() < 1)
					throw new Exception("Invalid DECst usage, usage must be DECLst <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, new Stack());
				else
					currentBlockValues.getLocalvars().put(operand1, new Stack());
				return;	

			case "STOR":
				if (values.size() < 2)
					throw new Exception("Invalid STOR usage, usage must be STOR <varName>,<value>");
				operand1 = values.get(0).trim();
				operand2 = values.get(1).trim();
				if(operand1.contains("temp")){
					int beginIndex = operand1.length()-1;
					int regIndex = Integer.parseInt(operand1.substring(beginIndex))-1;
					if (Pattern.matches("null|true|false|(-)?[0-9]+", operand2)) {
						RunTime.tempRegisters[regIndex] = operand2;
					} else if (Pattern.matches("\".*\"", operand2)) {
						RunTime.tempRegisters[regIndex] = operand2.substring(1, operand2.length() - 1);
					} else
						RunTime.tempRegisters[regIndex] = Instruction.getSymblTbl(currentBlockValues, operand2).get(operand2).toString();
				}	
				else{
					symblTbl = Instruction.getSymblTbl(currentBlockValues, operand1);
					if (Pattern.matches("null|true|false|(-)?[0-9]+", operand2)) {
						symblTbl.put(operand1, operand2);
					} else if (Pattern.matches("\".*\"", operand2)) {
						symblTbl.put(operand1, operand2.substring(1, operand2.length() - 1));
					} else
						symblTbl.put(operand1, Instruction.getSymblTbl(currentBlockValues, operand2).get(operand2));
				}
				
				
				return;

			case "PRIN":
				if (values.size() < 1)
					System.out.print("");
				operand1 = values.get(0).trim();
				if(operand1.contains("temp")){
					int beginIndex = operand1.length()-1;
					int regIndex = Integer.parseInt(operand1.substring(beginIndex))-1;
					System.out.print(RunTime.tempRegisters[regIndex]);
				}	
				else if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
					System.out.print(operand1);
				} else if (Pattern.matches("\".*\"", operand1)) {
					System.out.print(operand1.substring(1, operand1.length() - 1));
				} else
					System.out.print(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				return;

			/*case "PRINLN":
				if (values.size() < 1)
					System.out.print("");
				operand1 = values.get(0).trim();
				if(operand1.contains("temp")){
					int beginIndex = operand1.length()-1;
					int regIndex = Integer.parseInt(operand1.substring(beginIndex))-1;
					System.out.println(RunTime.tempRegisters[regIndex]);
				}	
				else if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
					System.out.println(operand1);
				} else if (Pattern.matches("\".*\"", operand1)) {
					System.out.println(operand1.substring(1, operand1.length() - 1));
				} else
					System.out.println(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				return;*/

			case "FDEC":
				BlockValues newBlockValues = new BlockValues();
				RunTime.localSymblTbl.push(newBlockValues);
				newBlockValues.setParentBlock(currentBlockValues);
				return;
				
			case "FEND":
				RunTime.localSymblTbl.pop();
				return;
			
			case "PUSH":
				if(values.size()<1)
					throw new Exception("Invalid PUSH usage, usage must be PUSH <value>");
				if(values.size() == 1){
					operand1 = values.get(0).trim();
					if(operand1.contains("temp")){
						int beginIndex = operand1.length()-1;
						int regIndex = Integer.parseInt(operand1.substring(beginIndex))-1;
						RunTime.tempStack.push(RunTime.tempRegisters[regIndex]);
					}else{
						if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
							RunTime.tempStack.push(operand1);
						} else if (Pattern.matches("\".*\"", operand1)) {
							RunTime.tempStack.push(operand1.substring(1, operand1.length() - 1));
						} else
							RunTime.tempStack.push(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
					}
				}else{
					Stack<Integer> stack;
					operand2 = values.get(1).trim();
					if (currentBlockValues == null){
						stack = (Stack<Integer>)RunTime.globalSymbolTable.get(operand2);
					}			
					else{
						stack = (Stack<Integer>)currentBlockValues.getLocalvars().get(operand2);
					}
						
					operand1 = values.get(0).trim();
					if(operand1.contains("temp")){
						int beginIndex = operand1.length()-1;
						int regIndex = Integer.parseInt(operand1.substring(beginIndex))-1;
						stack.push(Integer.parseInt(RunTime.tempRegisters[regIndex]));
					}else{
						if (Pattern.matches("(-)?[0-9]+", operand1)) {
							stack.push(Integer.parseInt(operand1));
						} else
							stack.push(Integer.parseInt(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1).toString()));
					}
				}
				
				return;				
				
			case "POP":
				if(values.size()<1)
					throw new Exception("Invalid POP usage, usage must be POP <varName>");
				if(values.size() == 1){
					operand1 = values.get(0).trim();
					Object value = RunTime.tempStack.pop();
					currentBlockValues.getLocalvars().put(operand1, value);
				}else{
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					Stack stack;
					if (currentBlockValues == null){
						stack = (Stack<Integer>)RunTime.globalSymbolTable.get(operand2);
					}			
					else{
						stack = (Stack<Integer>)currentBlockValues.getLocalvars().get(operand2);
					}
					Integer value = (Integer)stack.pop();
					currentBlockValues.getLocalvars().put(operand1, value);
					
				}
					return;
			
			case "RET":
				if(values.size()<1)throw new Exception("Invalid RET usage, usage must be RET <varName>");
				operand1 = values.get(0).trim();
				if(operand1.contains("temp")){
					int beginIndex = operand1.length()-1;
					int regIndex = Integer.parseInt(operand1.substring(beginIndex))-1;
					RunTime.tempStack.push(RunTime.tempRegisters[regIndex]);
				}else{
					if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
						RunTime.tempStack.push(operand1);
					} else if (Pattern.matches("\".*\"", operand1)) {
						RunTime.tempStack.push(operand1.substring(1, operand1.length() - 1));
					} else
						RunTime.tempStack.push(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				}
				return;	
				
			case "FCALL":
				Block currBlock = RunTime.blocks.get(values.get(0));
				currBlock.execute();
				return;
				
			case "ADD":
				if(values.size()<3)
					throw new Exception("Invalid ADD usage, usage must be ADD <varName> <varName> <varName>");
				answer = values.get(0).trim();
				operand1 = values.get(1).trim();
				operand2 = values.get(2).trim();
				operandValue1 = getValue(operand1);
				operandValue2 = getValue(operand2);
				answerValue = (Integer)operandValue1 + (Integer)operandValue2;
				if(answer.contains("temp")){
					int beginIndex = answer.length()-1;
					int regIndex = Integer.parseInt(answer.substring(beginIndex))-1;
					RunTime.tempRegisters[regIndex] = answerValue.toString();
				}else{
					symblTbl = Instruction.getSymblTbl(currentBlockValues, answer);
					symblTbl.put(answer, answerValue);
				}
				return;	
			
			case "MUL":
				if(values.size()<3)
					throw new Exception("Invalid MUL usage, usage must be MUL <varName> <varName> <varName>");
				answer = values.get(0).trim();
				operand1 = values.get(1).trim();
				operand2 = values.get(2).trim();
				operandValue1 = getValue(operand1);
				operandValue2 = getValue(operand2);
				answerValue = (Integer)operandValue1 * (Integer)operandValue2;
				if(answer.contains("temp")){
					int beginIndex = answer.length()-1;
					int regIndex = Integer.parseInt(answer.substring(beginIndex))-1;
					RunTime.tempRegisters[regIndex] = answerValue.toString();
				}else{
					symblTbl = Instruction.getSymblTbl(currentBlockValues, answer);
					symblTbl.put(answer, answerValue);
				}
				return;	
				
			case "SUB":
				if(values.size()<3)
					throw new Exception("Invalid SUB usage, usage must be SUB <varName> <varName> <varName>");
				answer = values.get(0).trim();
				operand1 = values.get(1).trim();
				operand2 = values.get(2).trim();
				operandValue1 = getValue(operand1);
				operandValue2 = getValue(operand2);
				answerValue = (Integer)operandValue1 - (Integer)operandValue2;
				if(answer.contains("temp")){
					int beginIndex = answer.length()-1;
					int regIndex = Integer.parseInt(answer.substring(beginIndex))-1;
					RunTime.tempRegisters[regIndex] = answerValue.toString();
				}else{
					symblTbl = Instruction.getSymblTbl(currentBlockValues, answer);
					symblTbl.put(answer, answerValue);
				}
				return;	
			
			case "DIV":
				if(values.size()<3)
					throw new Exception("Invalid DIV usage, usage must be DIV <varName> <varName> <varName>");
				answer = values.get(0).trim();
				operand1 = values.get(1).trim();
				operand2 = values.get(2).trim();
				operandValue1 = getValue(operand1);
				operandValue2 = getValue(operand2);
				answerValue = (Integer)operandValue1 / (Integer)operandValue2;
				if(answer.contains("temp")){
					int beginIndex = answer.length()-1;
					int regIndex = Integer.parseInt(answer.substring(beginIndex))-1;
					RunTime.tempRegisters[regIndex] = answerValue.toString();
				}else{
					symblTbl = Instruction.getSymblTbl(currentBlockValues, answer);
					symblTbl.put(answer, answerValue);
				}
				return;		
				
			case "EQ":
				if(values.size()<2)throw new Exception("Invalid EQ usage, usage must be EQ <varName> <varName>");
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					operandValue1 = getObjectValue(operand1);
					operandValue2 = getObjectValue(operand2);
				if(operandValue1.equals(operandValue2))
					conditionTrue = true;
				else
					conditionTrue = false;
				return;
				
			case "NE":
				if(values.size()<2)throw new Exception("Invalid NE usage, usage must be NE <varName> <varName>");
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					operandValue1 = getObjectValue(operand1);
					operandValue2 = getObjectValue(operand2);
				if(!operandValue1.equals(operandValue2))
					conditionTrue = true;
				else
					conditionTrue = false;
				return;	
				
			case "LE":
				if(values.size()<2)
					throw new Exception("Invalid LE usage, usage must be LE <varName> <varName>");
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					operandValue1 = getValue(operand1);
					operandValue2 = getValue(operand2);
				if((Integer)operandValue1<=(Integer)operandValue2)
					conditionTrue = true;
				else
					conditionTrue = false;
				return;
				
			case "LT":
				if(values.size()<2)
					throw new Exception("Invalid LT usage, usage must be LT <varName> <varName>");
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					operandValue1 = getValue(operand1);
					operandValue2 = getValue(operand2);
				if((Integer)operandValue1<(Integer)operandValue2)
					conditionTrue = true;
				else
					conditionTrue = false;
				return;			
				
			case "GE":
				if(values.size()<2)
					throw new Exception("Invalid GE usage, usage must be GE <varName> <varName>");
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					operandValue1 = getValue(operand1);
					operandValue2 = getValue(operand2);
				if((Integer)operandValue1>=(Integer)operandValue2)
					conditionTrue = true;
				else
					conditionTrue = false;
				return;
				
			case "GT":
				if(values.size()<2)
					throw new Exception("Invalid GT usage, usage must be GT <varName> <varName>");
					operand1 = values.get(0).trim();
					operand2 = values.get(1).trim();
					operandValue1 = getValue(operand1);
					operandValue2 = getValue(operand2);
				if((Integer)operandValue1>(Integer)operandValue2)
					conditionTrue = true;
				else
					conditionTrue = false;
				return;			
				
			case "IFT":
				label = values.get(0);
				if(conditionTrue)
					exec = true;
				else
					exec = false;
				return;
				
			case "IFF":
				label = values.get(0);
				if(!conditionTrue){
					exec = true;
				}
				else{
					exec = false;
				}
				return;
				
			case "ENDC":
				exec = true;
				return;
				
			case "LOOP":
				loopName = this.getValues().get(0);
				newBlock = new Block();
				loopScope = true;
				RunTime.blocks.put(loopName, newBlock);
				return;
			
			case "JMP":
				loopName = this.getValues().get(0);
				Block executeBlock = RunTime.blocks.get(loopName);
				executeBlock.execute();
				return;
				
			case "ENDL":
				if(loopName.equals(values.get(0)))
					loopScope = false;
				return;
				
			default:
				return;

			}

		} catch (Exception e) {
			System.out.println("Exception caught while executing instruction " + e.toString());
		}

	}

	private int getValue(String operand) {
		int operandValue = 0;
		if(operand.contains("temp")){
			int beginIndex = operand.length()-1;
			int regIndex = Integer.parseInt(operand.substring(beginIndex))-1;
			operandValue = Integer.parseInt(RunTime.tempRegisters[regIndex]);
		}else{
			if (Pattern.matches("(-)?[0-9]+", operand)) {
				operandValue = Integer.parseInt(operand);
			} else{
				try {
					symblTbl = Instruction.getSymblTbl(currentBlockValues, operand);
					operandValue = Integer.parseInt(Instruction.getSymblTbl(currentBlockValues, operand).get(operand).toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return operandValue;
	}
	private Object getObjectValue(String operand) {
		Object operandValue = 0;
		if(operand.contains("temp")){
			int beginIndex = operand.length()-1;
			int regIndex = Integer.parseInt(operand.substring(beginIndex))-1;
			operandValue = Integer.parseInt(RunTime.tempRegisters[regIndex]);
		}else{
			if (Pattern.matches("null|true|false|(-)?[0-9]+", operand)){
				operandValue = operand;
			} else{
				try {
					symblTbl = Instruction.getSymblTbl(currentBlockValues, operand);
					operandValue = Instruction.getSymblTbl(currentBlockValues, operand).get(operand);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return operandValue;
	}
}