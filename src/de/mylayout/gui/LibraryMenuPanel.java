package de.mylayout.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import de.mylayout.lib.LibParser;

//import de.virtualprocessmanagement.listener.MenuListener;
//import de.virtualprocessmanagement.tools.Dialog;

public class LibraryMenuPanel extends JPanel implements ActionListener {
	
	/**
	 * Der Konstruktor erhaelt die HashMap, welche verschiedene
	 * Komponenten Objekte beinhaltet (Textfelder, Checkboxen, usw.)
	 * @param inputComponents
	 */
	public LibraryMenuPanel(HashMap<String, Component> inputComponents)
	{
		initPanel(inputComponents);
	}

	/**
	 * Initialisierung des Panels mit Buttons und Icons fuer das Menue 
	 * @param inputComponents
	 */
	private void initPanel(HashMap<String, Component> inputComponents)
	{
		setBackground(new Color(215, 215, 215));	// Hintergrundfarbe festlegen
		setLayout(new BorderLayout());
		
		LibParser lp = new LibParser();	// Testen des KiCad-parsers
			
		String libList[] = lp.getLibList();
		
		JComboBox<String> library = new JComboBox<String>(libList);
		library.addActionListener(this);
		
		add(library, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(((JComboBox<String>)arg0.getSource()).getSelectedItem().toString());
		
	}
}