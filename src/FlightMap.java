import java.io.*;
import java.util.*;

public class FlightMap {
	private Map<String, Airport> airMap;
	
	public FlightMap() {
		airMap = new HashMap<String, Airport>();
	}
	public void addAirport(String key, Airport air) {
		airMap.put(key, air);
	}
	public boolean airExisted(String key) {
		if(airMap.containsKey(key)) {
			return true;
		}
		else {
			return false;
		}
	}
	public Airport getAir(String key) {
		return airMap.get(key);
	}
}