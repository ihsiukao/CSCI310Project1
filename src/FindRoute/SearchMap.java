package FindRoute;
import java.io.*;
import java.util.*;

public class SearchMap {
	//main function of client code
	public static void main(String[] args) {
		String inputName = args[0];
		String outputName = args[1];
		FlightMap map = new FlightMap();
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		String originAir = null;
		List<String> airports = new LinkedList<String>();
		//read input file and parse into graph
		try {
			fr = new FileReader(inputName);
			br = new BufferedReader(fr);
			String line = br.readLine();
			originAir = line;
			map.addAir(originAir);
			airports.add(originAir);
			line = br.readLine();
			while(line != null) {
				String[] words = line.split("\\s+");
				if(map.containsAir(words[0])) {
					map.addFlight(words[0], words[1], Integer.parseInt(words[2]));
				}
				else {
					map.addAir(words[0]);
					map.addFlight(words[0], words[1], Integer.parseInt(words[2]));
					airports.add(words[0]);
				}
				if(!map.containsAir(words[1])) {
					map.addAir(words[1]);
					airports.add(words[1]);
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
		//find route from starting point to each node and write to output file
		try {
			fw = new FileWriter(outputName);
			pw = new PrintWriter(fw);
			String line;
			//formatting output
			line = "Destination Flight Route from " + originAir + " ";
			for(int i = 0; i < (airports.size()*2) - 19; i++) {
				line = line + " ";
			}
			line = line + "Total Cost  ";
			pw.println(line);
			pw.flush();
			for(Iterator<String> it = airports.iterator(); it.hasNext();) {
				String endAir = it.next();
				if(originAir != endAir) {
					List<String> airRoutes = new LinkedList<String>();
					List<String> visitedAir = new LinkedList<String>();
					int cost[] = new int[1];
					cost[0] = 0;
					int result = map.findRoutes(cost, originAir, endAir, airRoutes, visitedAir);
					//formatting output
					if(result == 1) {
						line = endAir + "           ";
						for(int i = 0; i < airRoutes.size(); i++) {
							line = line + airRoutes.get(i) + ",";
						}
						for(int i = 0; i < (airports.size() - airRoutes.size()); i++) {
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
		return;
	}

}