package de.mylayout.visu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import de.mylayout.interfaces.ObjectInterface;

public class ObjectTablePanel extends JPanel {
	
	private JTable table;
	
	private ArrayList<ObjectInterface> objects;
	
//	private ObjectInterface object;
	
	private Box vBoxL = javax.swing.Box.createVerticalBox();
	private Box vBoxR = javax.swing.Box.createVerticalBox();
	
	public ObjectTablePanel(ArrayList<ObjectInterface> objects)
	{
		this.objects = objects;
		
		setLayout(new BorderLayout());
//		setLayout(new GridLayout(1,2));
		
		JPanel p = new JPanel(new GridLayout(1,2));
		
		p.add(vBoxL);
		p.add(vBoxR);
		
		add(p, BorderLayout.NORTH);
		
//		vBoxL.add(createTextField("links1", false));
//		vBoxR.add(createTextField("rechts1", true));
//		vBoxL.add(createTextField("links2", false));
//		vBoxR.add(createTextField("rechts2", true));
	}
	
//	public JTable getTable()
//	{
//		return table;
//	}
	
	public void update()
	{
		
	}
	
	public void update(ObjectInterface object)
	{
//		System.out.println("aktualisieren!");
		
//		this.object = object;
		
		JTextField tf;
		
		vBoxL.removeAll();
		vBoxR.removeAll();
		
		vBoxL.add(createTextField("Name", false));
		vBoxR.add(createTextField(object.getName(), true));
		vBoxL.add(createTextField("ID", false));
		vBoxR.add(createTextField(""+object.getId(), true));
		vBoxL.add(createTextField("linecolor", false));
		tf = createTextField("", false);
		tf.setBackground(object.getLineColor());
		vBoxR.add(tf, true);
		vBoxL.add(createTextField("linewidth", false));
		vBoxR.add(createTextField(""+object.getLineWidth(), true));
		
		
		repaint();
		revalidate();
	}
	
	private JTextField createTextField(String text, boolean editable)
	{
		JTextField tf = new JTextField();
		
		tf.setEditable(editable);
		tf.setText(text);
		
		return tf;
	}
	
//	public void update(int id)
//	{
//		
//	}

}
