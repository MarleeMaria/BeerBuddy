package backend;

/**
 *  This class searches the lists of data for beer names or brewery names that contain some character sequence
 *  <p>
 *  This class takes some list of beer reviews and some character sequence and searches to 
 *  find which beer name or brewery name conatiand that character sequence.
 *  <p>
 *  @author SE2XB3, Group 13
 */

import java.util.ArrayList;

import edu.princeton.cs.algs4.Queue;

public class SearchAlgs {
	/**
	* Finds any review thats beer name or brewery name conatians a cretain string of charaters
	* @param b - a list of beer reviews
	* @param s - a sequence of charaters
	* @return a queue of all beer reviews containing the sequence of charaters
	*/
	public static Queue<BeerReview> searchBeers(ArrayList<BeerReview> b, CharSequence s){
		Queue<BeerReview> q = new Queue<BeerReview>();
		SortAlgs.sortBrewery(b);
		for (int i = 0; i < b.size(); i++){
			Beer beer = b.get(i).getBeer();
			if(beer.getBrewery().contains(s) || beer.getName().contains(s)){
				q.enqueue(b.get(i));
			}
		}
		return q;
	}
}
