package de.flowduino.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import de.mylayout.lib.LibReader;
import de.mylayout.lib.Library;
import de.mylayout.lib.LibraryComponent;
import de.mylayout.test.TestTheLib;

//import de.virtualprocessmanagement.listener.MenuListener;
//import de.virtualprocessmanagement.tools.Dialog;

public class LibraryMenuPanel extends JPanel implements ActionListener {
	
	private LibReader libraryReader = null;
	
	private HashMap<String, JPanel> libPanels = new HashMap<String, JPanel>();
	
	private String lastPanelKey = null;
	
	private Box vBox = Box.createVerticalBox();
	/**
	 * Der Konstruktor erhaelt die HashMap, welche verschiedene
	 * Komponenten Objekte beinhaltet (Textfelder, Checkboxen, usw.)
	 * @param inputComponents
	 */
	public LibraryMenuPanel(HashMap<String, Component> inputComponents)
	{
		initPanel(inputComponents);
		
		initElectricComponents();
	}

	/**
	 * Initialisierung des Panels mit Buttons und Icons fuer das Menue 
	 * @param inputComponents
	 */
	private void initPanel(HashMap<String, Component> inputComponents)
	{
		setBackground(new Color(215, 215, 215));	// Hintergrundfarbe festlegen
		setLayout(new BorderLayout());
		
//		JPanel p = new JPanel();
		
		LibReader lp = new LibReader();	// Testen des KiCad-parsers
			
		String libList[] = lp.getLibList();
		
		JComboBox<String> library = new JComboBox<String>(libList);
		library.addActionListener(this);

//		p.add(vBox);
		
		add(library, BorderLayout.NORTH);
		add(new JScrollPane(vBox), BorderLayout.CENTER);
	}
	
	private void initElectricComponents()
	{
		libraryReader = new LibReader();
		
		libraryReader.parse();
		
		ArrayList<Library> libs = libraryReader.getLibrary();
		
		JPanel libPanel = null;
		
		Box b = null;
		
		for(Library l : libs)
		{
			System.out.println("Bibliothek: "+l.getName()+" Bauteile: "+l.getCount());
			
			libPanel = new JPanel(new GridLayout(1, 1));
			libPanel.setVisible(false);
			
			b = Box.createVerticalBox();
			
			libPanel.add(b);
			
			libPanels.put(l.getName(), libPanel);
			
			for(LibraryComponent lc : l.getLibraryComponents())
			{
//				System.out.println(lc.getLibraryButton());
				
				b.add(lc.getLibraryButton());
				b.add(new JLabel(lc.getName()));
				b.add(Box.createVerticalStrut(3));
			}
			
			vBox.add(libPanel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		@SuppressWarnings("unchecked")
		String cmd = ((JComboBox<String>)arg0.getSource()).getSelectedItem().toString();
		
//		TestTheLib tl = new TestTheLib();
		
		if(lastPanelKey == null)
		{
			libPanels.get(cmd).setVisible(true);
			
			lastPanelKey = cmd;
		}
		else
		{
			libPanels.get(lastPanelKey).setVisible(false);
			libPanels.get(cmd).setVisible(true);
			
			lastPanelKey = cmd;
		}
		
		validate();
		
		System.out.println(cmd);
		
//		for(Iterator<String> it = libPanels.keySet().iterator(); it.hasNext();)
//		{
////			System.out.println("it="+it.next());
//		}

	}
}