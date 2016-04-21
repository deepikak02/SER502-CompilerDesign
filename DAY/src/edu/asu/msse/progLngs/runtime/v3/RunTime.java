package edu.asu.msse.progLngs.runtime.v3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import edu.asu.msse.progLngs.runtime.v3.MyParser;


public class RunTime {
		
	public static void main(String args[]){
		
		/**
		if(args.length<1){
			
		}			
		code to open and read intermediate file **/
		try{	
			
			ArrayList<String> programCode = new ArrayList<>();
			ArrayList<String> globalCode = new ArrayList<>();
			HashMap<String,Integer> functionInfo = new HashMap<>();
			Boolean globalScope = true;
			String currentLine = null;
			int lineCount=0;
			
			BufferedReader br = new BufferedReader(new FileReader("E:\\Visu\\ASU\\SecondSem\\prgmngLangs\\LanguageDevelopment\\EclipseWorkspace\\DAY\\src\\edu\\asu\\msse\\progLngs\\runtime\\v3\\HelloWorld.dpp"));
			
			
			while((currentLine=br.readLine())!=null){
				currentLine = currentLine.trim();
				programCode.add(currentLine);
				
				if(currentLine.contains("FDEC")){
					globalScope = false;
					String[] tokens = currentLine.split(" ");
					functionInfo.put(tokens[1],lineCount);
				}
				if(globalScope){
					globalCode.add(currentLine);
				}
				if(currentLine.contains("FEND")){
					globalScope = true;
				}	
				lineCount++;
			}	
			System.out.println(programCode);
			System.out.println("global:");
			System.out.println(globalCode);
			System.out.println("MAP");
			System.out.println(functionInfo);
			MyParser mp = new MyParser();
			mp.parse(programCode,globalCode,functionInfo);
		}
		catch(Exception e){
			System.out.println("Exception= "+ e);
		}
	}
	

}
