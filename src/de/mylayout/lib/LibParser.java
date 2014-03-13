package de.mylayout.lib;

import java.io.File;
import java.util.Arrays;

import de.mylayout.tools.Xml;

public class LibParser {
	
	Xml xml = new Xml();
	
	File file = new File(xml.getElement("home"));
	
	String libs = "";
	
	public LibParser()
	{
		
	}
	
	public String[] getLibList()
	{
		String str;
		
		String retArr[];
		
		for (File fileEntry : file.listFiles())
		{
	        if (fileEntry.isDirectory())
	        {
	        	str = fileEntry.getName(); //.replace(".lib","").replace("_lib","");
//	        	System.out.println(str);
	        	
	        	libs += str +";";
	        	
	        	for (File fileEntry2 : fileEntry.listFiles())
	        	{
	    	        if (fileEntry2.isFile() && fileEntry2.getName().endsWith(".lib")) {
//	    	        	System.out.println("\t\t"+fileEntry2.getAbsolutePath());
	    	        }
	        	}
	        } 
	    }
		
		retArr = libs.substring(0, libs.length()-1).split(";");
		
		Arrays.sort(retArr);
		
		return retArr;
	}
	
	public void parse()
	{
//		System.out.println(file.getAbsolutePath());
		
		for (File fileEntry : file.listFiles())
		{
	        if (fileEntry.isDirectory())
	        {
//	        	System.out.println("\t"+fileEntry.getName());
	        	
	        	libs += fileEntry.getName()+";";
	        	
	        	for (File fileEntry2 : fileEntry.listFiles())
	        	{
	    	        if (fileEntry2.isFile() && fileEntry2.getName().endsWith(".lib")) {
//	    	        	System.out.println("\t\t"+fileEntry2.getAbsolutePath());
	    	        }
	        	}
	        } 
	    }
		
//		System.out.println(libs.substring(0, libs.length()-1));
	}
}