import java.awt.Font;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.ResourceLoader;


public class Fabio extends Person{

	private Texture texture;
	private TrueTypeFont ammoFont;
	private static int baseHealth = 100;
	private Outfit outfit;
	private long lastTimeShot = 0, beganReloading = 0;
	private Integer[] availableWeapons = {0,1,2,3,4,5,6,7,8,9};
	private List<List<Integer>> magazines = new ArrayList<List<Integer>>();
	private List<List<Integer>> ammoStores = new ArrayList<List<Integer>>();
	private int equippedWeapon, equippedIndex = 0, rateOfFire = 0,
			previousEquippedIndex = -1000, currentHealth = 100;
	private boolean reloading = false;


	public Fabio(double xCoord, double yCoord) {
		super(xCoord, yCoord, baseHealth);
		outfit = new Outfit(null, null, null, null);
		width = 20;
		height = 20;
		createMagazinesAndAmmoStores();
		createFonts();
	}

	private void createFonts(){

		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("Kirbys-Adventure.ttf");	
			Font ammoFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			this.ammoFont = new TrueTypeFont(ammoFont.deriveFont(24f), false);
			//			this.ammoFont = new TrueTypeFont(new Font("Times New Roman", Font.TYPE1_FONT, 36), false);
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("2");
		}

	}

	public void drawAmmoCount(){

		Integer currentAmmo = magazines.get(equippedWeapon).size();
		Integer totalAmmo = ammoStores.get(equippedWeapon).size();
		String phrase = currentAmmo.toString() + "-" + totalAmmo.toString();

		GL11.glRotated(180, 0, 0, 0);
		GL11.glRotated(180, 0, Display.getHeight()/2, 0);
		GL11.glEnable(GL11.GL_BLEND);

		//need to use the negative in the 
		ammoFont.drawString(0, -900, phrase, Color.white);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glRotated(180, 0, 0, 0);
		GL11.glRotated(180, 0, -Display.getHeight()/2, 0);
	}

	public void drawHealthBar(){

		//HEALTH BAR
		//outline
		GL11.glColor3d(.381019078, .381019078, .381019078);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(95, 94);
		GL11.glVertex2d(95, 56);
		GL11.glVertex2d(105+baseHealth*2, 56);
		GL11.glVertex2d(105+baseHealth*2, 94);

		GL11.glEnd();

		//missingHealth
		GL11.glColor3d(.731372549, .1568627451, .1882352941);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(100+baseHealth*2, 90);
		GL11.glVertex2d(100+baseHealth*2, 60);
		GL11.glVertex2d(100+baseHealth*2-(baseHealth*2-currentHealth*2), 60);
		GL11.glVertex2d(100+baseHealth*2-(baseHealth*2-currentHealth*2), 90);

		GL11.glEnd();

		//current of health
		GL11.glColor3d(0, 1, 0);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(100, 90);
		GL11.glVertex2d(100, 60);
		GL11.glVertex2d(100+currentHealth*2, 60);
		GL11.glVertex2d(100+currentHealth*2, 90);

		GL11.glEnd();
		//END OF HEALTH BAR
	}

	public void drawReloadBar(){

		double reloadSpeed = Ranged.reloadSpeeds[equippedWeapon];
		double percent = ((double)(System.currentTimeMillis()-beganReloading))/reloadSpeed;
		double displacement = 40*percent;				
		if (reloading){

			//Outline
			GL11.glColor3d(.381019078, .381019078, .381019078);
			GL11.glBegin(GL11.GL_QUADS);

			GL11.glVertex2d(xCoord - 23, yCoord + 27);
			GL11.glVertex2d(xCoord + 23, yCoord + 27);
			GL11.glVertex2d(xCoord + 23, yCoord + 13);
			GL11.glVertex2d(xCoord - 23, yCoord + 13);

			GL11.glEnd();

			//moving reload bar
			GL11.glColor3d(1, 0.75294117647, 0.01960784313);
			GL11.glBegin(GL11.GL_QUADS);

			GL11.glVertex2d(xCoord - 20, yCoord + 25);
			GL11.glVertex2d(xCoord - 20 + displacement, yCoord + 25);
			GL11.glVertex2d(xCoord - 20 + displacement, yCoord + 15);
			GL11.glVertex2d(xCoord - 20, yCoord + 15);

			GL11.glEnd();
		}
	}

	@Override
	public void move(){

		xCoord += dx;
		yCoord += dy;
	}

	public void createMagazinesAndAmmoStores(){

		for (int x = 0; x < Ranged.magSizes.length; x++){
			List<Integer> temp = new ArrayList<Integer>();
			for (int y = 0; y < Ranged.magSizes[x]; y++)
				temp.add(1);
			magazines.add(temp);
		}

		for (int x = 0; x < magazines.size(); x++){
			List<Integer> temp = new ArrayList<Integer>();
			ammoStores.add(temp);
		}

		//temporary ammo addage for testing
		for (int x = 0; x < Ranged.maxAmmoStashes.length; x++){
			for (int y = 0; y < Ranged.maxAmmoStashes[x]; y++){
				ammoStores.get(x).add(1);
			}
		}

	}

	@Override
	public void draw(){

		outfit.draw(xCoord, yCoord);
		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(xCoord+width/2, yCoord+height/2);
		GL11.glVertex2d(xCoord+width/2, yCoord-height/2);
		GL11.glVertex2d(xCoord-width/2, yCoord-height/2);
		GL11.glVertex2d(xCoord-width/2, yCoord+height/2);

		GL11.glEnd();
		rect = new Rectangle2D.Double(xCoord-width/2, yCoord+height/2, width, height);
	}

	public void equipWeapon(){

		//only swaps the rate of fire which a player has, later should swap the 
		//movement speed of a player as well, we should add that later when we determine
		//the size of the map
		equippedWeapon = availableWeapons[equippedIndex];
		if (previousEquippedIndex != equippedIndex){
			rateOfFire = Ranged.fireRates[equippedWeapon];
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

	public void increaseWeapon(){

		if (equippedIndex + 1 < availableWeapons.length)
			equippedIndex++;
		else
			equippedIndex = 0;

		reloading = false;
	}

	public void decreaseWeapon(){

		if (equippedIndex - 1 > -1)
			equippedIndex--;
		else
			equippedIndex = availableWeapons.length - 1;

		reloading = false;
	}

	public void actionReload(){

		if (reloading)
			if (System.currentTimeMillis()-beganReloading > Ranged.reloadSpeeds[equippedWeapon])
				while (0 < ammoStores.get(equippedWeapon).size()){
					if (magazines.get(equippedWeapon).size() > Ranged.magSizes[equippedWeapon]-1)
						break;
					magazines.get(equippedWeapon).add(1);
					ammoStores.get(equippedWeapon).remove(0);
				}
		reloading = false;	
	}

	public void reload(){

		if (!ammoStores.get(equippedWeapon).isEmpty())
			if (Ranged.magSizes[equippedWeapon] != magazines.get(equippedWeapon).size())
				if (!reloading){
					reloading = true;		
					beganReloading = System.currentTimeMillis();
				}
	}

	public void run(){

		dx *= 1.4;
		dy *= 1.4;
	}

	public List<Bullet> shoot(Point p){

		if (!reloading && !magazines.get(equippedWeapon).isEmpty()){
			//add recoil and gun specific things: movespeed with gun, etc....
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
				//shotguns need to shoot multiple bullets so i looped it to add several bullets
				//also need to add the explosives for rpg and nade launcher, as well as arrows for
				//crossbow, other than that all other guns will just run through the default
				//that adds a bullet normally
				case 12:
					for (int i = 0; i < 8; i++)
						list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
					magazines.get(equippedWeapon).remove(0);
					return list;
				case 13:
					for (int i = 0; i < 6; i++)
						list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
					magazines.get(equippedWeapon).remove(0);
					return list;
				case 14:
					for (int i = 0; i < 5; i++)
						list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
					magazines.get(equippedWeapon).remove(0);
					return list;
				case 15:
					for (int i = 0; i < 9; i++)
						list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
					magazines.get(equippedWeapon).remove(0);
					return list;
				case 16:
					for (int i = 0; i < 7; i++)
						list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
					magazines.get(equippedWeapon).remove(0);
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
					magazines.get(equippedWeapon).remove(0);
					return list;
				}
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