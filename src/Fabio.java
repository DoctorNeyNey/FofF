import java.awt.Point;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Fabio extends Person{

	private int magazine = 0;

	public Fabio(int xCoord, int yCoord, int health) {
		super(xCoord, yCoord, health);
		width = 10;
		height = 10;
	}

	public void move(){

		xCoord += dx;
		yCoord += dy;
	}

	public void draw(){



		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(xCoord+width, yCoord+height);
		GL11.glVertex2d(xCoord+width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord+height);

		GL11.glEnd();		
	}

	public void interact(){

	}

	public void openInventory(){

	}

	public void up(){

		dy = 5;
	}

	public void down(){

		dy = -5;
	}

	public void stopVertical(){

		dy = 0;
	}

	public void left(){

		dx = -5;
	}

	public void right(){

		dx = 5;
	}

	public void stopHorizontal(){

		dx = 0;
	}

	public void reload(){


	}

	public void run(){

		if (dx != 0)
			dx*=2;

		if (dy != 0)
			dy*=2;
	}

	public Bullet shoot(Point p){

		//add recoil and gun specific things: clip size, rate of fire, etc....
		//i think we should use a case and switch with ints to specify what gun the player has
		/** as of now all it does is shoot where the mouse is pointed**/

		double x = p.getX()-xCoord;
		double y = p.getY()-yCoord;
		double theta = Math.atan(y/x);

		if (p.getX()-xCoord < 0)
			theta += Math.PI;

		return new Bullet(xCoord, yCoord, theta, Bullet.PISTOL_ROUND);
	}

	public void aoePickUp(){

	}

	public void equip1(){

	}

	public void equip2(){

	}

	public void equip3(){

	}

	public void equip4(){

	}
}
