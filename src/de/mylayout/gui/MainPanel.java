package de.mylayout.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.listener.DrawListener;
import de.mylayout.listener.MenuListener;
import de.mylayout.visu.LayoutPanel;
import de.mylayout.visu.ObjectListPanel;
import de.mylayout.visu.ObjectPanel;

/**
 * Hauptpanel, beinhaltet alle Komponeten-Panels
 * @author bettray
 *
 */
public class MainPanel extends JPanel 
{
	public MainPanel(ArrayList<ObjectInterface> objects, MenuListener menuListener, DrawListener drawListener, ObjectPanel objectPanel, HashMap<String, Component> inputComponents)
	{		
		initPanel(objects, menuListener, drawListener, objectPanel, inputComponents);
	}

	private void initPanel(ArrayList<ObjectInterface> objects, MenuListener menuListener, DrawListener drawListener, ObjectPanel objectPanel, HashMap<String, Component> inputComponents)
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
		olp.setSize(160, 480);
		olp.setLocation(640, 0);
		olp.setResizable(true);
		olp.setVisible(true);
		mdiFrame.add(olp);
		
		// Das IconMenuPanel in einen ScrollPane geben
		JScrollPane leftScrollpane = new JScrollPane(new IconMenuPanel(menuListener, drawListener, inputComponents), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // contentPanel));
		leftScrollpane.setBorder(null);
		JScrollPane rightScrollpane = new JScrollPane(new LibraryMenuPanel(inputComponents), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // contentPanel));
		leftScrollpane.setBorder(null);
		add(leftScrollpane, BorderLayout.WEST); 	// Scrollpanel mit Menupanel links in Hauptpanel einhängen
		add(rightScrollpane, BorderLayout.EAST); 	// Scrollpanel mit Menupanel rechts in Hauptpanel einhängen
		add(mdiFrame, BorderLayout.CENTER);		// MDI-Panel mit Visu und Server-Msg ins Center einhaengen
		add(status, BorderLayout.SOUTH);
	}
}
