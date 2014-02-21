package de.mylayout.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

//import de.virtualprocessmanagement.listener.MenuListener;
//import de.virtualprocessmanagement.tools.Dialog;

public class IconMenuPanel extends JPanel {
	
	/**
	 * Der Konstruktor erhaelt die HashMap, welche verschiedene
	 * Komponenten Objekte beinhaltet (Textfelder, Checkboxen, usw.)
	 * @param inputComponents
	 */
	public IconMenuPanel(HashMap<String, Component> inputComponents)
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
		
		JPanel panel = null;
		JToggleButton button = null;
		
		ButtonGroup bgroup = new ButtonGroup();
		
		// GUI-Modus aus Componente lesen
//		int guiMode = new Integer(((JTextField)inputComponents.get("guimode")).getText());
		
//		MenuListener menuListener = new MenuListener(inputComponents);	// neuen MenuListener initialisieren

		Box vBox = Box.createVerticalBox();			// Box-Container fuer vertikales Layout anlegen
		Dimension dim = new Dimension(50, 50);	// Dimensions-Objekt fuer Groesse der Buttons
		Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12);	// Schriftart- und Grad festlegen

		/*
		 *  Erzeugen der Buttons
		 *  und zusammensetzen
		 *  des MenuPanels
		 */
		
		// Laden einer Prozess-Anlage
//		if(guiMode==Dialog.SERVER_MODE || guiMode==Dialog.SERVER_CLIENT_MODE)
		{
			panel = new JPanel(new GridLayout(1, 1));
			button = new JToggleButton(new ImageIcon(getClass().getResource("/de/mylayout/images/icons/catcher.png")));
//			button = new JToggleButton("<html>Fang<br/>aus</html>",
//					new ImageIcon(getClass().getResource("/de/mylayout/images/icons/catcher.png")));
			button.setFont(font);
			button.setToolTipText("Fang ein/ausschalten");
			button.setName("catch");
			inputComponents.put(button.getName(), button);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setPreferredSize(dim);
			button.setMinimumSize(dim);
//			button.addActionListener(menuListener);
			panel.add(button);
			vBox.add(panel);
			vBox.add(Box.createVerticalStrut(5));
		}
		
		// Starten der Visualisierung
		panel = new JPanel(new GridLayout(1, 1));
		button = new JToggleButton(new ImageIcon(getClass().getResource("/de/mylayout/images/icons/line.png")));
//		button = new JToggleButton("<html>Linie<br/>zeichnen</html>",
//				new ImageIcon(getClass().getResource("/de/mylayout/images/icons/line.png")));
		button.setFont(font);
		button.setToolTipText("Zeichnen einer Linie oder Leitung");
		button.setName("line");
		bgroup.add(button);
		inputComponents.put(button.getName(), button);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
//		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));
		
		panel = new JPanel(new GridLayout(1, 1));
		button = new JToggleButton(new ImageIcon(getClass().getResource("/de/mylayout/images/icons/path.png")));
//		button = new JToggleButton("<html>Pfad<br/>zeichnen</html>",
//				new ImageIcon(getClass().getResource("/de/mylayout/images/icons/path.png")));
		button.setFont(font);
		button.setToolTipText("<html>Einen Pfad zeichnen</html>");
		button.setName("path");
		bgroup.add(button);
		inputComponents.put(button.getName(), button);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
//		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));

		// Infos ueber das Programm
		panel = new JPanel(new GridLayout(1, 1));
		button = new JToggleButton(new ImageIcon(getClass().getResource("/de/mylayout/images/icons/point.png")));
//		button = new JToggleButton("<html>Kontakt<br/>zeichnen</html>",
//				new ImageIcon(getClass().getResource("/de/mylayout/images/icons/point.png")));
		button.setFont(font);
		button.setToolTipText("<html>Kontaktpunkt setzen</html>");
		button.setName("contact");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		bgroup.add(button);
//		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);

		add(vBox);
	}
}