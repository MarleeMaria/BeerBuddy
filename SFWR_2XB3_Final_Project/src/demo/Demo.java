package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import backend.*;
import frontend.*;

public class Demo {
	private ArrayList<BeerReview> totals;
	private ArrayList<BeerReview> reviews;
	private Graph users;
	
	public static void main (String [] args) throws IOException
	{
		
		// Initialize Data
		Demo d = new Demo();
		d.createList("data/beer_reviews.csv");
		d.totalReviews();
		
		// Initialize GUI
		HomeScreen h = new HomeScreen(d.reviews,d.totals);
		h.eventDemo();
		
		
	}
	
	public void createList(String source) throws IOException{
		users = new Graph();
		reviews = new ArrayList<BeerReview>();
		String line;
		String[] entries;
		BufferedReader r = new BufferedReader(new FileReader(source));
		r.readLine(); //Skip first line explaining organization of data
		while ((line = r.readLine()) != null){
			entries = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //Split by commas, ignoring commas in quotes
			BeerReview b = new BeerReview(entries[6], new Beer(entries[10], entries[1], entries[7]), Double.parseDouble(entries[3]), Double.parseDouble(entries[4]), Double.parseDouble(entries[5]), Double.parseDouble(entries[8]), Double.parseDouble(entries[9]));
			reviews.add(b);
			users.addReview(entries[6], entries[10], Double.parseDouble(entries[3]));
		}
	}
	
	public void relatedBeer(Beer b){
		SortAlgs.sortOverall(reviews);
		String user = "";
		for(int i = reviews.size()-1; i > -1; i--){
			if (reviews.get(i).getBeer().getName() == b.getName()){
				users.makeEdges(reviews.get(i).getReviewer());
				user = users.relatedUser(reviews.get(i).getReviewer());
			}
		}
		for(int i = reviews.size()-1; i > -1; i--){
			if (reviews.get(i).getReviewer() == user){
				//Return the beer in the review
			}
		}
	}
	public void totalReviews(){
		//Sort by beer name first
		SortAlgs.sortBeer(reviews);
		totals = new ArrayList<BeerReview>();
		String name, brewery, style;
		double o, ar, ap, p, t, count;
		int i = 0;
		BeerReview r;
		while(i < reviews.size()){
			r = reviews.get(i);
			name = r.getBeer().getName();
			brewery = r.getBeer().getBrewery();
			style = r.getBeer().getStyle();
			o = ar = ap = p = t = count = 0;
			while(r.getBeer().getName().equals(name) && r.getBeer().getBrewery().equals(brewery)){
				o += r.getOverall();
				ar += r.getAroma();
				ap += r.getAppearance();
				p += r.getPalate();
				t += r.getTaste();
				i++;
				count++;
				if(!(i < reviews.size())){
					break;
				}
				r = reviews.get(i);
			}
			totals.add(new BeerReview(null, new Beer(name, brewery, style), o/count, ar/count, ap/count, p/count, t/count));
		}
	}
}
