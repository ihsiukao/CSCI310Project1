package FindRoute;
import java.io.*;
import java.util.*;

public class FlightMap {
	private Map<String, Airport> airMap;
	
	public FlightMap() {
		airMap = new HashMap<String, Airport>();
	}
	public void addAir(String airName) {
		Airport temp = new Airport(airName);
		airMap.put(airName, temp);
	}
	public boolean containsAir(String airName) {
		return airMap.containsKey(airName);
	}
	public void addFlight(String startAir, String endAir, int cost) {
		if(!airMap.containsKey(startAir)) {
			return;
		}
		Airport temp = airMap.get(startAir);
		temp.addFlight(endAir, cost);
		airMap.put(startAir, temp);
	}
	public int findRoutes(int cost[], String startAir, String endAir, List<String> routes, List<String> visited) {
		visited.add(startAir);
		if(startAir == endAir) {
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