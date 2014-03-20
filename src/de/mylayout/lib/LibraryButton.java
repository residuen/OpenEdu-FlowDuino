package de.mylayout.lib;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JButton;

import de.mylayout.interfaces.ObjectInterface;

public class LibraryButton extends JButton {
	
	private ArrayList<ObjectInterface> objects = null;

	private double minX, minY;

	public LibraryButton(ArrayList<ObjectInterface> objects)
	{
		this.objects = objects;
	}
	
	public void setMinValues(double x, double y)
	{
		minX = x;
		minY = y;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.clearRect(0, 0, getWidth(), getHeight());
		
		if(objects.size() > 0)
		for(ObjectInterface o : objects)
		{
			g2d.setStroke(new BasicStroke(o.getLineWidth()));
			g2d.setColor(o.getLineColor());
			g2d.draw(o);
		}
	}
}
