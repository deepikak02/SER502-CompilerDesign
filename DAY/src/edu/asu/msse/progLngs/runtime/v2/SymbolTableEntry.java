package edu.asu.msse.progLngs.runtime.v2;

// A stack based class to identify scope of variables
public class SymbolTableEntry {
	//int value;
	String value;
	String dataType;
	SymbolTableEntry head,next;
	
	public SymbolTableEntry(String value){
		this.value = value;
		head = this;
	}

	public void push(String value) {
		if(head==null){
			head = new SymbolTableEntry(value);
			next = head;
		}
		else{
			SymbolTableEntry temp = head.next;
			head = new SymbolTableEntry(value);
			head.next = temp;
		}		
	}
	
	public String pop(){
		String poppedValue = null;
		if(null != head){
			poppedValue = head.value;
			head = head.next;
		}		
		return poppedValue;
	}
	
	public String getTop(){
		String poppedValue = null;
		if(null != head){
			poppedValue = head.value;
		}		
		return poppedValue;
	}
	
}
