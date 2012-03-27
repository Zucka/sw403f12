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
		SemanticAnalyser analyser = new SemanticAnalyser();
		//compiler.testLexer();
		Start start = compiler.testParser();
		System.out.println(start.toString());
		analyser.caseStart(start);
	}
	
	
}
