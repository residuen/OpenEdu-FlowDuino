package de.mylayout.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import de.mylayout.interfaces.ObjectInterface;
import de.mylayout.objects.Line;
import de.mylayout.tools.PaintConstants;
import de.mylayout.visu.DrawPanel;

public class DrawListener implements MouseListener, MouseMotionListener, MouseWheelListener {
	
//	private final double GRID_STEP = 2.5;

	private JTextField status = null;
	private ArrayList<ObjectInterface> objects = null;
	
	private int objectTyp = PaintConstants.LINE_OBJECT;
	
	private double zoom = 10;
	
	private ObjectInterface object = null;
	
	private DrawPanel comp = null;
	
	private ObjectInterface catcherRect;
	
	private boolean mousePressed = false;
	private boolean mouseReleased = false;
	private boolean mouseDragged = false;
	
	private double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

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
		
		double x = arg0.getX(), xx;
		double y = arg0.getY(), yy;
		double wh = PaintConstants.GRID_STEP*PaintConstants.WIDTH_CATCHER_SQUARE;
		
		xx = x - x%25;
		yy = y - y%25;	
		
		status.setText(mousePressed+" x="+x+" y="+y+" xx="+xx+" yy="+yy+" wh="+wh+" -> Object Nr. "+objects.size());
		catcherRect.movePoint(1, xx, yy);
		catcherRect.movePoint(2, wh,wh);

//		comp.repaint();
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
//		System.out.println("mousePressed");
//		status.setText("mousePressed");
		
		mousePressed = true;
		
		x1 = arg0.getX();
		y1 = arg0.getY();
		
		x2 = x1;
		y2 = y1;
		
		object = new Line(x1, y1, x2, y2);
		
		objects.add(object);
		
		comp.repaint();

		status.setText("mousePressed: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size()+" angelegt");
		System.out.println("mousePressed: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size()+" angelegt");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("mouseReleased");

		mousePressed = false;

//		if(mousePressed)
//		{
//			x2 = arg0.getX();
//			y2 = arg0.getY();
//
//			status.setText("mouseReleased: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2);
//			
//		}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("mouseDragged");
		status.setText("mouseDragged");

		if(mousePressed)
		{
			x2 = arg0.getX();
			y2 = arg0.getY();

			status.setText(mousePressed+" mouseDragged: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" -> Object Nr. "+objects.size());
			status.setText(status.getText()+" "+object.getBounds2D().getX() +" "+object.getBounds2D().getY()+" "+object.getBounds2D().getWidth()+" "+object.getBounds2D().getHeight());
			object.movePoint(2, x2, y2);
			
			moveCatcherRect(arg0);
			
			comp.repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
//		System.out.println("mouseMoved");
//		status.setText("mouseMoved");
//		
//		double x = arg0.getX(), xx;
//		double y = arg0.getY(), yy;
//		double wh = PaintConstants.GRID_STEP*PaintConstants.WIDTH_CATCHER_SQUARE;
//		
//		xx = x - x%25;
//		yy = y - y%25;	
//		
//		status.setText(mousePressed+" mouseMoved: x="+x+" y="+y+" xx="+xx+" yy="+yy+" wh="+wh+" -> Object Nr. "+objects.size());
////		catcherRect.moveObjectAbsolute(arg0.getX()*GRID_STEP*zoom, arg0.getY()*GRID_STEP*zoom);
//		catcherRect.movePoint(1, xx, yy);
//		catcherRect.movePoint(2, wh,wh);
//		
//		comp.repaint();
		
		moveCatcherRect(arg0);
		
		comp.repaint();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
