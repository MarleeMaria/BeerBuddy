/**
 * Author: Matthew Po
 * Revised: March 18, 2017
 * 
 * Description: Search Screen for the Beer Buddy GUI. This screen gives the option to text search for a
 *				beer name or brewery name. The list of the top 20 search results will be generated. This
 *				module makes use of the List.java file to generate the search results.
 */

package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import backend.BeerReview;
import backend.SearchAlgs;
import edu.princeton.cs.algs4.Queue;


public class Search {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel controlPanel;
	private JPanel exitPanel;
	private JPanel displayPanel;
	private JTextField t;
	private JComboBox cb;
	private JLabel statusLabel;
	private ArrayList<BeerReview> b;

	
	public Search(ArrayList<BeerReview> b)
	{
		showGUI();
		this.b = b;
	}
	
	public static void main(String [] args)
	{
		//Search s = new Search();
	}
	
	private void showGUI()
	{
		mainFrame = new JFrame ("Search");
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new GridLayout (5,1));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		headerLabel = new JLabel ("Search",JLabel.CENTER);
		headerLabel.setFont (headerLabel.getFont ().deriveFont (64.0f));
		
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(350,100);
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		
		displayPanel = new JPanel();
		displayPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(displayPanel);
		mainFrame.add(statusLabel);
		mainFrame.add(exitPanel);
		
		String choices[] = {"Beer", "Brewery"};
		
		// cb = new JComboBox(choices);
		t = new JTextField("",20);
		
		//JButton beer = new JButton("Beer");
		//JButton brewery = new JButton("Brewery");
		JButton exit = new JButton("Return");
		JButton enter = new JButton ("Enter");
		
		//beer.setActionCommand("beer");
		//brewery.setActionCommand("brew");
		exit.setActionCommand("Exit");
		enter.setActionCommand("Enter");
		enter.setPreferredSize(new Dimension(70,25));
		
		//beer.addActionListener(new ButtonClickListener());
		//brewery.addActionListener(new ButtonClickListener());
		exit.addActionListener(new ButtonClickListener());
		enter.addActionListener(new ButtonClickListener());
		
		//controlPanel.add(beer);
		//controlPanel.add(brewery);
		controlPanel.add(t);
		//controlPanel.add(cb);
		controlPanel.add(enter, "20");
		
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
			else if (command.equals("Enter"))
			{
				String input = t.getText();
				Queue<BeerReview> q = SearchAlgs.searchBeers(b, input);
				if (q.size() == 0)
				{
					statusLabel.setText("No Results Found");
				}
				else
				{
					statusLabel.setText("");
					List l = new List(q);
				}
			}
					
					
		}
	}
}