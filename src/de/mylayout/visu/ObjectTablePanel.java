package de.mylayout.visu;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import de.mylayout.interfaces.ObjectInterface;

public class ObjectTablePanel extends JPanel {
	
	private JTable table;
	
	private ArrayList<ObjectInterface> objects;
	
	public ObjectTablePanel(ArrayList<ObjectInterface> objects)
	{
		this.objects = objects;
	}
	
//	public JTable getTable()
//	{
//		return table;
//	}
	
	public void update()
	{
		
	}
	
	public void update(int id)
	{
		
	}

}
