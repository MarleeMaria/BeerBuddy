package backend;

/**
 *  This class creates a graph that holds multiple nodes each representing a different point of data
 *  @author SE2XB3, Group 13
 */

import java.util.*;

public class Graph {
	private HashMap<Vertex, TreeSet<Vertex>> myAdjList;  
	private HashMap<String, HashMap<String, Double>> beers;
	private HashMap<String, Vertex> myVertices;
	private static final TreeSet<Vertex> EMPTY_SET = new TreeSet<Vertex>();
	private int myNumVertices;
	private int myNumEdges;
	private int vertexID;

	
	/**
     * Initializes an empty graph with 0 vertices and 0 edges.
     */
	public Graph() {
		myAdjList = new HashMap<Vertex, TreeSet<Vertex>>();
		myVertices = new HashMap<String, Vertex>();
		beers = new HashMap<String, HashMap<String, Double>>();
		myNumVertices = myNumEdges = vertexID = 0;
		
	}
	/**
	* This function finds reviewers with similar taste in beers to one specific reviewer
	* @param reviewer - the username of one reviewe
	* @return the most similar reviewer
	*/
	public String relatedUser(String reviewer) {
		double diff = 6;
		String result = null;
		for (Vertex v: myAdjList.get(myVertices.get(reviewer))){
			if (dist(reviewer, v.toString()) < diff){
				diff = dist(reviewer, v.toString());
				result = v.toString();
			}
		}
		return result;
	}
	/**
	* Inserts a new point onto the graph at 
	* @param r - reviewer name 
	* @param b - beer name
	* @param o - overall score
	*/
	public void addReview(String r, String b, double o){
		Vertex a = addVertex(r);
		beers.get(r).put(b, o);
	}
	/**
	* Generates all edges from a certain review
	* @param r - review's name that all the edges connect to
	*/
	public void makeEdges(String r){
		for (String s: beers.get(r).keySet()){
			for (Vertex v: getVertices()){
				if (beers.get(v.toString()).containsKey(s)){
					addEdge(r, v.toString());
				}
			}
		}
	}
	/**
	* Finds the distance in scores between two reviews
	* @param from - the inital review 
	* @param to  - the second review from which we check the distance from the first review
	* @return 6 if the edge dose not exist
	* @return the sum of the edges divided by the amount of edges
	*/
	public double dist(String from, String to){
		if(!hasEdge(from, to)){
			return 6;
		}
		else{
			double sum = 0;
			int count = 0;
			Set<String> beerSet = beers.get(to).keySet();
			beerSet.retainAll(beers.get(from).keySet());
			for (String s: beerSet){
				sum += Math.abs(beers.get(from).get(s)-beers.get(to).get(s));
				count++;
			}
			return sum/count;
		}
	}
	/**
	* Add a new vertex to the graph
	* @param name - the name of the new vertex 
	* @return the pre existing vertex if it already exist
	*/
	public Vertex addVertex(String name) {
		Vertex v;
		v = myVertices.get(name);
		if (v == null) {
			v = new Vertex(name, vertexID);
			myVertices.put(name, v);
			myAdjList.put(v, new TreeSet<Vertex>());
			beers.put(name, new HashMap<String, Double>());
			myNumVertices += 1;
			vertexID += 1;
		}
		return v;
	}
	/**
	* Return the vertex attached to a specific name
	* @param name - the name of the vertex 
	* @return the vertex attached to the name
	*/
	public Vertex getVertex(String name) {
		return myVertices.get(name);
	}
	/**
	* Return the true if vertex exist otherwise returns false
	* @param name - the name of the vertex 
	* @return true if vertex exist
	* @return false if vertex does not exist
	*/
	public boolean hasVertex(String name) {
		return myVertices.containsKey(name);
	}
	/**
	* Checks to see if there is an edge between two reviews
	* @param form - the original vertex's name
	* @param to - second vertex's name
	* @return true if an edge exist
	* @return false if an edge does not exist
	*/
	public boolean hasEdge(String from, String to) {

		if (!hasVertex(from) || !hasVertex(to))
			return false;
		return myAdjList.get(myVertices.get(from)).contains(myVertices.get(to));
	}
	/**
	* Creates an edge between two points
	* @param form - the original vertex's name
	* @param to - the second vertex's name
	* @return void if the edge already exist
	*/
	public void addEdge(String from, String to) {
		Vertex v, w;
		if (hasEdge(from, to))
			return;
		myNumEdges += 1;
		if ((v = getVertex(from)) == null)
			v = addVertex(from);
		if ((w = getVertex(to)) == null)
			w = addVertex(to);
		myAdjList.get(v).add(w);
		myAdjList.get(w).add(v);
	}
	/**
	* Finds a vertex adjacent to the vertex attached to a specific name
	* @param name - the original vertex's name
	* @return the adjacent vertex
	*/
	public Iterable<Vertex> adjacentTo(String name) {
		if (!hasVertex(name))
			return EMPTY_SET;
		return myAdjList.get(getVertex(name));
	}
	/**
	* Finds a vertex adjacent to the one inputed
	* @param name - the original vertex
	* @return the adjacent vertex
	*/
	public Iterable<Vertex> adjacentTo(Vertex v) {
		if (!myAdjList.containsKey(v))
			return EMPTY_SET;
		return myAdjList.get(v);
	}
	/**
	* return the values of all the verticies
	* @return list of all the verticies
	*/
	public Iterable<Vertex> getVertices() {
		return myVertices.values();
	}
	/**
	* return the amount of verticies present in the graph
	* @return the sum of the amount verticies
	*/
	public int numVertices()
	{
		return myNumVertices;
	}
	/**
	* return the number of edges present in the graph
	* @return the number of edges
	*/
	public int numEdges()
	{
		return myNumEdges;
	}
	/**
	* return the graph as a string
	* @return a list of all nodes and what they are connected to
	*/
	public String toString() {
		String s = "";
		for (Vertex v : myVertices.values()) {
			s += v + ": ";
			for (Vertex w : myAdjList.get(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {
	}
}