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
		  | while_loop
		  | stack_declaration ';'
		  | stack_push ';'
		  | stack_pop ';'
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
    	   | left1 = IDENTIFIER '*' right1 = funccall #Ret_func 
     	   | number = NUMBER #numb
    	   | var = IDENTIFIER #variable
    	   | bool1 = bool_val #boolean1
    	   | str = STRING #str1
    	   | funccall #func_call_expr
    	   ;
    	   
stack_declaration : 'stack' var = IDENTIFIER;

stack_push : var = IDENTIFIER '.push(' val = expression ')';

stack_pop : var = IDENTIFIER '.pop(' var2 = IDENTIFIER ')'; 

while_loop : 'while' '(' list1 = cond_while ')' '{' list2 = while_list '}' ;

cond_while : expression ;

while_list : (statement)+ ;
    	   
vardeclaration : ('numb' | 'bool' | 'string' ) var2 = IDENTIFIER ; 

assignment : var1 = IDENTIFIER '=' expr = expression;

funcdeclaration : 'method' func = IDENTIFIER '(' (params = paramdec)? ')' '<-' ('numb'|'void') '{' stat = statementlist '}';

paramdec : (vardeclaration (',' vardeclaration)*) | 'NO PARAM' ;

statementlist : (statement )+;

funccall : func = IDENTIFIER '(' (args = expressionlist)? ')';

expressionlist : ident (',' ident)*;

ident : id = IDENTIFIER #ident1
	  | exp1 = expression #expr1
	  ; 

print : 'print' argument = expression ;
    	 
IDENTIFIER : [_a-zA-Z][a-zA-Z_0-9]* ; 	 
NUMBER : ('-')? [0-9]+;
STRING : '"' .*? '"';
bool_val : 'true' | 'false';

WS: [ \n\t\r]+ -> skip;