/**
 * http://www.kicadlib.org/
 * http://en.wikibooks.org/wiki/Kicad/file_formats
 */

package de.mylayout.lib;

import java.util.ArrayList;

public class Library {
	
	private int id;
	
	private String name;
	
	private ArrayList<LibraryComponent> pins = new ArrayList<LibraryComponent>();
	
	public void buildLibrary(final String[] data)
	{
		LibraryComponent lc = new LibraryComponent();
		
		System.out.println("\n***** "+getName()+" *****");
		
		// Start des neuen Objektes suchen
		for(String s : data)
		{	
			// Anfang suchen und neues Objekt erzeugen
			if(s.contains("DEF") && !s.contains("ENDDEF") && !lc.isReady())
			{
//				System.out.println(s);
				lc = new LibraryComponent();
				pins.add(lc);
				lc.setReady(true);
				lc.addLine(s);
				
				continue;
			}
			
			// Objektinfos auslesen
			if(lc.isReady())
			{
//				System.out.println(s);
				lc.addLine(s);
				
				// Ende markieren
				if(s.toLowerCase().contains("#end library"))
				{
					lc.setReady(false);
					lc.build();	// Build-Prozess starten
				}
			}
		}
	}

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
