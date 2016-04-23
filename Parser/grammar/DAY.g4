grammar DAY;

prog : (vardecl = vardeclaration |  fdecl = funcdeclaration) *  main = mainblock;
	 
vardeclaration : idec = intdecl 
			   | bdec = booldecl 
			   | sdec = stringdecl;

intdecl : ('numb')? IDENTIFIER ('=' (NUMBVALUE|expr|funccall))? ';';

booldecl : ('boolean')? IDENTIFIER ('=' boolvalue)? ';';

stringdecl : ('string')? IDENTIFIER ('=' STRINGVALUE )? ';';

funcdeclaration : 'method' IDENTIFIER '(' argument ')' '<-' (type | 'void') block;

block: '{' statement '}';

ret: 'return' (expr|NUMBVALUE|funccall)';';

mainblock: 'START' s = statement 'END';

statement : vd = vardeclaration|print|funccall|condnstatement|loop|ret;

loop: 'while('condn')'block;

condnstatement: 'if(' (condnstatement|condn) ')'block ( 'else' (condnstatement|block) )?;

condn: expr|IDENTIFIER '==' (NUMBVALUE|STRINGVALUE|boolvalue);

expr: ('-')?additionExp;

additionExp: multiplyExp( '+' multiplyExp | '-' multiplyExp)*;

multiplyExp: atomExp( '*' atomExp | '/' atomExp)*;

atomExp: (funccall|IDENTIFIER|NUMBVALUE|'(' additionExp ')');

argument : type IDENTIFIER (',' argument)*;

funccall: IDENTIFIER'('parameter')';

print: 'print' (expr|NUMBVALUE|STRINGVALUE|boolvalue) ';';

parameter: (NUMBVALUE|STRINGVALUE|boolvalue|IDENTIFIER|expr) (',' parameter)*;

type : 'numb'| 'boolean' | 'string';

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]*;
NUMBVALUE :  [0-9]+;
boolvalue : 'true'|'false';
STRINGVALUE : '"text"';

/* We're going to ignore all white space characters */
WS: [ \n\t\r]+ -> skip;