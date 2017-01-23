import java.awt.Point;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Fabio extends Person{

	private Outfit outfit;
	private long lastTimeShot = 0;
	private Integer[] availableWeapons = {Ranged.M1911}, magazines = {Ranged.M1911_MAGAZINE_SIZE};
	private int equippedWeapon, equippedIndex = 0, rateOfFire = 0, previousEquippedIndex = -1000;
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

	public void plus(){
		equippedIndex++;
	}
	
	public void equipWeapon(){

		equippedWeapon = availableWeapons[equippedIndex];
		if (previousEquippedIndex != equippedIndex)
			switch(equippedWeapon){
			case Ranged.M1911:
				rateOfFire = Ranged.M1911_RATE_OF_FIRE;
				break;
			case Ranged.M9:
				rateOfFire = Ranged.M9_RATE_OF_FIRE;
				break;
			case Ranged.GLOCK18:
				rateOfFire = Ranged.GLOCK18_RATE_OF_FIRE;
				break;
			case Ranged.BENELLI:
				rateOfFire = Ranged.BENELLI_RATE_OF_FIRE;
				break;
			case Ranged.MAGNUM:
				rateOfFire = Ranged.MAGNUM_RATE_OF_FIRE;
				break;
			case Ranged.DEAGLE:
				rateOfFire = Ranged.DEAGLE_RATE_OF_FIRE;
				break;
			case Ranged.MP9:
				rateOfFire = Ranged.MP9_RATE_OF_FIRE;
				break;
			case Ranged.THOMPSON:
				rateOfFire = Ranged.THOMPSON_RATE_OF_FIRE;
				break;
			case Ranged.SCORPION:
				rateOfFire = Ranged.SCORPION_RATE_OF_FIRE;
				break;
			case Ranged.UMP45:
				rateOfFire = Ranged.UMP45_RATE_OF_FIRE;
				break;
			case Ranged.UZI:
				rateOfFire = Ranged.UZI_RATE_OF_FIRE;
				break;
			case Ranged.VECTOR:
				rateOfFire = Ranged.VECTOR_RATE_OF_FIRE;
				break;
			case Ranged.REMINGTON870:
				rateOfFire = Ranged.REMINGTON870_RATE_OF_FIRE;
				break;
			case Ranged.ARMSEL_STRIKER:
				rateOfFire = Ranged.ARMSEL_STRIKER_RATE_OF_FIRE;
				break;
			case Ranged.USAS12:
				rateOfFire = Ranged.USAS12_RATE_OF_FIRE;
				break;
			case Ranged.DOUBLE_BARREL:
				rateOfFire = Ranged.DOUBLE_BARREL_RATE_OF_FIRE;
				break;
			case Ranged.SPAS12:
				rateOfFire = Ranged.SPAS12_RATE_OF_FIRE;
				break;
			case Ranged.AEK971:
				rateOfFire = Ranged.AEK971_RATE_OF_FIRE;
				break;
			case Ranged.AR15:
				rateOfFire = Ranged.AR15_RATE_OF_FIRE;
				break;
			case Ranged.AK47:
				rateOfFire = Ranged.AK47_RATE_OF_FIRE;
				break;
			case Ranged.M4A1:
				rateOfFire = Ranged.M4A1_RATE_OF_FIRE;
				break;
			case Ranged.SR47:
				rateOfFire = Ranged.SR47_RATE_OF_FIRE;
				break;
			case Ranged.BROWNING:
				rateOfFire = Ranged.BROWNING_RATE_OF_FIRE;
				break;
			case Ranged.L86:
				rateOfFire = Ranged.L86_RATE_OF_FIRE;
				break;
			case Ranged.TYPE99:
				rateOfFire = Ranged.TYPE99_RATE_OF_FIRE;
				break;
			case Ranged.FN_MAG:
				rateOfFire = Ranged.FN_MAG_RATE_OF_FIRE;
				break;
			case Ranged.ALEJANDRO:
				rateOfFire = Ranged.ALEJANDRO_RATE_OF_FIRE;
				break;
			case Ranged.BARRETT50:
				rateOfFire = Ranged.BARRETT50_RATE_OF_FIRE;
				break;
			case Ranged.DRAGUNOV:
				rateOfFire = Ranged.DRAGUNOV_RATE_OF_FIRE;
				break;
			case Ranged.SV98:
				rateOfFire = Ranged.SV98_RATE_OF_FIRE;
				break;
			case Ranged.GRENADE_LAUNCHER:
				rateOfFire = Ranged.GRENADE_LAUNCHER_RATE_OF_FIRE;
				break;
			case Ranged.RPG:
				rateOfFire = Ranged.RPG_RATE_OF_FIRE;
				break;
			case Ranged.MINIGUN:
				rateOfFire = Ranged.MINIGUN_RATE_OF_FIRE;
				break;
			case Ranged.CROSSBOW:
				rateOfFire = Ranged.CROSSBOW_RATE_OF_FIRE;
				break;
			default:
				System.out.println("There was an error in equipping the correct weapon");
				break;
			}
		previousEquippedIndex = equippedIndex;
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
			dx *= 1.4;

		if (dy != 0)
			dy *= 1.4;
	}

	public Bullet shoot(Point p){

		//add recoil and gun specific things: clip size, rate of fire, etc....
		//i think we should use a case and switch with ints to specify what gun the player has
		/**		will shoot once every 250 miliseconds while the mouse is pressed
		 *		should be changed to be specific to each type of gun   		     **/
		if (System.currentTimeMillis()-lastTimeShot > rateOfFire){
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
