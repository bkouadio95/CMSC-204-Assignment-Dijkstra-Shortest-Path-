import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoadTest_STUDENT 
{
	Road road1, road2, road3, road4, road5;
	Town chicago = new Town("Chicago"), detroit = new Town("Detroit"), miami = new Town("Miami");
	Town atlanta = new Town("Atlanta"), newOrleans = new Town("New Orleans"), dallas = new Town("Dallas");
	
	@BeforeEach
	void setUp() throws Exception 
	{
		road1 = new Road(chicago, detroit, 285, "I-96");
		road2 = new Road(detroit, chicago, 285, "I-96");
		road3 = new Road(atlanta, miami, 669, "I-85");
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		road1 = null; 
		road2 = null;
		road3 = null;
		road4 = null;
		road5 = null;
	}

	@Test
	void testContains() 
	{
		//assertTrue(road1.contains(chicago) && road1.contains(detroit));
		//assertTrue(road2.contains(chicago) && road2.contains(detroit));
		//assertTrue(road3.contains(atlanta) && road3.contains(miami));
		//assertTrue(road4.contains(miami) && road4.contains(newOrleans));

	}

	@Test
	void testToString() 
	{
		//assertEquals("I-96", road1.toString());
		//assertEquals("I-96", road2.toString());
		//assertEquals("I-85", road3.toString());
	}

	@Test
	void testCompareTo() 
	{
		assertTrue(road1.compareTo(road1) == 0);
		assertTrue(road1.compareTo(road2) == 0);
		assertTrue(road2.compareTo(road1) == 0);
		//assertTrue(road1.compareTo(road3) < 0);

	}

	@Test
	void testEqualsObject() 
	{
		assertTrue(road1.equals(road1) && road2.equals(road2));
	    assertFalse(road1.equals(road3) || road3.equals(road1));
	    assertTrue(road1.equals(road2) && road2.equals(road1));

	}

}
