package edu.asu.msse.progLngs.runtime;

public class Data {
	
	private Type type;
	private String value;
	public Data(Type type,String value){
		this.type=type;
		this.value=value;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
