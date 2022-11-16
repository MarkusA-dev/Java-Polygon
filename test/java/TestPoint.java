import org.junit.*;
import static org.junit.Assert.*;


public class TestPoint {
	/**
	 * <h1>Point to test</h1>
	 */
	Point p = new Point(2, 1);
	
	/**
	 * <h1>Test of point.getY()</h1>
	 */
	@Test
	public void TestY() {
		assertEquals(1, p.getY(), 0);
	}
	
	/**
	 * <h1>Test of point.getX()</h1>
	 */
	@Test
	public void TestX() {
		assertEquals(2, p.getX(), 0);
	}
}
