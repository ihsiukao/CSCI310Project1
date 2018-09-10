import java.io.*;
import java.util.*;

public class SearchMap {
	public static void main(String[] args) {
		String inputName = args[0];
		String outputName = args[1];
		FlightMap map;
		map = new FlightMap(inputName);
		map.findRoutes(outputName);
	}

}