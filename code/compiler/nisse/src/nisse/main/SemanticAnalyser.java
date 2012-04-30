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
	
	//Image Settings
/*	int ImageFontSize = 15;
	String ImageFontFamily = "arial";
	String ImageFontColor  = "black";
	double ImageFontLineheight  = 1.5;
	String ImageFontWeight = null;
	//Title Settings
	int TitleFontSize = 36;
	String TitleFontFamily = "arial";
	String TitleFontColor  = "black";
	double TitleFontLineheight  = 1.5;
	String TitleFontWeight = null;
	//Subtitle Settings
	int SubtitleFontSize = 20;
	String SubtitleFontFamily = "arial";
	String SubtitleFontColor  = "black";
	double SubtitleFontLineheight  = 1.5;
	String SubtitleFontWeight = null;
	//Text Settings
	int TextFontSize = 16;
	String TextFontFamily = "arial";
	String TextFontColor  = "black";
	double TextFontLineheight  = 1.5;
	String TextFontWeight = null;
	//Url Settings
	int UrlFontSize = 16;
	String UrlFontFamily = "arial";
	String UrlFontColor  = "black";
	double UrlFontLineheight  = 1.5;
	String UrlFontWeight = null;
	
	
	
	//Image Settings Lokal
	int NewImageFontSize = ImageFontSize;
	String NewImageFontFamily = ImageFontFamily;
	String NewImageFontColor  = ImageFontColor;
	double NewImageFontLineheight  = ImageFontLineheight;
	String NewImageFontWeight = ImageFontWeight;
	//Title Settings Lokal
	int NewTitleFontSize = TitleFontSize;
	String NewTitleFontFamily = TitleFontFamily;
	String NewTitleFontColor  = TitleFontColor;
	double NewTitleFontLineheight  = TitleFontLineheight;
	String NewTitleFontWeight = TitleFontWeight;
	//Subtitle Settings Lokal
	int NewSubtitleFontSize = SubtitleFontSize;
	String NewSubtitleFontFamily = SubtitleFontFamily;
	String NewSubtitleFontColor  = SubtitleFontColor;
	double NewSubtitleFontLineheight  = SubtitleFontLineheight;
	String NewSubtitleFontWeight = SubtitleFontWeight;
	//Text Settings Lokal
	int NewTextFontSize = TextFontSize;
	String NewTextFontFamily = TextFontFamily;
	String NewTextFontColor  = TextFontColor;
	double NewTextFontLineheight  = TextFontLineheight;
	String NewTextFontWeight = TextFontWeight;
	//URL Settings Lokal
	int NewUrlFontSize = UrlFontSize;
	String NewUrlFontFamily = UrlFontFamily;
	String NewUrlFontColor  = UrlFontColor;
	double NewUrlFontLineheight  = UrlFontLineheight;
	String NewUrlFontWeight = UrlFontWeight;    */
	
	
	public SemanticAnalyser()
	{
		int sdgf = SymbolTable.NewImageFontSize;
		
	}
	public void defaultIn(Node node)
	{
	//	String[][] SymbolTable = new String[1000][10];
	//	SymbolTable[0][0] = "hej";
		System.out.println(node.getClass().getName());
		System.out.println(node.toString());
		System.out.println("UNCAPTURED ALTERNATIVE IN SEMANTIC ANALYSER");
	}
	public void defaultOut(Node node)
	{
		System.out.println(node.getClass().getName());
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
			//System.out.println("Dette er en lokal variabel");
			if (SettingType.startsWith("@ font_color")){
				String Value = SettingType.substring(15);
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
				}
				else {
					System.out.println("Font color:" + Value + "could not be found, try a different one, or write only with small ");
				}
			}
			else if (SettingType.startsWith("@ font_family")){	
				String Value = SettingType.substring(16);
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
			}
			else if (SettingType.startsWith("@ font_weight")){	
				String Value = SettingType.substring(16);
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
				
			}
			
			else if (SettingType.startsWith("@ font_size")){
				String Value = SettingType.substring(14);
			//	System.out.println("Font size value = " + Value);
				try{
				int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
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
				
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				String Value = SettingType.substring(20);
			//	System.out.println("Font lineheight value = " + Value);
				try{
				double val = Double.parseDouble(Value);
				}
				catch(Exception a){
					System.out.println("FEJL, lineheight kan ikke konverteres til en double");
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
				
			}
		}
		//VED GLOBAL SETTING ÆNDRING
		else {
			//	System.out.println("Dette er global Setting");
			if (SettingType.startsWith("@ font_color")){
				String Value = SettingType.substring(15);
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
				}
				else {
					System.out.println("Font color:" + Value + "could not be found, try a different one, or write only with small ");
				}


			}
			else if (SettingType.startsWith("@ font_family")){	
				String Value = SettingType.substring(16);
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
				
			}
			else if (SettingType.startsWith("@ font_weight")){	
				String Value = SettingType.substring(16);
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
				
			}
			
			else if (SettingType.startsWith("@ font_size")){
				String Value = SettingType.substring(14);
			//	System.out.println("Font size value = " + Value);
				try{
				int val = Integer.parseInt(Value);
		//		NewTextFontSize = val;
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
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
				
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				String Value = SettingType.substring(20);
			//	System.out.println("Font lineheight value = " + Value);
				try{
				double val = Double.parseDouble(Value);
				}
				catch(Exception a){
					System.out.println("FEJL, lineheight kan ikke konverteres til en double");
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
			}
		}
		printIndents();
		System.out.println("ASettingblock");
		indent++;
	}
	public void inABeginblock (ABeginblock node)
	{
		SymbolTable.OpenScope();
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
		
	/*	int Type = CheckType(node);
		String Parent = node.parent().toString();
		System.out.println(Parent);
		LinkedList<PPlainsv1> Test = node.getPlainsv1();
		Object[] a = Test.toArray();
		int j = Test.size();
		int i = 0;
		while (i<j){
			
			String Plain = a[i].toString();
			int kj = Plain.length();
			Plain = Plain.substring(0, kj - 1);
			//System.out.println(Plain);
			
			if (Plain.startsWith("@i")){
				InsetWeight("italic", Type);
			}
			else if (Plain.startsWith("@u")){
				InsetWeight("underlined", Type);
			}
			else if (Plain.startsWith("@b")){
				InsetWeight("bold", Type);
			}
			
			
			if (Plain.startsWith("@setting") || Plain.startsWith("@title") ){
				
			}
			else if (Type == 1){
				SymbolTable.SymbolTableAdd(Plain, "title", NewTitleFontSize, NewTitleFontFamily, NewTitleFontColor, NewTitleFontLineheight, NewTitleFontWeight);
			}
			else if (Type == 2){
				SymbolTable.SymbolTableAdd(Plain, "subtitle", NewSubtitleFontSize, NewSubtitleFontFamily, NewSubtitleFontColor, NewSubtitleFontLineheight, NewSubtitleFontWeight);
			}
			else if (Type == 3){
				SymbolTable.SymbolTableAdd(Plain, "image", NewImageFontSize, NewImageFontFamily, NewImageFontColor, NewImageFontLineheight, NewImageFontWeight);
			}
			//else if (Parent.startsWith("@note")){
				
			//} 
			else {
				SymbolTable.SymbolTableAdd(Plain, "text", NewTextFontSize, NewTextFontFamily, NewTextFontColor, NewTextFontLineheight, NewTextFontWeight);
				
			} 

			i++;
		} */
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
	
	public int CheckThanAdd(String Text, String Parentx3, String Parent, String Parentx2){
		if (Parent.startsWith("@apply { @url") && Parentx3.startsWith("@image")){
			SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
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
			SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
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
				/*
				
				String ParentParentParent = node.parent().parent().parent().toString();
				String ParentParentParentParentParent = node.parent().parent().parent().parent().parent().toString();
				if (ParentParentParent.startsWith("@begin") || ParentParentParentParentParent.startsWith("@begin") ){
					SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight]);
				}
				else if (ParentParentParentParentParent.startsWith("@title")){
					SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]);
				}
				else if (ParentParentParentParentParent.startsWith("@subtitle")){
					SymbolTable.SymbolTableAdd(Text, "subtitle", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight]);
				}
				else if (ParentParentParentParentParent.startsWith("@image")){
					SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
				}
				else if (ParentParentParentParentParent.startsWith("@apply { @url") || ParentParentParent.startsWith("@apply { @url")){
					SymbolTable.SymbolTableAdd(Text, "url", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
				}
				else {
					String ParentParentParentParentParentParent = node.parent().parent().parent().parent().parent().parent().toString();
					System.out.println("CharAll ParentParentParentParentParentParent = " +ParentParentParentParentParentParent);
					if (ParentParentParentParentParentParent.startsWith("@begin")){
						SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight]);
					}
					else if (ParentParentParentParentParentParent.startsWith("@title")){
						SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]);
					}
					else if (ParentParentParentParentParentParent.startsWith("@subtitle")){
						SymbolTable.SymbolTableAdd(Text, "subtitle", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight]);
					}
					else if (ParentParentParentParentParentParent.startsWith("@image")){
						SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
					}
					else if (ParentParentParentParentParentParent.startsWith("@apply { @url")){
						SymbolTable.SymbolTableAdd(Text, "url", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
					}
					else{
						String ParentParentParentParentParentParentParentParent = node.parent().parent().parent().parent().parent().parent().parent().parent().toString();
						//System.out.println("CharAll ParentParentParentParentParentParentParentParent = " +ParentParentParentParentParentParentParentParent);
						
						if (ParentParentParentParentParentParentParentParent.startsWith("@begin")){
							SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight]);
						}
						else if (ParentParentParentParentParentParentParentParent.startsWith("@title")){
							SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]);
						}
						else if (ParentParentParentParentParentParentParentParent.startsWith("@subtitle")){
							SymbolTable.SymbolTableAdd(Text, "subtitle", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight]);
						}
						else if (ParentParentParentParentParentParentParentParent.startsWith("@image")){
							SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
						}
						else if (ParentParentParentParentParentParentParentParent.startsWith("@apply { @url")){
							SymbolTable.SymbolTableAdd(Text, "url", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
						}
						else {
							String ParentParentParentParentParentParentParentParentParent = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
							//System.out.println("CharAll ParentParentParentParentParentParentParentParentParent = " + ParentParentParentParentParentParentParentParentParent);
							if (ParentParentParentParentParentParentParentParentParent.startsWith("@begin")){
								SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight]);
							}
							else if (ParentParentParentParentParentParentParentParentParent.startsWith("@title")){
								SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]);
							}
							else if (ParentParentParentParentParentParentParentParentParent.startsWith("@subtitle")){
								SymbolTable.SymbolTableAdd(Text, "subtitle", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight]);
							}
							else if (ParentParentParentParentParentParentParentParentParent.startsWith("@image")){
								SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
							}
							else if (ParentParentParentParentParentParentParentParentParent.startsWith("@apply { @url")){
								SymbolTable.SymbolTableAdd(Text, "url", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
							}
							else {
								String ParentParentParentParentParentParentParentParentParentParentParentParent = node.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().toString();
								//System.out.println("CharAll ParentParentParentParentParentParentParentParentParentParentParentParent = " + ParentParentParentParentParentParentParentParentParentParentParentParent);
								if (ParentParentParentParentParentParentParentParentParentParentParentParent.startsWith("@begin")){
									SymbolTable.SymbolTableAdd(Text, "text", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight]);
									
								}
								else if (ParentParentParentParentParentParentParentParentParentParentParentParent.startsWith("@title")){
									SymbolTable.SymbolTableAdd(Text, "title", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]);
									
								}
								else if (ParentParentParentParentParentParentParentParentParentParentParentParent.startsWith("@subtitle")){
									SymbolTable.SymbolTableAdd(Text, "subtitle", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight]);
									
								}
								else if (ParentParentParentParentParentParentParentParentParentParentParentParent.startsWith("@image")){
									SymbolTable.SymbolTableAdd(Text, "image", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight]);
									
								}
								else if (ParentParentParentParentParentParentParentParentParentParentParentParent.startsWith("@apply { @url")){
									SymbolTable.SymbolTableAdd(Text, "url", SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight], SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight],SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink]);
								}
								else {
								
									System.out.println("Text type could not be found");
									System.out.println("Text " + Text);
								}
							}
						}
						
					}
					
				}
				
			} */

			
		  
		
		printIndents();
		System.out.println("ACharallPlainsv1");
		indent++;
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
/*			try{
			String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;
			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;
			}
			else if (SettingType.startsWith("@url")){
				Value = TakeValue(SettingType, 7);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink] = Value;
			//	System.out.println(Value);
			}
			} catch (Exception a){
				//System.out.println("Ingen Settingtype ændringer i @apply");
			}
			  									*/
		} 
		else if (FormatKwd.startsWith("@i")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + "i";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + "i";
/*			try{
			String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;
			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;
			}
			else if (SettingType.startsWith("@url")){
				Value = TakeValue(SettingType, 7);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink] = Value;
			//	System.out.println(Value);
			}
			}catch(Exception a){
				//System.out.println("Ingen Settingtype ændringer i @i");
			}           */
		}
		else if (FormatKwd.startsWith("@u")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + "u";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + "u";

/*			try{
				String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;

			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;

			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;

			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;

			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;

			}
			else if (SettingType.startsWith("@url")){
				Value = TakeValue(SettingType, 7);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink] = Value;
			//	System.out.println(Value);
			}
			
		} catch (Exception a){
			//System.out.println("Ingen Settingtype ændringer i @u");
		}						*/
		}
		else if (FormatKwd.startsWith("@b")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + "b";
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + "b";

/*			try{
				String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;

			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontColor] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;

			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;

			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;

			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontLineheight] = Value;
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;

			}
			else if (SettingType.startsWith("@url")){
				Value = TakeValue(SettingType, 17);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlHyperlink] = Value;
			//	System.out.println(Value);
			}
			} catch (Exception a){
				//System.out.println("Ingen Settingtype ændringer i @b");
			}					*/
		}
		else if (FormatKwd.startsWith("@image")){
			/*try{
				String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontColor] = Value;
			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontLineheight] = Value;
			}
			} catch (Exception a){
				//System.out.println("Ingen Settingtype ændringer i @image");
			}				*/
		}
		else if (FormatKwd.startsWith("@title")){
/*			try{
				String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontColor] = Value;
			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] + " " + Value;
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontLineheight] = Value;
			}
			} catch (Exception a){
				//System.out.println("Ingen Settingtype ændringer i @title");
			}				*/
		}
		else if (FormatKwd.startsWith("@subtitle")){
/*			try{
				String SettingType = node.getShortidents().toString();
			if (SettingType.startsWith("@ font_family")){
				Value = TakeValue(SettingType, 16);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
			}
			else if (SettingType.startsWith("@ font_color")){
				Value = TakeValue(SettingType, 15);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontColor] = Value;
			}
			else if (SettingType.startsWith("@ font_size")){
				Value = TakeValue(SettingType, 14);
				
				try{
					int val = Integer.parseInt(Value);
				} catch(Exception a){
					System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
				}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
			}
			else if (SettingType.startsWith("@ font_weight")){
				Value = TakeValue(SettingType, 16);
				Value = Value.substring(0, 1);
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
			}
			else if (SettingType.startsWith("@ font_lineheight")){
				Value = TakeValue(SettingType, 20);
				try{
					double val = Double.parseDouble(Value);
					}
					catch(Exception a){
						System.out.println("FEJL, lineheight kan ikke konverteres til en double");
					}
				SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontLineheight] = Value;
			}
			} catch (Exception a){
				//System.out.println("Ingen Settingtype ændringer i @subtitle");
			} 				*/
		}
		else if (FormatKwd.startsWith("@note")){
			
		}
		else{
			System.out.println("Format Keyword:" + FormatKwd + " ikke fundet");
		}
		
		
		printIndents();
		System.out.println("AShortblock");
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
		String SettingType = node.getKwd().toString().trim();
		String IfSetting = node.parent().parent().toString().trim();
		System.out.println(IfSetting);
		//System.out.println(SettingType);
		int Length1 = node.getShortidentv1().size();
		Object[] Value1 = node.getShortidentv1().toArray();
				
		int i = 0;
		String Value = "";
		while (i<Length1){
			
			Value = Value + Value1[i].toString().trim();
			i++;
		}    
		//String Value = node.getShortidentv1().toString().trim();
	//	int Length = Value.length() - 1;
	//	Value = Value.substring(1, Length).trim();
	//	System.out.println(Value);
		try{
		if (IfSetting.startsWith("@setting")){
			
		}
		else if (SettingType.startsWith("@ font_family")){
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontFamily] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontFamily] = Value;
		}
		else if (SettingType.startsWith("@ font_color")){
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
		else if (SettingType.startsWith("@ font_size")){
			try{
				int val = Integer.parseInt(Value);
			} catch(Exception a){
				System.out.println("FEJL, font_size "+ Value + " kan ikke konverteres til en int");
			}
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontSize] = Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontSize] = Value;
		}
		else if (SettingType.startsWith("@ font_weight")){
			//Value = SettingType.substring(16);
			Value = Value.substring(0, 1);
			//System.out.println("Font weight value1 = " + Value);
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTextFontWeight] + " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewTitleFontWeight]+ " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewSubtitleFontWeight] + " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewUrlFontWeight] + " " + Value;
			SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] = SymbolTable.Scope[SymbolTable.ScopeLevel][SymbolTable.NewImageFontWeight] + " " + Value;
		}
		else if (SettingType.startsWith("@ font_lineheight")){
			try{
				double val = Double.parseDouble(Value);
				}
				catch(Exception a){
					System.out.println("FEJL, lineheight kan ikke konverteres til en double");
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
		} catch (Exception a){
			//System.out.println("Ingen Settingtype ændringer i @apply");
		}
		
		
		
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
		
	//	SymbolTable.SymbolTableAdd("hej", "Type", 6, "FontFamily", "FontColor", 6, "FontWeight", null, null);
	//	SymbolTable.PrintSymbolTable();
		//System.out.println("First1 = " + node.getLines().getFirst());
		String Transition = node.getBeginblock().toString();
		Transition = Transition.substring(9);
		//System.out.println(Transition);
		String Transition1 = "none";
		if (Transition.startsWith("slide")){
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
		else if (Transition.startsWith("rotate-scale")){
			Transition1 = "rotate-scale";
		}
		try{
		String First =node.getLines().getFirst().toString();
		String Last =node.getLines().getLast().toString();
		}
		catch(Exception a){
			//System.out.println("Slided er tomt");
			indent--;
			return;
		}
		String SlideType = "Normal";
		try{
		String First =node.getLines().getFirst().toString();
		String Last =node.getLines().getLast().toString();
		String Firstsub = First.substring(0, 6);
		String Lastsub = Last.substring(0, 9);
		
		if (Firstsub.equals("@title")){
		//	System.out.println("Det findes en titel");
			if (Lastsub.equals("@subtitle")){
				//System.out.println("Dette er en titel side med undertitel");
				SlideType = "TitleWithSubtitle";
			}
			else if (Last.equals(First)){
				//System.out.println("Dette er en titel side uden undertitel");
				SlideType = "Title";
			}
			else {
		//		System.out.println("Dette er ikke en titel side");
			}
		}
		else if(Firstsub.equals("@image") && First.equals(Last)){
			//System.out.println("Dette er et slide kun bestående af et billede.");
			SlideType = "Image";
		}
		else{
		//	System.out.println("Der findes ingen titel");
		}
		}
		catch(Exception a){
			System.out.println("Dette er ikke en title slide");
			System.out.println("Exception, no worries");
			System.out.println("Da den første og/eller sidste linje højest sandsynlig er mindre end 8 chars lang");
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
		SymbolTable.PrintSymbolTable();
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
	/*	String Parent = node.parent().toString();
		System.out.println(Parent);
		LinkedList<PPlainsv1> Test = node.getPlainsv1();
		Object[] a = Test.toArray();
		int j = Test.size();
		int i = 0;
		while (i<j){
			
			String Plain = a[i].toString();
			int kj = Plain.length();
			Plain = Plain.substring(0, kj - 1);
			//System.out.println(Plain);
			if (Plain.startsWith("@")){
			//	System.out.println("Dette er en shortblock");
			}
			else if (Parent.startsWith("@title")){
				SymbolTable.SymbolTableAdd(Plain, "title", NewTextFontSize, NewTextFontFamily, NewTextFontColor, NewTextFontLineheight, NewTextFontWeight);
			}
			else if (Parent.startsWith("@subtitle")){
				SymbolTable.SymbolTableAdd(Plain, "subtitle", NewTextFontSize, NewTextFontFamily, NewTextFontColor, NewTextFontLineheight, NewTextFontWeight);
			}
			else if (Parent.startsWith("@image")){
				SymbolTable.SymbolTableAdd(Plain, "image", NewTextFontSize, NewTextFontFamily, NewTextFontColor, NewTextFontLineheight, NewTextFontWeight);
			}
			//else if (Parent.startsWith("@note")){
				
			//} 
			else {
				SymbolTable.SymbolTableAdd(Plain, "text", NewTextFontSize, NewTextFontFamily, NewTextFontColor, NewTextFontLineheight, NewTextFontWeight);
				
			} 

			i++;
		}  */
		
	//	System.out.println("Linked list: " + Test);
	//	System.out.println("Linked list er størrelsen: " + i);
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
	
	
/*	public void InsetWeight(String Weight, int Type){
		
		if(Type == 1){
			NewTitleFontWeight =  NewTitleFontWeight + Weight;
		}
		else if(Type == 2){
			NewSubtitleFontWeight =  NewSubtitleFontWeight + Weight;
		}
		else if(Type == 3){
			NewImageFontWeight =  NewImageFontWeight + Weight;
		}
		else if(Type == 4){
		//	NewImageFontWeight =  NewImageFontWeight + Weight;
		}
		else{
			System.out.println("InsetWeight function error, Type = "+ Type + " Weight = " + Weight );
		}
		System.out.println("Type = "+ Type + " Weight = " + Weight);
		
	} */
	
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
	/*	StringBuilder builder = new StringBuilder();
		for (PShortidentv1 p : node.getShortidentv1())
		{
			builder.append(p.toString());
		}
		String Value = builder.toString().trim();
		String Kwd1 = node.getKwd().toString().trim();
		
		String FormatKwd = node.parent().parent().toString();
		System.out.println(FormatKwd + " ÆANBWFAEFNÆÆAEF");  */
		
		
		
		
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
		SymbolTable.PrintSlideTable();
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
