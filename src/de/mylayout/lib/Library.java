/**
 * http://www.kicadlib.org/
 * http://en.wikibooks.org/wiki/Kicad/file_formats
 */

package de.mylayout.lib;

import java.util.ArrayList;

import de.mylayout.interfaces.ObjectInterface;

public class Library {
	
	private int id;
	
	private String name;
	
	private ArrayList<LibraryComponent> pins = new ArrayList<LibraryComponent>();
	
	public void buildLibrary(final String[] data)
	{
//		new Thread()
//		{ 
//			public void run ()
//			{
				LibraryComponent lc = new LibraryComponent();
				
				// Start des neuen Objektes suchen
				for(String s : data)
				{	
					if(s.contains("DEF") && !s.contains("ENDDEF"))
					{
						System.out.println(s);
						lc = new LibraryComponent();
						pins.add(lc);
						lc.setReady(true);
						lc.addLine(s);
					}
					
					// Objektinfos auslesen
					if(lc.isReady())
					{
						System.out.println(s);
						lc.addLine(s);
					}
					
					// Ende markieren
					if(s.toLowerCase().contains("#End Library") && lc.isReady())
					{
						System.out.println(s);
						lc.addLine(s);
						lc.setReady(false);
					}
				}
//			}
//		}.start();
	}
	
//	private void ParseDEF(LibraryComponent lc, String line)
//	{
//		String split[] = line.split(" ");
//		
//		lc.setName(split[1]);
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
