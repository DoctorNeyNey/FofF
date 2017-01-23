import java.awt.Polygon;


public class Moveable {

	protected double xCoord, yCoord, width, height, dx = 0, dy = 0;
	protected Polygon poly;
	
	
	public Moveable(double xCoord, double yCoord) {

		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public void move(){
		
		xCoord += dx;
		yCoord += dy;
	}	

	public void draw(){
		
	}
}