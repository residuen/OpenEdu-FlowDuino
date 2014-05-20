package de.mylayout.lib;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.test.TestTheLib;

public class LibraryButton extends JButton implements ActionListener {
	
	private ArrayList<ObjectInterface> objects = null;

	private double minX = -1, minY = -1;
	private double maxX = -1, maxY = -1;
	
	private String name = "Button";

	public LibraryButton(ArrayList<ObjectInterface> objects)
	{
		this.objects = objects;
		
		addActionListener(this);
		
//		setPreferredSize(new Dimension(200, 100));
//		setMinimumSize(new Dimension(200, 100));
	}
	
//	public void setMinValues(double x, double y)
//	{
//		this.minX = x;
//		this.minY = y;
//	}
//	
//	public void setMaxValues(double x, double y)
//	{
//		this.maxX = x;
//		this.maxY = y;
//	}

	public void paintComponent(Graphics g)	// paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.clearRect(0, 0, getWidth(), getHeight());
		
//		g2d.drawLine(0,0, getWidth(), getHeight());
//		g2d.drawLine(0,getHeight(), getWidth(), 0);

		g2d.scale(0.1, 0.1);
		g2d.translate(minX*0.1, minY*0.1);
		
//		g2d.drawLine(0,0, getWidth(), getHeight());
//		g2d.drawLine(0,getHeight(), getWidth(), 0);
		
//		g2d.drawString("minX="+minX, 0, 10);

		if(objects.size() > 0)
		for(ObjectInterface o : objects)
		{
			g2d.setStroke(new BasicStroke(o.getLineWidth()));
			g2d.setColor(Color.BLACK); // o.getLineColor());
			g2d.draw(o);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
		setText(name);
	}

	public double getMinX() {
		return minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
		
		System.out.println("minX="+minX);
	}

	public double getMinY() {
		return minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public ArrayList<ObjectInterface> getObjects() {
		return objects;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		
		new TestTheLib(arg0.getActionCommand(), objects, minX, minY);
	}
	
	

//	public double getMinY() {
//		return minY;
//	}
//
//	public void setMinY(double minY) {
//		this.minY = minY;
//	}
}
