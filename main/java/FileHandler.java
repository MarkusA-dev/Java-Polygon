import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	
	/**
	 * <h1>Read poly from file</h1>
	 * <p>Reads the points for the polygon from a file</p>
	 * @param File name
	 * @return polygon object
	 */
	public static Polygon readPolygonFromFile(String fileName) {
		File polyFile = new File(fileName);
		Scanner readPoly;
		try{readPoly = new Scanner(polyFile);}
		catch(Exception e) {
			throw new RuntimeException("The code failed at making a Scanner");
		}
		ArrayList<Integer> polyPointFloats = new ArrayList<Integer>();
		while(readPoly.hasNext()) {
			polyPointFloats.add(readPoly.nextInt());
		}
		
		int i = 0;
		int[] polyFloatArr = new int[polyPointFloats.size()];
		for(int f : polyPointFloats) {
			polyFloatArr[i++] = f;
		}
		
		if(polyPointFloats.size() % 2 != 0) {
			polyPointFloats.remove(polyPointFloats.size()-1);
		}
		Polygon poly = new Polygon(polyFloatArr);
		readPoly.close();
		return poly ;
	}
	
	
	/**
	 * <h1>Read points to test from file</h1>
	 * <p>Reads points from a file and returns an array of points to test</p>
	 * @param File path
	 * @return Points to check
	 */
	public static ArrayList<Point> readPointsFromFile(String fileName){
		ArrayList<Point> points = new ArrayList<Point>();
		
		File pointFile = new File(fileName);
		Scanner read;
		try{
			read = new Scanner(pointFile);
		}
		catch(Exception e) {
			throw new RuntimeException("The code failed at creating a Scanner");
		}
		while(read.hasNext()) {
			Point readPoint = new Point(read.nextInt(), read.nextInt());
			points.add(readPoint);
		}
		read.close();
		return points;
	}
	
	/**
	 * <h1>Write reports to files</h1>
	 * <p>Gets an input of strings and file name and writes the array into a file, one line per string</p>
	 * @param data to write
	 * @param file path
	 * @return if succeeded return 1 
	 */
	public static boolean writeReportToFile(String[] reports, String fileName){
		try {
			FileWriter writer = new FileWriter(fileName);
			 writer.write("");
				for(String prep : reports) {
					writer.append(prep + "\n");
				}
			writer.close();
		}
		catch( Exception e ) {
			throw new RuntimeException();
		}
		return true;
		
	}
}
