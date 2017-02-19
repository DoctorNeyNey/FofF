import org.lwjgl.opengl.GL11;

public class Immoveable {

	protected int xCoord, yCoord, width, height;
	
	
	public Immoveable(int xCoord, int yCoord, int width, int height){

		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.width = width;
		this.height = height;
	}

	public void draw(){			
		
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}	
	
	
}