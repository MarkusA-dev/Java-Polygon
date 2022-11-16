import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestOctagon {
	
	/**
	 * <h1>Octagon coordinates</h1>
	 * <p>Octagon point coordinates that will be used for testing</p>
	 */
	int[] octagonPosArr = {0, 2, 0, 4, 2, 6, 4, 6, 6, 4, 6, 2, 4, 0, 2, 0};
	
	/**
	 * <h1>Polygon used for testing</h1>
	 * <p>Polygon created from the octagon coordinates</p>
	 */
	Polygon octagon = new Polygon(octagonPosArr);
	
	/**
	 * <h1>Inside octagon test</h1>
	 * <p>Test if a point is inside the octagon</p>
	 */
	@Test
	public void InsideOctTest() {
		Point inPoint = new Point(2, 1);
		assertEquals(Polygon.possiblePosition.INSIDE, octagon.pointInsidePolygon(inPoint));
	}
	
	/**
	 * <h1>Outside octagon test</h1>
	 * <p>Test if a point is outside of the octagon</p>
	 */
	@Test
	public void OutsideOctTest() {
		Point outPoint = new Point(1, 1);
		assertEquals(Polygon.possiblePosition.OUTSIDE, octagon.pointInsidePolygon(outPoint));
	}
	
	/**
	 * <h1>On border test</h1>
	 * <p>Test if a point is on the edge of the octagon</p>
	 */
	@Test
	public void BorderOctTest() {
		Point edgePoint = new Point(1, 0);
		assertEquals(Polygon.possiblePosition.ON_EDGE, octagon.pointInsidePolygon(edgePoint));
	}
	
	/**
	 * <h1>Corner test</h1>
	 * <p>Test if a point is in a corner</p>
	 */
	@Test
	public void CornerOctTest() {
		Point cornerPoint = new Point(6, 4);
		assertEquals(Polygon.possiblePosition.CORNER, octagon.pointInsidePolygon(cornerPoint));
	}
}
