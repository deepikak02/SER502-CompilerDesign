grammar DAY;

main_prog : prog main_block;

main_block : 'START' statement* 'END';

prog : ((vardeclaration ';') | (funcdeclaration) | (assignment ';'))+;

statement : print ';'
		  | vardeclaration ';'
		  | assignment ';'
		  | funccall ';'
		  | selection
		  | return1
		  ;

return1 : 'return' ret = expression';';

selection : 'if' '(' condition = expression ')' onTrue = block 'else' onFalse = block ;

block : '{' statement* '}';

expression : left = expression '/' right = expression #Div
    	   | left = expression '*' right = expression #Mul
    	   | left = expression '+' right = expression #Plus
    	   | left = expression '-' right = expression #Minus
    	   | left = expression '<' right = expression #LessThan
    	   | left = expression '<=' right = expression #LessThanE
    	   | left = expression '>' right = expression #Gthan
    	   | left = expression '>=' right = expression #GThanE
    	   | left = expression '==' right = expression #EQ
    	   | left = expression '!=' right = expression #NEQ
    	   | number = NUMBER #numb
    	   | var = IDENTIFIER #variable
    	   | funccall #func_call_expr
    	   ;
    	   
vardeclaration : 'numb' var2 = IDENTIFIER; 

assignment : var1 = IDENTIFIER '=' expr = expression;

funcdeclaration : 'method' func = IDENTIFIER '(' (params = paramdec)? ')' '<-' 'numb' '{' stat = statementlist '}';

paramdec : (vardeclaration (',' vardeclaration)*) | 'NO PARAM' ;

statementlist : (statement )+;

funccall : func = IDENTIFIER '(' (args = expressionlist)? ')';

expressionlist : ident (',' ident)*;

ident : id = IDENTIFIER #ident1
	  ; 

print : 'print' argument = expression ;
    	 
IDENTIFIER : [_a-zA-Z][a-zA-Z_0-9]* ; 	 
NUMBER : ('-')?[0-9]+;
STRING : '"' .*? '"';

WS: [ \n\t\r]+ -> skip;