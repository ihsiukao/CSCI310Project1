package FindRoute;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class TestAirport {

	private Airport tester;
	
	@Test
	public void testGetName1() {
		tester = new Airport("LAX");
		assertEquals("LAX", tester.getName());
	}
	@Test
	public void testGetName2() {
		tester = new Airport("SFO");
		assertEquals("SFO", tester.getName());
	}
	@Test
	public void testGetName3() {
		tester = new Airport("JFK");
		assertEquals("JFK", tester.getName());
	}
	@Test
	public void testGetName4() {
		tester = new Airport("TPE");
		assertEquals("TPE", tester.getName());
	}
	
	@Test
	public void testAddFlight1() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("b", 20);
		tester.addFlight("b", 50);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(50, (int)temp.get("b"));
	}
	@Test
	public void testAddFlight2() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("c", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(10, (int)temp.get("c"));
	}
	@Test
	public void testAddFlight3() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("c", 100);
		tester.addFlight("d", 50);
		tester.addFlight("e", 25);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(50, (int)temp.get("d"));
	}
	
	@Test
	public void testNumFlight1() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(temp.size(), tester.numberFlight());
	}
	@Test
	public void testNumFlight2() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("c", 10);
		tester.addFlight("d", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(temp.size(), tester.numberFlight());
	}
	@Test
	public void testNumFlight3() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("b", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(temp.size(), tester.numberFlight());
	}
	@Test
	public void testNumFlight4() {
		tester = new Airport("a");
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(temp.size(), tester.numberFlight());
	}

	@Test
	public void testGetFlight1() {
		tester = new Airport("a");
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(0, temp.size());
	}
	@Test
	public void testGetFlight2() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("b", 10);
		tester.addFlight("b", 10);
		tester.addFlight("b", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(1, temp.size());
	}
	@Test
	public void testGetFlight3() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("c", 10);
		tester.addFlight("d", 10);
		tester.addFlight("c", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(3, temp.size());
	}
	@Test
	public void testGetFlight4() {
		tester = new Airport("a");
		tester.addFlight("b", 10);
		tester.addFlight("c", 10);
		tester.addFlight("d", 10);
		tester.addFlight("e", 10);
		tester.addFlight("f", 10);
		tester.addFlight("g", 10);
		Map<String, Integer> temp = tester.getFlight();
		assertEquals(6, temp.size());
	}
}
