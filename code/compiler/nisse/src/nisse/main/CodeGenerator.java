package nisse.main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import nisse.analysis.DepthFirstAdapter;
import nisse.node.ABlockBlocks;
import nisse.node.ACharallPlainsv1;
import nisse.node.AItemlistItemlistv1;
import nisse.node.AItemlistLines;
import nisse.node.ANumerationLines;
import nisse.node.ANumerationNumerationv1;
import nisse.node.APlaintextItemlistv1;
import nisse.node.APlaintextLines;
import nisse.node.APlaintextNumerationv1;
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
	int symbolCounter = 0;
	boolean isEnumerating = false;
	boolean isItemlisting = false;
	boolean isInTitle = false;
	boolean isInSubtitle = false;
	boolean isInSpan = false;
	boolean isInUrl = false;
	boolean isInImage = false;
	String prevStyle = "";
	String prevUrl = "";
	int prevNumerationLevel = 0;
	int currentNumerationLevel = 0;
	
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
			out.write(str);
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
		try {
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeToStream("\n<style type=\"text/css\">\n");
		writeToStream("img {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontLineheight]+";\n");
		writeToStream("font-size:"+fontSizeToPercent(Integer.parseInt(SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontSize]))+";\n");
		String weight = SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewImageFontWeight];
		String[] weights = weight.split("\\s");
		weight = "";
		for (String string : weights) {
			if (string.contains("b"))
			{
				writeToStream("font-weight:bold;\n");
			}
			else if (string.contains("i"))
			{
				writeToStream("font-style:italic;\n");
			}
			else if (string.contains("u"))
			{
				writeToStream("text-decoration:underline\n");
			}
		}
		writeToStream("}\n");
		
		writeToStream(".subtitle {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontLineheight]+";\n");
		writeToStream("font-size:"+fontSizeToPercent(Integer.parseInt(SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontSize]))+";\n");
		String weight1 = SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewSubtitleFontWeight];
		String[] weights1 = weight1.split("\\s");
		weight1 = "";
		for (String string : weights1) {
			if (string.contains("b"))
			{
				writeToStream("font-weight:bold;\n");
			}
			else if (string.contains("i"))
			{
				writeToStream("font-style:italic;\n");
			}
			else if (string.contains("u"))
			{
				writeToStream("text-decoration:underline\n");
			}
		}
		writeToStream("}\n");
		
		writeToStream("body {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontLineheight]+";\n");
		writeToStream("font-size:"+fontSizeToPercent(Integer.parseInt(SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontSize]))+";\n");
		String weight2 = SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontWeight];
		String[] weights2 = weight2.split("\\s");
		weight2 = "";
		for (String string : weights2) {
			if (string.contains("b"))
			{
				writeToStream("font-weight:bold;\n");
			}
			else if (string.contains("i"))
			{
				writeToStream("font-style:italic;\n");
			}
			else if (string.contains("u"))
			{
				writeToStream("text-decoration:underline\n");
			}
		}
		writeToStream("}\n");
		
		writeToStream(".title {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontLineheight]+";\n");
		writeToStream("font-size:"+fontSizeToPercent(Integer.parseInt(SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontSize]))+";\n");
		String weight3 = SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTitleFontWeight];
		String[] weights3 = weight3.split("\\s");
		weight3 = "";
		for (String string : weights3) {
			if (string.contains("b"))
			{
				writeToStream("font-weight:bold;\n");
			}
			else if (string.contains("i"))
			{
				writeToStream("font-style:italic;\n");
			}
			else if (string.contains("u"))
			{
				writeToStream("text-decoration:underline\n");
			}
		}
		writeToStream("}\n");
		
		writeToStream("a {\n");
		writeToStream("color:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontColor]+";\n");
		writeToStream("font-family:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontFamily]+";\n");
		writeToStream("line-height:"+SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontLineheight]+";\n");
		writeToStream("font-size:"+fontSizeToPercent(Integer.parseInt(SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontSize]))+";\n");
		String weight4 = SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewUrlFontWeight];
		String[] weights4 = weight4.split("\\s");
		weight4 = "";
		for (String string : weights4) {
			if (string.contains("b"))
			{
				writeToStream("font-weight:bold;\n");
			}
			else if (string.contains("i"))
			{
				writeToStream("font-style:italic;\n");
			}
			else if (string.contains("u"))
			{
				writeToStream("text-decoration:underline\n");
			}
		}
		writeToStream("}\n");
		writeToStream("</style>");
		
		writeToStream("</head>\n <body style=\"font-size: 58.5%; \">\n <div id=\"wrapper\" data-ratio=\"4/3\">\n <div id=\"axis\" style=\"margin-left: 336px; \">\n");
	}
	public void outStart(Start node)
	{
		writeToStream("</div>\n</div>\n</body></html>");
		try {
			out.flush();
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
		if (Transition == "none")
		{
			Transition = "fade";
		}
		String Type1 = SlideData[SlideType];
		String Type = "";
		if (Type1 == "Title" || Type1 == "XTitleXSubtitle" || Type1 == "Subtitle")
		{
			Type = "titleslide";
		}
		
		else if (Type1 == "TitleImage")
		{
			Type = "titleimgageslide";
		}
		else if (Type1 == "TitleSubtitleImage")
		{
			Type = "titleimgageslide";
		}
		else if (Type1 == "SubtitleImage")
		{
			Type = "titleimgageslide";
		}
		
		else if (Type1 == "TitleDImage")
		{
			Type = "titledimgageslide";
		}
		else if (Type1 == "TitleSubtitleDImage")
		{
			Type = "titledimgageslide";
		}
		else if (Type1 == "SubtitleDImage")
		{
			Type = "titledimgageslide";
		}
		
		else if (Type1 == "TitleTImage")
		{
			Type = "titletimgageslide";
		}
		else if (Type1 == "TitleSubtitleTImage")
		{
			Type = "titletimgageslide";
		}
		else if (Type1 == "SubtitleTImage")
		{
			Type = "titletimgageslide";
		}
		
		else if (Type1 == "TitleQImage")
		{
			Type = "titleqimgageslide";
		}
		else if (Type1 == "TitleSubtitleQImage")
		{
			Type = "titleqimgageslide";
		}
		else if (Type1 == "SubtitleQImage")
		{
			Type = "titleqimgageslide";
		}
		
		else if (Type1 == "Image")
		{
			Type = "imageslide";
		}
		else if (Type1 == "DImage")
		{
			Type = "dimageslide";
		}
		else if (Type1 == "TImage")
		{
			Type = "timageslide";
		}
		else if (Type1 == "QImage")
		{
			Type = "qimageslide";
		}
		
		else if (Type1 == "Lots")
		{
			Type = "lotsslide";
		}
		String opacity = "0";
		String top = "100%";
		if (slideCounter == 0)
		{
			opacity = "1";
			top = "0%";
		}
		String str = "<div class=\"slide_wrapper\" id=\"slide"+slideCounter+"\" data-transition=\""+Transition+"\" style=\"top: "+top+"; opacity: "+opacity+"; height: 936px; width: 1248px; \">\n<div class=\"slide\">\n<div class=\""+Type+"\">\n";
		writeToStream(str);
		slideCounter++;
	}
	public void outABlockBlocks(ABlockBlocks node)
	{
		if (isInUrl)
		{
			writeToStream("</a>\n");
			isInUrl = false;
		}
		if (isInSpan)
		{
			writeToStream("</span>\n");
			isInSpan = false;
		}
		if (isInSubtitle) 
		{
			writeToStream("</h2>\n");
			isInSubtitle = false;
		}
		if (isInTitle)
		{
			writeToStream("</h1>\n");
			isInTitle = false;
		}
		if (isInImage)
		{
			writeToStream("</div>\n");
			isInImage = false;
		}
		writeToStream("</div></div></div>\n");
	}
	public void inASettingBlocks(ASettingBlocks node)
	{
		
	}
	public void inACharallPlainsv1(ACharallPlainsv1 node)
	{
		String[] symbol = SymbolTable.SymbolTable1.get(symbolCounter);
		String style = "";
		String output = "";
		boolean printA = false;
		if (!symbol[1].equals("imagetext") && isInImage)
		{
			if (isInSpan)
			{
				if (isInUrl)
				{
					output += "</a>\n";
					isInUrl = false;
				}
				output += "</span>\n";
				isInSpan = false;
			}
			if (isInTitle)
			{
				if (isInUrl)
				{
					output += "</a>\n";
					isInUrl = false;
				}
				output += "</h1>\n";
				isInTitle = false;
			}
			if (isInSubtitle)
			{
				if (isInUrl)
				{
					output += "</a>\n";
					isInUrl = false;
				}
				output += "</h2>\n";
				isInSubtitle = false;
			}
			output += "</div>";
			isInImage = false;
		}
		if (symbol[1].equals("image"))
		{
			if (isInSpan)
			{
				if (isInUrl)
				{
					output += "</a>\n";
					isInUrl = false;
				}
				output += "</span>\n";
				isInSpan = false;
			}
			if (isInTitle)
			{
				if (isInUrl)
				{
					output += "</a>\n";
					isInUrl = false;
				}
				output += "</h1>\n";
				isInTitle = false;
			}
			if (isInSubtitle)
			{
				if (isInUrl)
				{
					output += "</a>\n";
					isInUrl = false;
				}
				output += "</h2>\n";
				isInSubtitle = false;
			}
			String[] SlideData = SymbolTable.SymbolTableForSlide.get(slideCounter);
			String imgStyle = "";
			if (!SlideData[0].equals("Image"))
			{
				imgStyle = "width:100%;";
			}
			output += "<div class=\"image\">\n<img style=\""+imgStyle+"\" src=\""+symbol[7]+"\"></br>";
			isInImage = true;
			symbolCounter++;
			symbol = SymbolTable.SymbolTable1.get(symbolCounter);
		}
		String font_size = symbol.length > 2 ? fontSizeToPercent(Integer.parseInt(symbol[2])) : "";
		String font_family = symbol.length > 3 ? symbol[3] : "";
		String font_color = symbol.length > 4 ? symbol[4] : "";
		String font_lineheight = symbol.length > 5 ? symbol[5] : "";
		String font_weight = symbol.length > 6 ? symbol[6] : "";
		String url = symbol.length > 7 ? symbol[7] : "";
		if (url != prevUrl && isInUrl)
		{
			output += "</a>";
			isInUrl = false;
		}
		if (font_size != fontSizeToPercent(Integer.parseInt(SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontSize])))
		{
			style += "font-size:"+font_size+"; ";
		}
		if (font_family != SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontFamily])
		{
			style += "font-family:"+font_family+"; ";
		}
		if (font_color != SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontColor])
		{
			style += "color:"+font_color+"; ";
		}
		if (font_lineheight != SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontLineheight])
		{
			style += "line-height:"+font_lineheight+"; ";
		}
		if (font_weight != SymbolTable.Scope[SymbolTable.OuterMostScope][SymbolTable.NewTextFontWeight])
		{
			String[] weights = font_weight.split("\\s");
			
			for (String string : weights) {
				if (string.contains("b"))
				{
					
					style += "font-weight:bold; ";
				}
				else if (string.contains("i"))
				{
					style += "font-style:italic; ";
				}
				else if (string.contains("u"))
				{
					style += "text-decoration:underline; ";
				}
			}
		}
		if (style != "")
		{
			style = "style=\""+style+"\"";
		}
		if (style.equals(prevStyle) && (isInSpan || isInSubtitle || isInTitle))
		{
			output += symbol[0];
		}
		else {
			if (symbol[1] == "text")
			{
				
				if (isInSpan)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</span>\n";
					isInSpan = false;
				}
				if (isInTitle)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</h1>\n";
					isInTitle = false;
				}
				if (isInSubtitle)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</h2>\n";
					isInSubtitle = false;
				}
				if (!isInSpan)
				{
					output += "<span "+style+">";
					
					isInSpan = true;
				}
				if (url != "")
				{
					if (prevUrl != url || !isInUrl)
					{
						output += "<a href=\""+url+"\" target=\"_top\">";
						isInUrl = true;
					}
				}
				output += symbol[0];
			}
			else if (symbol[1] == "title")
			{
				if (isInSpan)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</span>\n";
					isInSpan = false;
				}
				if (isInSubtitle)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</h2>\n";
					isInSubtitle = false;
				}
				if (isInTitle)
				{
					output += "<span "+style+">";
					isInSpan = true;
				}
				if (!isInTitle)
				{
					output += "<h1 class =\"title\"><span "+style+">";
					
					isInTitle = true;
					isInSpan = true;
				}
				if (url != "")
				{
					if (prevUrl != url || !isInUrl)
					{
						output += "<a href=\""+url+"\" target=\"_top\">";
						printA = true;
						isInUrl = true;
					}
				}
				output += symbol[0];
			}
			else if (symbol[1] == "subtitle")
			{
				if (isInSpan)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</span>\n";
					isInSpan = false;
				}
				if (isInTitle)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</h1>\n";
					isInTitle = false;
				}
				if (!isInSubtitle)
				{
					output += "<h2 class=\"subtitle\"><span "+style+">";
					isInSubtitle = true;
					isInSpan = true;
				}
				if (url != "")
				{
					if (prevUrl != url || !isInUrl)
					{
						output += "<a href=\""+url+"\" target=\"_top\">";
						printA = true;
						isInUrl = true;
					}
				}
				output += symbol[0];
			}
			else if (symbol[1].equals("imagetext"))
			{
				if (isInSpan)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</span>\n";
					isInSpan = false;
				}
				if (isInTitle)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</h1>\n";
					isInTitle = false;
				}
				if (isInSubtitle)
				{
					if (isInUrl)
					{
						output += "</a>\n";
						isInUrl = false;
					}
					output += "</h2>\n";
					isInSubtitle = false;
				}
				if (url != "")
				{
					if (prevUrl != url || !isInUrl)
					{
						output += "<a href=\""+url+"\" target=\"_top\">";
						printA = true;
						isInUrl = true;
					}
				}
				if (!isInSpan)
				{
					output += "<span class=\"description\" "+style+">";
					isInSpan = true;
				}
				output += symbol[0];
			}
		}
		writeToStream(output);
		symbolCounter++;
		prevStyle = style;
		prevUrl = url;
		//Write the plain text
	}
	public String fontSizeToPercent(int size)
	{
		return (float)size/18f*100f+"%";
	}
	public void inAShortblock(AShortblock node)
	{
		//Write the text with the given "settings"
	}
	public void inANumerationLines(ANumerationLines node)
	{
		if (isItemlisting == true)
		{
			writeToStream("</ul>\n");
			isItemlisting = false;
		}
		if (isEnumerating == false)
		{
			if (isInSpan)
			{
				writeToStream("</span>\n");
				isInSpan = false;
			}
			if (isInTitle)
			{
				writeToStream("</h1>\n");
				isInTitle = false;
			}
			if (isInSubtitle)
			{
				writeToStream("</h2>\n");
				isInSubtitle = false;
			}
			writeToStream("<ol>\n");
		}
		isEnumerating = true;
		currentNumerationLevel = 1;
	}
	public void outANumerationLines(ANumerationLines node)
	{
		prevNumerationLevel = currentNumerationLevel;
	}
	public void inAItemlistLines (AItemlistLines node)
	{
		if (isEnumerating == true)
		{
			writeToStream("</ol>\n");
			isEnumerating = false;
		}
		if (isItemlisting == false)
		{
			if (isInSpan)
			{
				writeToStream("</span>\n");
				isInSpan = false;
			}
			if (isInTitle)
			{
				writeToStream("</h1>\n");
				isInTitle = false;
			}
			if (isInSubtitle)
			{
				writeToStream("</h2>\n");
				isInSubtitle = false;
			}
			writeToStream("<ul>\n");
		}
		isItemlisting = true;
	}
	public void inAPlaintextLines (APlaintextLines node)
	{
		if (isEnumerating == true)
		{
			writeToStream("</ol>\n");
			isEnumerating = false;
		}
		if (isItemlisting == true)
		{
			writeToStream("</ul>\n");
			isItemlisting = false;
		}
	}
	public void outAPlaintextLines(APlaintextLines node)
	{
		writeToStream("<br/>");
	}
	public void inASettingLines (ASettingLines node)
	{
		if (isEnumerating == true)
		{
			writeToStream("</ol>\n");
			isEnumerating = false;
		}
		if (isItemlisting == true)
		{
			writeToStream("</ul>\n");
			isItemlisting = false;
		}
	}
	public void inANumerationNumerationv1 (ANumerationNumerationv1 node)
	{
		//writeToStream("<ol>\n");
		currentNumerationLevel++;
	}
	public void outANumerationNumerationv1 (ANumerationNumerationv1 node)
	{
		//writeToStream("</ol>\n");
	}
	public void inAItemlistItemlistv1 (AItemlistItemlistv1 node)
	{
		writeToStream("<ul>\n");
	}
	public void outAItemlistItemlistv1 (AItemlistItemlistv1 node)
	{
		writeToStream("</ul>\n");
	}
	public void inAPlaintextNumerationv1 (APlaintextNumerationv1 node)
	{
		if (currentNumerationLevel < prevNumerationLevel)
		{
			for (int i = 0; i < prevNumerationLevel-currentNumerationLevel; i++)
			{
				writeToStream("</ol>\n");
			}
		}
		if (currentNumerationLevel > prevNumerationLevel)
		{
			if (currentNumerationLevel != 1)
			{
				for (int i = 0; i < currentNumerationLevel-prevNumerationLevel; i++)
				{
					writeToStream("<ol>\n");
				}
			}
		}
		writeToStream("<li>\n");
	}
	public void outAPlaintextNumerationv1 (APlaintextNumerationv1 node)
	{
		if (isInSpan)
		{
			writeToStream("</span>\n");
			isInSpan = false;
		}
		if (isInTitle)
		{
			writeToStream("</h1>\n");
			isInTitle = false;
		}
		if (isInSubtitle)
		{
			writeToStream("</h2>\n");
			isInSubtitle = false;
		}
		writeToStream("</li>\n");
	}
	public void inAPlaintextItemlistv1 (APlaintextItemlistv1 node)
	{
		writeToStream("<li>\n");
	}
	public void outAPlaintextItemlistv1 (APlaintextItemlistv1 node)
	{
		if (isInSpan)
		{
			writeToStream("</span>\n");
			isInSpan = false;
		}
		if (isInTitle)
		{
			writeToStream("</h1>\n");
			isInTitle = false;
		}
		if (isInSubtitle)
		{
			writeToStream("</h2>\n");
			isInSubtitle = false;
		}
		writeToStream("</li>\n");
	}
}
