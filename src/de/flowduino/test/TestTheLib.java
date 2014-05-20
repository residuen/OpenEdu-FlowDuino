package de.flowduino.test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.flowduino.interfaces.ObjectInterface;

public class TestTheLib extends JFrame implements ChangeListener {
	
	private TestPanel tp = null;
	
	public TestTheLib(String arg0, ArrayList<ObjectInterface> objects, double minX, double minY)
	{
		super(arg0);

		initFrame(objects, minX, minY);
	}

	/**
	 * Festlegen der wichtigsten Fenstereigenschaften
	 */
	private void initFrame(ArrayList<ObjectInterface> objects, double minX, double minY)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// Verhalten bei Fenster-Schliessen
		setSize(640, 480);								// Groesse des Fensters
		setLocation(5, 5);								// Position des Fensters auf dem Desktop
//		setLocation(1930, 25);
		
		JSlider slider = new JSlider(10, 100);
		slider.setValue(100);
		slider.addChangeListener(this);
		
		tp = new TestPanel(objects, minX, minY);
		tp.setZoom(100d);
		
		getContentPane().setLayout(new BorderLayout());
		
		getContentPane().add(tp, BorderLayout.CENTER);
		getContentPane().add(slider, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		System.out.println(((JSlider)arg0.getSource()).getValue());
		
		tp.setZoom(((JSlider)arg0.getSource()).getValue());
	}
	
	public class TestPanel extends JPanel
	{
		
		private ArrayList<ObjectInterface> objects = null;
		
		private double minX = -1, minY = -1;
//		private double maxX = -1, maxY = -1;
		
		double zoom = 1;

		public TestPanel(ArrayList<ObjectInterface> objects, double minX, double minY)
		{
			this.objects = objects;
			this.minX = minX;
			this.minY = minY;
		}
		
		public void paintComponent(Graphics g)	// paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D)g;
			
			g2d.clearRect(0, 0, getWidth(), getHeight());
			
//			g2d.drawLine(0,0, getWidth(), getHeight());
//			g2d.drawLine(0,getHeight(), getWidth(), 0);

			g2d.scale(zoom, zoom);
//			g2d.translate(minX*0.1, minY*0.1);
			g2d.translate(-minX, -minY);
			
//			g2d.drawLine(0,0, getWidth(), getHeight());
//			g2d.drawLine(0,getHeight(), getWidth(), 0);
			
//			g2d.drawString("minX="+minX, 0, 10);

			if(objects.size() > 0)
			for(ObjectInterface o : objects)
			{
				g2d.setStroke(new BasicStroke(o.getLineWidth()));
				g2d.setColor(Color.BLACK); // o.getLineColor());
				g2d.draw(o);
			}
		}
		
		public void setMinX(double minX) {
			this.minX = minX;
			
			System.out.println("minX="+minX);
		}
		
		public void setMinY(double minY) {
			this.minY = minY;
		}

		public void setZoom(double zoom) {
			this.zoom = zoom / 100d;
			
			repaint();
			validate();
		}

	}

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
