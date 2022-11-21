public class Main {

	/**
	 * <h1>Main function for the polygon project</h1>
	 * 
	 * <p>The main function reads polygons and points and does all the testing, then writes the end file.</p>
	 */
	public static void main(String[] args) {
		//File paths to all the files, may cause problems if the system has a custom set USERPROFILE
		String polyPath = System.getenv("USERPROFILE") + "\\Desktop\\polygoni.txt";
		String pointPath = System.getenv("USERPROFILE") + "\\Desktop\\pisteet.txt";
		String finalPath = System.getenv("USERPROFILE") + "\\Desktop\\selvitys.txt";
		
		Point[] pointsToTest = FileHandler.readPointsFromFile(pointPath);
		Polygon poly = FileHandler.readPolygonFromFile(polyPath);
		String[] reports = new String[pointsToTest.length];
		int i = 0;
		
		//Loop through the points and test them, placing a string in the array that will be printed to the file
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
