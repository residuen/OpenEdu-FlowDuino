/**
 * http://www.kicadlib.org/
 * http://en.wikibooks.org/wiki/Kicad/file_formats
 */

package de.mylayout.lib;

import java.util.ArrayList;

public class Library {
	
	private int id;
	
	private int count = 0;
	
	private String name;
	
	private ArrayList<LibraryComponent> libraryComponents = new ArrayList<LibraryComponent>();
	
	public void buildLibrary(final String[] data)
	{
		LibraryComponent lc = new LibraryComponent();
		
//		System.out.println("\n***** "+getName()+" *****");
		
		// Start des neuen Objektes suchen
		for(String s : data)
		{
//			System.out.println("s: "+s);
//			System.out.println("lc.isReady()="+lc.isReady());
			// Anfang suchen und neues Objekt erzeugen
			if(s.toLowerCase().contains("def") && !s.toLowerCase().contains("enddef") && !lc.isReady())
			{
//				System.out.println("Bauteilname: "+s);
				lc = new LibraryComponent();
				libraryComponents.add(lc);
				lc.setReady(true);
				lc.addLine(s);
				
				count++;
				
				continue;
			}
			
			// Objektinfos auslesen
			if(lc.isReady())
			{
//				System.out.println("line: "+s);
				lc.addLine(s);
				
				// Ende markieren
				if(s.toLowerCase().contains("enddef"))
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

	public ArrayList<LibraryComponent> getLibraryComponents() {
		return libraryComponents;
	}
	
	public int getCount() {
		return count;
	}
}
