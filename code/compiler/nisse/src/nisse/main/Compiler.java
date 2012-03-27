package nisse.main;

import java.io.IOException;

import nisse.analysis.DepthFirstAdapter;
import nisse.lexer.Lexer;
import nisse.lexer.LexerException;
import nisse.node.Start;
import nisse.node.Switchable;
import nisse.node.Token;
import nisse.parser.Parser;
import nisse.parser.ParserException;
import nisse.parser.TokenIndex;

public class Compiler {
	private final TokenIndex converter = new TokenIndex(); 
	private Lexer lexer;
	private Parser parser;
	
	public Compiler(Lexer lexer, Parser parser) {
		this.lexer = lexer;
		this.parser = parser;
	}
	
	public void testLexer()
	{
		try {
			while (index(lexer.peek()) != 19)
			{
				Token token = lexer.next();
				System.out.print(index(token));
				System.out.print(": "+token.getText());
				System.out.print(" on line "+token.getLine()+" at column "+token.getPos()+"\n");
			}
		} catch (LexerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Start testParser()
	{
		Start start = null;
		try {
			start = parser.parse();
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (LexerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return start;
	}
	private int index(Switchable token)
	{
		this.converter.index = -1;
		token.apply(this.converter);
		return this.converter.index;
	}

}
