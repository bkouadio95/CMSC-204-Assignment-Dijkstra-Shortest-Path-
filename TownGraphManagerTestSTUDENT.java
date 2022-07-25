import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManagerTestSTUDENT {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[11];
		  
		  for (int i = 1; i < 11; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2"); 
		  graph.addRoad(town[1], town[5], 6, "Road_3");
		  graph.addRoad(town[3], town[7], 1, "Road_4");
		  graph.addRoad(town[3], town[8], 2, "Road_5");
		  graph.addRoad(town[4], town[8], 3, "Road_6");
		  graph.addRoad(town[6], town[9], 3, "Road_7");
		  graph.addRoad(town[9], town[5], 4, "Road_8");
		  graph.addRoad(town[7], town[4], 5, "Road_9");
		  graph.addRoad(town[2], town[8], 5, "Road_10");
		 
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad_STUDENT() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_2", roads.get(2));
		assertEquals("Road_3", roads.get(3));
		graph.addRoad(town[4], town[10], 1,"Road_13");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		
		
	}

	@Test
	public void testGetRoad_STUDENT() {
		assertEquals("Road_9", graph.getRoad(town[7], town[4]));
		assertEquals("Road_4", graph.getRoad(town[3], town[7]));
	}

	@Test
	public void testAddTown_STUDENT() {
		assertEquals(false, graph.containsTown("Town_13"));
		graph.addTown("Town_13");
		assertEquals(true, graph.containsTown("Town_13"));
	}
	
	@Test
	public void testDisjointGraph_STUDENT() {
		assertEquals(false, graph.containsTown("Town_13"));
		graph.addTown("Town_13");
		ArrayList<String> path = graph.getPath(town[1],"Town_13");
		assertFalse(path.size() < 0);
	}

	@Test
	public void testContainsTown_STUDENT() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_13"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[8]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	public void testAllRoads_STUDENT() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_2", roads.get(2));
		assertEquals("Road_8", roads.get(8));
		assertEquals("Road_9", roads.get(9));
	}

	@Test
	public void testDeleteRoadConnection_STUDENT() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[8]));
		graph.deleteRoadConnection(town[2], town[8], "Road_10");
		assertEquals(false, graph.containsRoadConnection(town[2], town[8]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_3"));
		graph.deleteTown(town[3]);
		assertEquals(false, graph.containsTown("Town_3"));
	}

	@Test
	public void testDeleteTownSTUDENT() {
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Town_2"));
		//fail("Test not yet implemented");
	}
	
	@Test
	public void testAllTowns_STUDENT() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_2", roads.get(2));
		assertEquals("Town_3", roads.get(3));
		assertEquals("Town_9", roads.get(9));
	}

	@Test
	public void testGetPath_STUDENT() {
		ArrayList<String> path = graph.getPath(town[1],town[4]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road_5 to Town_8 2 mi",path.get(1).trim());
		  assertEquals("Town_8 via Road_6 to Town_4 3 mi",path.get(2).trim());


	}
	
	
	
	@Test
	public void testGetPathSTUDENT() {
		ArrayList<String> path = graph.getPath(town[1],town[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_3 to Town_5 6 mi",path.get(0).trim());
		  assertEquals("Town_5 via Road_8 to Town_9 4 mi",path.get(1).trim());
		  assertEquals("Town_9 via Road_7 to Town_6 3 mi",path.get(2).trim());
		  
	}

}