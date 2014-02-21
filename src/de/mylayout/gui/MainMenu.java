package de.mylayout.gui;

//import java.awt.Component;
//import java.util.HashMap;
//
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.mylayout.listener.MenuListener;

//import de.virtualprocessmanagement.listener.MenuListener;

/**
 * Menue-Klasse, derzeit nicht verwendet
 */
public class MainMenu extends JMenuBar {

	public MainMenu() //HashMap<String,Component> inputComponents)
	{
		super();

		initMenuBar(); //inputComponents);
	}
//
	private void initMenuBar() // HashMap<String, Component> inputComponents)
	{
		MenuListener menuListener = new MenuListener(); // inputComponents);
		
		JMenu help = new JMenu("Hilfe");
		JMenu properties = new JMenu("Einstellungen");
		JMenu file = new JMenu("Datei");
		
		properties.setName("properties");
		properties.addMouseListener(menuListener);
		
		JMenuItem item;

		item = new JMenuItem("Lade Layout");
		item.setName("load");
		item.addActionListener(menuListener);
		file.add(item);

		item = new JMenuItem("Speichere Layout");
		item.setName("save");
		item.addActionListener(menuListener);
		file.add(item);

		item = new JMenuItem("Drucke Layout");
		item.setName("print");
		item.addActionListener(menuListener);
		file.add(item);

//		item = new JMenuItem("Exportiere Funktionsplot");
//		item.setName("saveFktPlot");
//		item.addActionListener(menuListener);
//		file.add(item);
		
		file.addSeparator();

		item = new JMenuItem("Exit");
		item.setName("exit");
		item.addActionListener(menuListener);
		file.add(item);
		
//		item = new JMenuItem("plotSolution");
//		item.setName("about");
//		item.addActionListener(menuListener);
		
		item = new JMenuItem("About");
		item.setName("about");
		item.addActionListener(menuListener);

		help.add(item);

		add(file);
		add(properties);
		add(help);
	}
}
