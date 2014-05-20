package de.flowduino.gui;

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
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import de.mylayout.listener.DrawListener;
import de.mylayout.listener.MenuListener;

//import de.virtualprocessmanagement.listener.MenuListener;
//import de.virtualprocessmanagement.tools.Dialog;

public class IconMenuPanel extends JPanel {
	
	/**
	 * Der Konstruktor erhaelt die HashMap, welche verschiedene
	 * Komponenten Objekte beinhaltet (Textfelder, Checkboxen, usw.)
	 * @param inputComponents
	 */
	public IconMenuPanel(MenuListener menuListener, DrawListener drawListener, HashMap<String, Component> inputComponents)
	{
		initPanel(menuListener, drawListener, inputComponents);
	}

	/**
	 * Initialisierung des Panels mit Buttons und Icons fuer das Menue 
	 * @param inputComponents
	 */
	private void initPanel(MenuListener menuListener, DrawListener drawListener, HashMap<String, Component> inputComponents)
	{
		setBackground(new Color(215, 215, 215));	// Hintergrundfarbe festlegen
		
		JPanel panel = null;
		JToggleButton tButton = null;
		JButton button = null;
		
		ButtonGroup bgroup = new ButtonGroup();
		
		// GUI-Modus aus Componente lesen
//		int guiMode = new Integer(((JTextField)inputComponents.get("guimode")).getText());
		
//		MenuListener menuListener = new MenuListener(drawListener); //inputComponents);	// neuen MenuListener initialisieren

		Box vBox = Box.createVerticalBox();			// Box-Container fuer vertikales Layout anlegen
		Dimension dim = new Dimension(50, 50);	// Dimensions-Objekt fuer Groesse der Buttons
		Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12);	// Schriftart- und Grad festlegen

		/*
		 *  Erzeugen der Buttons
		 *  und zusammensetzen
		 *  des MenuPanels
		 */
		
		panel = new JPanel(new GridLayout(1, 1));
		tButton = new JToggleButton(new ImageIcon(getClass().getResource("/de/flowduino/images/icons/network-wired.png")));
//		button = new JToggleButton("<html>Fang<br/>aus</html>",
//		new ImageIcon(getClass().getResource("/de/mylayout/images/icons/catcher.png")));
		tButton.setFont(font);
//		tButton.setSelected(true);
		tButton.setToolTipText("Connect Arduino");
		tButton.setName("connect");
		inputComponents.put(tButton.getName(), tButton);
//		button.setHorizontalTextPosition(SwingConstants.CENTER);
//		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		tButton.setPreferredSize(dim);
		tButton.setMinimumSize(dim);
		tButton.addActionListener(menuListener);
		panel.add(tButton);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));

		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton(new ImageIcon(getClass().getResource("/de/flowduino/images/icons/folder-downloads.png")));
		button.setFont(font);
		button.setSelected(true);
		button.setToolTipText("Arduino auslesen");
		button.setName("read");
		inputComponents.put(button.getName(), button);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));

		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton(new ImageIcon(getClass().getResource("/de/flowduino/images/icons/folder-remote.png")));
		button.setFont(font);
		button.setToolTipText("Arduino senden");
		button.setName("send");
//		bgroup.add(button);
		inputComponents.put(button.getName(), button);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(3));

		// Starten der Visualisierung
		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton(new ImageIcon(getClass().getResource("/de/flowduino/images/icons/edit-clear.png")));
		button.setFont(font);
		button.setToolTipText("Reset Arduino");
		button.setName("reset");
//		bgroup.add(tButton);
		inputComponents.put(button.getName(), button);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(3));
		
		panel = new JPanel(new GridLayout(1, 1));
		tButton = new JToggleButton(new ImageIcon(getClass().getResource("/de/flowduino/images/icons/media-playback-start.png")));
		tButton.setFont(font);
		tButton.setToolTipText("Starte Arduino");
		tButton.setName("start");
//		bgroup.add(tButton);
		inputComponents.put(tButton.getName(), tButton);
		tButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		tButton.setPreferredSize(dim);
		tButton.setMinimumSize(dim);
		tButton.addActionListener(menuListener);
		panel.add(tButton);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(3));

		// Infos ueber das Programm
		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton(new ImageIcon(getClass().getResource("/de/flowduino/images/icons/media-playback-stop.png")));
		button.setFont(font);
		button.setToolTipText("Stoppe Arduino");
		button.setName("stop");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
//		bgroup.add(tButton);
		button.addActionListener(menuListener);
		panel.add(button);
		vBox.add(panel);

		add(vBox);
	}
}