ARITM	START 0
	LDS X
	LDT Y
	LDA #0
	ADDR S,A
	ADDR T,A
	STA SUM
	
	LDA #0
	ADDR T,A
	SUBR S,A
	STA DIFF
	
	LDA #0
	ADDR T,A
	MULR S,A
	STA PROD
	
	LDA #0
	ADDR T,A
	DIVR S,A
	STA QUOT
	
	MULR S,A
	COMPR T,A
	JGT TVEC
	SUBR T,A
	STA MOD
	J HALT
TVEC	SUBR A,T
	STT MOD	
	J HALT	
	
	

HALT	J HALT






SUM	RESW 1
DIFF	RESW 1
PROD	RESW 1
QUOT	RESW 1
MOD	RESW 1

X	WORD 9
Y	WORD 10


