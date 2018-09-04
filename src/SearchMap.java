import java.io.*;
import java.util.*;

public class SearchMap {
	public static void main(String[] args) {
		String inputName;
		FileReader fr;
		BufferedReader br;
		FlightMap map;
		inputName = args[0];
		map = new FlightMap();
		try {
			fr = new FileReader(inputName);
			br = new BufferedReader(fr);
			map = constructMap(br);
		}

	}
	public static FlightMap constructMap(BufferedReader br) {
		FlightMap map = new FlightMap();
		
	}
	public Map<List<String>, Integer> findRoute() {
		
	}

}