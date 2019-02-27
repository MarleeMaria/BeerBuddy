/**
 * Author: Matthew Po
 * Revised: March 30, 2017
 * 
 * Description: Beer Screen for the application GUI that displays data pertaining to the BeerReviewADT
 */

package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import backend.BeerReview;

public class BeerScreen {
	private JFrame mainFrame;
	private JPanel displayPanel;
	private JLabel headerLabel;
	private JPanel exitPanel;
	private JLabel [] data = new JLabel[8];
	
	public BeerScreen(BeerReview name)
	{
		showGUI(name);
	}
	
	public static void main (String [] args)
	{
		//String name = "Test";
		//BeerScreen b = new BeerScreen(name);
	}
	
	private void showGUI(BeerReview b)
	{
		mainFrame = new JFrame (b.getBeer().getName());
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new GridLayout (3,1));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		headerLabel = new JLabel(b.getBeer().getName(), JLabel.LEFT);
		headerLabel.setFont (headerLabel.getFont ().deriveFont (55.0f));

		displayPanel = new JPanel();
		//displayPanel.setLayout(new FlowLayout());
		//displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
		displayPanel.setLayout(new GridLayout(8,1));
		
		exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(displayPanel);
		mainFrame.add(exitPanel);
		
		/*for (int i = 0; i< 8; i++)
		{
			data[i] = new JLabel("Test");
		}*/
		
		data[0] = new JLabel("Name: " + b.getBeer().getName(), JLabel.LEFT);
		data[0].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[1] = new JLabel("Brewery: " + b.getBeer().getBrewery(),JLabel.LEFT);
		data[1].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[2] = new JLabel("Style: " + b.getBeer().getStyle(),JLabel.LEFT);
		data[2].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[3] = new JLabel("Overall: " + String.format("%.2f",b.getOverall()),JLabel.LEFT);
		data[3].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[4] = new JLabel("Aroma: " + String.format("%.2f",b.getAroma()),JLabel.LEFT);
		data[4].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[5] = new JLabel("Appearance: " + String.format("%.2f",b.getAppearance()),JLabel.LEFT);
		data[5].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[6] = new JLabel("Palate: " + String.format("%.2f",b.getPalate()),JLabel.LEFT);
		data[6].setFont (headerLabel.getFont ().deriveFont (20.0f));
		data[7] = new JLabel("Taste: " + String.format("%.2f",b.getTaste()),JLabel.LEFT);
		data[7].setFont (headerLabel.getFont ().deriveFont (20.0f));
		
		for (int i = 0; i < 8; i++)
		{
			displayPanel.add(data[i]);
		}
		
		JButton exit = new JButton("Return");
		exit.setActionCommand("Exit");
		exit.addActionListener(new ButtonClickListener());
		
		exitPanel.add(exit);
		
		mainFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			
			if (command.equals("Exit"))
			{
				mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			}			
		}
	}
}
