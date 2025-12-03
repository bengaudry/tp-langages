grammar NPI;

expr :
    INT # entier
|   expr expr OP # operation
;

main : 
    expr EOF;

NEWLINE : [\r\n\t ]+ -> skip;
INT : '-'?[0-9]+ ;
OP : [-+*/%];