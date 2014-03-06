package de.mylayout.gui;

import javax.swing.JFrame;

/**
 * Hauptframe/Fenster
 * @author bettray
 *
 */
public class MainFrame extends JFrame
{
	public MainFrame(String arg0)
	{
		super(arg0);

		initFrame();
	}

	/**
	 * Festlegen der wichtigsten Fenstereigenschaften
	 */
	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Verhalten bei Fenster-Schliessen
		setSize(1050, 700);								// Groesse des Fensters
		setLocation(5, 5);								// Position des Fensters auf dem Desktop
//		setLocation(1930, 25);
	}

}
