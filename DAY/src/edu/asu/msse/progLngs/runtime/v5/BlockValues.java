package edu.asu.msse.progLngs.runtime.v5;

import java.util.HashMap;

public class BlockValues {	
	
	public BlockValues parentBlock;
	public HashMap<String, Object> localvars;
	
	BlockValues(){
		parentBlock = null;
		localvars = new HashMap<>();
	}

	public BlockValues getParentBlock() {
		return parentBlock;
	}

	public void setParentBlock(BlockValues parentBlock) {
		this.parentBlock = parentBlock;
	}

	public HashMap<String, Object> getLocalvars() {
		return localvars;
	}

	public void setLocalvars(HashMap<String, Object> localvars) {
		this.localvars = localvars;
	}
}
