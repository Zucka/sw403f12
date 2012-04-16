package nisse.main;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import nisse.analysis.DepthFirstAdapter;
import nisse.node.AAtKwd;
import nisse.node.ABackslashCharall;
import nisse.node.ABeblock;
import nisse.node.ABeblockv1;
import nisse.node.ABeginblock;
import nisse.node.ABlockBlocks;
import nisse.node.ACharCharall;
import nisse.node.ACharShortidentv1;
import nisse.node.ACharallPlainsv1;
import nisse.node.AColonCharall;
import nisse.node.AColonShortidentv1;
import nisse.node.ACommaCharall;
import nisse.node.ADigitCharall;
import nisse.node.ADigitShortidentv1;
import nisse.node.ADotCharall;
import nisse.node.ADotShortidentv1;
import nisse.node.AEndblock;
import nisse.node.AExclamationCharall;
import nisse.node.AFloatShortidentv1;
import nisse.node.AForwardslashCharall;
import nisse.node.AFslashShortidentv1;
import nisse.node.AItemlist;
import nisse.node.AItemlistItemlistv1;
import nisse.node.AItemlistLines;
import nisse.node.ANisse;
import nisse.node.ANumeration;
import nisse.node.ANumerationLines;
import nisse.node.ANumerationNumerationv1;
import nisse.node.APercentCharall;
import nisse.node.APlains;
import nisse.node.APlaintextItemlistv1;
import nisse.node.APlaintextLines;
import nisse.node.APlaintextNumerationv1;
import nisse.node.ASemicolonCharall;
import nisse.node.ASettingBlocks;
import nisse.node.ASettingLines;
import nisse.node.ASettingblock;
import nisse.node.AShortblock;
import nisse.node.AShortblockPlainsv1;
import nisse.node.AShortblockv1;
import nisse.node.AShortident;
import nisse.node.AShortidents;
import nisse.node.ASpaceCharall;
import nisse.node.AUrlKwd;
import nisse.node.Node;
import nisse.node.PShortidentv1;
import nisse.node.Start;

public class SemanticAnalyser extends DepthFirstAdapter {
	private int indent = 0;
	public SemanticAnalyser()
	{
		
	}
	public void defaultIn(Node node)
	{
		
	}
	public void defaultOut(Node node)
	{
		System.out.println(node.toString());
		System.out.println("UNCAPTURED ALTERNATIVE IN SEMANTIC ANALYSER");
	}
	public void printIndents()
	{
		String indents = "";
		for (int i = 0; i < indent; i++)
		{
			indents += "	";
		}
		System.out.print(indents);
	}
	public void inANisse (ANisse node)
	{
		printIndents();
		System.out.println("ANisse");
		indent++;
	}
	public void inABlockBlocks (ABlockBlocks node)
	{
		printIndents();
		System.out.println("ABlockBlocks");
		indent++;
	}
	public void inASettingblock (ASettingblock node)
	{
		printIndents();
		System.out.println("ASettingblock");
		indent++;
	}
	public void inABeginblock (ABeginblock node)
	{
		printIndents();
		System.out.println("ABeginblock");
		indent++;
	}
	public void inAPlaintextLines (APlaintextLines node)
	{
		printIndents();
		System.out.println("APlaintextLines");
		indent++;
	}
	public void inAEndblock (AEndblock node)
	{
		printIndents();
		System.out.println("AEndblock");
		indent++;
	}
	public void inABeblock (ABeblock node)
	{
		printIndents();
		System.out.println("ABeblock");
		indent++;
	}
	public void inABeblockv1 (ABeblockv1 node)
	{
		printIndents();
		System.out.println("ABeblockv1");
		indent++;
	}
	public void inAPlains (APlains node)
	{
		printIndents();
		System.out.println("APlains");
		indent++;
	}
	public void inAShortblockPlainsv1 (AShortblockPlainsv1 node)
	{
		printIndents();
		System.out.println("AShortblockPlainsv1");
		indent++;
	}
	public void inACharallPlainsv1 (ACharallPlainsv1 node)
	{
		printIndents();
		System.out.println("ACharallPlainsv1");
		indent++;
	}
	public void inAShortblock (AShortblock node)
	{
		printIndents();
		System.out.println("AShortblock");
		indent++;
	}
	public void inAShortblockv1 (AShortblockv1 node)
	{
		printIndents();
		System.out.println("AShortblockv1");
		indent++;
	}
	public void inAShortidents (AShortidents node)
	{
		printIndents();
		System.out.println("AShortidents");
		indent++;
	}
	public void inAShortident (AShortident node)
	{
		printIndents();
		System.out.println("AShortident");
		indent++;
	}
	public void inACharShortidentv1 (ACharShortidentv1 node)
	{
		printIndents();
		System.out.println("ACharShortidentv1");
		indent++;
	}
	public void inADigitShortidentv1 (ADigitShortidentv1 node)
	{
		printIndents();
		System.out.println("ADigitShortidentv1");
		indent++;
	}
	public void inADotShortidentv1 (ADotShortidentv1 node)
	{
		printIndents();
		System.out.println("ADotShortidentv1");
		indent++;
	}
	public void inAFloatShortidentv1 (AFloatShortidentv1 node)
	{
		printIndents();
		System.out.println("AFloatShortidentv1");
		indent++;
	}
	public void inAColonShortidentv1 (AColonShortidentv1 node)
	{
		printIndents();
		System.out.println("AColonShortidentv1");
		indent++;
	}
	public void inAFslashShortidentv1 (AFslashShortidentv1 node)
	{
		printIndents();
		System.out.println("AFslashShortidentv1");
		indent++;
	}
	public void inAAtKwd (AAtKwd node)
	{
		printIndents();
		System.out.println("AAtKwd");
		indent++;
	}
	public void inAUrlKwd (AUrlKwd node)
	{
		printIndents();
		System.out.println("AUrlKwd");
		indent++;
	}
	public void inStart (Start node)
	{
		printIndents();
		System.out.println("Start");
		indent++;
	}
	public void inAColonCharall (AColonCharall node)
	{
		printIndents();
		System.out.println("AColonCharall");
		indent++;
	}
	public void inADigitCharall (ADigitCharall node)
	{
		printIndents();
		System.out.println("ADigitCharall");
		indent++;
	}
	public void inASemicolonCharall (ASemicolonCharall node)
	{
		printIndents();
		System.out.println("ASemicolonCharall");
		indent++;
	}
	public void inAPercentCharall (APercentCharall node)
	{
		printIndents();
		System.out.println("APercentCharall");
		indent++;
	}
	public void inAForwardslashCharall (AForwardslashCharall node)
	{
		printIndents();
		System.out.println("AForwardslashCharall");
		indent++;
	}
	public void inABackslashCharall (ABackslashCharall node)
	{
		printIndents();
		System.out.println("ABackslashCharall");
		indent++;
	}
	public void inAExclamationCharall (AExclamationCharall node)
	{
		printIndents();
		System.out.println("AExclamationCharall");
		indent++;
	}
	public void inACharCharall (ACharCharall node)
	{
		printIndents();
		System.out.println("ACharCharall");
		indent++;
	}
	public void inASpaceCharall (ASpaceCharall node)
	{
		printIndents();
		System.out.println("ASpaceCharall");
		indent++;
	}
	public void inADotCharall (ADotCharall node)
	{
		printIndents();
		System.out.println("ADotCharall");
		indent++;
	}
	public void inACommaCharall (ACommaCharall node)
	{
		printIndents();
		System.out.println("ACommaCharall");
		indent++;
	}
	public void inANumeration (ANumeration node)
	{
		printIndents();
		System.out.println("ANumeration");
		indent++;
	}
	public void inAPlaintextNumerationv1 (APlaintextNumerationv1 node)
	{
		printIndents();
		System.out.println("APlaintextNumerationv1");
		indent++;
	}
	public void inANumerationNumerationv1 (ANumerationNumerationv1 node)
	{
		printIndents();
		System.out.println("ANumerationNumerationv1");
		indent++;
	}
	public void inAItemlist (AItemlist node)
	{
		printIndents();
		System.out.println("AItemlist");
		indent++;
	}
	public void inAPlaintextItemlistv1 (APlaintextItemlistv1 node)
	{
		printIndents();
		System.out.println("APlaintextItemlistv1");
		indent++;
	}
	public void inAItemlistItemlistv1 (AItemlistItemlistv1 node)
	{
		printIndents();
		System.out.println("AItemlistItemlistv1");
		indent++;
	}
	public void inANumerationLines (ANumerationLines node)
	{
		printIndents();
		System.out.println("ANumerationLines");
		indent++;
	}
	public void inAItemlistLines (AItemlistLines node)
	{
		printIndents();
		System.out.println("AItemlistLines");
		indent++;
	}
	public void inASettingLines (ASettingLines node)
	{
		printIndents();
		System.out.println("ASettingLines");
		indent++;
	}
	public void inASettingBlocks (ASettingBlocks node)
	{
		printIndents();
		System.out.println("ASettingBlocks");
		indent++;
	}
	public void outANisse (ANisse node)
	{
		indent--;
	}
	public void outASettingblock (ASettingblock node)
	{
		String Scope = node.getChar().toString().trim();
		if (Scope.equals("global") || Scope.equals("text") || Scope.equals("title") || Scope.equals("image")){
		}
		else{
			System.out.println("FEJL, Keyworded " + Scope + " existere ikke");
		}
		indent--;
	}
	public void outABlockBlocks (ABlockBlocks node)
	{
		try{
		String First =node.getLines().getFirst().toString();
		String Last =node.getLines().getLast().toString();
		String Firstsub = First.substring(0, 6);
		String Lastsub = Last.substring(0, 9);
		if (Firstsub.equals("@title")){
		//	System.out.println("Det findes en titel");
			if (Lastsub.equals("@subtitle")){
				System.out.println("Dette er en titel side");
			}
			else if (Last.equals(First)){
				System.out.println("Dette er en titel side uden undertitel");
			}
			else {
		//		System.out.println("Dette er ikke en titel side");
			}
		}
		else{
		//	System.out.println("Der findes ingen titel");
		}
		}
		catch(Exception a){
			System.out.println("Dette er ikke en title slide");
			System.out.println("Da den første og/eller sidste linje højest sandsynlig er mindre end 8 chars lang");
		}
		indent--;
		
	}
	public void outABeginblock (ABeginblock node)
	{
		indent--;
	}
	public void outAPlaintextLines (APlaintextLines node)
	{
		indent--;
	}
	public void outAEndblock (AEndblock node)
	{
		indent--;
	}
	public void outABeblock (ABeblock node)
	{
		String Parent = node.parent().toString();
		String Char = node.getChar().toString().trim();
		if (Parent.compareTo("@begin") > 5){	   // ved en begin block		
			if (Char.equals("slide")){      // i tilfælde af at der ikke er nogen transition
			}
			else if (Char.equals("fade")) {    // Transition
			}
			else{
				System.out.println("Fejl, Transition findes ikke. Eller slide er ikke skrevet i begin");
			}
		}
		else if (Parent.compareTo("@end") > 4){    // ved en end block
			if (Char.equals("slide")){
			}
			else{
				System.out.println("Fejl, der skal stå slide imellem de 2 curly brackets i end");
			}
		}
		indent--;
	}
	public void outABeblockv1 (ABeblockv1 node)
	{
		indent--;
	}
	public void outAPlains (APlains node)
	{
		indent--;
	}
	public void outAShortblockPlainsv1 (AShortblockPlainsv1 node)
	{
		indent--;
	}
	public void outACharallPlainsv1 (ACharallPlainsv1 node)
	{
		indent--;
	}
	public void outAShortblock (AShortblock node)
	{
		indent--;
	}
	public void outAShortblockv1 (AShortblockv1 node)
	{
		indent--;
	}
	public void outAShortidents (AShortidents node)
	{
		indent--;
	}
	public void outAShortident (AShortident node)
	{
		StringBuilder builder = new StringBuilder();
		for (PShortidentv1 p : node.getShortidentv1())
		{
			builder.append(p.toString());
		}
		String Value = builder.toString();
		String Kwd1 = node.getKwd().toString().trim();
		if (Kwd1.equals("@ font_color") || Kwd1.equals("@ font_bg_color") || Kwd1.equals("@ font_family") || Kwd1.equals("@ font_weight") || Kwd1.equals("@url")){	
		}
		else if (Kwd1.equals("@ font_size")){
			try{
			int val = Integer.parseInt(Value);
			} catch(Exception a){
				System.out.println("FEJL, font_size kan ikke konverteres til en int");
			}
		}
		else if (Kwd1.equals("@ font_lineheight")){
			try{
			double val = Double.parseDouble(Value);
			}
			catch(Exception a){
				System.out.println("FEJL, lineheight kan ikke konverteres til en double");
			}
		}
		else {
			System.out.println("FEJL, Keyworded " + Kwd1 + " existere ikke");
		}
		indent--;
	}
	public void outACharShortidentv1 (ACharShortidentv1 node)
	{
		indent--;
	}
	public void outADigitShortidentv1 (ADigitShortidentv1 node)
	{
		indent--;
	}
	public void outADotShortidentv1 (ADotShortidentv1 node)
	{
		indent--;
	}
	public void outAFloatShortidentv1 (AFloatShortidentv1 node)
	{
		indent--;
	}
	public void outAColonShortidentv1 (AColonShortidentv1 node)
	{
		indent--;
	}
	public void outAFslashShortidentv1 (AFslashShortidentv1 node)
	{
		indent--;
	}
	public void outAAtKwd (AAtKwd node)
	{
		indent--;
	}
	public void outAUrlKwd (AUrlKwd node)
	{
		indent--;
	}
	public void outStart (Start node)
	{
		indent--;
		printIndents();
		System.out.println("EOF");
	}
	public void outAColonCharall (AColonCharall node)
	{
		indent--;
	}
	public void outADigitCharall (ADigitCharall node)
	{
		indent--;
	}
	public void outASemicolonCharall (ASemicolonCharall node)
	{
		indent--;
	}
	public void outAPercentCharall (APercentCharall node)
	{
		indent--;
	}
	public void outAForwardslashCharall (AForwardslashCharall node)
	{
		indent--;
	}
	public void outABackslashCharall (ABackslashCharall node)
	{
		indent--;
	}
	public void outAExclamationCharall (AExclamationCharall node)
	{
		indent--;
	}
	public void outACharCharall (ACharCharall node)
	{
		indent--;
	}
	public void outASpaceCharall (ASpaceCharall node)
	{
		indent--;
	}
	public void outADotCharall (ADotCharall node)
	{
		indent--;
	}
	public void outACommaCharall (ACommaCharall node)
	{
		indent--;
	}
	public void outANumeration (ANumeration node)
	{
		indent--;
	}
	public void outAPlaintextNumerationv1 (APlaintextNumerationv1 node)
	{
		indent--;
	}
	public void outANumerationNumerationv1 (ANumerationNumerationv1 node)
	{
		indent--;
	}
	public void outAItemlist (AItemlist node)
	{
		indent--;
	}
	public void outAPlaintextItemlistv1 (APlaintextItemlistv1 node)
	{
		indent--;
	}
	public void outAItemlistItemlistv1 (AItemlistItemlistv1 node)
	{
		indent--;
	}
	public void outANumerationLines (ANumerationLines node)
	{
		indent--;
	}
	public void outAItemlistLines (AItemlistLines node)
	{
		indent--;
	}
	public void outASettingLines (ASettingLines node)
	{
		indent--;
	}
	public void outASettingBlocks (ASettingBlocks node)
	{
		indent--;
	}
	
}
