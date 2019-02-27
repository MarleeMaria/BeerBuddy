/**
 * Author: Matthew Po
 * Revised: March 30, 2017
 * 
 * Description: List screen for the Beer Buddy GUI that displays a list of 20 items on the screen.
 * 				What actually gets displayed is based on whether the option to show Top20 or Search.
 *				The methods signature reflects which method is being called.
 */

package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import backend.Beer;
import backend.BeerReview;
import edu.princeton.cs.algs4.Queue;

public class List {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel displayPanel;
	private JPanel exitPanel;
	private BeerReview[] beer =  new BeerReview[20];
	private Queue<BeerReview> beerReview;
	
	public List(Queue<BeerReview> name)
	{
		showGUI(name);
	}
	public List(String title, ArrayList<BeerReview> name)
	{
		showGUI(title, name);
	}
	
	public static void main (String [] args)
	{
		//List l = new List();
	}
	
	private void showGUI(Queue<BeerReview> name)
	{
		beerReview = name;
		mainFrame = new JFrame ("List");
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new GridLayout(3,1));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		headerLabel = new JLabel("Results", JLabel.CENTER);
		headerLabel.setFont (headerLabel.getFont ().deriveFont (64.0f));
		
		//String [] display = {"Example 1", "Example 2", "Example 3"};
		displayPanel = new JPanel();
		//displayPanel.setLayout(new BorderLayout());
	    displayPanel.setLayout(new GridLayout(10,10));
	    
		exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(displayPanel);
		mainFrame.add(exitPanel);
		
		JButton exit = new JButton("Return");
		JButton more = new JButton("More");
		
		JButton options [] = new JButton[20];
		//int counter = 0;
		//float alignY = 0.0f;
		//float alignX = 10.0f;
		int s;
		int counter = 0;
		for (int i = 0; i < 20; i++)
		{
			//System.out.println(name.size());
			//System.out.println(b.getName());

			try{
				BeerReview br = name.dequeue();
				Beer b = br.getBeer();
				beer[counter++] = br;
				options[i] = new JButton(b.getName());
				options[i].setActionCommand(b.getName());
				options[i].addActionListener(new ButtonClickListener());
				displayPanel.add(options[i]);
				//System.out.println("Something " + i);
			}
			catch(Exception e){
				System.out.println("Error");
				break;
			}
		
		}
		
		
		for (int i = counter; i < 20; i++)
		{
			options[i]= new JButton("");
			options[i].setAction(null);
			displayPanel.add(options[i]);
			//System.out.println("Something " + i);
		}
		
		
		exit.setActionCommand("Exit");
		more.setActionCommand("More");
		
		exit.addActionListener(new ButtonClickListener());
		more.addActionListener(new ButtonClickListener());
		
		exitPanel.add(exit, BorderLayout.SOUTH);
		exitPanel.add(more);
		
		mainFrame.setVisible(true);
	}
	
	private void showGUI(String title,ArrayList<BeerReview> name)
	{
		mainFrame = new JFrame (title);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new GridLayout(3,1));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		headerLabel = new JLabel(title, JLabel.CENTER);
		headerLabel.setFont (headerLabel.getFont ().deriveFont (64.0f));
		
		//String [] display = {"Example 1", "Example 2", "Example 3"};
		displayPanel = new JPanel();
		//displayPanel.setLayout(new BorderLayout());
	    displayPanel.setLayout(new GridLayout(10,10));
	    
		exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(displayPanel);
		mainFrame.add(exitPanel);
		
		JButton exit = new JButton("Return");
		
		JButton options [] = new JButton[20];
		//int counter = 0;
		//float alignY = 0.0f;
		//float alignX = 10.0f;
		int s;
		int counter = 0;
		for (int i = 0; i < 20; i++)
		{
			//System.out.println(name.size());
			BeerReview br = name.get(counter);
			Beer b = br.getBeer();
			//System.out.println(b.getName());

			try{
				beer[counter++] = br;
				options[i] = new JButton(b.getName());
				options[i].setActionCommand(b.getName());
				options[i].addActionListener(new ButtonClickListener());
				displayPanel.add(options[i]);
				//System.out.println("Something " + i);
			}
			catch(Exception e){
				System.out.println("Error");
				break;
			}
		
		}
		
		
		for (int i = counter; i < 20; i++)
		{
			options[i]= new JButton("");
			options[i].setAction(null);
			displayPanel.add(options[i]);
			//System.out.println("Something " + i);
		}
		
		
		exit.setActionCommand("Exit");
		
		exit.addActionListener(new ButtonClickListener());
		
		exitPanel.add(exit, BorderLayout.SOUTH);
		
		mainFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			
			if (command.equals("Exit"))
			{
				try{
					mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
				}
				catch (Exception exception)
				{
					
				}
			}
			else if (command.equals("More"))
			{
				/*Queue<BeerReview> br = new Queue<BeerReview>();
				for (int i = 0; i < 20; i++)
				{
					BeerReview beers = beerReview.dequeue();
					br.enqueue(beers);
				}*/
				List l = new List(beerReview);
				try{
					mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
				}
				catch (Exception exception)
				{
				}
				
			}
			
			for(BeerReview b: beer)
			{
				if (command.equals(b.getBeer().getName()))
				{
					BeerScreen bs = new BeerScreen(b);
				}
			}
			
			
			/*else if (command.equals("Something"))
			{
				BeerScreen b = new BeerScreen("Test");
				//System.out.println("Something");
			}*/
		}
	}
}
