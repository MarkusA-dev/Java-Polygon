public class TestPolygonWithFile extends AbstractPolygonTest {
	
	String baseFilepath = System.getProperty("java.io.tmpdir");
	String rectFilePath = baseFilepath + "/Rectangle";
	String triFilePath = baseFilepath + "/Triangle";
	String octFilePath = baseFilepath + "/Octagon";
	
	public void getPolyShape() {
		FileHandler.writePointsToFile(getTestRect().points, rectFilePath + ".txt");
		FileHandler.writePointsToFile(getTestTri().points, triFilePath + ".txt");
		FileHandler.writePointsToFile(getTestOct().points, octFilePath + ".txt");
		
		setTestRect(FileHandler.readPolygonFromFile(rectFilePath + ".txt"));
		setTestTri(FileHandler.readPolygonFromFile(triFilePath + ".txt"));
		setTestOct(FileHandler.readPolygonFromFile(octFilePath + ".txt"));	
	}
	
	public void getPoints() {
		FileHandler.writePointsToFile(getTestPointsRect(), rectFilePath + "_points.txt");
		FileHandler.writePointsToFile(getTestPointsTri(), triFilePath + "_points.txt");
		FileHandler.writePointsToFile(getTestPointsOct(), octFilePath + "_points.txt");
		
		setTestPointsRect(FileHandler.readPointsFromFile(rectFilePath + "_points.txt"));
		setTestPointsTri(FileHandler.readPointsFromFile(triFilePath + "_points.txt"));
		setTestPointsOct(FileHandler.readPointsFromFile(octFilePath + "_points.txt"));
	}
	
	
}
