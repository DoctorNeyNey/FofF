import java.awt.Polygon;
import java.awt.geom.Rectangle2D;


public class Moveable {

	//for now we will use rectangles as rough hitboxes but will switch to polygons
	//for more exact ones once we figure out what all the models will look like.
	protected double xCoord, yCoord, width, height, dx = 0, dy = 0;
	protected Polygon poly;
	
	
	public Moveable(double xCoord, double yCoord) {

		this.xCoord = xCoord;
		this.yCoord = yCoord;
		poly = new Polygon();
	}

	public void move(){
		
		xCoord += dx;
		yCoord += dy;
	}	

	public void draw(){

	}
	

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public Polygon getPoly() {
		return poly;
	}

	public void setPoly(Polygon poly) {
		this.poly = poly;
	}
	
}