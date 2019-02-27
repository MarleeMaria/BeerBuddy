package backend;

/**
 *  This class creates a beer review object that represents a sinlge line in the beer advocate user data base
 *  <p>
 *  To use this class, you must input many different parameters. The first is a string which represents the reviews name.
 *  The second is a object of type Beer. The last is five doubles that represent the reiews rating for the five different criteria
 *  <p>
 *  Here is an example program that uses {@code BeerReview}:
 *  <pre>
 *   public class TestBeer {
 *       public static void main(String[] args) {
 *			 String n = "Bud";
 *           String b = "Wiser";
 *			 String s = "Lagger";
 *           Beer b = new Beer(n,b,s);
 *
 *			 String r = "Marlee";
 *			 Double o = 4.0;
 *			 Double ar = 2.0;
 *			 Double ap = 2.3;
 *			 Double p = 5.0;
 *			 Double t = 3.0;
 *			 BeerReview Review = new BeerReview(r,b,o,ar,ap,p,t);
 *       }
 *   }
 *  </pre>
 *  @author SE2XB3, Group 13
 */

public class BeerReview {
	private String reviewer;
	private Beer beer;
	private double overall, aroma, appearance, palate, taste;


	/**
	 *  Create a new review
	 *  @param r is the name of the reviewer
	 *  @param b is an object of type Beer
	 *  @param o is a double that represents what a reviewer rated a beer overall
	 *  @param ar is a double that represents what a reviewer rated a beers aroma
	 *  @param ap is a double that represents what a reviewer rated a beers appearance
	 *  @param p is a double that represents what a reviewer rated a beers palate
	 *  @param t is a double that represents what a reviewer rated a beers taste
	 */
	public BeerReview(String r, Beer b, double o, double ar, double ap, double p, double t){
		this.reviewer = r;
		this.beer = b;
		this.overall = o;
		this.aroma = ar;
		this.appearance = ap;
		this.palate = p;
		this.taste = t;
	}
	/**
	 *  Returns the reviewer of the review
	 *  @return reviewer of the given review
	 */
	public String getReviewer(){
		return this.reviewer;
	}
	/**
	 *  Returns the beer of the review
	 *  @return beer object of the given review
	 */
	public Beer getBeer(){
		return this.beer;
	}
	/**
	 *  Returns the overall rating of the review
	 *  @return overall rating
	 */
	public double getOverall(){
		return this.overall;
	}
	/**
	 *  Returns the aroma rating of the review
	 *  @return aroma rating
	 */
	public double getAroma(){
		return this.aroma;
	}
	/**
	 *  Returns the appearance rating of the review
	 *  @return appearance rating
	 */
	public double getAppearance(){
		return this.appearance;
	}
	/**
	 *  Returns the palate rating of the review
	 *  @return palate rating
	 */
	public double getPalate(){
		return this.palate;
	}
	/**
	 *  Returns the taste rating of the review
	 *  @return taste rating
	 */
	public double getTaste(){
		return this.taste;
	}
	/**
	 *  compares the beer to another reviews beer
	 *  @param r is an object of class BeerReview
	 *  @return a value greater than 0 if the original beer is smaller than the beer it is being compared to
	 *  @return a value smaller than 0 if the original beer is larger than the beer it is being compared to
	 *  @return a value of 0 if they are the same
	 */
	public int cmpBeer(BeerReview r){
		return this.beer.cmpBeer(r.getBeer());
	}
	/**
	 *  Subtracts the overall rating of one review from another
	 *  @param r is an object of class BeerReview
	 *  @return the value of the orignal reviews overall rating subtracted by the other reviews overall rating
	 */
	public double cmpOverall(BeerReview r){
		return r.getOverall() - this.overall;
	}
	/**
	 *  Subtracts the aroma rating of one review from another
	 *  @param r is an object of class BeerReview
	 *  @return the value of the orignal reviews aroma rating subtracted by the other reviews aroma rating
	 */
	public double cmpAroma(BeerReview r){
		return r.getAroma() - this.aroma;
	}
	/**
	 *  Subtracts the appearance rating of one review from another
	 *  @param r is an object of class BeerReview
	 *  @return the value of the orignal reviews appearance rating subtracted by the other reviews appearance rating
	 */
	public double cmpAppearance(BeerReview r){
		return r.getAppearance() - this.appearance;
	}
	/**
	 *  Subtracts the palate rating of one review from another
	 *  @param r is an object of class BeerReview
	 *  @return the value of the orignal reviews palate rating subtracted by the other reviews palate rating
	 */
	public double cmpPalate(BeerReview r){
		return r.getPalate() - this.palate;
	}
	/**
	 *  Subtracts the taste rating of one review from another
	 *  @param r is an object of class BeerReview
	 *  @return the value of the orignal reviews taste rating subtracted by the other reviews taste rating
	 */
	public double cmpTaste(BeerReview r){
		return r.getTaste() - this.taste;
	}
}
