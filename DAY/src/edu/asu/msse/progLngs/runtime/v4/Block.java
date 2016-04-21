package edu.asu.msse.progLngs.runtime.v4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Block {
	private HashMap<String, Variable> localvars;
	private List<Instruction> instns;
	private Block parentBlock;
	Block(){
		localvars = new HashMap<String,Variable>();
		instns = new ArrayList<Instruction>();
		parentBlock = null;
	}	
	
	public HashMap<String, Variable> getLocalvars() {
		return localvars;
	}

	public void setLocalvars(HashMap<String, Variable> localvars) {
		this.localvars = localvars;
	}

	public List<Instruction> getInstns() {
		return instns;
	}

	public void setInstns(List<Instruction> instns) {
		this.instns = instns;
	}

	public Block getParentBlock() {
		return parentBlock;
	}

	public void setParentBlock(Block parentBlock) {
		this.parentBlock = parentBlock;
	}

	public void addToBlock(Instruction instn){
		//Add the instns to this block's
		instns.add(instn);
	}
	public Variable execute() throws Exception{
		//Execute the block
		//iterate each instn and execute
		Instruction instn = null;
		Variable returnValue = null;
		Variable temp = null;
		Iterator<Instruction> itr = instns.iterator();
		while(itr.hasNext()){
			instn = itr.next();	
			temp = instn.execute(this,RunTime.globalSymbolTable,RunTime.tempStack,RunTime.blocks);
			if(temp!=null)
				{
					returnValue = temp;
				};
		}
		return returnValue;
	}	
	
}
