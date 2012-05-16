package nisse.main;

public class Settings {

}
//package nisse.main;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Settings {
//	private FileReader data = null;
//	public List<settings> sList = new ArrayList<settings>();
//	private int currentListLocation = -1;
//	public Settings ()
//	{
//		
//	}
//	public void loadSettings()
//	{
//		try {
//			URL url = getClass().getResource("Data");
//			data = new FileReader(new File(url.getPath()));
//		} catch (FileNotFoundException e) {
//			System.out.println("Could not open settings file: Data");
//			e.printStackTrace();
//			e.getMessage();
//		}
//		char[] buffer = new char[255];
//		StringBuilder builder = new StringBuilder();
//		try {
//			while (data.read(buffer, 0, buffer.length) != -1)
//			{
//				builder.append(buffer);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Pattern pattern = Pattern.compile("([^\n\r]+)");
//		Matcher matcher = pattern.matcher(builder);
//		while (matcher.find())
//		{
//			if (matcher.group(0).substring(0, 1).contains("["))
//			{
//				sList.add(new settings(matcher.group(0).substring(1, matcher.group(0).length()-1)));
//				currentListLocation++;
//			}
//			else {
//				if (currentListLocation == -1)
//				{
//					//FEJL
//				}
//				String[] temp = matcher.group(0).split("[:]");
//				sList.get(currentListLocation).options.add(new settingsOptions(temp[0],temp[1]));
//			}
//		}
//		try {
//			data.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	private class settingsOptions
//	{
//		public settingsOptions(String name, String value) {
//			this.name = name;
//			this.value = value;
//		}
//		public String name;
//		public String value;
//	}
//	private class settings
//	{
//		public settings(String name) {
//			this.name = name;
//		}
//		public String name;
//		public String temp;
//		public List<settingsOptions> options = new ArrayList<settingsOptions>();
//	}
//}
