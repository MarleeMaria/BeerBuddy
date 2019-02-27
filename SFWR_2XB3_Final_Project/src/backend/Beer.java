package backend;

/**
 *  This class creates a beer object that saves a beers name brewery and style 
 *  <p>
 *  To use this class, you must input three strings. This will create a beer with three parameters name brewery and style
 *  <p>
 *  Here is an example program that uses {@code Beer}:
 *  <pre>
 *   public class TestBeer {
 *       public static void main(String[] args) {
 *           String n = "Bud";
 *           String b = "Wiser";
 *			 String s = "Lagger";
 *        	 Beer(n,b,s);
 *       }
 *   }
 *  </pre>
 *  @author SE2XB3, Group 13
 */

public class Beer {
	private String name;	
	private String brewery;
	private String style;


	/**
	 *  Create a new beer with specific name, brewery and, style.
	 *  @param name of the beer
	 *  @param brewery where the beer was brewed
	 *  @param style of the beer e.g lagger, hoppy
	 */
	public Beer(String n, String b, String s){
		this.name = n;
		this.brewery = b;
		this.style = s;
	}

	/**
	 *  Returns the name of the beer
	 *  @return name of the given beer
	 */
	public String getName(){
		return this.name;
	}
	/**
	 *  Returns the brewery the beer was brewed at
	 *  @return name of the brewery
	 */
	public String getBrewery(){
		return this.brewery;
	}
	/**
	 *  Returns the style of the beer
	 *  @return the style of beer
	 */
	public String getStyle(){
		return this.style;
	}
	/**
	 *  compares the beers name to another beers name
	 *  @param b is an object of class Beer
	 *  @return a value greater than 0 if the original beer name is smaller than the beer it is being compared to
	 *  @return a value smaller than 0 if the original beer name is larger than the beer it is being compared to
	 *  @return a value of 0 if they are the same
	 */
	public int cmpBeer(Beer b){
		return this.name.compareTo(b.getName());
	}
	/**
	 *  compares the brewery name to another beers brewery
	 *  @param b is an object of class Beer
	 *  @return a value greater than 0 if the original beer brewery is smaller than the beers brewery it is being compared to
	 *  @return a value smaller than 0 if the original beer brewery is larger than the beers brewery it is being compared to
	 *  @return a value of 0 if they are the same
	 */
	public int cmpBrewery(Beer b){
		return this.brewery.compareTo(b.getBrewery());
	}
	/**
	 *  compares the style of the beer to the style of another beer
	 *  @param b is an object of class Beer
	 *  @return a value greater than 0 if the original beer style is smaller than the beer it is being compared to
	 *  @return a value smaller than 0 if the original beer style is larger than the beers it is being compared to
	 *  @return a value of 0 if they are the same
	 */
	public int cmpStyle(Beer b){
		return this.style.compareTo(b.getStyle());
	}

	/**
	 *  Returns all of the parameters in class beer as a sting seperated by spaces
	 *  @return a sting of all the parameters in beer
	 */
	public String toString(){
		return this.name + "    " + this.style + "    " + this.brewery;
	}
}
