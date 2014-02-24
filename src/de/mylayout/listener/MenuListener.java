package de.mylayout.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import de.mylayout.gui.About;
import de.mylayout.tools.PaintConstants;

public class MenuListener implements ActionListener, MouseListener
{
	private DrawListener drawListener = null;
	
	/**
	 * Konstruktor bekommt HashMap mit Komponentenliste uebergeben
	 * @param inputComponents
	 */
	public MenuListener(DrawListener drawListener) // HashMap<String,Component> inputComponents)
	{
//		this.inputComponents = inputComponents;
		this.drawListener = drawListener;
	}
	
	/**
	 * nimmt Auswahlereignisse entgegen
	 * und leitet diese an die Methode event() weiter
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// Name des gedrueckten Buttons wird an Zeichenkette uebergeben
		String cmd = ((Component) arg0.getSource()).getName();

		event(cmd, arg0);
	}
	
	private void event(String event, ActionEvent arg0)
	{
		System.out.println("cmd=" + event);	// Zu Kontrollzwecken: Ausgabe des gedrueckten Buttons
		
		if(event.equals("catch"))
			drawListener.setCatchMode( ((JToggleButton)(arg0.getSource())).isSelected());
		
		if(event.equals("pointer"))
			drawListener.setMenuCLicked(PaintConstants.SEL_TOOL_POINTER);
		else
			if(event.equals("line"))
				drawListener.setMenuCLicked(PaintConstants.SEL_TOOL_LINE);
			else
				if(event.equals("path"))
					drawListener.setMenuCLicked(PaintConstants.SEL_TOOL_PATH);
				else
					if(event.equals("contact"))
						drawListener.setMenuCLicked(PaintConstants.SEL_TOOL_CONTACT);

		if(event.equals("about"))
			new About();
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		String cmd = ((Component)arg0.getSource()).getName();
		
		event(cmd, null);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
