import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 
 * @author Betty Kouadio
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {
	private TownGraph m = new TownGraph();
	private ArrayList<String> roads = new ArrayList<String>();
	private ArrayList<String> towns= new ArrayList<String>();
	
	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	TownGraph graph = new TownGraph();
	
	public boolean populateTownGraph(File file) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		boolean populated = false;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String lineInfo[] = line.split(";");
			String edgeInfo[] = lineInfo[0].split(","); 		
			addTown(lineInfo[1]);
			addTown(lineInfo[2]);
			addRoad(lineInfo[1], lineInfo[2], Integer.parseInt(edgeInfo[1]), edgeInfo[0]);
			populated = true;
		}
		return populated;
	}

	/**
	 * getTownFromMap method
	 * @param name 
	 * @return t or null
	 */
	public Town getTownFromMap(String name) {
		Set <Town> town = m.vertexSet();
		for(Town t : town) {
			if(t.getName().equals(name))
				return t;
		}
		return null;
	}
	/**
	 * getRoadFromMapWeight method
	 * @param name
	 * @param a
	 * @param b
	 * @return max value integer
	 */
	public int getRoadFromMapWeight(String name,Town a, Town b) {
		Set <Road> roads = m.edgeSet();
		for(Road t : roads) {
			Set<Town> towns =new HashSet<Town>();
			towns.add(a);
			towns.add(b);
			if(t.getName().equals(name))
				if(t.getTowns().equals(towns))
				return t.getWeight();
		}
		return Integer.MAX_VALUE;
	}
	/**
	 * addRoad method
	 */
	
	
	@Override
	public boolean addRoad(String sourceTown, String desntinationTown, int weight, String roadName) {
		Town townS =getTownFromMap(sourceTown);
		Town townD = getTownFromMap(desntinationTown);

		if (m.containsVertex(townS) && m.containsVertex(townD)) {
			if (!m.containsEdge(townS, townD) ) {
				m.addEdge(townS, townD, weight, roadName);
				Road road = (Road) m.addEdge(townS, townD, weight, roadName); 

				roads.add(road.getName());

				return true;
			}
		}
		return false;
	}
	
	/**
	 * Getter and setter for Road
	 */
	@Override
	public String getRoad(String sourceTown, String desntinationTown) {

		Town townS = getTownFromMap(sourceTown);
		Town townD = getTownFromMap(desntinationTown);

		if (m.containsEdge(townS, townD)) {
			Road roadName = (Road) m.getEdge(townS, townD);

			return roadName.getName();
		}
		return null;
	}
	/**
	 * addTown method
	 */
	@Override
	public boolean addTown(String townName) {
		Town newTown = new Town(townName);

		if (!m.containsVertex(newTown)) {
			m.addVertex(newTown);

			towns.add(townName);

			return true;
		}
		return false;
	}
	/**
	 * containsTown method
	 */
	@Override
	public boolean containsTown(String townName) {
		Town town =getTownFromMap(townName);

		return (m.containsVertex(town));

	}
	/**
	 * containsRoadConnection method
	 */
	@Override
	public boolean containsRoadConnection(String sourceTown, String desntinationTown) {
		Town townSource = new Town(sourceTown);
		Town townDestination = new Town(desntinationTown);

		return (m.containsEdge(townSource, townDestination));
	}
	/**
	 * allRoads method
	 */
	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> sortRoads = new ArrayList<String>();

		sortRoads = roads;

		Collections.sort(roads);

		return sortRoads;
	}
	/**
	 * deleteRoadConnection method
	 */
	
	@Override
	public boolean deleteRoadConnection(String sourceTown, String destinationTown, String roadName) {
		Town townS =getTownFromMap(sourceTown);
		Town townD = getTownFromMap(destinationTown);

		if (m.containsEdge(townS, townD) == true) {
			m.removeEdge(townS, townD, getRoadFromMapWeight(roadName, townS, townD), roadName);
			roads.remove(roadName);
			return true;
		}

		return false;

	}
	/**
	 * deleteTown method
	 */
	@Override
	public boolean deleteTown(String townName) {
		Town town =getTownFromMap(townName);

		if (m.containsVertex(town	)) {
			m.removeVertex(town);
			towns.remove(townName);
			return true;
		}
		return false;

	}
	
	/**
	 * allTowns method
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> sortedTownNames = new ArrayList<String>();
		sortedTownNames = towns;

		Collections.sort(sortedTownNames);

		return sortedTownNames;
		
		
	}
	/**
	 * getPath method
	 */
	@Override
	public ArrayList<String> getPath(String sourceTown, String desntinationTown) {
		Town townSource = getTownFromMap(sourceTown);
		Town townDestination = getTownFromMap(desntinationTown);
		if(m.containsVertex(townDestination) && m.containsVertex(townSource))
			return m.shortestPath(townSource, townDestination);
		return null;

		
	

	}

	public Town getTown(String town1) {
		Town source = new Town(town1);
		return source;
		
	}
	
	

}
