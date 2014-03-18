package de.mylayout.lib;

import java.util.ArrayList;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.objects.Circle;

public class LibraryComponent {
	
	private ArrayList<ObjectInterface> objects = new ArrayList<ObjectInterface>();
	
	private LibraryButton libraryButton = new LibraryButton(objects);
	
	private ArrayList<String> libLines = new ArrayList<String>();
	
	private boolean ready = false;
	
	private String name = null;
	
	private double minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
	private double maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
	
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
						 parseDEF(line);
					else
						if(line.contains("X "))	// Kontakt erzeugen
							parseX(line);
					
//					System.out.println(line);
				}
				
				libLines.clear();
			}
//		}.start();
	}
	
	private void parseDEF(String line)
	{
		String split[] = line.split(" ");
		
		setName(split[1]);
		
		System.out.println("\nBauteilname: "+name);
	}
	
	private void parseX(String line)
	{
		Circle c = null;
		
		int id;
		double x, y, length;
		
		String split[] = line.split(" ");
		
		setName(split[1]);
		
		id = Integer.parseInt(split[2]);
		x = Double.parseDouble(split[3]) / 10;
		y = Double.parseDouble(split[4]) / 10;
		length = Double.parseDouble(split[5]) / 10;
		
		if(x < minX) minX = x;
		if(y < minY) minY = y;
		if(x > maxX) maxX = x;
		if(y > maxY) maxY = y;

		c = new Circle(id, x, y, length, length);
		c.setFill(true);
		
		objects.add(c);
		
		System.out.println("Pin-Name: "+name+" id="+id+" x="+x+" y="+y+" length="+length);
	}

}
