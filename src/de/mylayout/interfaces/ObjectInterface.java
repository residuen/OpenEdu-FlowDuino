package de.mylayout.interfaces;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;

public interface ObjectInterface extends Shape {
	
	public int getTyp();
	
	public Color getLineColor();
	public Color getFillColor();
	
	public float getLineWidth();
	public BasicStroke getStroke();
	
	public void movePoint(int n, double x, double y);
	public void moveObjectAbsolute(double x, double y);
	public void moveObjectRelative(double x, double y);
//	public void setPoint2(double x, double y);
	
	public void addPoint(double x, double y);
	public void deletePoint(int n);
	
	public Shape getShape();

}
