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
			damage = 20;
			break;
		case 4:
			//MAGNUM
			variability = .08*Math.random()-.04;
			bulletVelocity = 22;
			damage = 40;
			break;
		case 5:
			//DESERT EAGLE
			variability = .7*Math.random()-.035;
			bulletVelocity = 22;
			damage = 35;
		case 6:
			//MP9
			variability = .14*Math.random()-.07;
			bulletVelocity = 22;
			break;
		case 7:
			//THOMPSON
			variability = .14*Math.random()-.07;
			bulletVelocity = 16;
			break;
		case 8:
			//SCORPION
			variability = .14*Math.random()-.07;
			bulletVelocity = 16;
			break;
		case 9:
			//UMP45
			variability = .14*Math.random()-.07;
			bulletVelocity = 16;
			break;
		case 10:
			//UZI
			variability = .14*Math.random()-.07;
			bulletVelocity = 16;
			break;
		case 11:
			//VECTOR
			variability = .14*Math.random()-.07;
			bulletVelocity = 16;
			break;
		case 12:
			//REMINGTON870
			break;
		case 13:
			//ARMSEL_STRIKER
			variability = .5*Math.random()-.25;
			bulletVelocity = 14+2*Math.random();
			break;
		case 14:
			//USAS12
			variability = .5*Math.random()-.25;
			bulletVelocity = 14+2*Math.random();
			break;
		case 15:
			//DOUBLE BARREL
			variability = .35*Math.random()-.175;
			bulletVelocity = 16+2*Math.random();
			break;
		case 16:
			//SPAS12
			variability = .4*Math.random()-.2;
			bulletVelocity = 16+2*Math.random();
			break;
		case 17:
			//AEK971
			bulletVelocity = 18;
			break;
		case 18:
			//CAR4
			bulletVelocity = 18;
			break;
		case 19:
			//AK47
			bulletVelocity = 18;
			break;
		case 20:
			//M4A1
			bulletVelocity = 18;
			break;
		case 21:
			//SR47
			bulletVelocity = 18;
			break;
		case 22:
			//BROWNING
			bulletVelocity = 16;
			break;
		case 23:
			//L86
			bulletVelocity = 16;
			break;
		case 24:
			//TYPE 99
			bulletVelocity = 16;
			break;
		case 25:
			//FN_MAG
			bulletVelocity = 16;
			break;
		case 26:
			//ALEJANDRO
			variability = .025*Math.random()-.0125;
			bulletVelocity = 28;
			break;
		case 27:
			//BARRETT50
			variability = .025*Math.random()-.0125;
			bulletVelocity = 28;
			break;
		case 28:
			//DRAGUNOV
			variability = .025*Math.random()-.0125;
			bulletVelocity = 28;
			break;
		case 29:
			//SV98
			variability = .025*Math.random()-.0125;
			bulletVelocity = 28;
			break;
		case 30:
			//GRENADE LAUNCHER
			variability = 0;
			break;
		case 31:
			//RPG
			variability = 0;
			break;
		case 32:
			//MINIGUN
			variability = .25*Math.random()-.125;
			bulletVelocity = 16;
			break;
		case 33:
			//CROSSBOW
			variability = 0;

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

		GL11.glColor3d(0.9960784314, 0.8862745098, 0.2431372549);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(xCoord+width, yCoord+height);
		GL11.glVertex2d(xCoord+width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord-height);
		GL11.glVertex2d(xCoord-width, yCoord+height);

		GL11.glEnd();
	}

	//	public boolean collision(Moveable m){
	//
	//		for (Rectangle r : rects)
	//			if (r.intersects(m.getRect()))
	//				return true;
	//		return false;
	//		
	//	}

	public boolean collision(Fabio f){		

		int initialHealth = f.getHealth();
		if (f != null)
			for (Rectangle rect : rects)
				if (rect.intersects(f.getRect())){
					f.dealDamage(damage);
				}
		if (f.health != initialHealth)
			return true;
		
		return false;
	}

	public boolean collision(Immoveable i){

		return false;
	}	

	public boolean collision(Person npc){

		return false;
	}

	public List<Rectangle> getRects(){

		return rects;
	}

	public int getDamage(){

		return damage;
	}
}
