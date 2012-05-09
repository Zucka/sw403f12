package nisse.main;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

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
import nisse.node.AShortident;
import nisse.node.AShortidents;
import nisse.node.ASpaceCharall;
import nisse.node.AUrlKwd;
import nisse.node.Node;
import nisse.node.PPlainsv1;
import nisse.node.PShortidentv1;
import nisse.node.Start;
import nisse.node.TChar;

public class SemanticAnalyser extends DepthFirstAdapter {
	private int indent = 0;
	
	public SemanticAnalyser()
	{
		
	}
	public void defaultIn(Node node)
	{
		if (Main.NodesB == true ){
			System.out.println(node.getClass().getName());
			System.out.println(node.toString());
			System.out.println("UNCAPTURED ALTERNATIVE IN SEMANTIC ANALYSER");
		}
		Error.MakeError("UNCAPTURED ALTERNATIVE IN SEMANTIC ANALYSER", "defaultin");
	}
	public void defaultOut(Node node)
	{
		if (Main.NodesB == true ){
			System.out.println(node.getClass().getName());
			System.out.println(node.toString());
			System.out.println("UNCAPTURED ALTERNATIVE IN SEMANTIC ANALYSER");
		}
		Error.MakeError("UNCAPTURED ALTERNATIVE IN SEMANTIC ANALYSER", "defaultout");
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
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ANisse");
		}
		indent++;
	}
	public void inABlockBlocks (ABlockBlocks node)
	{
		if (Main.NodesB == true ){	
		printIndents();
		System.out.println("ABlockBlocks");
		}
		indent++;
	}
	public boolean CheckColor(String Value){
		if (Value.startsWith("brown")){
			return true;
		}
		else if (Value.startsWith("blue")){
			return true;
		}
		else if (Value.startsWith("black")){
			return true;
		}
		else if (Value.startsWith("red")){
			return true;
		}
		else if (Value.startsWith("teal")){
			return true;
		}
		else if (Value.startsWith("pink")){
			return true;
		}
		else if (Value.startsWith("cyan")){
			return true;
		}
		else if (Value.startsWith("grey")){
			return true;
		}
		else if (Value.startsWith("gray")){
			return true;
		}
		else if (Value.startsWith("violet")){
			return true;
		}
		else if (Value.startsWith("yellow")){
			return true;
		}
		else if (Value.startsWith("green")){
			return true;
		}
		else if (Value.startsWith("indigo")){
			return true;
		}
		else if (Value.startsWith("lime")){
			return true;
		}
		else if (Value.startsWith("navy")){
			return true;
		}
		else if (Value.startsWith("purple")){
			return true;
		}
		else {
		return false;
		}
	}
	
	public void inASettingblock (ASettingblock node)
	{
		
		String SettingType = node.getShortident().toString().trim();
		
		String Visability = node.getChar().toString().trim();
		//System.out.println(SettingType);
		//String Test = node.parent().parent().toString();
		//String Test1 = Test.substring(0, 6);
		String Test = node.parent().parent().getClass().toString();
		//System.out.println(Test);
		//ved lokal setting ændring
		if (Test.equals("class nisse.node.ABlockBlocks")){
			System.out.println("Dette er en lokal variabel");
			if (SettingType.startsWith("@ font _ color")){
				String Value = SettingType.substring(17);
				Boolean CheckColor1;
				CheckColor1 = CheckColor(Value);
				if (CheckColor1 == true){
					//	System.out.println("Font color value = " + Value);
					if (Visability.equals("global")){
						//		System.out.println("Dette er global Visability");
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor] = Value;
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
					}
					else if (Visability.equals("text")){
						//		System.out.println("Dette er text Visability");
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
					}
					else if (Visability.equals("image")){
						//		System.out.println("Dette er image Visability");
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;
					}
					else if (Visability.equals("title")){
						//		System.out.println("Dette er title Visability");
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
					}
					else if (Visability.equals("subtitle")){
						//		System.out.println("Dette er subtitle Visability");
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
					}
					else if (Visability.equals("url")){
						//		System.out.println("Dette er url Visability");
						SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
					}
					else {
						Error.MakeError("Visiblity existance" , Value);
			    	    //System.out.println("Visability word not recognized");
			    	  }
				}
				else {
					Error.MakeError("Font color existance" , Value);
					//System.out.println("Font color:" + Value + "could not be found, try a different one, or write only with small ");
				}
			}
			else if (SettingType.startsWith("@ font _ family")){	
				String Value = SettingType.substring(18);
			//	System.out.println("Font color value = " + Value);
				
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
			}
			else if (SettingType.startsWith("@ font _ weight")){	
				String Value = SettingType.substring(18);
				Value = Value.substring(0, 1);
				//System.out.println("Font color value = " + Value);
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = Value;
				}
				else if (Visability.equals("image")){
					//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
			}
			
			else if (SettingType.startsWith("@ font _ size")){
				String Value = SettingType.substring(16);
			//	System.out.println("Font size value = " + Value);
				try{
				int val = Integer.parseInt(Value);
				} catch(Exception a){
					Error.MakeError("Convert to int" , Value);
					//System.out.println("FEJL, font _ size "+ Value + " kan ikke konverteres til en int");
				}
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
			}
			else if (SettingType.startsWith("@ font _ lineheight")){
				String Value = SettingType.substring(22);
			//	System.out.println("Font lineheight value = " + Value);
				try{
				double val = Double.parseDouble(Value);
				}
				catch(Exception a){
					Error.MakeError("Convert to double" , Value);
					//System.out.println("FEJL, lineheight kan ikke konverteres til en double");
				}
				
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
				
			}
		}
		//VED GLOBAL SETTING ÆNDRING
		else {
			//	System.out.println("Dette er global Setting");
			if (SettingType.startsWith("@ font _ color")){
				String Value = SettingType.substring(17);
				//	System.out.println("Font color value = " + Value);
				Boolean CheckColor1;
				CheckColor1 = CheckColor(Value);
				if (CheckColor1 == true){
					
					if (Visability.equals("global")){
						//		System.out.println("Dette er global Visability");
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontColor] = Value;
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontColor] = Value;
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontColor] = Value;
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontColor] = Value;
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontColor] = Value;

					}
					else if (Visability.equals("text")){
						//		System.out.println("Dette er text Visability");
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontColor] = Value;
					}
					else if (Visability.equals("image")){
						//		System.out.println("Dette er image Visability");
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontColor] = Value;
					}
					else if (Visability.equals("title")){
						//		System.out.println("Dette er title Visability");
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontColor] = Value;
					}
					else if (Visability.equals("subtitle")){
						//		System.out.println("Dette er subtitle Visability");
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontColor] = Value;
					}
					else if (Visability.equals("url")){
						//		System.out.println("Dette er url Visability");
						SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontColor] = Value;
					}
					else {
						Error.MakeError("Visiblity existance" , Value);
						//System.out.println("Visability word not recognized");
					}
				}
				else {
					Error.MakeError("Font color existance" , Value);
					//System.out.println("Font color:" + Value + "could not be found, try a different one, or write only with small ");
				}


			}
			else if (SettingType.startsWith("@ font _ family")){	
				String Value = SettingType.substring(18);
			//	System.out.println("Font color value = " + Value);
				
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontFamily] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontFamily] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontFamily] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontFamily] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontFamily] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontFamily] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontFamily] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
				
			}
			else if (SettingType.startsWith("@ font _ weight")){	
				String Value = SettingType.substring(18);
			//	System.out.println("Font color value = " + Value);
				Value = Value.substring(0, 1);
				//System.out.println("Font weight value = " + Value);
				if (Visability.equals("global")){
					//System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontWeight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontWeight] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontWeight] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontWeight] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontWeight] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontWeight] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontWeight] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
				
			}
			
			else if (SettingType.startsWith("@ font _ size")){
				String Value = SettingType.substring(16);
			//	System.out.println("Font size value = " + Value);
				try{
				int val = Integer.parseInt(Value);
		//		NewTextFontSize = val;
				} catch(Exception a){
					Error.MakeError("Convert to int" , Value);
					//System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontSize] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontSize] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontSize] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontSize] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontSize] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontSize] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontSize] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontSize] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontSize] = Value;
				}
				else if (Visability.equals("url")){
					System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontSize] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
				
			}
			else if (SettingType.startsWith("@ font _ lineheight")){
				String Value = SettingType.substring(22);
			//	System.out.println("Font lineheight value = " + Value);
				try{
				double val = Double.parseDouble(Value);
				}
				catch(Exception a){
					Error.MakeError("Convert to double" , Value);
					//System.out.println("FEJL, lineheight kan ikke konverteres til en double");
				}
				
				if (Visability.equals("global")){
			//		System.out.println("Dette er global Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontLineheight] = Value;
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontLineheight] = Value;
				}
				else if (Visability.equals("text")){
			//		System.out.println("Dette er text Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontLineheight] = Value;
				}
				else if (Visability.equals("image")){
			//		System.out.println("Dette er image Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontLineheight] = Value;
				}
				else if (Visability.equals("title")){
			//		System.out.println("Dette er title Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontLineheight] = Value;
				}
				else if (Visability.equals("subtitle")){
			//		System.out.println("Dette er subtitle Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontLineheight] = Value;
				}
				else if (Visability.equals("url")){
			//		System.out.println("Dette er url Visability");
					SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontLineheight] = Value;
				}
				else {
					Error.MakeError("Visiblity existance" , Value);
		    	    //System.out.println("Visability word not recognized");
		    	  }
			}
		}
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ASettingblock");
		}
		indent++;
	}
	public void inABeginblock (ABeginblock node)
	{
		SymbolTable.OpenScope();
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ABeginblock");
		}
		indent++;
	}
	public void inAPlaintextLines (APlaintextLines node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("APlaintextLines");
		}
		indent++;
	}
	public void inAEndblock (AEndblock node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("AEndblock");
		}
		indent++;
	}
	public void inABeblock (ABeblock node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ABeblock");
		}
		indent++;
	}
	public void inABeblockv1 (ABeblockv1 node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ABeblockv1");
		}
		indent++;
	}
	public void inAPlains (APlains node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("APlains");
		}
		indent++;
		
	}
	public void inAShortblockPlainsv1 (AShortblockPlainsv1 node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("AShortblockPlainsv1");
		}
		indent++;
	}
	
	public int CheckThanAdd(String Text, String Parentx3, String Parent, String Parentx2){
		if (Parent.startsWith("@apply { @url") && Parentx3.startsWith("@image")){
			SymbolTable.SymbolTableAdd(Text, "imagetext", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight]);
			return 1;
		} 
		else if (Parent.startsWith("@apply { @url") && Parentx3.startsWith("@title")){
			SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);

			return 1;
		} 
		else if (Parent.startsWith("@apply { @url") && Parentx3.startsWith("@subtitle")){
			SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
	
			return 1;
		} 
		else if (Parent.startsWith("@apply { @url") && Parentx3.startsWith("@begin")){
			SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
	
			return 1;
		} 		
		else if (Parentx2.startsWith("@begin")){
			SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight]);
			return 1;
		}
		else if (Parentx2.startsWith("@title")){
			SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]);
			return 1;
		}
		else if (Parentx2.startsWith("@subtitle")){
			SymbolTable.SymbolTableAdd(Text, "subtitle", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight]);
			return 1;
		}
		else if (Parentx2.startsWith("@image")){
			SymbolTable.SymbolTableAdd(Text, "imagetext", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
			return 1;
		}
		
		else {
		return 0;
		}
	}
	

	
	public void inACharallPlainsv1 (ACharallPlainsv1 node)
	{
		String Text = node.toString();
		int j = Text.length();
		Text = Text.substring(0, j - 1);
		
		String Parent = node.parent().toString();
		String Parentx2 = node.parent().parent().toString();
		
		int Check = CheckThanAdd(Text, "empty" ,"empty" , Parentx2);
		
		if (Check == 1){
		}
		else {
			String Parentx3 = node.parent().parent().parent().toString();
			Check = CheckThanAdd(Text, "empty", "empty" , Parentx3);
			if (Check == 1){
			}
			else {
				String Parentx4 = node.parent().parent().parent().parent().toString();
				String Parentx5 = node.parent().parent().parent().parent().parent().toString();
				Check = CheckThanAdd(Text, Parentx5, Parent, Parentx4);
				if (Check == 1){
				}
				else {
					String Parentx6 = node.parent().parent().parent().parent().parent().parent().toString();
					Check = CheckThanAdd(Text, Parentx6, Parentx2, Parentx5);
					if (Check == 1){
					}
					else {
						String Parentx7 = node.parent().parent().parent().parent().parent().parent().parent().toString();
						Check = CheckThanAdd(Text, Parentx7, Parentx3, Parentx6);
						if (Check == 1){
						}
						else {
							String Parentx8 = node.parent().parent().parent().parent().parent().parent().parent().parent().toString();
							Check = CheckThanAdd(Text, Parentx8, Parentx4, Parentx7);
							if (Check == 1){
							}
							else {
								String Parentx9 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
								Check = CheckThanAdd(Text, Parentx9, Parentx5, Parentx8);
								if (Check == 1){
								}
								else {
									String Parentx10 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
									Check = CheckThanAdd(Text, Parentx10, Parentx6, Parentx9);
									if (Check == 1){
									}
									else {
										String Parentx11 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
										Check = CheckThanAdd(Text, Parentx11, Parentx7, Parentx10);
										if (Check == 1){
										}
										else {
											String Parentx12 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
											Check = CheckThanAdd(Text, Parentx12, Parentx8, Parentx11);
											if (Check == 1){

											}
											else {
												String Parentx13 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
												Check = CheckThanAdd(Text, Parentx13, Parentx9, Parentx12);

												if (Check == 1){

												}
												else {
													String Parentx14 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
													Check = CheckThanAdd(Text, Parentx14, Parentx10, Parentx13);

													if (Check == 1){

													}
													else {
														String Parentx15 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
														Check = CheckThanAdd(Text, Parentx15, Parentx11, Parentx14);

														if (Check == 1){
														}
														else {
															String Parentx16 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
															Check = CheckThanAdd(Text, Parentx16, Parentx12, Parentx15);
															//System.out.println(Parentx16);
															//System.out.println(Parentx12);
															//System.out.println(Text);
															if (Check == 1){
															}
															else {
																/*String Parentx17 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
																	Check = CheckThanAdd(Text, Parentx17, Parentx15);
																	if (Check == 1){
																	}
																	else {
																		String Parentx18 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
																		Check = CheckThanAdd(Text, Parentx18, Parentx16);
																		if (Check == 1){
																		}
																		else {
																			String Parentx19 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
																			Check = CheckThanAdd(Text, Parentx19, Parentx17);
																			if (Check == 1){
																			}
																			else {
																				String Parentx20 = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
																				Check = CheckThanAdd(Text, Parentx20, Parentx18);
																				if (Check == 1){
																				}
																				else { */
																System.out.println("Text type could not be found");
																System.out.println("Text " + Text);
																/*}
																			}
																		}
																	} */
															}
														} 

													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
				

			
		  
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ACharallPlainsv1");
		} indent++;
	}
	
	public String TakeValue(String SettingType, int start){
		String Value = SettingType.substring(start).trim();
		int Length = Value.length() - 1;
		Value = Value.substring(0, Length).trim();
		return Value;
	}
	
	public void inAShortblock (AShortblock node)
	{
		SymbolTable.OpenScope();
		String FormatKwd = node.getFormatKwd().toString();
		//System.out.println(FormatKwd);
		//String Parent = node.parent().toString();
		//System.out.println("Shortblock parent= " + Parent);
		//String SettingType = node.getShortidents().toString();
		String Value = "invalid";
		
	//	System.out.println("Shortident Type = " + Type);
	//	System.out.println(SettingType + " First");
	//	System.out.println(Value + " Second");
		
	//	'@u' | '@b' | '@i' | '@apply' | '@image' | '@title' | '@subtitle' | '@note' ;
		if (FormatKwd.startsWith("@setting")){
			// bliver bearbejdet af Setting
		}
		else if (FormatKwd.startsWith("@apply")){

		} 
		else if (FormatKwd.startsWith("@i ")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + "i";

		}
		else if (FormatKwd.startsWith("@u ")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + "u";


		}
		else if (FormatKwd.startsWith("@b ")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + "b";


		}
		else if (FormatKwd.startsWith("@image")){
			
		}
		else if (FormatKwd.startsWith("@title")){

		}
		else if (FormatKwd.startsWith("@subtitle")){

		}
		else if (FormatKwd.startsWith("@note")){
			
		}
		else{
			System.out.println("Format Keyword:" + FormatKwd + " ikke fundet");
		}
		
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("AShortblock");
		} indent++;
	}
	public void inAShortidents (AShortidents node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("AShortidents");
		} indent++;
	}
	public void inAShortident (AShortident node)
	{		
		String SettingType = node.getKwd().toString().trim();
		String IfSetting = node.parent().parent().toString().trim();
	//	System.out.println(IfSetting);
	//	System.out.println(SettingType);
		int Length1 = node.getShortidentv1().size();
		Object[] Value1 = node.getShortidentv1().toArray();
		
				
		int i = 0;
		String Value = "";
		for(i=0; i<Length1; i++){
			Value = Value + Value1[i].toString().trim();
		}    
		//String Value = node.getShortidentv1().toString().trim();
	//	int Length = Value.length() - 1;
	//	Value = Value.substring(1, Length).trim();
	//	System.out.println(Value);
		try{
		if (IfSetting.startsWith("@setting { @ transition")){
			if (Value.startsWith("slide")){
				SymbolTable.Transition = Value;
			}
			else if (Value.startsWith("fade")){
				SymbolTable.Transition = Value;
			}
			else if (Value.startsWith("swipe")){
				SymbolTable.Transition = Value;
			}
			else if (Value.startsWith("scale")){
				SymbolTable.Transition = Value;
			}
			else if (Value.startsWith("rotatescale")){
				SymbolTable.Transition = Value;
			}
			else {
				System.out.println("Transition:" + Value + " in @setting not found");
			}
			
		}
		else if (IfSetting.startsWith("@setting")){
			
		}
		else if (SettingType.startsWith("@ font _ family")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
		}
		else if (SettingType.startsWith("@ font _ color")){
			Boolean CheckColor1;
			CheckColor1 = CheckColor(Value);
			if (CheckColor1 == true){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;
			}
			else {
				System.out.println("Font color:" + Value + "could not be found, try a different one, or write only with small ");
			}
		}
		else if (SettingType.startsWith("@ font _ size")){
			try{
				int val = Integer.parseInt(Value);
			} catch(Exception a){
				Error.MakeError("Convert to int" , Value);
				//System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
			}
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
		}
		else if (SettingType.startsWith("@ font _ weight")){
			//Value = SettingType.substring(16);
			Value = Value.substring(0, 1);
			//System.out.println("Font weight value1 = " + Value);
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;
		}
		else if (SettingType.startsWith("@ font _ lineheight")){
			try{
				double val = Double.parseDouble(Value);
				}
				catch(Exception a){
					Error.MakeError("Convert to double" , Value);
					//System.out.println("FEJL, lineheight kan ikke konverteres til en double");
				}
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;
		}
		else if (SettingType.startsWith("@url")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink] = Value;
		//	System.out.println(Value);
		}
		
		if (IfSetting.startsWith("@image") && SettingType.startsWith("@url")){
			SymbolTable.SymbolTableAdd("", "image", "", "", "", "", "", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
		}
		} catch (Exception a){
			//System.out.println("Ingen Settingtype ændringer i @apply");
		}
		
		
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("AShortident");
		} indent++;
	}
	public void inACharShortidentv1 (ACharShortidentv1 node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ACharShortidentv1");
		} indent++;
	}
	public void inADigitShortidentv1 (ADigitShortidentv1 node)
	{
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("ADigitShortidentv1");
		} indent++;
	}
	public void inADotShortidentv1 (ADotShortidentv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ADotShortidentv1");
		} indent++;
	}
	public void inAFloatShortidentv1 (AFloatShortidentv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AFloatShortidentv1");
		} indent++;
	}
	public void inAColonShortidentv1 (AColonShortidentv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AColonShortidentv1");
		} indent++;
	}
	public void inAFslashShortidentv1 (AFslashShortidentv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AFslashShortidentv1");
		} indent++;
	}
	public void inAAtKwd (AAtKwd node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AAtKwd");
		} indent++;
	}
	public void inAUrlKwd (AUrlKwd node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AUrlKwd");
		} indent++;
	}
	public void inStart (Start node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("Start");
		} indent++;
	}
	public void inAColonCharall (AColonCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AColonCharall");
		} indent++;
	}
	public void inADigitCharall (ADigitCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ADigitCharall");
		} indent++;
	}
	public void inASemicolonCharall (ASemicolonCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ASemicolonCharall");
		} indent++;
	}
	public void inAPercentCharall (APercentCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("APercentCharall");
		} indent++;
	}
	public void inAForwardslashCharall (AForwardslashCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AForwardslashCharall");
		} indent++;
	}
	public void inABackslashCharall (ABackslashCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ABackslashCharall");
		} indent++;
	}
	public void inAExclamationCharall (AExclamationCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AExclamationCharall");
		} indent++;
	}
	public void inACharCharall (ACharCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ACharCharall");
		} indent++;
	}
	public void inASpaceCharall (ASpaceCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ASpaceCharall");
		} indent++;
	}
	public void inADotCharall (ADotCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ADotCharall");
		} indent++;
	}
	public void inACommaCharall (ACommaCharall node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ACommaCharall");
		} indent++;
	}
	public void inANumeration (ANumeration node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ANumeration");
		} indent++;
	}
	public void inAPlaintextNumerationv1 (APlaintextNumerationv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("APlaintextNumerationv1");
		} indent++;
	}
	public void inANumerationNumerationv1 (ANumerationNumerationv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ANumerationNumerationv1");
		} indent++;
	}
	public void inAItemlist (AItemlist node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AItemlist");
		} indent++;
	}
	public void inAPlaintextItemlistv1 (APlaintextItemlistv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("APlaintextItemlistv1");
		} indent++;
	}
	public void inAItemlistItemlistv1 (AItemlistItemlistv1 node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AItemlistItemlistv1");
		} indent++;
	}
	public void inANumerationLines (ANumerationLines node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ANumerationLines");
		} indent++;
	}
	public void inAItemlistLines (AItemlistLines node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("AItemlistLines");
		} indent++;
	}
	public void inASettingLines (ASettingLines node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ASettingLines");
		} indent++;
	}
	public void inASettingBlocks (ASettingBlocks node)
	{
		if (Main.NodesB == true ){ printIndents();
		System.out.println("ASettingBlocks");
		} indent++;
	}
	public void outANisse (ANisse node)
	{
		indent--;
	}
	public void outASettingblock (ASettingblock node)
	{
		String Scope = node.getChar().toString().trim();
		if (Scope.equals("global") || Scope.equals("text") || Scope.equals("title") || Scope.equals("image") || Scope.equals("subtitle") || Scope.equals("url")){
		}
		else{
			Error.MakeError("Scope doesn't exist" , Scope);
			//System.out.println("FEJL, Keyworded " + Scope + " existere ikke");
		}
		indent--;
	}
	public void outABlockBlocks (ABlockBlocks node)
	{
		
	//	SymbolTable.SymbolTableAdd("hej", "Type", 6, "FontFamily", "FontColor", 6, "FontWeight", null, null);
	//	SymbolTable.PrintSymbolTable();
		//System.out.println("First1 = " + node.getLines().getFirst());
		//System.out.println(SymbolTable.Transition);
		String Transition = node.getBeginblock().toString();
		Transition = Transition.substring(9);
		//System.out.println(Transition);
		String Transition1 = "none";
		if (Transition.startsWith("slide")){
			Transition1 = SymbolTable.Transition;
		}
		else if (Transition.startsWith("fade")){
			Transition1 = "fade";
		}
		else if (Transition.startsWith("swipe")){
			Transition1 = "swipe";
		}
		else if (Transition.startsWith("scale")){
			Transition1 = "scale";
		}
		else if (Transition.startsWith("rotatescale")){
			Transition1 = "rotatescale";
		}
/*		try{
		String First =node.getLines().getFirst().toString();
		String Last =node.getLines().getLast().toString();
		}
		catch(Exception a){
			//System.out.println("Slided er tomt");
			indent--;
			return;
		}   */
		String SlideType = "Unknown";
		Object[] Slide = node.getLines().toArray();
		int Lines = Slide.length;
		int i = 0;
		int title = 0;
		int subtitle = 0;
		int image = 0;
		for (i=0; i<Lines; i++){
			String Slide1 = Slide[i].toString();
			if (Slide1.startsWith("@setting")  ||  Slide1.startsWith("@note")){
			}
			else if (Slide1.startsWith("@title") ) {
				title++;
			}
			else if (Slide1.startsWith("@subtitle") ) {
				subtitle++;
			}
			else if (Slide1.startsWith("@image") ) {
				image++;
			}
			else {
				SlideType = "Normal";
				SymbolTable.SlideTableAdd(SlideType, Transition1);
				indent--;
				return;
			}
			
		}
		if (title > 0 && subtitle == 0 && image == 0){
			SlideType = "Title";
		}
		else if (title > 0 && subtitle > 0 && image == 0){
			SlideType = "TitleWithSubtitle";
		}
		else if (image > 0){
			SlideType = "Image";
		}
			

		SymbolTable.SlideTableAdd(SlideType, Transition1);
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
		SymbolTable.CloseScope();
		//SymbolTable.PrintSymbolTable();
		indent--;
	}
	public void outABeblock (ABeblock node)
	{

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
		SymbolTable.CloseScope();
		indent--;
	}
	public void outAShortidents (AShortidents node)
	{
		indent--;
	}

	public int CheckType(APlains node){
		
		String Parent = node.parent().toString();
		System.out.println(Parent);
		if (Parent.startsWith("@setting")){
			return 6;
		}
		else if (Parent.startsWith("@begin")){
			return 5;
		}
		else if (Parent.startsWith("@apply")){
			return 5;
		}
		else if (Parent.startsWith("@title")){
		return 1;
		}
		else if (Parent.startsWith("@subtitle")){
		return 2;
		}
		else if (Parent.startsWith("@image")){
		return 3;
		}
		else if (Parent.startsWith("@note")){
		return 4;
		}
		else {
			String Parent1 = node.parent().parent().toString();
			if (Parent1.startsWith("@title")){
				return 1;
			}
			else if (Parent1.startsWith("@subtitle")){
				return 2;
			}
			else if (Parent1.startsWith("@image")){
				return 3;
			}
			else if (Parent1.startsWith("@note")){
				return 4;
			}
			else {
				String Parent2 = node.parent().parent().parent().toString();
				if (Parent2.startsWith("@title")){
					return 1;
				}
				else if (Parent2.startsWith("@subtitle")){
					return 2;
				}
				else if (Parent2.startsWith("@image")){
					return 3;
				}
				else if (Parent2.startsWith("@note")){
					return 4;
				}
			}
		}
		return 0;
		
	}
	
	
public int CheckType1(AShortident node){
		
		String Parent = node.parent().toString();
		System.out.println(Parent);
		if (Parent.startsWith("@setting")){
			return 6;
		}
		else if (Parent.startsWith("@begin")){
			return 5;
		}
		else if (Parent.startsWith("@apply")){
			return 5;
		}
		else if (Parent.startsWith("@title")){
		return 1;
		}
		else if (Parent.startsWith("@subtitle")){
		return 2;
		}
		else if (Parent.startsWith("@image")){
		return 3;
		}
		else if (Parent.startsWith("@note")){
		return 4;
		}
		else {
			String Parent1 = node.parent().parent().toString();
			if (Parent1.startsWith("@title")){
				return 1;
			}
			else if (Parent1.startsWith("@subtitle")){
				return 2;
			}
			else if (Parent1.startsWith("@image")){
				return 3;
			}
			else if (Parent1.startsWith("@note")){
				return 4;
			}
			else {
				String Parent2 = node.parent().parent().parent().toString();
				if (Parent2.startsWith("@title")){
					return 1;
				}
				else if (Parent2.startsWith("@subtitle")){
					return 2;
				}
				else if (Parent2.startsWith("@image")){
					return 3;
				}
				else if (Parent2.startsWith("@note")){
					return 4;
				}
			}
		}
		return 0;
		
	}
	
	public void outAShortident (AShortident node)
	{
	 		
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
		
		if (Main.SymbolTableB == true ){
			SymbolTable.PrintSymbolTable();
		}
		if (Main.SlideTableB == true ){
			SymbolTable.PrintSlideTable();
		}
	
		indent--;
		if (Main.NodesB == true ){
		printIndents();
		System.out.println("EOF");
		}
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
		//node.getChar();
		//node.setChar(node);
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
