package backend;

/**
 *  This class computes all of the averages and important calulated data used to orginize the beer advocate user review data set
 *  <p>
 *  This class reads the CSV file and computes all of the important information into usable data
 *  <p>
 *  @author SE2XB3, Group 13
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReviewCalcs {
	private static ArrayList<BeerReview> reviews;
	private static ArrayList<BeerReview> totals;
	private static Graph users;
	/**
	* This function reads the information in the CSV file and creates a list of type BeerReview for every line in the file
	* @param source - the path location of the CSV file being read
  	* @exception IOException if a File cannot be read
	*/
	public static void createList(String source) throws IOException{
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
	/**
	* Sorts all beers in terms of their overall score
	*/
	public static void topOverall(){
		SortAlgs.sortOverall(totals);
	}
	/**
	* Sorts all beers in terms of their aroma score
	*/
	public static void topAroma(){
		SortAlgs.sortAroma(totals);
	}
	/**
	* Sorts all beers in terms of their appearance score
	*/
	public static void topAppearance(){
		SortAlgs.sortAppearance(totals);
	}
	/**
	* Sorts all beers in terms of their palate score
	*/
	public static void topPalate(){
		SortAlgs.sortPalate(totals);
	}
	/**
	* Sorts all beers in terms of their taste score
	*/
	public static void topTaste(){
		SortAlgs.sortTaste(totals);
	}
	/**
	* finds a similar beer to a specified one
	* @param b - an object of type beer
	*/
	public static void relatedBeer(Beer b){
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
	/**
	* Finds all reviews of one beer and averages out the ratings each user gave that specific beer
	* into one beer review that has the average overall score, average aroma score, average appearance score,
	* average palate score and, average taste score.
	*/
	public static void totalReviews(){
		//Sort by beer name first
		SortAlgs.sortBeer(reviews);
		totals = new ArrayList<BeerReview>();
		String name, brewery, style;
		int o, ar, ap, p, t, count;
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
	  /**
     * Checks the runtime for the initalization of the database into usable code
     * @param args the command-line arguments
     */
	public static void main(String[] args){
		try {
			long start = System.currentTimeMillis();
			createList("data/beer_reviews.csv");
			totalReviews();
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
