package de.mylayout.lib;

import java.util.ArrayList;

import de.mylayout.interfaces.ObjectInterface;

public class LibraryComponent {
	
	private ArrayList<ObjectInterface> objects = new ArrayList<ObjectInterface>();
	
	private ArrayList<String> libLines = new ArrayList<String>();
	
	private boolean ready = false;
	
	private String name = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void addLine(String line)
	{
		libLines.add(line);
	}
	
	public void build()
	{
//		new Thread()
//		{ 
//			public void run ()
			{
				for(String line : libLines)
				{
					if(line.contains("DEF "))
						 ParseDEF(line);
					
//					System.out.println(line);
				}
			}
//		}.start();
	}
	
	private void ParseDEF(String line)
	{
		String split[] = line.split(" ");
		
		setName(split[1]);
		
		System.out.println("mein Name ist "+getName());
	}

}
