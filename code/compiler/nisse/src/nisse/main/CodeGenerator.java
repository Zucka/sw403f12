package nisse.main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import nisse.analysis.DepthFirstAdapter;
import nisse.node.ABlockBlocks;
import nisse.node.ACharallPlainsv1;
import nisse.node.APlaintextLines;
import nisse.node.ASettingblock;
import nisse.node.AShortblock;
import nisse.node.Node;
import nisse.node.Start;

public class CodeGenerator extends DepthFirstAdapter{
	FileWriter file = null;
	BufferedWriter out = null;
	FileReader in = null;
	int slideCounter = 0;
	int divsToPrintFromSettings = 0;
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
		String divs = "";
		for (int i = 0; i < divsToPrintFromSettings; i++) {
			divs += "</div>\n";
		}
		writeToStream(divs+"</div>\n</div>\n</body></html>");
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
		String transition = "fade"; //NEED TO KNOW THIS ALSO (TEST TRANSITION)
		String opacity = "0";
		String top = "100%";
		if (slideCounter == 0)
		{
			opacity = "1";
			top = "0%";
		}
		String str = "<div class=\"slide_wrapper\" id=\"slide"+slideCounter+"\" data-transition=\""+transition+"\" style=\"top: "+top+"; opacity: "+opacity+"; height: 936px; width: 1248px; \">\n<div class=\"slide\">";
		writeToStream(str);
		slideCounter++;
	}
	public void outABlockBlocks(ABlockBlocks node)
	{
		writeToStream("</div></div>");
	}
	public void inASettingblock(ASettingblock node)
	{
		//Find out which setting to set
		writeToStream("<div style=\"\">");
		divsToPrintFromSettings++;
	}
	public void inACharallPlainsv1(ACharallPlainsv1 node)
	{
		//Write the plain text
	}
	public void inAShortblock(AShortblock node)
	{
		//Write the text with the given "settings"
	}
}
