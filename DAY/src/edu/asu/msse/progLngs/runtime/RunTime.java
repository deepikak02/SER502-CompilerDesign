package edu.asu.msse.progLngs.runtime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RunTime {
	
	private HashMap<String,Block> progblock;
	
	
	public static void main(String args[]){
				
		/**code to open and read intermediate file **/
		try{			
			BufferedReader br = new BufferedReader(new FileReader("E:\\Visu\\ASU\\SecondSem\\prgmngLangs\\LanguageDevelopment\\EclipseWorkspace\\DAY\\src\\edu\\asu\\msse\\progLngs\\runtime\\HelloWorld.dpp"));
			String currentLine=null;
			while((currentLine=br.readLine())!=null){
				currentLine=currentLine.trim();
				MyTokenizer mt = new MyTokenizer(currentLine);
				MyParser mp = new MyParser(mt.tokens);
				
			}			
		}
		catch(Exception e){
			System.out.println("Exception= "+ e);
		}
	}
	

}
/*

variables
while


*/