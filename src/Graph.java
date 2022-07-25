import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Betty Kouadio
 *
 */

public class Graph implements GraphInterface<Town, Road> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<Town> setTowns = new HashSet();
	@SuppressWarnings({ "unchecked", "rawtypes" }) 
	private Set<Road> setRoads = new HashSet();
	Set<Town> visitTowns;
	Set<Town> unVisitTowns;
	ArrayList<String> location = new ArrayList<String>();
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		Iterator<Road> iterator = setRoads.iterator();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<Town> Towns = new HashSet();
		Towns.add(sourceVertex);
		Towns.add(destinationVertex);
		while(iterator.hasNext())
		{
			Road temper = iterator.next();
			if(temper.getTowns().equals(Towns))
				return temper;
		}
		return null;
	}
	 /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		sourceVertex.getAdjacentTowns().add((destinationVertex));
		destinationVertex.getAdjacentTowns().add((sourceVertex));
		sourceVertex.addTowns(destinationVertex);
		destinationVertex.addTowns(sourceVertex);
		Road t = new Road(sourceVertex,destinationVertex,weight, description);
		setRoads.add(t);
		return t;
		

	}
	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */

	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		
		return setTowns.add(v);
	}

	
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		Iterator<Road>iter = setRoads.iterator();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<Town>towns = new HashSet();
		towns.add(sourceVertex);
		towns.add(destinationVertex);
		while(iter.hasNext())
		{
			Road t = iter.next();
			if(t.getTowns().equals(towns))
				return true;
		}
		return false;
	}

	 /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		return setTowns.contains(v);
	}
	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return setRoads;
	}

	 /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	
	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<Road> edgeVertices = new HashSet();
		Iterator<Road>iter = setRoads.iterator();
		while(iter.hasNext())
		{
			Road t= iter.next();
			if (t.getTowns().contains(vertex)) 
			{
				edgeVertices.add(t);
			}
		}
			
		return edgeVertices;
	}
	
	 /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		sourceVertex.removeTowns(destinationVertex);
		destinationVertex.removeTowns(sourceVertex);
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		return setRoads.remove(temp) ? temp : null;
	}
	 /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		for(Road r :edgesOf(v)){
			@SuppressWarnings("rawtypes")
			Iterator iter = r.getTowns().iterator();
			Town a = (Town) iter.next();
			Town b = (Town) iter.next();
			removeEdge(a, b, r.getWeight(), r.getName());
		}
		return setTowns.remove(v);
	}
	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return setTowns;
	}
	
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex to destinationVertex
     */

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		location.clear();
		visitTowns = new HashSet();
		unVisitTowns= new HashSet(setTowns);
		Town townS,townD;
		townS =townD=null;
		for(Town t : setTowns)
		{
			if(t.getName().equals(sourceVertex.getName())) {
				townS =t;
				townS.setAdjacentTowns(t.getAdjacentTowns());
			}
			if(t.getName().equals(destinationVertex.getName())) {
				townD =t;
			}

		}
		townS.setWeight(0);
		visitTowns.add(townS);
		unVisitTowns.remove(townS);
		this.dijkstraShortestPath(townS);
		for (Town t : unVisitTowns) {
		

		}
		getShortestPath(townS, townD);

		Collections.reverse(location);
		for (Town town : setTowns) {
			town.resetLocation();
		}
		return location;
	}
	/**
	 * getShortestPath method
	 * @param sourceVertex
	 * @param destinationVertex
	 */
	private void getShortestPath(Town sourceVertex, Town destinationVertex) {
		try {
		Road t = getEdge(destinationVertex.getBackpath(), destinationVertex);
		StringBuilder str = new StringBuilder();
		str.append(destinationVertex.getBackpath().getName());
		str.append(" via ");
		str.append(t.getName());
		str.append(" to ");
		str.append(destinationVertex.getName());
		str.append(" ");
		str.append(t.getWeight());
		str.append(" mi");

		location.add(str.toString());
		if (!(destinationVertex.getBackpath().equals(sourceVertex))) {
			getShortestPath(sourceVertex, destinationVertex.getBackpath());

		}}catch(NullPointerException e) {

		location.clear();
		location.add("No such path found");
		}

	}
	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which hold the ability to retrieve the path,
     * shortest distance from the sourceVertex to all the other vertices in the graph, etc.
     * 
     * @param sourceVertex the vertex to find shortest path from
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
		Boolean finding = false;
		while (!unVisitTowns.isEmpty() && !finding) {
			finding = true;
			int shortest = Integer.MAX_VALUE;
			Town closestTown = null;
			for (Town visitedTown : visitTowns) {

				Set<Town> adjTowns = visitedTown.getAdjacentTowns();

				Set<Town> adjTownsUnVisited = new HashSet<>();
				for (Town town : adjTowns) {
					if (unVisitTowns.contains(town)) {
						adjTownsUnVisited.add(town);
					}
				}
				for (Town unvisitedTown : adjTownsUnVisited) {
					int totalWeight = getTotalWeight(unvisitedTown, visitedTown, sourceVertex);
					if (totalWeight < shortest) {
						shortest = totalWeight;

						closestTown = unvisitedTown;

						unvisitedTown.setBackpath(visitedTown);
					}
				}

			}
			if (closestTown != null) {
				closestTown.setWeight(shortest);
				visitTowns.add(closestTown);
				unVisitTowns.remove(closestTown);
				finding = false;
			}
		}

	}
	/**
	 * getTotalWeight method
	 * @param unvisitedTown
	 * @param visitedTown
	 * @param sourceVertex
	 * @return town
	 */

private int getTotalWeight(Town unvisitedTown, Town visitedTown, Town sourceVertex) {
	if (unvisitedTown.equals(sourceVertex))
		return 0;

	return visitedTown.getWeight() + getEdge(visitedTown, unvisitedTown).getWeight();
}

}