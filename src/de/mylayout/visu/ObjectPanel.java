package de.mylayout.visu;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mylayout.interfaces.ObjectInterface;

public class ObjectPanel extends JPanel {
	
	private ArrayList<ObjectInterface> objects = null;
	
	private Box vBox = Box.createVerticalBox();
	
	public ObjectPanel(ArrayList<ObjectInterface> objects, ObjectTablePanel objectTable)
	{
		this.objects = objects;
		
		setLayout(new GridLayout(1,1));
		
		init(objectTable);
	}
	
	private void init(ObjectTablePanel objectTable)
	{
		add(vBox);
		
		vBox.add(objectTable);
		
		JLabel l;
		for(int i=0; i<3; i++)
		{
			l = new JLabel(""+i);
			l.setOpaque(true);
			setBackground(Color.LIGHT_GRAY);
			vBox.add(l);
			vBox.add(Box.createVerticalStrut(2));
		}

	}

}
