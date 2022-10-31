package java;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String polyPath = System.getenv("USERPROFILE") + "\\Desktop\\polygoni.txt";
		String pointPath = System.getenv("USERPROFILE") + "\\Desktop\\pisteet.txt";
		String finalPath = System.getenv("USERPROFILE") + "\\Desktop\\selvitys.txt";
		
		ArrayList<Point> pointsToTest = FileHandler.readPointsFromFile(pointPath);
		Polygon poly = FileHandler.readPolygonFromFile(polyPath);
		String[] reports = new String[pointsToTest.size()];
		int i = 0;
		for(Point p : pointsToTest) {
			Polygon.possiblePosition pos = poly.pointInsidePolygon(p);
			switch(pos) {
				case INSIDE:
					reports[i++] = String.format("Point %d is inside the polygon", i);
					break;
				case OUTSIDE:
					reports[i++] = String.format("Point %d is outside the polygon", i);
					break;
				case ON_EDGE:
					reports[i++] = String.format("Point %d is on the edge of the polygon", i);
					break;
				case CORNER:
					reports[i++] = String.format("Point %d is a corner of the polygon", i);
					break;
			}
		}
		FileHandler.writeReportToFile(reports, finalPath);
	}

}
