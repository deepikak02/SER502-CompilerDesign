package edu.asu.msse.progLngs.runtime.v3;

import java.util.HashMap;

public class Block {
	
	HashMap<String, Variable> localVars;
	int returnLine;
	Block(){
		localVars = new HashMap<>();
		returnLine=-1;
	}

}
