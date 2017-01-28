import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Moveable {

	//for now we will use rectangles as rough hitboxes but will switch to polygons
	//for more exact ones once we figure out what all the models will look like.
	protected double xCoord, yCoord, width, height, dx = 0, dy = 0;
	protected Polygon poly;
	protected Rectangle2D rect;
	
	
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
	
	public Rectangle2D getRect(){
		return rect;
	}
}