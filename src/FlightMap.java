import java.io.*;
import java.util.*;

public class FlightMap {
	private Map<String, Airport> airMap;
	FileReader fr;
	BufferedReader br;
	
	public FlightMap(String inputName) {
		airMap = new HashMap<String, Airport>();
		constructMap(inputName);
	}
	private void constructMap(String inputName) {
		try {
			fr = new FileReader(inputName);
			br = new BufferedReader(fr);
			String line = br.readLine();
			Airport temp = new Airport(line);
			airMap.put(line, temp);
			while(line != null) {
				line = br.readLine();
				String[] words = line.split("\\s+");
				if(airMap.containsKey(words[0])) {
					temp = airMap.get(words[0]);
					temp.addFlight(words[1], Integer.parseInt(words[2]));
					airMap.remove(words[0]);
				}
				else 
				{
					temp = new Airport(words[0]);
				}
				airMap.put(words[0], temp);
				if(!airMap.containsKey(words[1])) {
					temp = new Airport(words[1]);
					airMap.put(words[1], temp);
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					System.out.print(ioe.getMessage());
				}
			}
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException ioe) {
					System.out.print(ioe.getMessage());
				}
			}
		}
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