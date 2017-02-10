import java.awt.Font;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
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
	private Integer[] availableWeapons = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private List<List<Integer>> magazines = new ArrayList<List<Integer>>();
	private List<List<Integer>> ammoStores = new ArrayList<List<Integer>>();
	private Item[] inventory = new Item[25];
	private int equippedWeapon, equippedIndex = 0, rateOfFire = 0,
			previousEquippedIndex = -1000, currentHealth = 100;
	private boolean reloading = false, mustReleaseShoot = false;
	private boolean isInventoryOpen = false;
	private double theta = 0;


	public Fabio(double xCoord, double yCoord) {
		super(xCoord, yCoord, baseHealth);
		outfit = new Outfit(null, null, null, null);
		width = 20;
		height = 20;
		createMagazinesAndAmmoStores();
		createFont();
		initiatePolygon();
	}

	private void initiatePolygon(){

		poly = new Polygon2D();
		createPolygon();
	}

	private void createFont(){

		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("Fonts/Kirbys-Adventure.ttf");	
			Font ammoFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			this.ammoFont = new TrueTypeFont(ammoFont.deriveFont(24f), false);
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("2");
		}
	}

	public void drawAmmoCount(){

		Integer currentAmmo = magazines.get(equippedWeapon).size();
		Integer totalAmmo = ammoStores.get(equippedWeapon).size();
		String ammoPrintOut = currentAmmo.toString() + "-" + totalAmmo.toString();

		GL11.glColor4d(.831372549d, .431372549d, .2862745098d, .5d);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(600, 600);
		GL11.glVertex2d(700, 600);
		GL11.glVertex2d(700, 700);
		GL11.glVertex2d(600, 700);
		GL11.glPushMatrix();

		GL11.glEnd();
		GL11.glEnable(GL11.GL_BLEND);

		GL11.glRotated(180, 0, Display.getHeight()/2, 0);
		GL11.glRotated(180, 0, 0, 0);

		//need to use the negative in the y position
		ammoFont.drawString(0, -900, ammoPrintOut, Color.white);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glRotated(180, 0, -Display.getHeight()/2, 0);
		GL11.glRotated(180, 0, 0, 0);
	}

	public void drawInventory(){
		if (isInventoryOpen){






		}
	}

	public void drawHealthBar(int x, int y){



		//HEALTH BAR
		//outline
		GL11.glColor3d(.381019078, .381019078, .381019078);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x-5, y+4);
		GL11.glVertex2d(x-5, y-34);
		GL11.glVertex2d(x+5+baseHealth*2, y-34);
		GL11.glVertex2d(x+5+baseHealth*2, y+4);

		GL11.glEnd();

		//missingHealth
		GL11.glColor3d(.731372549, .1568627451, .1882352941);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x+baseHealth*2, y);
		GL11.glVertex2d(x+baseHealth*2, y-30);
		GL11.glVertex2d(x+baseHealth*2-(baseHealth*2-currentHealth*2), y-30);
		GL11.glVertex2d(x+baseHealth*2-(baseHealth*2-currentHealth*2), y);

		GL11.glEnd();

		//current health
		GL11.glColor3d(0, 1, 0);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x, y-30);
		GL11.glVertex2d(x+currentHealth*2, y-30);
		GL11.glVertex2d(x+currentHealth*2, y);

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
		for (int x = 0; x < Ranged.maxAmmoStashes.length; x++)
			for (int y = 0; y < Ranged.maxAmmoStashes[x]; y++)
				ammoStores.get(x).add(1);

	}

	public void createPolygon(){

		//declare polygon
		double[] tempX = {
				xCoord + 14.1421356237*Math.cos(theta + Math.PI/4),
				xCoord + 14.1421356237*Math.cos(theta + 3*Math.PI/4),
				xCoord + 14.1421356237*Math.cos(theta + 5*Math.PI/4),
				xCoord + 14.1421356237*Math.cos(theta + 7*Math.PI/4)
		};

		double[] tempY = {
				yCoord + 14.1421356237*Math.sin(theta + Math.PI/4),
				yCoord + 14.1421356237*Math.sin(theta + 3*Math.PI/4),
				yCoord + 14.1421356237*Math.sin(theta + 5*Math.PI/4),
				yCoord + 14.1421356237*Math.sin(theta + 7*Math.PI/4)
		};

		poly.npoints = tempX.length;
		poly.xpoints = tempX;
		poly.ypoints = tempY;
	}

	@Override
	public void draw(){


		double x = Mouse.getX()-xCoord;
		double y = Mouse.getY()-yCoord;
		theta = Math.atan(y/x);

		//because of arccos's range we need to add pi if they are shooting to the left
		if (Mouse.getX()-xCoord < 0)
			theta += Math.PI;

		createPolygon();

		outfit.draw(xCoord, yCoord);
		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);		

		for (int z = 0; z < poly.npoints; z++)
			GL11.glVertex2d(poly.xpoints[z], poly.ypoints[z]);

		GL11.glEnd();
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

	public void equipWeapon1(){
		if (availableWeapons[0] != null){
			equippedIndex = 0;
			reloading = false;
		}
	}

	public void equipWeapon2(){
		if (availableWeapons[1] != null){
			equippedIndex = 1;
			reloading = false;
		}
	}

	public void equipWeapon3(){
		if (availableWeapons[2] != null){
			equippedIndex = 2;
			reloading = false;
		}
	}

	public void equipWeapon4(){
		if (availableWeapons[3] != null){
			equippedIndex = 3;
			reloading = false;
		}
	}

	public void equipWeapon5(){
		if (availableWeapons[4] != null){
			equippedIndex = 4;
			reloading = false;
		}
	}

	public void equipWeapon6(){
		if (availableWeapons[5] != null){
			equippedIndex = 5;
			reloading = false;
		}
	}

	public void equipWeapon7(){
		if (availableWeapons[6] != null){
			equippedIndex = 6;
			reloading = false;
		}
	}

	public void interact(){

	}

	public void openInventory(){

		isInventoryOpen = true;		
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

		if (reloading){
			if (System.currentTimeMillis()-beganReloading > Ranged.reloadSpeeds[equippedWeapon]){
				while (0 < ammoStores.get(equippedWeapon).size()){
					if (magazines.get(equippedWeapon).size() > Ranged.magSizes[equippedWeapon]-1)
						break;
					magazines.get(equippedWeapon).add(1);
					ammoStores.get(equippedWeapon).remove(0);
				}
				reloading = false;
			}
		}
	}


	public void reload(){

		if (!ammoStores.get(equippedWeapon).isEmpty())
			if (Ranged.magSizes[equippedWeapon] != magazines.get(equippedWeapon).size())
				if (!reloading){
					reloading = true;		
					beganReloading = System.currentTimeMillis();
				}
	}

	public boolean magEmpty(){
		
		return magazines.get(equippedWeapon).isEmpty();
	}

	public void run(){

		dx *= 1.6;
		dy *= 1.6;
	}

	public List<Bullet> shoot(Point p){

		if (!reloading && !magEmpty() && !mustReleaseShoot){
			//add recoil and gun specific things: movespeed with gun, etc....
			List<Bullet> list = new ArrayList<Bullet>();
			if (System.currentTimeMillis()-lastTimeShot > rateOfFire){
				lastTimeShot = System.currentTimeMillis();
				double x = p.getX()-xCoord;
				double y = p.getY()-yCoord;
				double theta = Math.atan(y/x);
				//because of arccos's range we need to add pi if they are shooting to the left
				if (p.getX()-xCoord < 0)
					theta += Math.PI;

				checkFireMode();
				switch (equippedWeapon){
				//shotguns need to shoot multiple bullets so i looped it to add several bullets
				//also need to add the explosives for rpg and nade launcher, as well as 
				//arrows for crossbow, other than that all other guns will just run through
				//the default that adds a bullet normally
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

	public void checkFireMode(){

		switch (Ranged.fireModes[equippedWeapon]){
		case 0 :
			mustReleaseShoot = true;
			break;
		case 1:
			mustReleaseShoot = false;
			break;
		default:
			System.out.println("There was an error in selecting a fire mode");
			break;
		}
	}

	public void aoePickUp(){


	}

	public void resetShot(){

		mustReleaseShoot = false;
	}
}