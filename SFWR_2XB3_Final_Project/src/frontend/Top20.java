/**
 * Author: Matthew Po
 * Revised: March 30, 2017
 * 
 * Description: The Top20 Screen for the Beer Buddy GUI. This screen displays the various options to choose
 *				from when searching for a Top 20 category. This module makes use of the List.java to generate
 *				a list based on the top 20 results of each category.
 */

package frontend;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import backend.*;

public class Top20 {
	private JFrame mainFrame;
	private JPanel controlPanel;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel exitPanel;
	private ArrayList<BeerReview> totals;
	
	public Top20(ArrayList<BeerReview> totals)
	{
		showGUI();
		this.totals = totals;
	}
	
	public static void main(String[] args)
	{
		//Top20 t = new Top20();
	}
	
	private void showGUI()
	{
		mainFrame = new JFrame("Top 20 Search");
		//mainFrame.setSize(800, 700);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new GridLayout (3,1));
		
		headerLabel = new JLabel ("",JLabel.CENTER);
		headerLabel.setFont (headerLabel.getFont ().deriveFont (64.0f));

		statusLabel = new JLabel ("",JLabel.CENTER);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
	
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(exitPanel);
		
		headerLabel.setText("Top 20 Search");
		
		JButton rating = new JButton("Overall");
		JButton taste = new JButton("Taste");
		JButton appearance = new JButton("Appearance");
		JButton smell = new JButton ("Aroma");
		JButton palate = new JButton("Palate");
		
		JButton exit = new JButton ("Return");
		
		rating.setActionCommand("Rate");
		taste.setActionCommand("Taste");
		appearance.setActionCommand("Appearance");
		smell.setActionCommand("Smell");
		palate.setActionCommand("Palate");
		
		exit.setActionCommand("Exit");
		
		rating.addActionListener(new ButtonClickListener());
		taste.addActionListener(new ButtonClickListener());
		appearance.addActionListener(new ButtonClickListener());
		smell.addActionListener(new ButtonClickListener());
		palate.addActionListener(new ButtonClickListener());
		
		exit.addActionListener(new ButtonClickListener());
		
		controlPanel.add(rating);
		controlPanel.add(taste);
		controlPanel.add(appearance);
		controlPanel.add(smell);
		controlPanel.add(palate);
		
		exitPanel.add(exit);
		
		mainFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			
			if (command.equals("Rate"))
			{
				topOverall();
				List l = new List("Overall", totals);
			}
			else if(command.equals("Taste"))
			{
				topTaste();
				List l = new List(command, totals);
			}
			else if (command.equals("Appearance"))
			{
				topAppearance();
				List l = new List (command,totals);
			}
			else if (command.equals("Smell"))
			{	
				topAroma();
				List l = new List ("Aroma",totals);
			}
			else if (command.equals("Palate"))
			{
				topPalate();
				List l = new List (command,totals);
			}
			else if (command.equals("Exit"))
			{
				mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			}
					
					
		}
	}
	
	public void topOverall(){
		SortAlgs.sortOverall(totals);
	}
	public void topAroma(){
		SortAlgs.sortAroma(totals);
	}
	public void topAppearance(){
		SortAlgs.sortAppearance(totals);
	}
	public void topPalate(){
		SortAlgs.sortPalate(totals);
	}
	public void topTaste(){
		SortAlgs.sortTaste(totals);
	}
}
