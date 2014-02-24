package de.mylayout.visu;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.listener.DrawListener;

public class LayoutPanel extends JInternalFrame  {

	private ArrayList<ObjectInterface> objects = new ArrayList<ObjectInterface>();

	public LayoutPanel(DrawListener drawListener, JTextField status)
	{
		setLayout(new BorderLayout());
		
		add(new DrawPanel(drawListener, objects, status), BorderLayout.CENTER);
	}
	

}
