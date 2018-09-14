package FindRoute;
import java.io.*;
import java.util.*;

public class SearchMap {
	public static void main(String[] args) {
		//String inputName = args[0];
		//String outputName = args[1];
		FlightMap map = new FlightMap();
		FileReader fr = null;
		BufferedReader br = null;
		String originAir;
		try {
			fr = new FileReader("inputfile.txt");
			br = new BufferedReader(fr);
			String line = br.readLine();
			originAir = line;
			map.addAir(originAir);
			line = br.readLine();
			while(line != null) {
				String[] words = line.split("\\s+");
				if(map.containsAir(words[0])) {
					map.addFlight(words[0], words[1], Integer.parseInt(words[2]));
				}
				else {
					map.addAir(words[0]);
					map.addFlight(words[0], words[1], Integer.parseInt(words[2]));
				}
				if(!map.containsAir(words[1])) {
					map.addAir(words[1]);
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
		
		map.writeFile("outputfile.txt");
		return;
	}

}