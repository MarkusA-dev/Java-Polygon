
public class Point {
	
	/**
	 * <h1>Point variables</h1>
	 * <p>Protected variables that can be accessed with the getter methods.</p>
	 */
	protected int x, y;
	
	/**
	 * <h1>Point init method</h1>
	 * @param xpos
	 * @param ypos
	 */
	protected Point(int xpos, int ypos) {
		x = xpos;
		y = ypos;
	}
	
	/**
	 * <h1>Getter method for x</h1>
	 * @return x
	 */
	public float getX() {
		return this.x;
	}
	
	/**
	 * <h1>Getter method for y</h1>
	 * @return y
	 */
	public float getY() {
		return this.y;
	}
}
