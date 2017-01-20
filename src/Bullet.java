import org.lwjgl.opengl.GL11;

public class Bullet extends Moveable {

	private int damage;
	public static int PISTOL_ROUND = 0;

	public Bullet(int xCoord, int yCoord, double theta, int type){
		
		super(xCoord, yCoord);
		double cos = Math.cos(theta);
		double sin = Math.sin(theta);
		double bulletVelocity = 0;
		switch (type){
		case 0:
			bulletVelocity = 8;
			damage = 25;
			break;
		default:
			System.out.println("Bullet constructor completed incorrectly");
		}
		dx = cos*bulletVelocity;
		dy = sin*bulletVelocity;
	}

	public void draw(){
		
		
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2d(xCoord+width, yCoord+height);
		GL11.glVertex2d(xCoord+width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord+height);
		
		GL11.glEnd();

	}

	public void move(){

	}

	public void collision(Moveable m){

	}

	public boolean isInView(){

		return true;
	}

	public int getDamage(){

		return damage;
	}
}
