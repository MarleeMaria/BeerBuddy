
package backend;

/**
 *  This class Creates a vertex object that saves a vertex's name and its unique key.  
 *  <p>
 *  To use this class, you must input a string and an integer. This will create a vertex Sting with ID Integer
 *  <p>
 *  Here is an example program that uses {@code Vertex}:
 *  <pre>
 *   public class TestVertex {
 *       public static void main(String[] args) {
 *           int a = 17;
 *           String b = "Beer";
 *        	 Vertex(b,a);
 *       }
 *   }
 *  </pre>
 *  @author SE2XB3, Group 13
 */

public class Vertex implements Comparable<Vertex> {

	public String name; 	// label for vertex
	public int uid; 		// unique identifier for vertex (index)

 	 /**
     * Initializes the key and name of a specific vertex
     *
     * @param v the name of the vertex as a string
     * @param i the unique id value
     */
	public Vertex(String v, int i) {
		name = v;
		uid = i;
	}
 	 /**
     * Returns the name of the vertex
     *
     * @return the name of the vertex
     */
	public String toString() {
		return name;
	}
 	 /**
     * Compares a vertex to another vertex and checks to see if the original vertex is smaller
     *
     * @param other another object of class vertex
   	 * @return a value greater than 0 if the original vertex is smaller than the other vertex it is being compared to
	 * @return a value smaller than 0 if the original vertex is larger than the other vertex it is being compared to
	 * @return a value of 0 if they are the same
	 */
	public int compareTo(Vertex other) {
		return name.compareTo(other.name);
	}
}
