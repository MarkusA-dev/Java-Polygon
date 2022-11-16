import org.junit.*;
import static org.junit.Assert.*;

public class TestTriangle {
	
	/**
	 * <h1>Triangle coordinates</h1>
	 * <p>Triangle point coordinates that will be used for testing</p>
	 */
	int[] trianglePosArr = {0, 0, 4, 4, 4, 0};
	
	/**
	 * <h1>Polygon used for testing</h1>
	 * <p>Polygon created from the triangle coordinates</p>
	 */
	Polygon triangle = new Polygon(trianglePosArr);
	
	/**
	 * <h1>Inside triangle test</h1>
	 * <p>Test if a point is inside the triangle</p>
	 */
	@Test
	public void InsideTriTest() {
		Point inPoint = new Point(2, 1);
		assertEquals(Polygon.possiblePosition.INSIDE, triangle.pointInsidePolygon(inPoint));
	}
	
	/**
	 * <h1>Outside triangle test</h1>
	 * <p>Test if a point is outside of the triangle</p>
	 */
	@Test
	public void OutsideTriTest() {
		Point outPoint = new Point(1, 1);
		assertEquals(Polygon.possiblePosition.OUTSIDE, triangle.pointInsidePolygon(outPoint));
	}
	
	/**
	 * <h1>On border test</h1>
	 * <p>Test if a point is on the edge of the triangle</p>
	 */
	@Test
	public void BorderTriTest() {
		Point edgePoint = new Point(2, 0);
		assertEquals(Polygon.possiblePosition.ON_EDGE, triangle.pointInsidePolygon(edgePoint));
	}
	
	/**
	 * <h1>Corner test</h1>
	 * <p>Test if a point is in a corner</p>
	 */
	@Test
	public void CornerTriTest() {
		Point cornerPoint = new Point(4, 4);
		assertEquals(Polygon.possiblePosition.CORNER, triangle.pointInsidePolygon(cornerPoint));
	}
	
}
