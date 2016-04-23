package edu.asu.msse.progLngs.runtime.v5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asu.msse.progLngs.runtime.v5.Instruction;


/*
 * Every piece of code is a block - func, if, else, while etc
 */

public class Block {
	
	//private Block parentBlock;
	private List<Instruction> instns;
	
	Block(){
		//parentBlock = null;
		instns = new ArrayList<>();
	}
	
	public void addToBlock(Instruction instn){
		instns.add(instn);
	}
	
	public void execute(){
		Instruction instn = null;
		Iterator<Instruction> itr = instns.iterator();
		while(itr.hasNext()){
			instn = itr.next();	
			instn.execute();
			}
	}

}
