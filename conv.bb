Type letterlib 
	Field sta$
	Field enda$
End Type 



Function addlet2lib(let$,let2$)
	ll.letterlib = New letterlib
	ll\sta$ = let$
	ll\enda$ = let2$
End Function


Function SwypeLetter$(letter$)
	For ll.letterlib = Each letterlib
		If Lower(ll\sta$) =Lower(letter$)
			Print "swype : "+letter$+" rto:"+ll\enda$
			Return ll\enda$+" "
		EndIf 
	Next 
	Return letter$
End Function



bindstream=OpenFile("bind.txt")
While Not Exitcycle=1
	rawdata$=ReadLine(bindstream)
	rawdata2$=ReadLine(bindstream)
	If rawdata$="STOP"
		Exitcycle=1
	EndIf
	If Exitcycle=0
		addlet2lib(rawdata$,rawdata2$)
	state=1-state
EndIf 
	
	
Wend
CloseFile bindstream

OutStream=OpenFile("out.txt")
InputFile=OpenFile("Input.txt")

While Exitcycle=1
	
	rawdata$=Lower$(ReadLine(InputFile))
	If rawdata$="stop"
		Exitcycle=1
		Exit
	EndIf
	
	StringLen=Len(rawdata$) 
	Print StringLen
	ExtString$=""
	
	For i=1 To StringLen
		
		Print Mid (rawdata$,i,1)
		ExtString$=ExtString$+SwypeLetter$(Mid (rawdata$,i,1))
			
	Next
	WriteLine OutStream,ExtString$
	Print ExtString
Wend
CloseFile InputFile
CloseFile OutStream



;~IDEal Editor Parameters:
;~C#Blitz3D