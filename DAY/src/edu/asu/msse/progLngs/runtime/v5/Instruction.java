package edu.asu.msse.progLngs.runtime.v5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class which tokenizes and executes each and every instruction
 */
public class Instruction {

	private String instruction;
	private List<String> values;

	public Instruction() {
		instruction = null;
		values = new ArrayList<>();
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

		String opcode = instruction;
		String operand1 = null;
		String operand2 = null;
		BlockValues currentBlockValues = RunTime.localSymblTbl.isEmpty() ? null : RunTime.localSymblTbl.peek();
		HashMap<String, Object> symblTbl = null;
		try {
			switch (opcode) {

			case "PSTART":
				return;
			case "PEND":
				return;

			case "DECLi":
				if (values.size() < 1)
					throw new Exception("Invalid DECLi usage, usage must be DECLi <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, new Integer(RunTime.intDefaultValue));
				else
					currentBlockValues.getLocalvars().put(operand1, new Integer(RunTime.intDefaultValue));
				return;

			case "DECLb":
				if (values.size() < 1)
					throw new Exception("Invalid DECLb usage, usage must be DECLb <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, new Boolean(RunTime.boolDefaultValue));
				else
					currentBlockValues.getLocalvars().put(operand1, new Boolean(RunTime.boolDefaultValue));
				return;

			case "DECLs":
				if (values.size() < 1)
					throw new Exception("Invalid DECLs usage, usage must be DECLs <varName>");
				operand1 = values.get(0).trim();
				if (currentBlockValues == null)
					RunTime.globalSymbolTable.put(operand1, RunTime.strDefaultValue);
				else
					currentBlockValues.getLocalvars().put(operand1, RunTime.strDefaultValue);
				return;

			case "STOR":
				if (values.size() < 2)
					throw new Exception("Invalid STOR usage, usage must be STOR <varName>,<value>");
				operand1 = values.get(0).trim();
				operand2 = values.get(1).trim();
				symblTbl = Instruction.getSymblTbl(currentBlockValues, operand1);
				if (Pattern.matches("null|true|false|(-)?[0-9]+", operand2)) {
					symblTbl.put(operand1, operand2);
				} else if (Pattern.matches("\".*\"", operand2)) {
					symblTbl.put(operand1, operand2.substring(1, operand2.length() - 1));
				} else
					symblTbl.put(operand1, Instruction.getSymblTbl(currentBlockValues, operand2).get(operand2));
				return;

			case "PRIN":
				if (values.size() < 1)
					System.out.print("");
				operand1 = values.get(0).trim();
				if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
					System.out.print(operand1);
				} else if (Pattern.matches("\".*\"", operand1)) {
					System.out.print(operand1.substring(1, operand1.length() - 1));
				} else
					System.out.print(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				return;

			case "PRINLN":
				if (values.size() < 1)
					System.out.print("");
				operand1 = values.get(0).trim();
				if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
					System.out.println(operand1);
				} else if (Pattern.matches("\".*\"", operand1)) {
					System.out.println(operand1.substring(1, operand1.length() - 1));
				} else
					System.out.println(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				return;

			case "FDEC":
				BlockValues newBlockValues = new BlockValues();
				RunTime.localSymblTbl.push(newBlockValues);
				newBlockValues.setParentBlock(currentBlockValues);
				return;
				
			case "FEND":
				RunTime.localSymblTbl.pop();
				return;
			
			case "PUSH":
				if(values.size()<1)throw new Exception("Invalid PUSH usage, usage must be PUSH <value>");
				operand1 = values.get(0).trim();
				if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
					RunTime.tempStack.push(operand1);
				} else if (Pattern.matches("\".*\"", operand1)) {
					RunTime.tempStack.push(operand1.substring(1, operand1.length() - 1));
				} else
					RunTime.tempStack.push(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				return;				
				
			case "POP":
				if(values.size()<1)throw new Exception("Invalid POP usage, usage must be POP <varName>");
				operand1 = values.get(0).trim();
				Object value = RunTime.tempStack.pop();
				currentBlockValues.getLocalvars().put(operand1, value);
				return;
			
			case "RET":
				if(values.size()<1)throw new Exception("Invalid RET usage, usage must be RET <varName>");
				operand1 = values.get(0).trim();
				if (Pattern.matches("null|true|false|(-)?[0-9]+", operand1)) {
					RunTime.tempStack.push(operand1);
				} else if (Pattern.matches("\".*\"", operand1)) {
					RunTime.tempStack.push(operand1.substring(1, operand1.length() - 1));
				} else
					RunTime.tempStack.push(Instruction.getSymblTbl(currentBlockValues, operand1).get(operand1));
				return;	
				
			case "FCALL":
				Block currBlock = RunTime.blocks.get(values.get(0));
				currBlock.execute();
				return;
			
			case "LE":
				if(values.size()<3)throw new Exception("Invalid LE usage, usage must be LE <varName> <varName>");
				return;

			default:
				return;

			}

		} catch (Exception e) {
			System.out.println("Exception caught while executing instruction " + e.toString());
		}

	}
}
