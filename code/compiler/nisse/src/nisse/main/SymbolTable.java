package nisse.main;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.print.MultiDoc;

public class SymbolTable {
	static int Tæller = -1;
	public static void CreateSymbolTable(){

	//	 String[][] SymbolTable = new String[1000][10];
	}
	
	public static int SymbolTableAdd(String Text, String Type/*, int FontSize, String FontFamily,String FontColor, double FontLineheight, String FontWeight*/){
	//	MultiDoc<String, Integer> myMap = HashMultimap.create();
		Hashtable<Integer, String> SymbolTable = new Hashtable<Integer, String>();
		SymbolTable.put(1, "TTText");
	//	SymbolTable.pu
		SymbolTable.put(1, "Type");
		
		String SymbolNavn = (String) SymbolTable.get(1);;
		System.out.println(SymbolNavn + "Wazzup");
		String SymbolNavn1 = (String) SymbolTable.get(1);
		
		System.out.println(SymbolNavn1 + "Wazzup");
		
		return 1;
		//SymbolNavn.
		//SymbolTable.
	//	Enumeration names; 
	//	String str; 
	//	double bal;
		
	//	SymbolTable.put(GetCurrentSymbolNumber())
	}

	
	public static int GetNextSymbolNumber(){
		SymbolTable.Tæller = SymbolTable.Tæller + 1;
		return Tæller;
	}
	public static int GetCurrentSymbolNumber(){
		return Tæller;
	}
}
