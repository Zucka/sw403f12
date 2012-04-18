package nisse.main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import nisse.analysis.DepthFirstAdapter;
import nisse.node.ABlockBlocks;
import nisse.node.Node;
import nisse.node.Start;

public class CodeGenerator extends DepthFirstAdapter{
	FileWriter file = null;
	BufferedWriter out = null;
	FileReader in = null;
	int slideCounter = 0;
	public CodeGenerator()
	{
		try {
			file = new FileWriter("output.html");
			URL url = getClass().getResource("prefix");
			in = new FileReader(url.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out = new BufferedWriter(file);
	}
	private void writeToStream(String str)
	{
		try {
			out.write(str+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void defaultIn(Node node)
	{
		
	}
	public void defaultOut(Node node)
	{
		
	}
	public void inStart(Start node)
	{
		char[] buffer = new char[255];
		StringBuilder builder = new StringBuilder();
		try {
			while (in.read(buffer, 0, buffer.length) != -1)
			{
				builder.append(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		writeToStream(builder.toString());
	}
	public void outStart(Start node)
	{
		writeToStream("</div>\n</div>\n</body></html>");
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void inABlockBlocks(ABlockBlocks node)
	{
		// NEED TO FIND OUT IF SLIDE IS TITLESLIDE, IMAGESLIDE OR NORMAL SLIDE
		String opacity = "1";
		if (slideCounter == 0)
		{
			opacity = "0";
		}
		String str = "<div class=\"slide_wrapper\" id=\"slide"+slideCounter+"\" style=\"opacity: "+opacity+"; height: 936px; width: 1248px; \">\n<div class=\"slide\">";
		writeToStream(str);
		slideCounter++;
	}
	public void outABlockBlocks(ABlockBlocks node)
	{
		writeToStream("</div></div>");
	}
}
