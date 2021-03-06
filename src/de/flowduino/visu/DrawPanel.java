package de.flowduino.visu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.flowduino.interfaces.ObjectInterface;
import de.flowduino.interfaces.PinInterface;
import de.flowduino.listener.DrawListener;
import de.flowduino.objects.Circle;
import de.flowduino.objects.Rectangle;
import de.flowduino.tools.Constants;

public class DrawPanel extends JPanel implements ComponentListener {
	
	private ArrayList<PinInterface> objects = null;
	
	private ObjectInterface catcherRect = new Rectangle(0, -1,-1,0,0);
	
	private BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	
	private boolean resized = true;
	
	private double zoom = 10;
	
	private boolean gridMode = true;
	
	private boolean antialiasing = true;
	
	public DrawPanel(DrawListener drawListener, ArrayList<PinInterface> objects, JTextField status)
	{
		this.objects = objects;
		
		drawListener.setStatus(status);
		drawListener.setObjects(objects);
		drawListener.setCatcherRect(catcherRect);
		drawListener.setComp(this);
		
		addMouseListener(drawListener);
		addMouseMotionListener(drawListener);
		addMouseWheelListener(drawListener);
		
		addComponentListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		if(antialiasing)
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(resized)
			drawGrid(zoom);
		
		g2d.drawImage(img, 0,0, this);
		
//		for(PinInterface o : objects)
//		{
//			g2d.setStroke(new BasicStroke(o.getLineWidth()));
//			g2d.setColor(o.getLineColor());
//			g2d.draw(o);
//		}
		
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.BLACK);
//		g2d.draw(catcherRect);
	}
	
	private void drawGrid(double zoom)
	{
		Graphics2D g = img.createGraphics();
		
		double w = getWidth(); 	if(w<=0) w=100;
		double h = getHeight();	if(h<=0) h=100;
		double ww = (w/(Constants.GRID_STEP*zoom))+1;
		double hh = (h/(Constants.GRID_STEP*zoom))+1;
		double xy, dx;//, y;
		
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int)w, (int)h);
		
		g.setColor(Color.LIGHT_GRAY);
		
//		System.out.println("w/PaintConstants.GRID_STEP*zoom="+ww);
//		System.out.println("h/PaintConstants.GRID_STEP*zoom="+hh);

//		if(gridMode)
//			for(int i=0; i<(ww); i++)
//				for(int j=0; j<(hh); j++)
//				{
//					xy = PaintConstants.GRID_STEP;
//					dx = (PaintConstants.GRID_STEP*PaintConstants.WIDTH_CATCHER_SQUARE - xy) / 4;
//	//				System.out.println("dx="+dx);
//					g.setStroke(new BasicStroke(2));
//					g.draw(new Circle(0, i*xy*zoom+dx, j*xy*zoom+dx, PaintConstants.GRID_STEP*PaintConstants.RASTER_BALL_FACTOR*zoom, PaintConstants.GRID_STEP*PaintConstants.RASTER_BALL_FACTOR*zoom));
//				}
		
		resized = false;
			
	}
	
	public void setZoom(double zoom)
	{
		this.zoom = zoom;
	}

	public void setGridMode(boolean gridMode)
	{
		this.gridMode = gridMode;
		
		resized = true;
		
		repaint();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) { }

	@Override
	public void componentMoved(ComponentEvent arg0) { }

	@Override
	public void componentResized(ComponentEvent arg0)
	{
		img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		resized = true;
		repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) { }

}
