import java.awt.Point;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Fabio extends Person{

	private Outfit outfit;
	private long lastTimeShot = 0;
	private Integer[] availableWeapons = {-1, 0};
	private int equippedWeapon = 0, equippedIndex;
	public Fabio(double xCoord, double yCoord, int health) {
		super(xCoord, yCoord, health);
		outfit = new Outfit(null, null, null, null);
		width = 20;
		height = 20;
	}

	public void move(){

		xCoord += dx;
		yCoord += dy;
	}

	public void draw(){

		outfit.draw(xCoord, yCoord);

		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(xCoord+width/2, yCoord+height/2);
		GL11.glVertex2d(xCoord+width/2, yCoord-height/2);
		GL11.glVertex2d(xCoord-width/2, yCoord-height/2);
		GL11.glVertex2d(xCoord-width/2, yCoord+height/2);

		GL11.glEnd();		
	}

	public void equipWeapon(){
		
		equippedWeapon = availableWeapons[equippedIndex];
		
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
		/**		will shoot once every 250 miliseconds while the mouse is pressed
		 *		should be changed to be specific to each type of gun   		     **/
		if (System.currentTimeMillis()-lastTimeShot > 100){
			double x = p.getX()-xCoord;
			double y = p.getY()-yCoord;
			double theta = Math.atan(y/x);
			/**as the player shoots for longer there should be more spread in their shot
			//should differ with each individual gun**/			
			if (p.getX()-xCoord < 0)
				theta += Math.PI;
			lastTimeShot = System.currentTimeMillis();
			return new Bullet(xCoord, yCoord, theta, equippedWeapon);
		}
		return null;
	}

	public void aoePickUp(){


	}
}
