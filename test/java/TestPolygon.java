import org.junit.*;
import static org.junit.Assert.*;



public class TestPolygon {
	
	
	/**
	 *  <p>Test array that has the coordinates for best simple polygon to use for testing</p>
	 */
	int[] testArr = {0, 0, 2, 0, 2, 2, 0, 2};
	
	/**
	 * <h1>Test Polygon</h1>
	 * <p>Polygon used for testing, created from the test array</p>
	 */
	Polygon testPoly = new Polygon(testArr);
	

	/**
	 * <h1>Test point being a corner of the polygon</h1>
	 */
	@Test
	public void cornerTest() {
		
		Point testpoint = new Point(2,0);
		assertEquals(Polygon.possiblePosition.CORNER, testPoly.pointInsidePolygon(testpoint));
	}
	
	/**
	 * <h1>Test point outside of the polygon</h1>
	 */
	@Test
	public void outsideTest() {
		Point testpoint = new Point(-1,4);
		assertEquals(Polygon.possiblePosition.OUTSIDE, testPoly.pointInsidePolygon(testpoint));
	}
	
	
	/**
	 * <h1>Test point inside the polygon</h1>
	 */
	@Test
	public void insideTest() {
		Point testpoint = new Point(1, 1);
		assertEquals(Polygon.possiblePosition.INSIDE, testPoly.pointInsidePolygon(testpoint));
	}
	
	/**
	 * <h1>Test point on an edge of the polygon</h1>
	 */
	@Test
	public void onEdgeTest() {
		Point testpoint = new Point(1, 0);
		assertEquals(Polygon.possiblePosition.ON_EDGE, testPoly.pointInsidePolygon(testpoint));
	}
	
}
