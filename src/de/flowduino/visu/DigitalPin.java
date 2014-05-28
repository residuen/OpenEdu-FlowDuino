package de.flowduino.visu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.flowduino.interfaces.PinInterface;
import de.flowduino.tools.Constants;

public class DigitalPin extends JPanel implements PinInterface {
	
	private int mode = Constants.OUTPUT_MODE;
	
	private int pinId = 0;
	
	private JLabel state = new JLabel("LOW");
	 
	public DigitalPin(int mode, int pinId)
	{
		this.mode = mode;
		this.pinId = pinId;
		
		init();	
	}
	
	private void init()
	{
		setLayout(new GridLayout(1,2));
		
		state.setOpaque(true);
		state.setBackground(Color.RED);
		
		Box hBox = Box.createHorizontalBox();
		
		hBox.add(new JLabel("Pin "+pinId+" "));
		hBox.add(state);
		
		add(hBox);
	}

	@Override
	public int getPinId() {
		return pinId;
	}

	@Override
	public int getMode() {
		return mode;
	}
	

}
