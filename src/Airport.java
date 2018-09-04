import java.io.*;
import java.util.*;
import java.lang.*;

public class Airport {
	private String airName;
	private Map<String, Integer> directFlight;
	
	public Airport(String name) {
		airName = name;
	}
	public String getName() {
		return airName;
	}
	public void addFlight(String name, int cost) {
		directFlight.put(name, cost);
	}
}