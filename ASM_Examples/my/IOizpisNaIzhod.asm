	LDA CRKAB
	JSUB ECHOCH
	
	JSUB ECHONL
	JSUB ECHONL
	
	LDA #BSEDIU
	JSUB ECHOSTR
	
	LDA #969	
	JSUB ECHONUM




HALT	J HALT

OUTPUT	BYTE 1
CRKAB	WORD	X'000042'
NEWLN	WORD X'00000a'	
BSEDIU	WORD C'paprika', C'\0'
.PLAC ZA SHRANIT REGISTRE
REGSTS	RESW 1
REGSTT	RESW 1
REGSTX	RESW 1
REGSTA	RESW 1

ECHOCH	WD OUTPUT
	RSUB


ECHONL	STA REGSTA
RDYLOOP	TD OUTPUT
        JEQ RDYLOOP
	LDA NEWLN
	WD OUTPUT
	LDA REGSTA
	RSUB
	


ECHOSTR	STA ADDRS
	STX REGSTX
	LDX ADDRS
	
LOOP	TD OUTPUT
	JEQ LOOP
	STX OUT
	LDCH @OUT
	COMP #0
	JEQ EXITT
	WD OUTPUT
	TIX #0
	J LOOP
		
EXITT	LDA ADDRS
	LDX REGSTX
	RSUB
	
ADDRS	RESW 1
OUT	RESW 1


ECHONUM	STA NUM
	STA REGSTA
	STS REGSTS
	STT REGSTT
	STX REGSTX
	LDS #0
	LDX #0

LOO	LDT NUM
	LDA NUM
	COMPR T,S
	JEQ IZPIS
	DIV #10
	MUL #10
	SUBR A,T
	DIV #10
	STA NUM
	LDA #0
	ADDR T,A
	STCH BUFFER,X
	TIX #0
	J LOO
	
IZPIS	LDT #1
	SUBR T,X

IZLOOP	SUBR T,X
	TIX #0
	JLT EXIT
	LDCH BUFFER,X
	ADD #48
	WD OUTPUT
	SUB #48	
	SUBR T,X
	J IZLOOP
EXIT	LDA REGSTA
	LDS REGSTS
	LDT REGSTT
	LDX REGSTX	
	
	RSUB		


NUM	RESW 1
BUFFER 	RESW 100











	
