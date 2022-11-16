import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRectangle {
	
	/**
	 * <h1>Rectangle coordinates</h1>
	 * <p>Rectangle point coordinates that will be used for testing</p>
	 */
	int[] rectanglePosArr = {0, 0, 0, 2, 3, 2, 3, 0};
	
	/**
	 * <h1>Polygon used for testing</h1>
	 * <p>Polygon created from the rectangle coordinates</p>
	 */
	Polygon rectangle = new Polygon(rectanglePosArr);
	
	/**
	 * <h1>Inside rectangle test</h1>
	 * <p>Test if a point is inside the rectangle</p>
	 */
	@Test
	public void InsideRectTest() {
		Point inPoint = new Point(1, 1);
		assertEquals(Polygon.possiblePosition.INSIDE, rectangle.pointInsidePolygon(inPoint));
	}
	
	/**
	 * <h1>Outside rectangle test</h1>
	 * <p>Test if a point is outside of the rectangle</p>
	 */
	@Test
	public void OutsideRectTest() {
		Point outPoint = new Point(-1, 4);
		assertEquals(Polygon.possiblePosition.OUTSIDE, rectangle.pointInsidePolygon(outPoint));
	}
	
	/**
	 * <h1>On border test</h1>
	 * <p>Test if a point is on the edge of the rectangle</p>
	 */
	@Test
	public void BorderRectTest() {
		Point edgePoint = new Point(2, 0);
		assertEquals(Polygon.possiblePosition.ON_EDGE, rectangle.pointInsidePolygon(edgePoint));
	}
	
	/**
	 * <h1>Corner test</h1>
	 * <p>Test if a point is in a corner</p>
	 */
	@Test
	public void CornerRectTest() {
		Point cornerPoint = new Point(0, 0);
		assertEquals(Polygon.possiblePosition.CORNER, rectangle.pointInsidePolygon(cornerPoint));
	}
}
