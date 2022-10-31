package java;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	
	
	/**
	 * @param File name
	 * @return polygon object
	 * @throws FileNotFoundException 
	 */
	public static Polygon readPolygonFromFile(String fileName) throws FileNotFoundException {
		File polyFile = new File(fileName);
		Scanner readPoly = new Scanner(polyFile);
		ArrayList<Float> polyPointFloats = new ArrayList<Float>();
		while(readPoly.hasNext()) {
			polyPointFloats.add(readPoly.nextFloat());
		}
		
		int i = 0;
		float[] polyFloatArr = new float[polyPointFloats.size()];
		for(Float f : polyPointFloats) {
			polyFloatArr[i++] = (f != null ? f : Float.NaN);
		}
		
		if(polyPointFloats.size() % 2 != 0) {
			polyPointFloats.remove(polyPointFloats.size()-1);
		}
		Polygon poly = new Polygon(polyFloatArr);
		readPoly.close();
		return poly ;
	}
	
	
	/**
	 * @param File path
	 * @return Points to check
	 * @throws FileNotFoundException 
	 */
	public static ArrayList<Point> readPointsFromFile(String fileName) throws FileNotFoundException, IOException {
		ArrayList<Point> points = new ArrayList<Point>();
		
		File pointFile = new File(fileName);
		Scanner read = new Scanner(pointFile);
		while(read.hasNext()) {
			Point readPoint = new Point(read.nextFloat(), read.nextFloat());
			points.add(readPoint);
		}
		read.close();
		return points;
	}
	
	/**
	 * @param data to write
	 * @return if succeeded return 1
	 * @throws IOException 
	 */
	public static boolean writeReportToFile(String[] reports, String fileName) throws IOException {
		
		FileWriter writer = new FileWriter(fileName);
		writer.write("");
		for(String prep : reports) {
			writer.append(prep + "\n");
		}
		writer.close();
		
		return false;
		
	}
}
