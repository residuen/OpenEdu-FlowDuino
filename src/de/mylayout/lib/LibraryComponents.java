/**
 * http://www.kicadlib.org/
 * http://en.wikibooks.org/wiki/Kicad/file_formats
 */

package de.mylayout.lib;

import java.util.ArrayList;

import de.mylayout.interfaces.ObjectInterface;

public class LibraryComponents {
	
	private int id;
	
	private String name;
	
	private ArrayList<ObjectInterface> pins = new ArrayList<ObjectInterface>();

}
