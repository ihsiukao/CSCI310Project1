package FindRoute;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestFlightMap {

	private FlightMap tester;
	@Test
	public void testConAddAir1() {
		tester = new FlightMap();
		tester.addAir("a");
		tester.addAir("b");
		assertEquals(true, tester.containsAir("a"));
	}
	@Test
	public void testConAddAir2() {
		tester = new FlightMap();
		assertEquals(false, tester.containsAir("a"));
	}
	@Test
	public void testConAddAir3() {
		tester = new FlightMap();
		tester.addAir("a");
		tester.addAir("b");
		tester.addAir("a");
		assertEquals(true, tester.containsAir("a"));
	}
	
	@Test
	public void testAddFlight1() {
		tester = new FlightMap();
		tester.addAir("a");
		tester.addFlight("a", "b", 50);
		assertEquals(true, tester.containsAir("a"));
	}
	@Test
	public void testAddFlight2() {
		tester = new FlightMap();
		tester.addAir("a");
		tester.addFlight("a", "b", 50);
		assertEquals(false, tester.containsAir("e"));
	}
	@Test
	public void testAddFlight3() {
		tester = new FlightMap();
		tester.addAir("a");
		tester.addAir("b");
		tester.addAir("c");
		tester.addAir("e");
		tester.addAir("a");
		tester.addAir("c");
		tester.addFlight("a", "b", 50);
		tester.addFlight("c", "t", 50);
		tester.addFlight("e", "x", 50);
		tester.addFlight("y", "t", 50);
		tester.addFlight("x", "f", 50);
		assertEquals(false, tester.containsAir("x"));
	}
	@Test
	public void testAddFlight4() {
		tester = new FlightMap();
		tester.addAir("a");
		tester.addFlight("b", "a", 50);
		assertEquals(false, tester.containsAir("b"));
	}
	
	@Test
	public void testFindRoutes1() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addAir("R");
		tester.addAir("X");
		tester.addAir("W");
		tester.addAir("S");
		tester.addAir("T");
		tester.addAir("Y");
		tester.addAir("Z");
		tester.addAir("Q");
		tester.addFlight("P", "W", 200);
		tester.addFlight("P", "R", 300);
		tester.addFlight("R", "X", 200);
		tester.addFlight("Q", "X", 375);
		tester.addFlight("W", "S", 250);
		tester.addFlight("S", "T", 300);
		tester.addFlight("T", "W", 350);
		tester.addFlight("W", "Y", 500);
		tester.addFlight("Y", "Z", 450);
		tester.addFlight("Y", "R", 600);
		int cost[] = new int[1];
		List<String> routes = new LinkedList<String>();
		List<String> visited = new LinkedList<String>();
		int result = tester.findRoutes(cost, "P", "Q", routes, visited);
		assertEquals(0, result);
	}
	@Test
	public void testFindRoutes2() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addAir("R");
		tester.addAir("X");
		tester.addAir("W");
		tester.addAir("S");
		tester.addAir("T");
		tester.addAir("Y");
		tester.addAir("Z");
		tester.addAir("Q");
		tester.addFlight("P", "W", 200);
		tester.addFlight("P", "R", 300);
		tester.addFlight("R", "X", 200);
		tester.addFlight("Q", "X", 375);
		tester.addFlight("W", "S", 250);
		tester.addFlight("S", "T", 300);
		tester.addFlight("T", "W", 350);
		tester.addFlight("W", "Y", 500);
		tester.addFlight("Y", "Z", 450);
		tester.addFlight("Y", "R", 600);
		int cost[] = new int[1];
		List<String> routes = new LinkedList<String>();
		List<String> visited = new LinkedList<String>();
		int result = tester.findRoutes(cost, "P", "T", routes, visited);
		assertEquals(750, cost[0]);
	}
	@Test
	public void testFindRoutes3() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addAir("R");
		tester.addAir("X");
		tester.addAir("W");
		tester.addAir("S");
		tester.addAir("T");
		tester.addAir("Y");
		tester.addAir("Z");
		tester.addAir("Q");
		tester.addFlight("P", "W", 200);
		tester.addFlight("P", "R", 300);
		tester.addFlight("R", "X", 200);
		tester.addFlight("Q", "X", 375);
		tester.addFlight("W", "S", 250);
		tester.addFlight("S", "T", 300);
		tester.addFlight("T", "W", 350);
		tester.addFlight("W", "Y", 500);
		tester.addFlight("Y", "Z", 450);
		tester.addFlight("Y", "R", 600);
		int cost[] = new int[1];
		List<String> routes = new LinkedList<String>();
		List<String> visited = new LinkedList<String>();
		int result = tester.findRoutes(cost, "P", "S", routes, visited);
		assertEquals(1, result);
	}
	@Test
	public void testFindRoutes4() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addAir("R");
		tester.addAir("X");
		tester.addAir("W");
		tester.addAir("S");
		tester.addAir("T");
		tester.addAir("Y");
		tester.addAir("Z");
		tester.addAir("Q");
		tester.addFlight("P", "W", 200);
		tester.addFlight("P", "R", 300);
		tester.addFlight("R", "X", 200);
		tester.addFlight("Q", "X", 375);
		tester.addFlight("W", "S", 250);
		tester.addFlight("S", "T", 300);
		tester.addFlight("T", "W", 350);
		tester.addFlight("W", "Y", 500);
		tester.addFlight("Y", "Z", 450);
		tester.addFlight("Y", "R", 600);
		int cost[] = new int[1];
		List<String> routes = new LinkedList<String>();
		List<String> visited = new LinkedList<String>();
		int result = tester.findRoutes(cost, "P", "M", routes, visited);
		assertEquals(0, result);
	}
	
	@Test
	public void testGetAir1() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addFlight("P", "C", 300);
		Airport temp = tester.getAir("P");
		int flag = 0;
		if(temp != null) {
			flag = 1;
		}
		assertEquals(1, flag);
	}
	@Test
	public void testGetAir2() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addFlight("P", "C", 300);
		Airport temp = tester.getAir("H");
		int flag = 0;
		if(temp != null) {
			flag = 1;
		}
		assertEquals(0, flag);
	}
	@Test
	public void testGetAir3() {
		tester = new FlightMap();
		tester.addAir("P");
		tester.addFlight("P", "C", 300);
		tester.addFlight("P", "V", 300);
		tester.addFlight("P", "K", 300);
		Airport temp = tester.getAir("P");
		Map<String, Integer> map = temp.getFlight();
		assertEquals(3, map.size());
	}


}
