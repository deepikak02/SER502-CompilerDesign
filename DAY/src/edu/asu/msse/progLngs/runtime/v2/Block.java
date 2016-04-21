package edu.asu.msse.progLngs.runtime.v2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Block {
	private List<Instruction> instns;
	// HashMap SymbolTable
	// Parent block reference
	
	public Block(){
		instns = new ArrayList<Instruction>();
	}
	public void addToBlock(Instruction instn){
		//Add the instns to this block's
		instns.add(instn);
	}
	public void execute(){
		//Execute the block
		//iterate each instn and execute
		for(Instruction currentInstn:this.instns){
			currentInstn.execute();
		}
	}
	
	
}
