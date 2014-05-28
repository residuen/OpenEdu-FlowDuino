package de.flowduino.visu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import de.flowduino.interfaces.ObjectInterface;
import de.flowduino.interfaces.PinInterface;

public class ObjectTablePanel extends JPanel {
	
	private JTable table;
	
	private ArrayList<PinInterface> objects;
	
//	private ObjectInterface object;
	
	private Box vBoxL = Box.createVerticalBox();
	private Box vBoxR = Box.createVerticalBox();
	
	public ObjectTablePanel(ArrayList<PinInterface> objects)
	{
		this.objects = objects;
		
		setLayout(new BorderLayout());
		
		JPanel p = new JPanel(new GridLayout(1,2));
		
		p.add(vBoxL);
		p.add(vBoxR);
		
		add(p, BorderLayout.NORTH);
	}
	
	public void update()
	{
//		System.out.println("aktualisieren!");
		
//		this.object = object;
		
		JTextField tf;
		
		vBoxL.removeAll();
		vBoxR.removeAll();
		
		for(PinInterface object : objects)
		{
			vBoxL.add(createTextField("PIN"+object.getPinId(), false));
			vBoxR.add(createTextField(""+object.getMode(), false));
		}
		
		
//		vBoxL.add(createTextField("ID", false));
//		vBoxR.add(createTextField(""+object.getId(), true));
//		vBoxL.add(createTextField("linecolor", false));
//		tf = createTextField("", false);
//		tf.setBackground(object.getLineColor());
////		tf.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), new EtchedBorder()));
//		vBoxR.add(tf, true);
//		vBoxL.add(createTextField("linewidth", false));
//		vBoxR.add(createTextField(""+object.getLineWidth(), true));
		
		
		repaint();
		revalidate();
	}
	
	private JTextField createTextField(String text, boolean editable)
	{
		JTextField tf = new JTextField();
		
		tf.setEditable(editable);
		tf.setText(text);
		tf.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), new EtchedBorder()));

		
		return tf;
	}
	
//	public void update(int id)
//	{
//		
//	}

}
