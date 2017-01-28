import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Timer;

public class Fabio extends Person{

	private static int baseHealth = 100;
	private Timer timer;
	private Outfit outfit;
	private long lastTimeShot = 0;
	private Integer[] availableWeapons = {20};
	//private Integer[][] magazines = new Integer[33][30];
	private List<List<Integer>> magazines = new ArrayList<List<Integer>>();
	private int equippedWeapon, equippedIndex = 0, rateOfFire = 0,
			previousEquippedIndex = -1000, currentHealth = baseHealth;


	public Fabio(double xCoord, double yCoord) {
		super(xCoord, yCoord, baseHealth);
		outfit = new Outfit(null, null, null, null);
		width = 20;
		height = 20;
		createMagazines();
	}

	private void drawHUD(){

		//current health
		GL11.glColor3d(0.81764705882, 0.08019607843, 0.2431372549);
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2d(95, 94);
		GL11.glVertex2d(95, 56);
		GL11.glVertex2d(105+currentHealth*2, 56);
		GL11.glVertex2d(105+currentHealth*2, 94);
		
		GL11.glEnd();
		
		//outline of health
		GL11.glColor3d(.85, .3, .2);
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2d(100, 90);
		GL11.glVertex2d(100, 60);
		GL11.glVertex2d(100+baseHealth*2, 60);
		GL11.glVertex2d(100+baseHealth*2, 90);
		
		GL11.glEnd();
	}

	public void move(){

		xCoord += dx;
		yCoord += dy;
	}

	public void createMagazines(){

		//		i think the list approach would be better tbh
		//		list approach to the problem described below

		for (int x = 0; x < 33; x++){
			List<Integer> temp = new ArrayList<Integer>();
			for (int y = 0; y < Ranged.magSizes[x]; y++)
				temp.add(1);
			magazines.add(temp);
		}
		//alternatively we can use arrays where each array is the length of each guns 
		//magazine, we can then throw in some number to indicate whether each slot is filled 
		//with a bullet or use lists and take out one bullet everytime they shoot and not let
		//each list grow larger than each guns magazine
		//			for (int x = 0; x < Ranged.magSizes.length; x++)
		//				magazines[x] = new Integer[Ranged.magSizes[x]];
		//	
		//
		//			for(int x = 0; x < magazines.length; x++)
		//				for(int y = 0; y < magazines[x].length; y++)
		//					magazines[x][y] = 1;
	}

	public void draw(){

		outfit.draw(xCoord, yCoord);
		drawHUD();
		rect = new Rectangle2D.Double(xCoord-width/2, yCoord+height/2, width, height);

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

		//only swaps the rate of fire which a player has, later should swap the 
		//movement speed of a player as well, we should add that later when we determine
		//the size of the map

		equippedWeapon = availableWeapons[equippedIndex];
		if (previousEquippedIndex != equippedIndex)
			switch (equippedWeapon){
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

		switch (equippedWeapon){
		case Ranged.M1911:
			break;
		case Ranged.M9:
			break;
		case Ranged.GLOCK18:
			break;
		case Ranged.BENELLI:
			break;
		case Ranged.MAGNUM:
			break;
		case Ranged.DEAGLE:
			break;
		case Ranged.MP9:
			break;
		case Ranged.THOMPSON:
			break;
		case Ranged.SCORPION:
			break;
		case Ranged.UMP45:
			break;
		case Ranged.UZI:
			break;
		case Ranged.VECTOR:
			break;
		case Ranged.REMINGTON870:
			break;
		case Ranged.ARMSEL_STRIKER:
			break;
		case Ranged.USAS12:
			break;
		case Ranged.DOUBLE_BARREL:
			break;
		case Ranged.SPAS12:
			break;
		case Ranged.AEK971:
			break;
		case Ranged.AR15:
			break;
		case Ranged.AK47:
			break;
		case Ranged.M4A1:
			break;
		case Ranged.SR47:
			break;
		case Ranged.BROWNING:
			break;
		case Ranged.L86:
			break;
		case Ranged.TYPE99:
			break;
		case Ranged.FN_MAG:
			break;
		case Ranged.ALEJANDRO:
			break;
		case Ranged.BARRETT50:
			break;
		case Ranged.DRAGUNOV:
			break;
		case Ranged.SV98:
			break;
		case Ranged.GRENADE_LAUNCHER:
			break;
		case Ranged.RPG:
			break;
		case Ranged.MINIGUN:
			break;
		case Ranged.CROSSBOW:
			break;
		default:
			System.out.println("There was an error in equipping the correct weapon");
			break;
		}

	}

	public void run(){

		dx *= 1.4;
		dy *= 1.4;
	}

	public List<Bullet> shoot(Point p){

		//add recoil and gun specific things: clip size, movespeed with gun, etc....
		List<Bullet> list = new ArrayList<Bullet>();

		if (System.currentTimeMillis()-lastTimeShot > rateOfFire){			
			lastTimeShot = System.currentTimeMillis();
			double x = p.getX()-xCoord;
			double y = p.getY()-yCoord;
			double theta = Math.atan(y/x);
			//because of arccos's range we need to add pi if they are shooting to their left
			if (p.getX()-xCoord < 0)
				theta += Math.PI;

			switch (equippedWeapon){
			//shotguns need to shoot multiple bullets so i looped it to add seveal bullets
			//also need to add the explosives for rpg and nade launcher, as well as arrows for
			//crossbow, other than that all other guns will just run through the default
			//that adds a bullet normally
			case 12:
				for (int i = 0; i < 8; i++)
					list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				return list;
			case 13:
				for (int i = 0; i < 6; i++)
					list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				return list;
			case 14:
				for (int i = 0; i < 5; i++)
					list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				return list;
			case 15:
				for (int i = 0; i < 9; i++)
					list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				return list;
			case 16:
				for (int i = 0; i < 7; i++)
					list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				return list;
			case 30:
				System.out.println("need to add something for the grenade launcher");
				break;
			case 31:
				System.out.println("need to add something for the RPG");
				break;
				//default used for all other weapons
			default :
				list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				return list;
			}
		}
		return null;
	}

	@Override
	public void dealDamage(int d){
		
		currentHealth -= d;
	}
	
	public void aoePickUp(){


	}

}
