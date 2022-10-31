package java;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TestFilehandler {
	
	@Test
	public void fileReadTest() throws IOException, FileNotFoundException {
		String filepath = System.getenv("USERPROFILE") + "\\Desktop\\points.txt";
		String filepath2 = System.getenv("USERPROFILE") + "\\Desktop\\points.txt";
		ArrayList<Point> pointArr = FileHandler.readPointsFromFile(filepath);
		Polygon poly  = FileHandler.readPolygonFromFile(filepath2);
		assertEquals(3, poly.points.size());
		assertEquals(3, pointArr.size());
	}
	
	@Test
	public void fileWriteTest() throws IOException {
		String filepath = System.getenv("USERPROFILE") + "\\Desktop\\Point_repots.txt";
		String[] arr = {"test", "test"};
		File readfile = new File(filepath);
		FileHandler.writeReportToFile(arr, filepath);
		Scanner read = new Scanner(readfile);
		assertNotEquals(false, read.hasNext());
		assertEquals("test", read.nextLine());
		read.close();
	}
	
	
}
