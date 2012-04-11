package nisse.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Settings {
	private FileReader data = null;
	public List<settings> sList = new ArrayList<settings>();
	public Settings ()
	{
		
	}
	public void loadSettings()
	{
		try {
			URL url = getClass().getResource("Data");
			data = new FileReader(new File(url.getPath()));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open settings file: Data");
			e.printStackTrace();
			e.getMessage();
		}
		char[] buffer = new char[255];
		StringBuilder builder = new StringBuilder();
		try {
			while (data.read(buffer, 0, buffer.length) != -1)
			{
				builder.append(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Pattern pattern = Pattern.compile("(\\x5B[a-zA-Z_]+\\x5D)");
		Pattern pattern2 = Pattern.compile("[^(\\x5B\n\r)]+");
		Matcher matcher = pattern.matcher(builder);
		Matcher matcher2 = pattern2.matcher(builder);
		matcher.find();
		int end = matcher.end(1);
		int start = matcher.start(1);
		do
		{
			settings s = new settings();
			s.name = matcher.group(1);
			System.out.println(matcher.group(1));
			while (matcher2.find(end))
			{
				System.out.println(matcher2.group());
				String[] match = matcher2.group().split(":");
				settingsOptions sOptions = new settingsOptions();
				sOptions.name = match[0];
				sOptions.value = match[1];
				s.options.add(sOptions);
				end = matcher2.end();
			}
			sList.add(s);
		} while (matcher.find());
		System.out.println(sList.get(0).name);
		System.out.println(sList.get(0).options.get(0).name);
		System.out.println(sList.get(0).options.get(0).value);
		//System.out.println("PRINTING SETTINGS:");
		//System.out.println(buffer3[1]);
		try {
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private class settingsOptions
	{
		public String name;
		public String value;
	}
	private class settings
	{
		public String name;
		public String temp;
		public List<settingsOptions> options = new ArrayList<settingsOptions>();
	}
}
