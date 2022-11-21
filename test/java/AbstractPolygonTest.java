import static org.junit.Assert.assertEquals;

import org.junit.Test;


public abstract class AbstractPolygonTest {
	
	private Polygon testRect = new Polygon(new int[]{0, 0, 0, 2, 3, 2, 3, 0});
	private Point[] testPointsRect = {new Point(0, 0), new Point(-1, 4), new Point(1, 1), new Point(2, 0)};
	
	private Polygon testTri = new Polygon(new int[]{0, 0, 4, 4, 4, 0});
	private Point[] testPointsTri = {new Point(4, 4), new Point(1, 1), new Point(2, 1), new Point(2, 0)};
	
	private Polygon testOct = new Polygon(new int[]{0, 2, 0, 4, 2, 6, 4, 6, 6, 4, 6, 2, 4, 0, 2, 0});
	private Point[] testPointsOct = {new Point(6, 4), new Point(1, 1), new Point(2, 1), new Point(1, 0)};
	
	public Polygon getTestRect() {
		return testRect;
	}

	public void setTestRect(Polygon testRect) {
		this.testRect = testRect;
	}

	public Point[] getTestPointsRect() {
		return testPointsRect;
	}

	public void setTestPointsRect(Point[] testPointsRect) {
		this.testPointsRect = testPointsRect;
	}

	public Polygon getTestTri() {
		return testTri;
	}

	public void setTestTri(Polygon testTri) {
		this.testTri = testTri;
	}

	public Point[] getTestPointsTri() {
		return testPointsTri;
	}

	public void setTestPointsTri(Point[] testPointsTri) {
		this.testPointsTri = testPointsTri;
	}

	public Polygon getTestOct() {
		return testOct;
	}

	public void setTestOct(Polygon testOct) {
		this.testOct = testOct;
	}

	public Point[] getTestPointsOct() {
		return testPointsOct;
	}

	public void setTestPointsOct(Point[] testPointsOct) {
		this.testPointsOct = testPointsOct;
	}

	@Test
	public void TestRectangle() {
		assertEquals(Polygon.possiblePosition.CORNER, testRect.pointInsidePolygon(testPointsRect[0]));
		assertEquals(Polygon.possiblePosition.OUTSIDE, testRect.pointInsidePolygon(testPointsRect[1]));
		assertEquals(Polygon.possiblePosition.INSIDE, testRect.pointInsidePolygon(testPointsRect[2]));
		assertEquals(Polygon.possiblePosition.ON_EDGE, testRect.pointInsidePolygon(testPointsRect[3]));
	}
	
	@Test
	public void TestTri() {
		assertEquals(Polygon.possiblePosition.CORNER, testTri.pointInsidePolygon(testPointsTri[0]));
		assertEquals(Polygon.possiblePosition.OUTSIDE, testTri.pointInsidePolygon(testPointsTri[1]));
		assertEquals(Polygon.possiblePosition.INSIDE, testTri.pointInsidePolygon(testPointsTri[2]));
		assertEquals(Polygon.possiblePosition.ON_EDGE, testTri.pointInsidePolygon(testPointsTri[3]));
	}
	
	@Test
	public void TestOct() {
		assertEquals(Polygon.possiblePosition.CORNER, testOct.pointInsidePolygon(testPointsOct[0]));
		assertEquals(Polygon.possiblePosition.OUTSIDE, testOct.pointInsidePolygon(testPointsOct[1]));
		assertEquals(Polygon.possiblePosition.INSIDE, testOct.pointInsidePolygon(testPointsOct[2]));
		assertEquals(Polygon.possiblePosition.ON_EDGE, testOct.pointInsidePolygon(testPointsOct[3]));
	}
	
	
}
