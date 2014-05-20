package de.flowduino.visu;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import de.flowduino.interfaces.ObjectInterface;
import de.flowduino.listener.DrawListener;

public class LayoutPanel extends JInternalFrame  {

//	private ArrayList<ObjectInterface> objects = new ArrayList<ObjectInterface>();

	public LayoutPanel(ArrayList<ObjectInterface> objects, DrawListener drawListener, JTextField status)
	{
		setLayout(new BorderLayout());
		
		add(new DrawPanel(drawListener, objects, status), BorderLayout.CENTER);
	}
	

}
