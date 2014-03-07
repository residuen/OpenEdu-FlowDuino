package de.mylayout.visu;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mylayout.interfaces.ObjectInterface;

public class ObjectListPanel extends JInternalFrame
{
	public ObjectListPanel(ArrayList<ObjectInterface> objects, ObjectPanel op)
	{
//		setLayout(new BorderLayout());
		
		add(op);
	}
}
