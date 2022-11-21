public class Polygon {
	
	/**
	 * 
	 * <h1>Array of points</h1>
	 * 
	 * <p>Array of points that make up the polygon</p>
	 */
	
	Point[] points;
	
	
	
	/**
	 * <h1>Possible point positions</h1>
	 *
	 * <p>Enumerator with all possible positions where the point can be</p>
	 */
	enum possiblePosition {
		INSIDE,
		ON_EDGE,
		OUTSIDE,
		CORNER
	}
	
	/**
	 * <h1>Polygon init</h1>
	 * <p>Polygon initialiser, takes in an array of points that make up the new polygon</p>
	 * @param Array of points that make up the polygon
	 */
	protected Polygon(int[] pointArray) {
		points = new Point[pointArray.length/2];
		int j = 0;
		for(int i =0; i<pointArray.length-1; i+=2) {
			points[j++] = new Point(pointArray[i], pointArray[i+1]);
		}
	}
	
	/**
	 * <h1>Point on line</h1>
	 * Math translated to java from wikipedia article, while it's not the best solution, it works better than what i could do in a short time
	 * @param Point to test
	 * @param First point of the line
	 * @param Second point of the line
	 * @return if the calculated distance is 0 return true, else return false
	 */
	public boolean isOnLine(Point pt, Point l1, Point l2) {
		
		// Get distance of point from line formed by Points l1 and l2
		// absolute value of ((l2.x - l1.x)(l1.y - pt.y) - (l1.x - pt.x)(l2.y - l1.y)) 
		// divided by  the square root of((l2.x - l1.x) to the power of 2 and (l2.y -l1.y) to the power of 2)
		
		double distance = Math.abs((l2.getX()-l1.getX())*(l1.getY()-pt.getY())-(l1.getX()-pt.getX())*(l2.getY()-l1.getY())) /
				Math.sqrt((Math.pow((l2.getX() - l1.getX()), 2)) + (Math.pow((l2.getY() - l1.getY()), 2)));
		
		
		if(distance == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	/**
	 * <h1>Point position method</h1>
	 * @param Point to test
	 * @return Enum value depending on where the point is
	 * @see <a href="https://wrfranklin.org/Research/Short_Notes/pnpoly.html">Paper used in researching this</a> 
	 */
	public possiblePosition pointInsidePolygon(Point point) {
		//Number will be used for looping, while j and i will be the line to test
		int number = this.points.length;
		int j = number-1;
		boolean c = false;
		float px = point.getX();
		float py = point.getY();
		for(int i = 0; i<number;i++) {
			//Check if the point matches one of the corner points
			if(px == points[i].getX() && py == points[i].getY()) {
				return possiblePosition.CORNER;
			}
			
			//The algorithm I found in the link that is in the javaDoc
			if((points[i].getY() > py) != (points[j].getY() > py)
					&& (px <= (points[j].getX() - points[i].getX())*(py - points[i].getY()) / ( points[j].getY() - points[i].getY()) + points[i].getX())) {
				c = !c;
			}
			else if(isOnLine(point, points[i], points[j])) {
				return possiblePosition.ON_EDGE;
			}
			j = i;
		}
		if(c == true) {
			return possiblePosition.INSIDE;
		}
		else {
			return possiblePosition.OUTSIDE;
		}
		
	}
	
	

}

