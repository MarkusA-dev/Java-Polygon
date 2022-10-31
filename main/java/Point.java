package java;
public class Point {
	protected float x, y;
	protected Point(float xpos, float ypos) {
		x = xpos;
		y = ypos;
	}
	public float getX() {
		return this.x;
	}
	public float getY() {
		return this.y;
	}
}
