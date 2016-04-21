package edu.asu.msse.progLngs.runtime;


import java.util.HashMap;

/*
 * Every bunch of code is a block and whole program is a nested 
 * block of if block, for block, func block, main block
 * Hence we represent whole program as a stack of blocks
 * 
 */

public class Block {
	
	private int instrPtr; // instruction pointer
	private HashMap<String,Data> instns;
	//pointer to super block - to identify scoping
	
	public Block(){
		this.instrPtr=0;
		instns = new HashMap();
		//nestedBlocks = new ArrayList<>();
	}

}
