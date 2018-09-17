package FindRoute;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Airport {
	private String airName;
	private Map<String, Integer> directFlight;
	
	//constructor
	//take a string as input and initialize this.string with it
	//initialize map container
	public Airport(String name) {
		airName = name;
		directFlight = new HashMap<String, Integer>();
	}
	//return variable airName
	public String getName() {
		return airName;
	}
	//take a string and int as input
	//add a pair using the input to the map container
	//string represents a connecting node and cost represents the weight of edge
	public void addFlight(String name, int cost) {
		directFlight.put(name, cost);
	}
	//return size of map container
	public int numberFlight() {
		return directFlight.size();
	}
	//return the map container which contains all adjacent nodes and edge's weight
	public Map<String, Integer> getFlight(){
		return directFlight;
	}
}