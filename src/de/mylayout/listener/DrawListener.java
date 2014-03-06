package de.mylayout.listener;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.objects.Circle;
import de.mylayout.objects.Line;
import de.mylayout.objects.Path;
import de.mylayout.tools.PaintConstants;
import de.mylayout.visu.DrawPanel;

public class DrawListener implements MouseListener, MouseMotionListener, MouseWheelListener {
	
//	private final double GRID_STEP = 2.5;

	private JTextField status = null;
	private ArrayList<ObjectInterface> objects = null;
	
	private int objectTyp = PaintConstants.LINE_OBJECT;
	private int menuCLicked = PaintConstants.SEL_TOOL_POINTER;
	
	private boolean catchMode = true;
	
	private double zoom = 10, xx, yy;
	
	private ObjectInterface object = null;
	
	private DrawPanel comp = null;
	
	private ObjectInterface catcherRect;
	
	private String selectedIconMenuItem = "";
	
	private boolean mousePressed = false;
	private boolean mouseReleased = false;
	private boolean mouseDragged = false;
	
	private int clickCounter = 0;
	
	private Point previousSelectedCell = new Point(0,0);
	private Point currentSelectedCell = new Point(0,0);
	
	private double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	
	public DrawListener()
	{
		
	}

	public DrawListener(JTextField status, ArrayList<ObjectInterface> objects, ObjectInterface catcherRect, DrawPanel comp)
	{
		this.status = status;
		this.objects = objects;
		this.catcherRect = catcherRect;
		this.comp = comp;
	}

//	public void setZoom(double zoom)
//	{
//		this.zoom = zoom;
//	}
	
	private void moveCatcherRect(MouseEvent arg0)
	{
//		System.out.println(arg0.paramString());
//		status.setText(arg0.paramString());
		
		double x = arg0.getX();
		double y = arg0.getY();
		double wh = PaintConstants.GRID_STEP*PaintConstants.WIDTH_CATCHER_SQUARE;
		
		if(catchMode)
		{
			xx = x - x%25;
			yy = y - y%25;	
		}
		else
		{
			xx = -1; //x - wh/2;
			yy = -1; //y - wh/2;
			wh = 0;
		}
		
		status.setText(mousePressed+" x="+x+" y="+y+" xx="+xx+" yy="+yy+" wh="+wh+" -> Object Nr. "+objects.size());
		catcherRect.movePoint(1, xx, yy);
		catcherRect.movePoint(2, wh,wh);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouseClicked");
		status.setText("mouseClicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouseEntered");
		status.setText("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("mouseExited");
		status.setText("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
//		status.setText("mousePressed: selectedCell="+selectedCell.getX()+","+selectedCell.getY()+" lastSelectedCell="+lastSelectedCell.getX()+","+lastSelectedCell.getY());
		
		mousePressed = true;
		
		clickCounter++;
		
		double a=0, b=0, c=0;
		
		x1 = arg0.getX();
		y1 = arg0.getY();
		
		if(catchMode)
		{
			x1 = x1 - x1%25 + (int)(catcherRect.getBounds().getWidth())/2;
			y1 = y1 - y1%25 + (int)(catcherRect.getBounds().getHeight())/2;	
		}

		x2 = x1;
		y2 = y1;
		
		// Speichern der beiden letzten Klick-Positionen 
		if(clickCounter==1)
		{
			previousSelectedCell.setLocation((int)xx,(int)yy);	
		}
		else
			if(clickCounter>1)
			{
				previousSelectedCell.setLocation(currentSelectedCell.getX(),currentSelectedCell.getY());	
				currentSelectedCell.setLocation((int)xx,(int)yy);
			}
		
		System.out.println("mousePressed: clickCounter="+clickCounter+" selectedCell="+previousSelectedCell.getX()+","+previousSelectedCell.getY()+" lastSelectedCell="+currentSelectedCell.getX()+","+currentSelectedCell.getY());

		if(objectTyp == PaintConstants.LINE_OBJECT)
		{
			object = new Line(x1, y1, x2, y2);
			System.out.println("objectTyp="+objectTyp);
		}
		else
			if(objectTyp == PaintConstants.PATH_OBJECT)
			{
				object = new Path(x1, y1, x2, y2);
				System.out.println("objectTyp="+objectTyp);
			}
			else
//			if(objectTyp == PaintConstants.CIRCLE_OBJECT)
			{
				a = catcherRect.getBounds().getWidth();
				b = 10;
				c = (a-b)/2;
				
				object = new Circle(x1-c, y1-c, b, b);
				object.setLineWidth(2);
				
				mousePressed = false;
			}
		
		objects.add(object);
		
		comp.repaint();

		status.setText("mousePressed: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size()+" angelegt");
		System.out.println("mousePressed: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size()+" angelegt");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("mouseReleased:"+objectTyp+"->("+previousSelectedCell.getX()+","+currentSelectedCell.getX()+")("+previousSelectedCell.getY()+","+currentSelectedCell.getY()+")");

		if(objectTyp == PaintConstants.PATH_OBJECT)
		{
			if(previousSelectedCell.getX()==currentSelectedCell.getX() && previousSelectedCell.getY()==currentSelectedCell.getY())
			{
				mousePressed = false;
				clickCounter = 0;
//				System.out.println("gleiche Zelle");
			}
		}
		else
			if(objectTyp == PaintConstants.LINE_OBJECT)
			{
				if(clickCounter==2)
				{
					mousePressed = false;
					clickCounter = 0;
				}
			}
			else
			{
				mousePressed = false;
				clickCounter = 0;
			}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("mouseDragged");
		status.setText("mouseDragged");

//		if(mousePressed)
//		{
//			x2 = arg0.getX();
//			y2 = arg0.getY();
//
//			if(catchMode)
//			{
//				x2 = x2 - x2%25 + (int)(catcherRect.getBounds().getWidth())/2;
//				y2 = y2 - y2%25 + (int)(catcherRect.getBounds().getHeight())/2;	
//			}
//			
//			status.setText(mousePressed+" mouseDragged: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size());
//			status.setText(status.getText()+" "+object.getBounds2D().getX() +" "+object.getBounds2D().getY()+" "+object.getBounds2D().getWidth()+" "+object.getBounds2D().getHeight());
//			object.movePoint(2, x2, y2);
//			
//			moveCatcherRect(arg0);
//			
//			comp.repaint();
//		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		if(mousePressed && clickCounter>0)
		{
			x2 = arg0.getX();
			y2 = arg0.getY();

			if(catchMode)
			{
				x2 = x2 - x2%25 + (int)(catcherRect.getBounds().getWidth())/2;
				y2 = y2 - y2%25 + (int)(catcherRect.getBounds().getHeight())/2;	
			}
			
			status.setText(mousePressed+" mouseMoved: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size());
			status.setText(status.getText()+" "+object.getBounds2D().getX() +" "+object.getBounds2D().getY()+" "+object.getBounds2D().getWidth()+" "+object.getBounds2D().getHeight());
			object.movePoint(2, x2, y2);
		}
		
		moveCatcherRect(arg0);
		
		comp.repaint();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getStatus() {
		return status;
	}

	public void setStatus(JTextField status) {
		this.status = status;
	}

	public ArrayList<ObjectInterface> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<ObjectInterface> objects) {
		this.objects = objects;
	}

	public DrawPanel getComp() {
		return comp;
	}

	public void setComp(DrawPanel comp) {
		this.comp = comp;
	}

	public ObjectInterface getCatcherRect() {
		return catcherRect;
	}

	public void setCatcherRect(ObjectInterface catcherRect) {
		this.catcherRect = catcherRect;
	}

	public void setMenuCLicked(int menuCLicked) {
		this.menuCLicked = menuCLicked;
		
//		System.out.println("this.objectTyp="+this.objectTyp);
	}

	public void setObjectSelected(int objectTyp) {

		this.objectTyp = objectTyp;
		
//		System.out.println("this.objectTyp="+this.objectTyp);
	}

	public void setCatchMode(boolean catchMode) {
		this.catchMode = catchMode;
		
//		System.out.println("this.catchMode="+this.catchMode);
	}

}
