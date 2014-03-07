package de.mylayout.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.tools.PaintConstants;

public class Rectangle extends Rectangle2D.Double implements ObjectInterface {

	private Color lineColor = Color.black;
	private Color fillColor = Color.white;
	
	private float lineWidth = 1.0f;
	
	private int typ = PaintConstants.LINE_OBJECT;
	private int id = 0;

	private String name = "Rectangle"; 
			
	private BasicStroke stroke = new BasicStroke(lineWidth);
	
	public BasicStroke getStroke() {
		return stroke;
	}

	public Rectangle(int id) {
		super();
		
		this.id = id;
	}

	public Rectangle(int id, double arg0, double arg1, double arg2, double arg3) {
		super(arg0, arg1, arg2, arg3);
		
		this.id = id;
	}

	public void movePoint(int n, double x, double y)
	{
//		setRect(x, y, getWidth(), getHeight());
		
		if(n==1)
			setRect(x, y, getWidth(), getHeight());
		else
			if(n==2)
				setRect(getX(), getY(), x, y);
	}
	
	@Override
	public void moveObjectAbsolute(double x, double y) {
		setFrame(x, y, getWidth(), getHeight());
	}

	@Override
	public void moveObjectRelative(double x, double y) {
		setFrame(getX() + x, getY() + y, getWidth(), getHeight());
		
	}

	public void setLineColor(Color color)
	{
		this.lineColor = color;
	}

	@Override
	public int getTyp() {
		// TODO Auto-generated method stub
		return typ;
	}

	@Override
	public Color getLineColor() {

		return lineColor;
	}

	@Override
	public Color getFillColor() {

		return fillColor;
	}

	@Override
	public float getLineWidth() {
		// TODO Auto-generated method stub
		return lineWidth;
	}
	
	@Override
	public void setLineWidth(float lineWidth) {
		this.lineWidth = lineWidth;
	}
	
	public Shape getShape() { return null; }

	@Override
	public void addPoint(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePoint(int n) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
