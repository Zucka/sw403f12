package nisse.main;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.print.MultiDoc;

public class SymbolTable {
	static int Counter = 0;
	static Hashtable<Integer, String[]> SymbolTable1 = new Hashtable<Integer, String[]>();
	
	//Ved 1 Weight parametere
	public static void SymbolTableAdd(String Text, String Type, int FontSize, String FontFamily,String FontColor, double FontLineheight, String FontWeight){
		String FontSizeString = Integer.toString(FontSize);
		String FontLineheightString = Double.toString(FontLineheight);
		String[] Values = {Text, Type, FontSizeString, FontFamily, FontColor, FontLineheightString, FontWeight};
		SymbolTable1.put(GetCurrentSymbolNumber(), Values);
		NextSymbolNumber();
	}
	//Ved 2 Weight parametere
	public static void SymbolTableAdd(String Text, String Type, int FontSize, String FontFamily,String FontColor, double FontLineheight, String FontWeight, String FontWeight1){
		String FontSizeString = Integer.toString(FontSize);
		String FontLineheightString = Double.toString(FontLineheight);
		String[] Values = {Text, Type, FontSizeString, FontFamily, FontColor, FontLineheightString, FontWeight, FontWeight1 };
		SymbolTable1.put(GetCurrentSymbolNumber(), Values);
		NextSymbolNumber();
	}
	//Ved 3 Weight parametere
	public static void SymbolTableAdd(String Text, String Type, int FontSize, String FontFamily,String FontColor, double FontLineheight, String FontWeight, String FontWeight1, String FontWeight2){
		String FontSizeString = Integer.toString(FontSize);
		String FontLineheightString = Double.toString(FontLineheight);
		String[] Values = {Text, Type, FontSizeString, FontFamily, FontColor, FontLineheightString, FontWeight, FontWeight1, FontWeight2 };
		SymbolTable1.put(GetCurrentSymbolNumber(), Values);
		NextSymbolNumber();
	}
	
	
	public static void NextSymbolNumber(){
		SymbolTable.Counter = SymbolTable.Counter + 1;
		//return Counter;
	}
	public static int GetCurrentSymbolNumber(){
		return Counter;
	}
	
	public static void PrintSymbolTable(){
		int i= 0;
		int j = GetCurrentSymbolNumber();
		System.out.println(" ____________________________________________________________________________________________________________________");
		System.out.println("| Text :: Type :: FontSize :: FontFamily :: FontColor :: FontLineheight :: FontWeight :: FontWeight1 :: FontWeight2 |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
		while (i<j){
			String[] TableLine = SymbolTable1.get(i);
			int length = TableLine.length;
			int k = 0;
			System.out.print("| ");
			boolean h = true;
			
			while (k < length){
				
				if (h == true){
					System.out.print(TableLine[k]);
					h = false;
				}
				else{
					System.out.print( " :: " + TableLine[k]);
				}
				k++;
			}
			
			System.out.print(" |");
			System.out.print("\n");
			i++;
		}
		
	}
}
