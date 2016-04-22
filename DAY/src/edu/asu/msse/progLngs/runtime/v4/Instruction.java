package edu.asu.msse.progLngs.runtime.v4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
	
	private String instruction;
	private List<String> values;
	static boolean loopScope = false;
	static Block newBlock;
	static String loopName;
	static int conditionCheck = 2;
	static boolean condnTrue = true;
	
	Instruction(){
		instruction = null;
		values = new ArrayList<String>();
	}
	
	// This function can be called from create() or execute() of Block class
	public Instruction(String currentLine){
		values = new ArrayList<String>();
		Matcher match = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(currentLine);
		Boolean opcode=true;
		while (match.find()){
			if(opcode){
				instruction = match.group(1).trim();
				opcode=false;
			}
			else{
				values.add(match.group(1).trim());
			}
		}				
	}
	public HashMap<String,Variable> getSymblTbl(Block currentBlock,HashMap<String,Variable> globalSymbolTable, Stack<Variable> tempStack,String value) throws Exception{
		while(currentBlock!=null){
			if(currentBlock.getLocalvars().containsKey(value)){
				return currentBlock.getLocalvars();				
			}
			else{
				currentBlock = currentBlock.getParentBlock();
			}
		}
		if(currentBlock == null && globalSymbolTable.containsKey(value)) 
			return globalSymbolTable;
		else {throw new Exception("data not found");}		
		
	}
	
	public HashMap<String,Variable> getSymblTbl(Block currentBlock,HashMap<String,Variable> globalSymbolTable, Stack<Variable> tempStack) throws Exception{
		
		if(currentBlock == null) return globalSymbolTable;
		else return currentBlock.getLocalvars();
		
	}
	
	public Variable execute(Block currentBlock,HashMap<String,Variable> globalSymbolTable, Stack<Variable> tempStack,HashMap<String,Block> blocks) throws Exception{
		String keyword = this.getInstruction();	
		HashMap<String, Variable> symbltbl;
		
		if("PSTART".equals(keyword)|| "PEND".equals(keyword)) return null;
		if(condnTrue){
			if ("LOOP".equals(keyword)) {
				loopName = this.getValues().get(0);
				newBlock = new Block();
				newBlock.setParentBlock(currentBlock);
				currentBlock = newBlock;
				loopScope = true;
			}
			else if ("ENDL".equals(keyword)) {
				RunTime.blocks.put(loopName, newBlock);
				loopName = null;
				newBlock = null;
				loopScope = false;
			}
			else if (loopScope) {
				newBlock.addToBlock(this);
				return null;
			} 
			else if ("PRIN".equals(keyword) && this.getValues().size() > 0) {
				String value = this.getValues().get(0);
				if (Variable.getTypeInfo(value) == Type.STRING) {

					if (value != null)
						System.out.print(value.substring(
								value.indexOf("\"") + 1,
								value.lastIndexOf("\"")));
					else
						System.out.print(value);

				} else if (Variable.getTypeInfo(value) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, value);
					Variable var = symbltbl.get(value);
					value = var.getValue();
				}
				if (Variable.getTypeInfo(value) == Type.NUMB
						|| Variable.getTypeInfo(value) == Type.BOOL) {
					System.out.print(value);
				}

				else if (Variable.getTypeInfo(value) == Type.VOID)
					System.out.println(value);

			} else if ("PRINLN".equals(keyword) && this.getValues().size() > 0) {
				String value = this.getValues().get(0);
				if (Variable.getTypeInfo(value) == Type.STRING) {
					if (value != null)
						System.out.println(value.substring(
								value.indexOf("\"") + 1,
								value.lastIndexOf("\"")));
					else
						System.out.println(value);
				}

				else if (Variable.getTypeInfo(value) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, value);
					Variable var = symbltbl.get(value);
					value = var.getValue();
				}
				if (Variable.getTypeInfo(value) == Type.NUMB
						|| Variable.getTypeInfo(value) == Type.BOOL) {
					System.out.println(value);
				}

				else if (Variable.getTypeInfo(value) == Type.VOID)
					System.out.println(value);

			} else if ("DECLi".equals(keyword)) {
				Variable var = new Variable(Type.NUMB.toString(),
						Integer.toString(RunTime.intDefaultValue));
				symbltbl = this.getSymblTbl(currentBlock, globalSymbolTable,
						tempStack);
				symbltbl.put(this.values.get(0), var);
			} else if ("DECLb".equals(keyword)) {
				Variable var = new Variable(Type.BOOL.toString(),
						Boolean.toString(RunTime.boolDefaultValue));
				symbltbl = this.getSymblTbl(currentBlock, globalSymbolTable,
						tempStack);
				symbltbl.put(this.values.get(0), var);
			} else if ("DECLs".equals(keyword)) {
				Variable var = new Variable(Type.STRING.toString(),
						RunTime.strDefaultValue);
				symbltbl = this.getSymblTbl(currentBlock, globalSymbolTable,
						tempStack);
				symbltbl.put(this.values.get(0), var);
			} else if ("STOR".equals(keyword)) {
				String key = this.values.get(0);
				String value = this.values.get(1);
				symbltbl = this.getSymblTbl(currentBlock, globalSymbolTable,
						tempStack, key);

				if (symbltbl.containsKey(key)) {
					Variable var = symbltbl.get(key);
					var.setValue(value);
					symbltbl.put(key, var);
				} else {
					throw new Exception("IIlegal state exception");
				}
			} else if ("ADL".equals(keyword) && this.getValues().size() > 0) {
				String operand = this.getValues().get(0);
				String dataType = Variable.getTypeInfo(operand).toString();
				String value = null;
				if (dataType == Type.IDENTIFIER.toString()) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, operand);
					value = symbltbl.get(operand).getValue();
				} else {
					value = this.getValues().get(0);
				}
				Variable var = new Variable(dataType, value);
				tempStack.push(var);

			} else if ("FCALL".equals(keyword)) {
				Block block = blocks.get(this.getValues().get(0));
				Variable ans = null;
				if (this.getValues().contains("ans")) {
					Variable returnValue = block.execute();
					ans = returnValue;
					System.out.println(ans.getValue());
				} else {
					block.execute();
				}
			} else if ("RET".equals(keyword)) {
				String value = this.getValues().get(0);
				Variable var = null;
				if (Variable.getTypeInfo(value) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, value);
					var = symbltbl.get(value);

				} else if (Variable.getTypeInfo(value) == Type.NUMB) {
					var = new Variable(Type.NUMB.toString(), value);
				} else if (Variable.getTypeInfo(value) == Type.BOOL) {
					var = new Variable(Type.BOOL.toString(), value);
				} else if (Variable.getTypeInfo(value) == Type.STRING) {
					var = new Variable(Type.STRING.toString(), value.substring(
							value.indexOf("\"") + 1, value.lastIndexOf("\"")));
				}
				return var;
			} else if ("FDEC".equals(keyword)) {
				if (this.getValues().size() > 1) {
					int index = 1;
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack);
					while (tempStack.isEmpty() != true) {
						Variable param = tempStack.pop();
						symbltbl.put(this.getValues().get(index), new Variable(
								param.getDataType(), param.getValue()));
						index++;
					}
				}
			}else if("ADD".equals(keyword)){
				String ans = this.getValues().get(0);
				String operand1 = this.getValues().get(1);
				String operand2 = this.getValues().get(2);
				Variable ope1 = null;
				if (Variable.getTypeInfo(operand1) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, operand1);
					ope1 = symbltbl.get(operand1);
				}
				Variable ope2 = null;
				if (Variable.getTypeInfo(operand2) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, operand2);
					ope2 = symbltbl.get(operand2);

				}
				int opeInt1 = Integer.parseInt(ope1.getValue());
				int opeInt2 = Integer.parseInt(ope2.getValue());
				Integer result = opeInt1+opeInt2;
				symbltbl = this.getSymblTbl(currentBlock,
						globalSymbolTable, tempStack, ans);
				symbltbl.put(ans, new Variable(
						ope2.getDataType(), result.toString()));
			}else if ("JMP".equals(keyword)) {
				loopName = this.getValues().get(0);
				Block executeBlock = RunTime.blocks.get(loopName);
				executeBlock.execute();
			}
			else if ("CHK".equals(keyword)) {
				String operand1 = this.getValues().get(0);
				String operand2 = this.getValues().get(1);
				Variable ope1 = null;
				if (Variable.getTypeInfo(operand1) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, operand1);
					ope1 = symbltbl.get(operand1);
				}
				Variable ope2 = null;
				if (Variable.getTypeInfo(operand2) == Type.IDENTIFIER) {
					symbltbl = this.getSymblTbl(currentBlock,
							globalSymbolTable, tempStack, operand2);
					ope2 = symbltbl.get(operand2);

				}
				int opeInt1 = Integer.parseInt(ope1.getValue());
				int opeInt2 = Integer.parseInt(ope2.getValue());
				if (opeInt1 < opeInt2) {
					conditionCheck = -1;
				} else if (opeInt1 > opeInt2) {
					conditionCheck = 1;
				} else {
					conditionCheck = 0;
				}
			} 
			else if ("IFLT".equals(keyword) && !(conditionCheck == -1)) {
				condnTrue = false;
		} else if ("IFGT".equals(keyword) && !(conditionCheck == 1)) {
				condnTrue = false;
		} else if ("IFEQ".equals(keyword) && !(conditionCheck == 0)) {
				condnTrue = false;
		}
		}
		if ("IFLT".equals(keyword) && (conditionCheck == -1)) {
			condnTrue = true;
		} else if ("IFGT".equals(keyword) && (conditionCheck == 1)) {
			condnTrue = true;
		} else if ("IFEQ".equals(keyword) && (conditionCheck == 0)) {
			condnTrue = true;
		}
		else if (keyword.contains("END")) {
			condnTrue = true;
		}
		return null;
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

	
}
