import java.awt.Polygon;
import java.awt.geom.Area;


public class Moveable {

	protected int xCoord, yCoord, width, height;
	protected double dx = 0, dy = 0;
	protected Polygon poly;
	
	
	public Moveable(int xCoord, int yCoord) {

		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public void move(){

	}	

	public void draw(){
		
	}
}