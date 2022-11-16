import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TestFilehandler {
	
	/**
	 * <h1>Test both file reading methods</h1>
	 * <p>reads both files and makes a point arraylist from one and a polygon from the other.</p>
	 * <p>Then test that both have the expected number of points. <br>Could be improved with a dynamic counter for the expected points</p>
	 */
	@Test
	public void fileReadTest(){
		//Paths to the file to read, will not work if USERPROFILE is changed from default
		String filepath = System.getenv("USERPROFILE") + "\\Desktop\\pisteet.txt";
		String filepath2 = System.getenv("USERPROFILE") + "\\Desktop\\polygoni.txt";
		ArrayList<Point> pointArr = FileHandler.readPointsFromFile(filepath);
		Polygon poly  = FileHandler.readPolygonFromFile(filepath2);
		assertEquals(4, poly.points.size());
		assertEquals(3, pointArr.size());
	}
	
	/**
	 * <h1>Test file writing method</h1>
	 * <p>Writes a file with a test array, then tests that the file has been written into and that the value is the expected value</p>
	 */
	@Test
	public void fileWriteTest(){
		//Path to write the file to, will not work if USERPROFILE is changed from default
		String filepath = System.getenv("USERPROFILE") + "\\Desktop\\filetest.txt";
		String[] arr = {"test", "test"};
		File readfile = new File(filepath);
		FileHandler.writeReportToFile(arr, filepath);
		Scanner read;
		try {
			read = new Scanner(readfile);
		} catch ( Exception e) {
			throw new RuntimeException("Reading the file failed");
		}
		assertNotEquals(false, read.hasNext());
		assertEquals("test", read.nextLine());
		read.close();
	}
	
	
}
