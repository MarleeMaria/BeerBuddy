package backend;

/**
 *  This class sorts the beer reviews based on a wide range of criteria
 *  <p>
 *  This class takes some list of beer reviews and depending on how it is decided to be sorted 
 *  e.g highest to lowest; overall rating, aroma rating, etc
 *  sorts the review in the proper order
 *  <p>
 *  @author SE2XB3, Group 13
 */


import java.util.ArrayList;

public class SortAlgs {
	private static BeerReview[] aux;
	public static void sortBeer(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortBeer(b, 0, b.size() - 1);
	}
	/**
	* Sort the list of beer reviews based on thier beer name
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortBeer(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortBeer(b, lo, mid);
		sortBeer(b, mid+1, hi);
		mergeBeer(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their name
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergeBeer(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].getBeer().cmpBeer(aux[i].getBeer()) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
	/**
	* Sort the BeerReviews based on brewery
	* @param b - a list of BeerReview
	*/
	public static void sortBrewery(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortBrewery(b, 0, b.size() - 1);
	}
	/**
	* Sort the beer's in order of their brewery 
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortBrewery(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortBrewery(b, lo, mid);
		sortBrewery(b, mid+1, hi);
		mergeBrewery(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their brewery
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergeBrewery(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].getBeer().cmpBrewery(aux[i].getBeer()) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
	/**
	* Sort the beer's in order of their overall rating
	* @param b - a list of BeerReview
	*/
	public static void sortOverall(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortOverall(b, 0, b.size() - 1);
	}
	/**
	* Sort the beer's in order of their overall rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortOverall(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortOverall(b, lo, mid);
		sortOverall(b, mid+1, hi);
		mergeOverall(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their overall rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergeOverall(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].cmpOverall(aux[i]) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
	/**
	* Sort the beer's in order of their aroma rating
	* @param b - a list of BeerReview
	*/
	public static void sortAroma(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortAroma(b, 0, b.size() - 1);
	}
	/**
	* Sort the beer's in order of their aroma rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortAroma(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortAroma(b, lo, mid);
		sortAroma(b, mid+1, hi);
		mergeAroma(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their aroma rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergeAroma(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].cmpAroma(aux[i]) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
	/**
	* Sort the beer's in order of their appearance rating
	* @param b - a list of BeerReview
	*/
	public static void sortAppearance(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortAppearance(b, 0, b.size() - 1);
	}
	/**
	* Sort the beer's in order of their appearance rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortAppearance(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortAppearance(b, lo, mid);
		sortAppearance(b, mid+1, hi);
		mergeAppearance(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their appearance rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergeAppearance(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].cmpAppearance(aux[i]) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
	/**
	* Sort the beer's in order of their palate rating
	* @param b - a list of BeerReview
	*/
	public static void sortPalate(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortPalate(b, 0, b.size() - 1);
	}
	/**
	* Sort the beer's in order of their palate rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortPalate(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortPalate(b, lo, mid);
		sortPalate(b, mid+1, hi);
		mergePalate(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their palate rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergePalate(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].cmpPalate(aux[i]) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
	/**
	* Sort the beer's in order of their taste rating
	* @param b - a list of BeerReview
	*/
	public static void sortTaste(ArrayList<BeerReview> b){
		aux = new BeerReview[b.size()];
		sortTaste(b, 0, b.size() - 1);
	}
	/**
	* Sort the beer's in order of their taste rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param hi - the higher value where the list is partitoned
	*/
	private static void sortTaste(ArrayList<BeerReview> b, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sortTaste(b, lo, mid);
		sortTaste(b, mid+1, hi);
		mergeTaste(b, lo, mid, hi);
	}
	/**
	* Merge sort the beer's in order of their taste rating
	* @param b - a list of BeerReview
	* @param lo - the bottom value where the list is partitioned
	* @param mid - the middle value where the list is split
	* @param hi - the higher value where the list is partitoned
	*/
	private static void mergeTaste(ArrayList<BeerReview> b, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			aux[k] = b.get(k);
		}
		for (int k = lo; k <= hi; k++){
			if (i > mid) b.set(k, aux[j++]);
			else if (j > hi) b.set(k, aux[i++]);
			else if (aux[j].cmpTaste(aux[i]) < 0) b.set(k, aux[j++]);
			else b.set(k, aux[i++]);
		}
	}
}
