import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class Bullet extends Moveable {

	private List<Rectangle> rects = new ArrayList<Rectangle>();
	private int damage;
		

	public Bullet(double xCoord, double yCoord, double theta, int type){	
		super(xCoord, yCoord);
		double bulletVelocity = 0;
		double variability = 0;
		switch (type){
		case 0:
			//COLT
			variability = .14*Math.random()-.07;
			bulletVelocity = 14;
			damage = 22;
			break;
		case 1:
			//BERETTA
			variability = .14*Math.random()-.07;
			bulletVelocity = 14;
			damage = 20;
			break;
		case 2:
			//GLOCK
			variability = .14*Math.random()-.07;
			bulletVelocity = 14;
			damage = 18;
			break;
		case 3:
			//BENELLI
			variability = .14*Math.random()-.07;
			bulletVelocity = 14;
			damage = 16;
			break;
		case 4:
			//MAGNUM
			variability = .08*Math.random()-.04;
			bulletVelocity = 18;
			damage = 40;
			break;
		case 5:
			//DESERT EAGLE
			variability = .7*Math.random()-.035;
			bulletVelocity = 18;
			damage = 35;
		case 6:
			//MP9
			variability = .14*Math.random()-.07;
			break;
		case 7:
			//THOMPSON
			variability = .14*Math.random()-.07;
			break;
		case 8:
			//SCORPION
			variability = .14*Math.random()-.07;
			break;
		case 9:
			//UMP45
			variability = .14*Math.random()-.07;
			break;
		case 10:
			//UZI
			variability = .14*Math.random()-.07;
			break;
		case 11:
			//VECTOR
			variability = .14*Math.random()-.07;
			break;
		case 12:
			//REMINGTON870
			break;
		case 13:
			//ARMSEL_STRIKER
			break;
		case 14:
			//USAS12
			break;
		case 15:
			//DOUBLE BARREL
			break;
		case 16:
			//SPAS12
			break;
		case 17:
			//AEK971
			break;
		case 18:
			//CAR4
			break;
		case 19:
			//AK47
			break;
		case 20:
			//M4A1
			break;
		case 21:
			//SR47
			break;
		case 22:
			//BROWNING
			break;
		case 23:
			//L86
			break;
		case 24:
			//TYPE 99
			break;
		case 25:
			//FN_MAG
			break;
		case 26:
			//ALEJANDRO
			variability = .05*Math.random()-.025;
			break;
		case 27:
			//BARRETT50
			variability = .05*Math.random()-.025;
			break;
		case 28:
			//DRAGUNOV
			variability = .05*Math.random()-.025;
			break;
		case 29:
			//SV98
			variability = .05*Math.random()-.025;
			break;
		case 30:
			//GRENADE LAUNCHER
			break;
		case 31:
			//RPG
			break;
		case 32:
			//MINIGUN
			break;
		case 33:
			//CROSSBOW
			break;
		default:
			System.out.println("Bullet constructor completed incorrectly");
			break;
		}
		double cos = Math.cos(theta+variability);
		double sin = Math.sin(theta+variability);
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
