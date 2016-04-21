package edu.asu.msse.progLngs.runtime;

import java.util.ArrayList;
import java.util.Iterator;

public class MyParser {
	ArrayList<Data> tokens;	
	 Data lastToken=null;
	 Data currentToken = null;
	 String currentTokenValue = null;
	
	
	MyParser(ArrayList<Data> list){
		tokens = list;
		Iterator<Data> itr = tokens.iterator();
		while(itr.hasNext()){
			currentToken=itr.next();
			currentTokenValue=currentToken.getValue();
			if(lastToken == null){
				lastToken = currentToken;
				
			}
			else{
				if(lastToken.getValue().equals("PRIN")){
					System.out.println(currentTokenValue.substring(currentTokenValue.indexOf("\"")+1, currentTokenValue.lastIndexOf("\"")));
					
				}
				
				
			}
			
			
			
		}
		
		
		
		
	}

}
