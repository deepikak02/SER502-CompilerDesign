grammar DAY;

prog : 	(declaration)* 
		mainblock
		;
		
declaration : vardeclaration 
			| funcdeclaration 
			;
	 
vardeclaration : intdecl
			   | booldecl 
			   | stringdecl 
			   ;
			   
mainblock: 'START' statement 'END';

statement : vardeclaration #vdec_statement
		  | print #label_print
		  | funccall #fcall
		  | condnstatement #cstate
		  | loop #label_loop
		  | ret #return 
		  ; 

stringdecl : ('string')? var=IDENTIFIER ('=' val=STRINGVALUE )? ';';

intdecl : ('numb')? var=IDENTIFIER ('=' (numb_val = NUMBVALUE|expr|funccall))? ';';

booldecl : ('boolean')? var=IDENTIFIER ('=' val=boolvalue)? ';';

print: 'print' (expr|NUMBVALUE|STRINGVALUE|boolvalue) ';';

expr: ('-')?additionExp;

additionExp: multiplyExp( '+' multiplyExp | '-' multiplyExp)*;

multiplyExp: atomExp( '*' atomExp | '/' atomExp)*;

atomExp: (funccall|IDENTIFIER|NUMBVALUE|'(' additionExp ')');

funccall: IDENTIFIER'('parameter')';

funcdeclaration : 'method' IDENTIFIER '(' argument ')' '<-' (type | 'void') block;

argument : type IDENTIFIER (',' argument)*;

block: '{' statement '}';

ret: 'return' (expr|NUMBVALUE|funccall)';';



loop: 'while('condn')'block;

condnstatement: 'if(' (condnstatement|condn) ')'block ( 'else' (condnstatement|block) )?;

condn: expr|IDENTIFIER '==' (NUMBVALUE|STRINGVALUE|boolvalue);

parameter: (NUMBVALUE|STRINGVALUE|boolvalue|IDENTIFIER|expr) (',' parameter)*;

type : 'numb'| 'boolean' | 'string';

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]*;
NUMBVALUE :  [0-9]+;
boolvalue : 'true'|'false';
STRINGVALUE : '"text"';

/* We're going to ignore all white space characters */
WS: [ \n\t\r]+ -> skip;