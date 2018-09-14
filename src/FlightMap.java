import java.io.*;
import java.util.*;

public class FlightMap {
	private Map<String, Airport> airMap;
	private String originAir;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private PrintWriter pw;
	
	public FlightMap(String inputName) {
		airMap = new HashMap<String, Airport>();
		constructMap(inputName);
	}
	private void constructMap(String inputName) {
		try {
			fr = new FileReader(inputName);
			br = new BufferedReader(fr);
			String line = br.readLine();
			originAir = line;
			Airport temp = new Airport(line);
			airMap.put(line, temp);
			line = br.readLine();
			while(line != null) {
				String[] words = line.split("\\s+");
				if(airMap.containsKey(words[0])) {
					temp = airMap.get(words[0]);
					temp.addFlight(words[1], Integer.parseInt(words[2]));
					airMap.put(words[0], temp);
				}
				else {
					temp = new Airport(words[0]);
					temp.addFlight(words[1], Integer.parseInt(words[2]));
					airMap.put(words[0], temp);
				}
				airMap.put(words[0], temp);
				if(!airMap.containsKey(words[1])) {
					temp = new Airport(words[1]);
					airMap.put(words[1], temp);
				}
				line = br.readLine();
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
	public void writeFile(String outputName) {
		try {
			fw = new FileWriter(outputName);
			pw = new PrintWriter(fw);
			String line;
			line = "Destination Flight Route from " + originAir + " ";
			for(int i = 0; i < (airMap.size()*2) - 19; i++) {
				line = line + " ";
			}
			line = line + "Total Cost  ";
			pw.println(line);
			pw.flush();
			for(Map.Entry<String, Airport> pair : airMap.entrySet()) {
				if(pair.getKey() != originAir) {
					List<String> airRoutes = new LinkedList<String>();
					List<String> visitedAir = new LinkedList<String>();
					int cost[] = new int[1];
					cost[0] = 0;
					int result = findRoutes(cost, originAir, pair.getKey(), airRoutes, visitedAir);
					if(result == 1) {
						line = pair.getKey() + "           ";
						for(int i = 0; i < airRoutes.size(); i++) {
							line = line + airRoutes.get(i) + ",";
						}
						for(int i = 0; i < (airMap.size() - airRoutes.size()); i++) {
							line = line + "  ";
						}
						line = line + "  $" + Integer.toString(cost[0]);
						pw.println(line);
						pw.flush();
					}
				}
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} finally {
			if(pw != null) {
				pw.close();
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			}
		}
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