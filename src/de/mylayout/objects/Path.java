package de.mylayout.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.tools.PaintConstants;
 
public class Path implements ObjectInterface {

	private Color lineColor = Color.BLUE;
	private Color fillColor = Color.white;
	
	private boolean fill = false;
	
	private float lineWidth = 3.0f;
	
	private int typ = PaintConstants.LINE_OBJECT;
	private int id = 0;

	private String name = "path"; 
			
	private GeneralPath gp = new GeneralPath();
	
	private ArrayList<double[]> points = new ArrayList<double[]>();
	
	private BasicStroke stroke = new BasicStroke(lineWidth);
	
	private boolean closed = false;
	
	public BasicStroke getStroke() {
		return stroke;
	}

	public Path(int id) {
		super();
		
		this.id = id;
	}

	public Path(int id, double x1, double y1, double x2, double y2) {
		
		this.id = id;
		
		double point[] = new double[2];
		
		point[0] = x1;
		point[1] = y1;
		points.add(point);
		
		point = new double[2];
		
		point[0] = x2;
		point[1] = y2;
		points.add(point);
		
		
		gp.moveTo(x1, y1);
		gp.lineTo(x2, y2);
//		gp.closePath();
	}

	public Path(int id, Point2D p1, Point2D p2) {
		
		this.id = id;
		
		double point[] = new double[2];
		
		point[0] = p1.getX();
		point[1] = p1.getY();
		points.add(point);
		
		point = new double[2];
		
		point[0] = p2.getX();
		point[1] = p2.getY();
		points.add(point);
		
		gp.moveTo(p1.getX(), p1.getY());
		gp.lineTo(p2.getX(), p2.getY());
//		gp.closePath();
	}
	
	public void movePoint(int n, double x, double y)
	{
//		setLine(x, y, getX2(), getY2());
		double point[] = new double[2];
		point[0] = x;
		point[1] = y;
		
		points.set(points.size()-1, point);
		
		gp.reset();
		
		for(int i=0; i<points.size(); i++)
		{
			if(i==0)
				gp.moveTo(points.get(i)[0], points.get(i)[1]);
			else
				gp.lineTo(points.get(i)[0], points.get(i)[1]);
		}
		
		
	}

	@Override
	public void moveObjectRelative(double x, double y) {
		
		for(double[] p : points)	// Move all object-points
		{
			p[0] = p[0] + x;
			p[1] = p[1] + y;
		}
		
		rebuildPath();
	}
 
	@Override
	public void moveObjectAbsolute(double x, double y) {
		
		// Solve the new Startpoint
		double dx = x - points.get(0)[0];	
		double dy = y - points.get(0)[1];
		
		for(double[] p : points)	// Move all object-points
		{
			p[0] = p[0] + dx;
			p[1] = p[1] + dy;
		}
		
		rebuildPath();
	}
	
	private void rebuildPath()
	{
		gp.reset();					// clear path	
		
		gp.moveTo(points.get(0)[0], points.get(0)[1]); // set startpoint
		
		for(int i=1; i<points.size(); i++)	// draw the lines
			gp.lineTo(points.get(i)[0], points.get(i)[1]);
	}
	
	public void setLineColor(Color color)
	{
		this.lineColor = color;
	}

	@Override
	public int getTyp() {

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

		return lineWidth;
	}
	
	@Override
	public void setLineWidth(float lineWidth) {
		this.lineWidth = lineWidth;
		
		this.stroke = new BasicStroke(lineWidth);
	}
	
	@Override
	public Shape getShape() { return gp; }

	@Override
	public boolean contains(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return gp.getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return gp.getBounds2D();
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return gp.getPathIterator(at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		return gp.getPathIterator(at, flatness);
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPoint(double x, double y) {
		
		double point[] = new double[2];
		
		point[0] = x;
		point[1] = y;
		points.add(point);

		if(points.size()==1)
			gp.moveTo(x, y);
		else
			gp.lineTo(x, y);
	}

	@Override
	public void deletePoint(int n) {
		
		points.remove(n); 	// Remove point from list
			
		gp.reset();			// clear path
		
		gp.moveTo(points.get(0)[0], points.get(0)[1]); // set startpoint
		
		for(int i=1; i<points.size(); i++)	// draw the lines
			gp.lineTo(points.get(i)[0], points.get(i)[1]);
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
	
	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
}
