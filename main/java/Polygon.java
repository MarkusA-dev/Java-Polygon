package java;
import java.util.ArrayList;

public class Polygon {
	
	ArrayList<Point> points = new ArrayList<Point>();
	
	enum possiblePosition {
		INSIDE,
		ON_EDGE,
		OUTSIDE,
		CORNER
	}
	
	/**
	 * @param Array of points that make up the polygon
	 */
	protected Polygon(float[] pointArray) {
		
		for(int i =0; i<pointArray.length-1; i+=2) {
			Point add = new Point(pointArray[i], pointArray[i+1]);
			
			points.add(add);
		}
	}
	
	/**
	 * Math translated to java from wikipedia article, while it's not the best solution, it works better than what i could do in a short time
	 * @param Point to test
	 * @param First point of the line
	 * @param Second point of the line
	 * @return if the calculated distance is 0 return true, else return false
	 */
	public boolean isOnLine(Point pt, Point l1, Point l2) {
		
		//Get distance of point from line formed by Points l1 and l2
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
	 * @param Point to test
	 * @return Enum value depending on where the point is
	 * @see <a href="https://wrfranklin.org/Research/Short_Notes/pnpoly.html">Paper used in researching this</a> 
	 */
	public possiblePosition pointInsidePolygon(Point point) {
		int number = this.points.size();
		int j = number-1;
		boolean c = false;
		float px = point.getX();
		float py = point.getY();
		for(int i = 0; i<number;i++) {
			if(px == points.get(i).getX() && py == points.get(i).getY()) {
				return possiblePosition.CORNER;
			}
			
			if((points.get(i).getY() > py) != (points.get(j).getY() > py)
					&& (px <= (points.get(j).getX() - points.get(i).getX())*(py - points.get(i).getY()) / ( points.get(j).getY() - points.get(i).getY()) + points.get(i).getX())) {
				c = !c;
			}
			else if(isOnLine(point, points.get(i), points.get(j))) {
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

