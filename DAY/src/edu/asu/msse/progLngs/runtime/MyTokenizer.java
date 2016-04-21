package edu.asu.msse.progLngs.runtime;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTokenizer{
	
	public ArrayList<Data> tokens;
	
	MyTokenizer(String currentLine){
		tokens= new ArrayList();
					
		Matcher matched = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(currentLine);
		while (matched.find()){
			String curr=matched.group(1).trim();
			if(Pattern.matches("true|false", curr)){
				tokens.add(new Data(Type.BOOLVALUE,curr));	
				//System.out.println("added Type.BOOLVALUE "+ curr);
			}
			else if(Pattern.matches("[a-zA-Z_][a-zA-Z_0-9]*", curr)){
				tokens.add(new Data(Type.IDENTIFIER,curr));	
				//System.out.println("added Type.IDENTIFIER "+ curr);
			}
			else if(Pattern.matches("(-)?[0-9]+", curr)){
				tokens.add(new Data(Type.INTEGERVALUE,curr));
				//System.out.println("added Type.INTEGERVALUE "+ curr);
			}
			else if(Pattern.matches("\".*\"", curr)){
				tokens.add(new Data(Type.STRINGVALUE,curr));
				//System.out.println("added Type.STRINGVALUE "+ curr);
			}
			
		}		
		
		
		}
		
		
		
		
		
	}
	


