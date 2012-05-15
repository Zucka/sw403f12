package nisse.main;

import java.util.Enumeration;
import java.util.Hashtable;

public class SymbolTable {
	static int Counter = 0;
	static int SlideCounter = 1;
	static String[][] Scope = new String[10][100];
	static int ScopeLevel = 0;
	static int OuterMostScope = 0;

	static String Transition = "none";
	
	//Title Settings
	static String TitleFontSize = "36";
	static String TitleFontFamily = "arial";
	static String TitleFontColor  = "black";
	static String TitleFontLineheight  = "1.5";
	static String TitleFontWeight = "";
	//Subtitle Settings
	static String SubtitleFontSize = "24";
	static String SubtitleFontFamily = "arial";
	static String SubtitleFontColor  = "gray";
	static String SubtitleFontLineheight  = "1.5";
	static String SubtitleFontWeight = "";
	//Text Settings
	static String TextFontSize = "18";
	static String TextFontFamily = "arial";
	static String TextFontColor  = "black";
	static String TextFontLineheight  = "1.5";
	static String TextFontWeight = "";
	//Image Settings
	static String ImageFontSize = "16";
	static String ImageFontFamily = "arial";
	static String ImageFontColor  = "black";
	static String ImageFontLineheight  = "1.5";
	static String ImageFontWeight = "";
	//Url Settings
	static String UrlFontSize = "18";
	static String UrlFontFamily = "arial";
	static String UrlFontColor  = "blue";
	static String UrlFontLineheight  = "1.5";
	static String UrlFontWeight = "";
	static String UrlHyperlink = "";
	

	//Title Settings Lokal
	static int NewTitleFontSize = 1;
	static int NewTitleFontFamily = 2;
	static int NewTitleFontColor  = 3;
	static int NewTitleFontLineheight  = 4;
	static int NewTitleFontWeight = 5;
	//Subtitle Settings Lokal
	static int NewSubtitleFontSize = 11;
	static int NewSubtitleFontFamily = 12;
	static int NewSubtitleFontColor  = 13;
	static int NewSubtitleFontLineheight  = 14;
	static int NewSubtitleFontWeight = 15;
	//Text Settings Lokal
	static int NewTextFontSize = 21;
	static int NewTextFontFamily = 22;
	static int NewTextFontColor  = 23;
	static int NewTextFontLineheight  = 24;
	static int NewTextFontWeight = 25;
	//Image Settings
	static int NewImageFontSize = 31;
	static int NewImageFontFamily = 32;
	static int NewImageFontColor  = 33;
	static int NewImageFontLineheight  = 34;
	static int NewImageFontWeight = 35;
	//URL Settings Lokal
	static int NewUrlFontSize = 41;
	static int NewUrlFontFamily = 42;
	static int NewUrlFontColor  = 43;
	static int NewUrlFontLineheight  = 44;
	static int NewUrlFontWeight = 45;
	static int NewUrlHyperlink = 46;
	
	
	static Hashtable<Integer, String[]> SymbolTableForSlide = new Hashtable<Integer, String[]>();
	static Hashtable<Integer, String[]> SymbolTable1 = new Hashtable<Integer, String[]>();
	
	//Ved 1 Weight parametere
	public static void SymbolTableAdd(String Text, String Type, String FontSize, String FontFamily,String FontColor, String FontLineheight, String FontWeight){
	//	String FontSizeString = Integer.toString(FontSize);
	//	String FontLineheightString = Double.toString(FontLineheight);
		String[] Values = {Text, Type, FontSize, FontFamily, FontColor, FontLineheight, FontWeight};
		SymbolTable1.put(GetCurrentSymbolNumber(), Values);
		NextSymbolNumber();
		
	}
	
	public static void SymbolTableAdd(String Text, String Type, String FontSize, String FontFamily,String FontColor, String FontLineheight, String FontWeight, String Link){
	//	String FontSizeString = Integer.toString(FontSize);
	//	String FontLineheightString = Double.toString(FontLineheight);
		String[] Values = {Text, Type, FontSize, FontFamily, FontColor, FontLineheight, FontWeight, Link};
		SymbolTable1.put(GetCurrentSymbolNumber(), Values);
		NextSymbolNumber();
		
	}
/*	//Ved 3 Weight parametere
	public static void SymbolTableAdd(String Text, String Type, int FontSize, String FontFamily,String FontColor, double FontLineheight, String FontWeight, String FontWeight1, String FontWeight2){
		String FontSizeString = Integer.toString(FontSize);
		String FontLineheightString = Double.toString(FontLineheight);
		String[] Values = {Text, Type, FontSizeString, FontFamily, FontColor, FontLineheightString, FontWeight, FontWeight1, FontWeight2 };
		SymbolTable1.put(GetCurrentSymbolNumber(), Values);
		NextSymbolNumber();
	} */
	public static void SlideTableAdd(String Type, String Transition){
		//	String FontSizeString = Integer.toString(FontSize);
		//	String FontLineheightString = Double.toString(FontLineheight);
			String[] Values = {Type, Transition};
			SymbolTableForSlide.put(GetSlideNumber(), Values);
			NextSlide();
		}   
	
	public static void NextSlide(){
		SymbolTable.SlideCounter = SymbolTable.SlideCounter + 1;
	}
	public static int GetSlideNumber(){
		return SlideCounter;
	}
	
	public static void NextSymbolNumber(){
		SymbolTable.Counter = SymbolTable.Counter + 1;
		//return Counter;
	}
	public static int GetCurrentSymbolNumber(){
		return Counter;
	}
	
	public static void CreateScopeTable(){
		
		Scope[ScopeLevel][NewTitleFontSize] = TitleFontSize;
		Scope[ScopeLevel][NewTitleFontFamily] = TitleFontFamily;
		Scope[ScopeLevel][NewTitleFontColor]  = TitleFontColor;
		Scope[ScopeLevel][NewTitleFontLineheight]  = TitleFontLineheight;
		Scope[ScopeLevel][NewTitleFontWeight] =  TitleFontWeight;
		//Subtitle Settings Lokal
		Scope[ScopeLevel][NewSubtitleFontSize] = SubtitleFontSize;
		Scope[ScopeLevel][NewSubtitleFontFamily] = SubtitleFontFamily;
		Scope[ScopeLevel][NewSubtitleFontColor]  = SubtitleFontColor;
		Scope[ScopeLevel][NewSubtitleFontLineheight]  = SubtitleFontLineheight;
		Scope[ScopeLevel][NewSubtitleFontWeight] = SubtitleFontWeight;
		//Text Settings Lokal
		Scope[ScopeLevel][NewTextFontSize] = TextFontSize;
		Scope[ScopeLevel][NewTextFontFamily] = TextFontFamily;
		Scope[ScopeLevel][NewTextFontColor]  = TextFontColor;
		Scope[ScopeLevel][NewTextFontLineheight]  = TextFontLineheight;
		Scope[ScopeLevel][NewTextFontWeight] = TextFontWeight;
		//Image Settings
		Scope[ScopeLevel][NewImageFontSize] = ImageFontSize;
		Scope[ScopeLevel][NewImageFontFamily] = ImageFontFamily;
		Scope[ScopeLevel][NewImageFontColor]  = ImageFontColor;
		Scope[ScopeLevel][NewImageFontLineheight]  = ImageFontLineheight;
		Scope[ScopeLevel][NewImageFontWeight] = ImageFontWeight;
		//URL Settings Lokal
		Scope[ScopeLevel][NewUrlFontSize] = UrlFontSize;
		Scope[ScopeLevel][NewUrlFontFamily] = UrlFontFamily;
		Scope[ScopeLevel][NewUrlFontColor]  = UrlFontColor;
		Scope[ScopeLevel][NewUrlFontLineheight]  = UrlFontLineheight;
		Scope[ScopeLevel][NewUrlFontWeight] = UrlFontWeight;
		Scope[ScopeLevel][NewUrlHyperlink] = UrlHyperlink;
	}

	
	public static void OpenScope(){
		ScopeLevel = ScopeLevel + 1;
		//Title Settings
		Scope[ScopeLevel][NewTitleFontSize] = Scope[ScopeLevel-1][NewTitleFontSize];
		Scope[ScopeLevel][NewTitleFontFamily] = Scope[ScopeLevel-1][NewTitleFontFamily];
		Scope[ScopeLevel][NewTitleFontColor]  = Scope[ScopeLevel-1][NewTitleFontColor];
		Scope[ScopeLevel][NewTitleFontLineheight]  = Scope[ScopeLevel-1][NewTitleFontLineheight];
		Scope[ScopeLevel][NewTitleFontWeight] = Scope[ScopeLevel-1][NewTitleFontWeight];
		//Subtitle Settings Lokal
		Scope[ScopeLevel][NewSubtitleFontSize] = Scope[ScopeLevel-1][NewSubtitleFontSize];
		Scope[ScopeLevel][NewSubtitleFontFamily] = Scope[ScopeLevel-1][NewSubtitleFontFamily];
		Scope[ScopeLevel][NewSubtitleFontColor]  = Scope[ScopeLevel-1][NewSubtitleFontColor];
		Scope[ScopeLevel][NewSubtitleFontLineheight]  = Scope[ScopeLevel-1][NewSubtitleFontLineheight];
		Scope[ScopeLevel][NewSubtitleFontWeight] = Scope[ScopeLevel-1][NewSubtitleFontWeight];
		//Text Settings Lokal
		Scope[ScopeLevel][NewTextFontSize] = Scope[ScopeLevel-1][NewTextFontSize];
		Scope[ScopeLevel][NewTextFontFamily] = Scope[ScopeLevel-1][NewTextFontFamily];
		Scope[ScopeLevel][NewTextFontColor]  = Scope[ScopeLevel-1][NewTextFontColor];
		Scope[ScopeLevel][NewTextFontLineheight]  = Scope[ScopeLevel-1][NewTextFontLineheight];
		Scope[ScopeLevel][NewTextFontWeight] = Scope[ScopeLevel-1][NewTextFontWeight];
		//Image Settings
		Scope[ScopeLevel][NewImageFontSize] = Scope[ScopeLevel-1][NewImageFontSize];
		Scope[ScopeLevel][NewImageFontFamily] = Scope[ScopeLevel-1][NewImageFontFamily];
		Scope[ScopeLevel][NewImageFontColor]  = Scope[ScopeLevel-1][NewImageFontColor];
		Scope[ScopeLevel][NewImageFontLineheight]  = Scope[ScopeLevel-1][NewImageFontLineheight];
		Scope[ScopeLevel][NewImageFontWeight] = Scope[ScopeLevel-1][NewImageFontWeight];
		//URL Settings Lokal
		Scope[ScopeLevel][NewUrlFontSize] = Scope[ScopeLevel-1][NewUrlFontSize];
		Scope[ScopeLevel][NewUrlFontFamily] = Scope[ScopeLevel-1][NewUrlFontFamily];
		Scope[ScopeLevel][NewUrlFontColor]  = Scope[ScopeLevel-1][NewUrlFontColor];
		Scope[ScopeLevel][NewUrlFontLineheight]  = Scope[ScopeLevel-1][NewUrlFontLineheight];
		Scope[ScopeLevel][NewUrlFontWeight] = Scope[ScopeLevel-1][NewUrlFontWeight];
		Scope[ScopeLevel][NewUrlHyperlink] = Scope[ScopeLevel-1][NewUrlHyperlink];
		
	}
	
	public static void CloseScope(){
		ScopeLevel = ScopeLevel - 1;
	}
	
	public static int GetCurrentScope(){
		return ScopeLevel;
	}
	
	public static void PrintSymbolTable(){
		int i= 0;
		int j = GetCurrentSymbolNumber();
		System.out.println("_______________________________________________________________________________________________________________________");
		System.out.println("| Symnr ::         Text          ::   Type    :: F_Size    :: F_Family  :: F_Color   ::  F_LH     :: F_Weight  :: URL |");
		System.out.println("|---------------------------------------------------------------------------------------------------------------------|");
		while (i<j){
			String[] TableLine = SymbolTable1.get(i);
			int length = TableLine.length;
			int k = 0;
			System.out.print("| ");
			boolean h = true;
			
			while (k < length){
				
				if (h == true){
					System.out.printf( "%5d :: %20s ", i , TableLine[k]);
					h = false;
				}
				else{
					System.out.printf( " :: %8s ", TableLine[k]);
				}
				k++;
			}
			
			System.out.print(" |");
			System.out.print("\n");
			i++;
		}
		System.out.println("|_____________________________________________________________________________________________________________________|");
		
		
	}
	public static void PrintSlideTable(){
		int i= 1;
		int j = GetSlideNumber();
		System.out.println("___________________________________________________");
		System.out.println("| SlideNr ::         Type          ::   Transition |");
		System.out.println("|--------------------------------------------------|");
		while (i<j){
			String[] TableLine1 = SymbolTableForSlide.get(i);
			int length = TableLine1.length;
			int k = 0;
			System.out.print("| ");
			boolean h = true;
			
			while (k < length){
				
				if (h == true){
					System.out.printf( "%7d :: %20s ", i , TableLine1[k]);
					h = false;
				}
				else{
					System.out.printf( " :: %11s ", TableLine1[k]);
				}
				k++;
			}
			
			System.out.print(" |");
			System.out.print("\n");
			i++;
		}
		System.out.println("|__________________________________________________|");
		
		
	}
	
	
	
}
