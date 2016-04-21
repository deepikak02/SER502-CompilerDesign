package edu.asu.msse.progLngs.runtime.v3;

public class Variable {
	
	private String datatype;
	private String value;
	Variable(String datatype, String Value){
		this.datatype = datatype;
		this.value = value;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
