package de.flowduino.visu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.flowduino.interfaces.ObjectInterface;
import de.flowduino.interfaces.PinInterface;
import de.flowduino.tools.Constants;

public class ObjectListPanel extends JInternalFrame
{
	public ObjectListPanel(ArrayList<PinInterface> objects, ObjectPanel op)
	{
//		setLayout(new BorderLayout());
		
		setTitle("Arduino I/O");
		
		JPanel panel = new JPanel(new GridLayout(1,1));
		
		panel.add(new DigitalPin(Constants.OUTPUT_MODE, 0));
//		panel.add(new JLabel("Test"));
		
		add(panel);
		
//		repaint();
		
//		add(op);
	}
}
