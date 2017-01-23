import org.lwjgl.opengl.GL11;

public class Bullet extends Moveable {

	private int damage;
	public static final int COLT_M1911 = 0;
	public static final int BERETTA_M9 = 1;
	public static final int GLOCK_18 = 2;
	public static final int ASTRA_300 = 3;
	public static final int MAGNUM = 4;
	public static final int DESERT_EAGLE = 5;
//	public static final int 

	public Bullet(double xCoord, double yCoord, double theta, int type){
		
		super(xCoord, yCoord);
		double cos = Math.cos(theta);
		double sin = Math.sin(theta);
		double bulletVelocity = 0;
		switch (type){
		case 0:
			//COLT
			bulletVelocity = 14;
			damage = 22;
			break;
		case 1:
			//BERETTA
			bulletVelocity = 14;
			damage = 20;
			break;
		case 2:
			//GLOCK
			bulletVelocity = 14;
			damage = 18;
			break;
		case 3:
			//ASTRA
			bulletVelocity = 14;
			damage = 16;
			break;
		case 4:
			//MAGNUM
			bulletVelocity = 18;
			damage = 40;
			break;
		case 5:
			//DESERT EAGLE
			bulletVelocity = 18;
			damage = 35;
		default:
			System.out.println("Bullet constructor completed incorrectly");
		}
		dx = cos*bulletVelocity;
		dy = sin*bulletVelocity;
		//Temporary assignment, to be replaced with images
		width = 3;
		height = 3;
	}

	public void draw(){
		
		
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2d(xCoord+width, yCoord+height);
		GL11.glVertex2d(xCoord+width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord+height);
		
		GL11.glEnd();

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
