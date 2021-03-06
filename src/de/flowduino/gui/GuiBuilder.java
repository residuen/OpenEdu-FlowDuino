package de.flowduino.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.flowduino.interfaces.ObjectInterface;
import de.flowduino.interfaces.PinInterface;
import de.flowduino.lib.LibReader;
import de.flowduino.listener.DrawListener;
import de.flowduino.listener.MenuListener;
import de.flowduino.visu.ObjectPanel;
import de.flowduino.visu.ObjectTablePanel;

/**
 * Initialisiert wichtige Objekte
 * setzt das Look&Feel und baut die GUI auf
 * @author Blauel
 */
public class GuiBuilder
{
	public GuiBuilder()
	{
		initLookAndFeel();	// Setzen des Look & Feels
				
		HashMap<String, Component> inputComponents = new HashMap<String,Component>(); // Nimmt verschiedene Compontenten auf
		
		ArrayList<PinInterface> objects = new ArrayList<PinInterface>();
		
		JLabel status = new JLabel();
		status.setOpaque(true);
		status.setForeground(Color.BLACK);
		status.setBackground(Color.WHITE);
		
		ObjectTablePanel objectTable = new ObjectTablePanel(objects);
		ObjectPanel objectPanel = new ObjectPanel(objects, objectTable);
		
		DrawListener drawListener = new DrawListener(objectTable);
		MenuListener menuListener = new MenuListener(drawListener, objectTable); // inputComponents);

		
		MainFrame mainFrame = new MainFrame("OpenEdu-FlowDuino");
		mainFrame.getContentPane().setLayout(new BorderLayout());
		
		mainFrame.setJMenuBar(new MainMenu(menuListener, objectTable, drawListener));
		
		MainPanel mainPanel = new MainPanel(objects, menuListener, drawListener, objectPanel, inputComponents);
		
		mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainFrame.getContentPane().add(status, BorderLayout.SOUTH);

		mainFrame.setVisible(true);
		mainFrame.getContentPane().validate();
	}

	private void initLookAndFeel() {
		
		// Setzen des Look & Feels auf die System-Optik
		String ui = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	
		try {
			UIManager.setLookAndFeel(ui);
		} catch (ClassNotFoundException e1) {
			alternativeLF();
		} catch (InstantiationException e1) {
			alternativeLF();
		} catch (IllegalAccessException e1) {
			alternativeLF();
		} catch (UnsupportedLookAndFeelException e1) {
			alternativeLF();
		}
	
	}
	
	private void alternativeLF()
	{
		String ui;
		
		if(System.getProperty("os.name").toLowerCase().contains("linux"))
		{
			ui = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		}
		else
		{	
			ui = UIManager.getSystemLookAndFeelClassName();
		}
		// Setzen des Look & Feels auf die System-Optik
		try {
			UIManager.setLookAndFeel(ui);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
