package de.mylayout.lib;

import java.util.ArrayList;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.objects.Circle;
import de.mylayout.objects.Line;

public class LibraryComponent {
	
	private ArrayList<ObjectInterface> objects = new ArrayList<ObjectInterface>();
	
	private LibraryButton libraryButton = new LibraryButton(objects);
	
	private ArrayList<String> libLines = new ArrayList<String>();
	
	private boolean ready = false;
	
	private String name = null;
	
//	private double minX = 0, minY = 0;
//	private double maxX = 0, maxY = 0;
	private double minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
	private double maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
		libraryButton.setName(name);
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
//			{
				for(String line : libLines)
				{
					if(line.contains("DEF "))
						 parseDEF(line);
					else
						if(line.contains("X ") && !line.contains("ALIAS "))	// Kontakt erzeugen
							parseX(line);
						else
							if(line.contains("S ") && !line.contains("ALIAS "))	// Kontakt erzeugen
								parseS(line);
					
//					System.out.println(line);
				}
				
				libLines.clear();	// Bibliotheksdaten (Strings) loeschen
				libraryButton.setMinX(minX);
				libraryButton.setMinY(minY);
				libraryButton.setMaxX(maxX);
				libraryButton.setMaxY(maxY);
//				libraryButton.setMinValues(minX, minY);
//				libraryButton.setMaxValues(maxX, maxY);
//			}
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
		x = Double.parseDouble(split[3]) / 10d;
		y = Double.parseDouble(split[4]) / 10d;
		length = Double.parseDouble(split[5]) / 10d;
		
		if(x < minX) minX = x;
		if(y < minY) minY = y;
		if(x > maxX) maxX = x;
		if(y > maxY) maxY = y;

		c = new Circle(id, x, y, length, length);
		c.setFill(true);
		
		objects.add(c);
		
		System.out.println("Pin-Name: "+name+" id="+id+" x="+x+" y="+y+" length="+length);
	}

	private void parseS(String line)
	{
		Line c = null;
		
//		int id;
		double x1, y1, x2, y2, b, h;
		
		String split[] = line.split(" ");
//		System.out.println("split[1]="+split[1]);
		
//		setName(split[1]);
		
//		id = Integer.parseInt(split[2]);
		x1 = Double.parseDouble(split[1]) / 10d;
		y1 = Double.parseDouble(split[2]) / 10d;
		x2 = Double.parseDouble(split[3]) / 10d;
		y2 = Double.parseDouble(split[4]) / 10d;
		b = x2 - x1;
		h = y2 - y1;
		
		if(x1 < minX) minX = x1;
		if(y1 < minY) minY = y1;
		if(x1 > maxX) maxX = x1;
		if(y1 > maxY) maxY = y1;

		if(x2 < minX) minX = x2;
		if(y2 < minY) minY = y2;
		if(x2 > maxX) maxX = x2;
		if(y2 > maxY) maxY = y2;

		c = new Line(0, x1, y1, b, h);
//		c.setFill(true);
		
		objects.add(c);
		
		System.out.println("Rect-Name: "+name+" x1="+x1+" y1="+y1+" b="+b+" h="+h);
	}

	public double getMinX() {
		return minX;
	}

	public double getMinY() {
		return minY;
	}

	public LibraryButton getLibraryButton() {
		return libraryButton;
	}
}
