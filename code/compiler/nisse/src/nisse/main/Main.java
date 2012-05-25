package nisse.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

import nisse.lexer.Lexer;
import nisse.node.Start;
import nisse.parser.Parser;

public class Main {

	static FileWriter file = null;
	static int Error = 0;
	static int Debug1 = 0;
	/* 1 Symbol table
	 * 2 Slide table
	 * 3 = 2 + 1
	 * 4 Noder
	 * 5 = 4 + 1
	 * 6 = 4 + 2
	 * 7 = 4 + 2 + 1
	 * 8 = ErrorTable
	 * 9 = 8 + 1
	 * 10 = 8 + 2
	 * 11 = 8 + 2 + 1
	 * 12 = 8 + 4
	 * 13 = 8 + 4 + 1
	 * 14 = 8 + 4 + 2
	 * 15 = 8 + 4 + 2 + 1
	 * 16 = 
	 */
	static boolean SymbolTableB = false;
	static boolean SlideTableB = false;
	static boolean NodesB = false;
	static boolean ErrorTableB = false;
	public static void Debugging(int Debug){
		int DebugTest = Debug - 16;
		if (DebugTest >= 0){
			Debug = Debug - 16;
		}
		DebugTest = Debug - 8;
		if (DebugTest >= 0){
			Debug = Debug - 8;
			ErrorTableB = true;
		}
		DebugTest = Debug - 4;
		if (DebugTest >= 0){
			Debug = Debug - 4;
			NodesB = true;
		}
		DebugTest = Debug - 2;
		if (DebugTest >= 0){
			Debug = Debug - 2;
			SlideTableB = true;
		}
		DebugTest = Debug - 1;
		if (DebugTest >= 0){
			Debug = Debug - 1;
			SymbolTableB = true;
		}
	}
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();
		watch.start();
		Reader input = null;
		if(args.length == 1)
		{	
			try {
				input = new FileReader(args[0]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
//			try {
//				file = new FileWriter("output.html");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		else if(args.length == 2)
		{	
			try {
				Debug1 = Integer.parseInt( args[0] );
			} catch (NumberFormatException e) {
				try {
					input = new FileReader(args[0]);
					file = new FileWriter(args[1]);
				} catch (FileNotFoundException f) {
					f.printStackTrace();
				} catch (IOException g) {
					g.printStackTrace();
				}
			}
			if (input == null)
			{
				try {
					input = new FileReader(args[1]);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
//				try {
//					file = new FileWriter("output.html");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}
		else if(args.length == 3)
		{	
			try {
				Debug1 = Integer.parseInt( args[0] );
				input = new FileReader(args[1]);
				file = new FileWriter(args[2]);
			} catch (NumberFormatException e) {
				System.out.println("No valid debug level set");
			} catch (FileNotFoundException f) {
				System.out.println("No valid input set");
			} catch (IOException g) {
				System.out.println("No valid output set");
			}
		}
		else if(args.length == 0)
		{
			System.out.println("Usage: nisse input [output]");
			System.exit(0);
			
//			try {
//				input = new FileReader("/Users/JS/Documents/GIT/t3.txt");
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//			try {
//				file = new FileWriter("output.html");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		// /Users/JS/Documents/GIT/test1.txt 

		Debugging(Debug1);
		
		PushbackReader in = new PushbackReader(input, 1024);
		Lexer lexer = new Lexer(in);
		Parser parser = new Parser(lexer);
		Compiler compiler = new Compiler(lexer, parser);
		
		//LEXER (CAN'T RUN LEXER IF YOU ALSO WANT TO RUN PARSER)
		//compiler.testLexer();
		
		//PARSER

		Start start = compiler.testParser();
		
		switch(Error)
		{
		case 0:
		{
			System.out.println("Lexing and Parsing took "+watch.getElapsedTime()+" miliseconds");
			break;
		}
		case 1:
		{
			System.out.println("Critical Error in Lexer, will stop compiling");
			System.exit(0);
		}
		case 2:
		{
			System.out.println("Critical Error in Parser, will stop compiling");
			System.exit(0);
		}
		case 10:
		{
			System.out.println("Critical Error in IO, will stop compiling");
			System.exit(0);
		}
		break;
		}
		
		
		SymbolTable.CreateScopeTable();
		//SEMANTIC ANALYSER (YOU NEED THE START NODE FROM THE PARSER HERE)
		compiler.testSemanticAnalyser(start);
		
		//CODE GENERATOR
		compiler.testCodeGenerator(start);
		
		watch.stop();
		System.out.println("Compiling took "+watch.getElapsedTime()+" miliseconds");
		System.out.flush();

	}

	
	
}
