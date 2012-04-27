package nisse.main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import nisse.analysis.DepthFirstAdapter;
import nisse.node.ABlockBlocks;
import nisse.node.ACharallPlainsv1;
import nisse.node.AItemlistLines;
import nisse.node.ANumerationLines;
import nisse.node.APlaintextLines;
import nisse.node.ASettingBlocks;
import nisse.node.ASettingLines;
import nisse.node.ASettingblock;
import nisse.node.AShortblock;
import nisse.node.Node;
import nisse.node.Start;

public class CodeGenerator extends DepthFirstAdapter{
	FileWriter file = null;
	BufferedWriter out = null;
	FileReader in = null;
	int slideCounter = 0;
	boolean isEnumerating = false;
	boolean isItemlisting = false;
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
		
		writeToStream("<style type=\"text/css\">");
		writeToStream("image {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontLineheight]+";\n");
		writeToStream("font-size:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontSize]+";\n");
		writeToStream("font-weight:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontWeight]+";\n");
		writeToStream("}\n");
		
		writeToStream(".subtitle {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontLineheight]+";\n");
		writeToStream("font-size:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontSize]+";\n");
		writeToStream("font-weight:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontWeight]+";\n");
		writeToStream("}\n");
		
		writeToStream("body {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontLineheight]+";\n");
		writeToStream("font-size:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontSize]+";\n");
		writeToStream("font-weight:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontWeight]+";\n");
		writeToStream("}\n");
		
		writeToStream(".title {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontLineheight]+";\n");
		writeToStream("font-size:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontSize]+";\n");
		writeToStream("font-weight:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontWeight]+";\n");
		writeToStream("}\n");
		
		writeToStream("a {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontLineheight]+";\n");
		writeToStream("font-size:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontSize]+";\n");
		writeToStream("font-weight:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontWeight]+";\n");
		writeToStream("}\n");
		writeToStream("</style>");
		
		writeToStream("</head>\n <body style=\"font-size: 58.5%; \">\n <div id=\"wrapper\" data-ratio=\"4/3\">\n <div id=\"axis\" style=\"margin-left: 336px; \">\n");
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
		String[] SlideData = SymbolTable.SymbolTableForSlide.get(slideCounter+1);
		int SlideType = 0;
		int SlideTransition = 1;
		String Transition = SlideData[SlideTransition];
		String Type1 = SlideData[SlideType];
		String Type = "";
		if (Type1 == "Title" || Type1 == "TitleWithSubtitle")
		{
			Type = "titleslide";
		}
		else if (Type1 == "Image")
		{
			Type = "imageslide";
		}
		String opacity = "0";
		String top = "100%";
		if (slideCounter == 0)
		{
			opacity = "1";
			top = "0%";
		}
		String str = "<div class=\"slide_wrapper\" id=\"slide"+slideCounter+"\" data-transition=\""+Transition+"\" style=\"top: "+top+"; opacity: "+opacity+"; height: 936px; width: 1248px; \">\n<div class=\"slide\">\n<div class=\""+Type+"\">";
		writeToStream(str);
		slideCounter++;
	}
	public void outABlockBlocks(ABlockBlocks node)
	{
		writeToStream("</div></div>");
	}
	public void inASettingBlocks(ASettingBlocks node)
	{
		
	}
	public void inACharallPlainsv1(ACharallPlainsv1 node)
	{
		//Write the plain text
	}
	public void inAShortblock(AShortblock node)
	{
		//Write the text with the given "settings"
	}
	public void inANumerationLines(ANumerationLines node)
	{
		if (isItemlisting == true)
		{
			writeToStream("</ul>");
			isItemlisting = false;
		}
		if (isEnumerating == false)
		{
			writeToStream("<ol>");
		}
		isEnumerating = true;
	}
	public void inAItemlistLines (AItemlistLines node)
	{
		if (isEnumerating == true)
		{
			writeToStream("</ol>");
			isEnumerating = false;
		}
		if (isItemlisting == false)
		{
			writeToStream("<ul>");
		}
		isItemlisting = true;
	}
	public void inAPlaintextLines (APlaintextLines node)
	{
		if (isEnumerating == true)
		{
			writeToStream("</ol>");
			isEnumerating = false;
		}
		if (isItemlisting == true)
		{
			writeToStream("</ul>");
			isItemlisting = false;
		}
	}
	public void inASettingLines (ASettingLines node)
	{
		if (isEnumerating == true)
		{
			writeToStream("</ol>");
			isEnumerating = false;
		}
		if (isItemlisting == true)
		{
			writeToStream("</ul>");
			isItemlisting = false;
		}
	}
}
