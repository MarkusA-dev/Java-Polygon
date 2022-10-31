package java;
import org.junit.*;

import static org.junit.Assert.*;

import java.Polygon.possiblePosition;

public class PolygonTest {

	@Test
	public void cornerTest() {
		float[] testarr = {1.2f,1.6f,1.7f,1,9f,0.4f,0.6f};
		Polygon testpoly = new Polygon(testarr);
		Point testpoint = new Point(1.2f,1.6f);
		assertEquals(Polygon.possiblePosition.CORNER, testpoly.pointInsidePolygon(testpoint));
	}
	
	@Test
	public void outsideTest() {
		float[] testarr = {1f, 1f, 2f, 2f, 3f, 3f, 4f, 4f};
		Polygon testpoly = new Polygon(testarr);
		Point testpoint = new Point(0.1f,0.6f);
		assertEquals(Polygon.possiblePosition.OUTSIDE, testpoly.pointInsidePolygon(testpoint));
	}
	
	@Test
	public void insideTest() {
		float[] testarr = {0f, 0f, 0f, 2f, 2f, 0f, 2f, 2f};
		Polygon testpoly = new Polygon(testarr);
		Point testpoint = new Point(1f, 1f);
		assertEquals(Polygon.possiblePosition.INSIDE, testpoly.pointInsidePolygon(testpoint));
	}
	
	@Test
	public void onEdgeTest() {
		float[] testarr = {1f, 1f, 1f, 2f, 2f, 1f, 2f, 2f};
		Polygon testpoly = new Polygon(testarr);
		Point testpoint = new Point(1f, 0f);
		assertEquals(Polygon.possiblePosition.ON_EDGE, testpoly.pointInsidePolygon(testpoint));
	}
	
}
