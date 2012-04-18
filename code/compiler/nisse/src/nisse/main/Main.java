package nisse.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PushbackReader;
import java.io.Reader;

import nisse.lexer.Lexer;
import nisse.node.Start;
import nisse.parser.Parser;

public class Main {

	
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();
		watch.start();
		Reader input = null;
		try {
			input = new FileReader("c:/fisk/test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		PushbackReader in = new PushbackReader(input, 1024);
		Lexer lexer = new Lexer(in);
		Parser parser = new Parser(lexer);
		Compiler compiler = new Compiler(lexer, parser);
		
		//LEXER (CAN'T RUN LEXER IF YOU ALSO WANT TO RUN PARSER)
		//compiler.testLexer();
		
		//PARSER
		Start start = compiler.testParser();
		System.out.println("Lexing and Parsing took "+watch.getElapsedTime()+" miliseconds");
		
		//SEMANTIC ANALYSER (YOU NEED THE START NODE FROM THE PARSER HERE)
		compiler.testSemanticAnalyser(start);
		
		watch.stop();
		System.out.println("Compiling took "+watch.getElapsedTime()+" miliseconds");
		Settings opt = new Settings();
		opt.loadSettings();

	}
	
	
}
