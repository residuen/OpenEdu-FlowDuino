package de.mylayout.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.geom.Arc2D;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.tools.PaintConstants;
 
public class Circle extends Arc2D.Double implements ObjectInterface {

	private Color lineColor = Color.RED;
	private Color fillColor = Color.white;
	
	private float lineWidth = 3.0f;
	
	private int typ = PaintConstants.LINE_OBJECT;
	private int id = 0;

	private String name = "Circle"; 
			
//	java.awt.geom.GeneralPath
	
	private BasicStroke stroke = new BasicStroke(lineWidth);
	
	public BasicStroke getStroke() {
		return stroke;
	}

	public Circle(int id) {
		super();
		
		this.id = id;
	}

	public Circle(int id, double arg0, double arg1, double arg2, double arg3) {
		super(arg0, arg1, arg2, arg3, 0, 360, Arc2D.CHORD);
		
		this.id = id;
	}

	public void movePoint(int n, double x, double y)
	{
		setArc(x, y, getWidth(), getHeight(), 0, 360, Arc2D.CHORD);
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
		// TODO Auto-generated method stub
		return lineColor;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getLineWidth() {
		// TODO Auto-generated method stub
		return lineWidth;
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

	@Override
	public void setLineWidth(float lineWidth) {
		this.lineWidth = lineWidth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
