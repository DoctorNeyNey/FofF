import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;

import org.lwjgl.opengl.GL11;

public class Barrier extends Immoveable{
	
	private Area area;
	private int verticalStack, horizontalStack;
	private Polygon poly = new Polygon();
	
	
	public Barrier(int xCoord, int yCoord, int width, int height, int verticalStack, int horizontalStack) {
		super(xCoord, yCoord, width, height);
		this.verticalStack = verticalStack;
		this.horizontalStack = horizontalStack;
	}

	
	public void draw(){
		
		int[] xCoords = {
				
				xCoord,
				xCoord,
				xCoord+width,
				xCoord+width,
				xCoord+width*(horizontalStack+1),
				xCoord+width*(horizontalStack+1)
		};
		
		int[] yCoords = {
				
				yCoord,
				yCoord+height*(verticalStack+1),
				yCoord+height*(verticalStack+1),
				yCoord+height,
				yCoord+height,
				yCoord
		};
		
		poly.npoints = xCoords.length;
		poly.xpoints = xCoords;
		poly.ypoints = yCoords;
		
		GL11.glBegin(GL11.GL_POLYGON);
		
		for(int x = 0; x < poly.npoints; x++)
			GL11.glVertex2i(poly .xpoints[x], poly.ypoints[x]);
		
		GL11.glEnd();
	}
	
	public boolean collision(Area a){

		area = new Area(poly);
		area.intersect(a);
		return !area.isEmpty();
	}

	public int getVerticalStack() {
		return verticalStack;
	}

	public int getHorizontalStack() {
		return horizontalStack;
	}

	
}