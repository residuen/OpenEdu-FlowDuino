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
		
		JComboBox library = new JComboBox(new String[] { "Passive Bauteile", "Aktive Bauteile", "Optoelektonik", "ICs" } );
		library.addActionListener(this);
		
		add(library, BorderLayout.NORTH);
		
		JPanel panel = null;
		JToggleButton button = null;
		
		// GUI-Modus aus Componente lesen
//		int guiMode = new Integer(((JTextField)inputComponents.get("guimode")).getText());
		
//		MenuListener menuListener = new MenuListener(inputComponents);	// neuen MenuListener initialisieren

		Box vBox = Box.createVerticalBox();			// Box-Container fuer vertikales Layout anlegen
		Dimension dim = new Dimension(100, 80);	// Dimensions-Objekt fuer Groesse der Buttons
		Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12);	// Schriftart- und Grad festlegen

		/*
		 *  Erzeugen der Buttons
		 *  und zusammensetzen
		 *  des MenuPanels
		 */
		
		
		
		// Starten der Visualisierung
//		panel = new JPanel(new GridLayout(1, 1));
//		button = new JToggleButton("<html>Linie<br/>zeichnen</html>",
//				new ImageIcon(getClass().getResource("/de/mylayout/images/icons/x-office-presentation.png")));
//		button.setFont(font);
//		button.setToolTipText("Zeichnen einer Linie oder Leitung");
//		button.setName("line");
//		inputComponents.put(button.getName(), button);
//		button.setHorizontalTextPosition(SwingConstants.CENTER);
//		button.setVerticalTextPosition(SwingConstants.BOTTOM);
//		button.setPreferredSize(dim);
//		button.setMinimumSize(dim);
////		button.addActionListener(menuListener);
//		panel.add(button);
//		vBox.add(panel);
//		vBox.add(Box.createVerticalStrut(5));
//		
//		panel = new JPanel(new GridLayout(1, 1));
//		button = new JToggleButton("<html>Pfad<br/>zeichnen</html>",
//				new ImageIcon(getClass().getResource("/de/mylayout/images/icons/preferences-system.png")));
//		button.setFont(font);
//		button.setToolTipText("<html>Einen Pfad zeichnen</html>");
//		button.setName("path");
//		inputComponents.put(button.getName(), button);
//		button.setHorizontalTextPosition(SwingConstants.CENTER);
//		button.setVerticalTextPosition(SwingConstants.BOTTOM);
//		button.setPreferredSize(dim);
//		button.setMinimumSize(dim);
////		button.addActionListener(menuListener);
//		panel.add(button);
//		vBox.add(panel);
//		vBox.add(Box.createVerticalStrut(5));
//
//		add(vBox);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		System.out.println(arg0.getActionCommand());
		System.out.println(((JComboBox)arg0.getSource()).getSelectedItem().toString());
		
	}
}