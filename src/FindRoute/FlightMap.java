package FindRoute;
import java.io.*;
import java.util.*;

public class FlightMap {
	private Map<String, Airport> airMap;
	
	//constructor
	//initialized Map container
	public FlightMap() {
		airMap = new HashMap<String, Airport>();
	}
	//take a string as input and create an Airport object then put into Map container
	public void addAir(String airName) {
		Airport temp = new Airport(airName);
		airMap.put(airName, temp);
	}
	//take a string as input and return whether the map contains the corresponding Airport object
	public boolean containsAir(String airName) {
		return airMap.containsKey(airName);
	}
	//take a string as input, check whether the map contains a corresponding Airport object
	//if yes, retrieve the object and add a flight
	//if not, do nothing 
	public void addFlight(String startAir, String endAir, int cost) {
		if(!airMap.containsKey(startAir)) {
			return;
		}
		Airport temp = airMap.get(startAir);
		temp.addFlight(endAir, cost);
		airMap.put(startAir, temp);
	}
	//take an int array, two strings, two list container
	//use DFS to find a path between the corresponding Airport object and record the total weight
	public int findRoutes(int cost[], String startAir, String endAir, List<String> routes, List<String> visited) {
		visited.add(startAir);
		//check for existence
		if(!airMap.containsKey(startAir)) {
			return 0;
		}
		if(!airMap.containsKey(endAir)) {
			return 0;
		}
		//base case for recursive method
		if(startAir.equals(endAir)) {
			routes.add(startAir);
			return 1;
		}
		else {
			if(airMap.get(startAir).numberFlight() == 0) {
				return 0;
			}
			else {
				routes.add(startAir);
				for(Map.Entry<String, Integer> airPair : airMap.get(startAir).getFlight().entrySet()) {
					if(!visited.contains(airPair.getKey())) {
						cost[0] = cost[0] + airPair.getValue();
						//recursive call
						int result = findRoutes(cost, airPair.getKey(), endAir, routes, visited);
						if(result == 1) {
							return 1;
						}
						else {
							cost[0] = cost[0] - airPair.getValue();
						}
					}
				}
				routes.remove(startAir);
			}
			return 0;
		}
	}
}