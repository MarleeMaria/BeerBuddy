/**
 * Author: Matthew Po
 * Revised: March 30, 2017
 * 
 * Description: Home Screen for the Beer Buddy GUI
 */

package frontend;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import backend.BeerReview;

public class HomeScreen {
	private JFrame mainFrame;
	private JPanel controlPanel;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel exitPanel;
	private ArrayList<BeerReview> br;
	private ArrayList<BeerReview> totals;
	
	public HomeScreen(ArrayList<BeerReview> br, ArrayList<BeerReview> totals)
	{
		showGUI();
		this.br = br;
		this.totals = totals;
	}
	
	public static void main (String [] args)
	{
		//HomeScreen s = new HomeScreen();
		//s.eventDemo();
	}
	
	private void showGUI()
	{
		mainFrame = new JFrame("Beer Buddy");
		// mainFrame.setSize(800,700);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new GridLayout (3,1));
		mainFrame.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		headerLabel = new JLabel("",JLabel.CENTER);
		headerLabel.setFont (headerLabel.getFont ().deriveFont (64.0f));
		statusLabel = new JLabel("",JLabel.CENTER);
		
		mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      }); 
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		//mainFrame.add(statusLabel);
		mainFrame.add(exitPanel);
		mainFrame.setVisible(true);
	}
	
	public void eventDemo()
	{
		headerLabel.setText("Welcome to Beer Buddy!");
		
		JButton search = new JButton("Search");
		JButton top20 = new JButton("Top 20");
		
		JButton exit = new JButton("Exit");
		
		search.setActionCommand("Search");
		top20.setActionCommand("top20");
		exit.setActionCommand("Exit");
		
		search.setPreferredSize(new Dimension(100,50));
		top20.setPreferredSize(new Dimension(100,50));
		
		search.addActionListener(new ButtonClickListener());
		top20.addActionListener(new ButtonClickListener());
		exit.addActionListener(new ButtonClickListener());
		
		controlPanel.add(search);
		controlPanel.add(top20);
		exitPanel.add(exit);
		
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

		
		mainFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         
	         if( command.equals( "Search" ))  {
	        	 statusLabel.setText("Search button clicked");
	            Search();
	         } else if( command.equals( "top20" ) )  {
	        	 statusLabel.setText("top20 button clicked");
	        	 top20(totals);
	         }
	         else
	         {
	        	 mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
	         }
	      }
	      
	      private void Search()
	      {
	    	  
	    	  Search s = new Search (totals);
	    	  /*for (BeerReview beers: totals)
	    	  {
	    		  System.out.println(beers.getBeer().getName());
	    	  }*/
	      }
	      
	      private void top20(ArrayList<BeerReview> totals)
	      {
	    	  Top20 t = new Top20(totals);
	      }
	}
}
