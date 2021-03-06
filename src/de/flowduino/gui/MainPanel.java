package de.flowduino.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.flowduino.interfaces.ObjectInterface;
import de.flowduino.interfaces.PinInterface;
import de.flowduino.listener.DrawListener;
import de.flowduino.listener.MenuListener;
import de.flowduino.visu.LayoutPanel;
import de.flowduino.visu.ObjectListPanel;
import de.flowduino.visu.ObjectPanel;

/**
 * Hauptpanel, beinhaltet alle Komponeten-Panels
 * @author bettray
 *
 */
public class MainPanel extends JPanel 
{
	public MainPanel(ArrayList<PinInterface> objects, MenuListener menuListener, DrawListener drawListener, ObjectPanel objectPanel, HashMap<String, Component> inputComponents)
	{		
		initPanel(objects, menuListener, drawListener, objectPanel, inputComponents);
	}

	private void initPanel(ArrayList<PinInterface> objects, MenuListener menuListener, DrawListener drawListener, ObjectPanel objectPanel, HashMap<String, Component> inputComponents)
	{
		setLayout(new BorderLayout());	// Layout-Manager festlegen 
		
		JTextField status = new JTextField("Status: ");
		status.setEditable(false);
		
		/*
		 *  Objekt fuer MDI-Panels intitialisieren
		 *  Es beinhaltet die Visualisierung und
		 *  die Server-Nachrichten
		 */
		JDesktopPane mdiFrame = new JDesktopPane();
		LayoutPanel lp = new LayoutPanel(objects, drawListener, status);
		lp.setSize(640, 480);
		lp.setResizable(true);
		lp.setVisible(true);
		
//		inputComponents.put("mdiframe", mdiFrame);

		mdiFrame.setVisible(true);
		mdiFrame.add(lp);
		
		ObjectListPanel olp = new ObjectListPanel(objects, objectPanel);
		olp.setSize(160, 240);
		olp.setLocation(640, 0);
		olp.setResizable(true);
		olp.setVisible(true);
		mdiFrame.add(olp);
		
		// Das IconMenuPanel in einen ScrollPane geben
		JScrollPane leftScrollpane = new JScrollPane(new IconMenuPanel(menuListener, drawListener, inputComponents), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // contentPanel));
		leftScrollpane.setBorder(null);
//		JScrollPane rightScrollpane = new JScrollPane(new LibraryMenuPanel(inputComponents), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // contentPanel));
		leftScrollpane.setBorder(null);
		add(leftScrollpane, BorderLayout.WEST); 	// Scrollpanel mit Menupanel links in Hauptpanel einh�ngen
		add(new LibraryMenuPanel(inputComponents), BorderLayout.EAST); 	// Scrollpanel mit Menupanel rechts in Hauptpanel einh�ngen
//		add(rightScrollpane, BorderLayout.EAST); 	// Scrollpanel mit Menupanel rechts in Hauptpanel einh�ngen
		add(mdiFrame, BorderLayout.CENTER);		// MDI-Panel mit Visu und Server-Msg ins Center einhaengen
		add(status, BorderLayout.SOUTH);
	}
}
