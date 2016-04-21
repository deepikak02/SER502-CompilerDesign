package edu.asu.msse.progLngs.runtime.v4;

import java.util.regex.Pattern;

public class Variable {
	
	private String dataType;
	private String value;
	public Variable(String dataType, String value){
		this.dataType = dataType;
		this.value = value;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	
	public static Type getTypeInfo(String value){
		if(value == null) return Type.VOID;
		if(Pattern.matches("true|false", value)){
			return Type.BOOL;
		}
		else if(Pattern.matches("[a-zA-Z_][a-zA-Z_0-9]*", value))
			return Type.IDENTIFIER;
		else if(Pattern.matches("(-)?[0-9]+",value)){
			return Type.NUMB;
		}
		else if(Pattern.matches("\".*\"", value)){
			return Type.STRING;			
		}
		return Type.VOID;
	}
	
}
