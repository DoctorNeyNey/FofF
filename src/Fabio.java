import java.awt.Font;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Fabio extends Person{

	private TrueTypeFont ammoFont;
	private static int baseHealth = 100;
	private Outfit outfit;
	private long lastTimeShot = 0, beganReloading = 0;
	private Integer[] availableWeapons = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};//new Integer[4];
	private List<List<Integer>> magazines = new ArrayList<List<Integer>>(), ammoStores = new ArrayList<List<Integer>>();
	private Inventory inventory = new Inventory();
	private Head head = null;
	private Shirt shirt = null;
	private Pants pants = null;
	private Shoes shoes = null;
	private int equippedWeapon, equippedIndex = 0, rateOfFire = 0, previousEquippedIndex = -1000,
			currentHealth = 100;
	private boolean reloading = false, mustReleaseShoot = false, inventoryOpen = false,
			iHasBeenReleased = true;
	private double theta = 0;


	public Fabio(double xCoord, double yCoord) {
		super(xCoord, yCoord, baseHealth);
		createMagazinesAndAmmoStores();
		createFont();
		createPolygon();
	}
	
	private void createFont(){

		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("Fonts/ammoFont.ttf");	
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
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(.831372549f, .431372549f, .2862745098f, .5f);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(600, 600);
		GL11.glVertex2d(700, 600);
		GL11.glVertex2d(700, 700);
		GL11.glVertex2d(600, 700);

		GL11.glEnd();
		GL11.glRotated(180, 0, Display.getHeight()/2, 0	);
		GL11.glRotated(180, 0, 0, 0);

		//need to use the negative in the y position
		ammoFont.drawString(0, -900, ammoPrintOut, Color.white);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glRotated(180, 0, -Display.getHeight()/2, 0);
		GL11.glRotated(180, 0, 0, 0);
	}

	public void toggleInventory(){

		if (iHasBeenReleased){
			inventoryOpen = !inventoryOpen;
			iHasBeenReleased = false;
		}
	}

	public void resetI(){
		iHasBeenReleased = true;
	}

	public void drawHealthBar(int x, int y){

		//HEALTH BAR
		//outline
		GL11.glColor4f(.381019078f, .381019078f, .381019078f, 1f);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x-5, y+4);
		GL11.glVertex2d(x-5, y-34);
		GL11.glVertex2d(x+5+baseHealth*2, y-34);
		GL11.glVertex2d(x+5+baseHealth*2, y+4);

		GL11.glEnd();

		//missingHealth
		GL11.glColor4f(.731372549f, .1568627451f, .1882352941f, 1f);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x+baseHealth*2, y);
		GL11.glVertex2d(x+baseHealth*2, y-30);
		GL11.glVertex2d(x+baseHealth*2-(baseHealth*2-currentHealth*2), y-30);
		GL11.glVertex2d(x+baseHealth*2-(baseHealth*2-currentHealth*2), y);

		GL11.glEnd();

		//current health
		GL11.glColor4f(0f, 1f, 0f, 1f);
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
			GL11.glColor4f(.381019078f, .381019078f, .381019078f, 1f);
			GL11.glBegin(GL11.GL_QUADS);

			GL11.glVertex2d(xCoord - 23, yCoord + 31);
			GL11.glVertex2d(xCoord + 23, yCoord + 31);
			GL11.glVertex2d(xCoord + 23, yCoord + 16);
			GL11.glVertex2d(xCoord - 23, yCoord + 16);

			GL11.glEnd();

			//moving reload bar
			GL11.glColor4f(1f, 0.75294117647f, 0.01960784313f, 1f);
			GL11.glBegin(GL11.GL_QUADS);

			GL11.glVertex2d(xCoord - 20, yCoord + 28);
			GL11.glVertex2d(xCoord - 20 + displacement, yCoord + 28);
			GL11.glVertex2d(xCoord - 20 + displacement, yCoord + 18);
			GL11.glVertex2d(xCoord - 20, yCoord + 18);

			GL11.glEnd();
		}
	}

	public void move(Barrier b){

		if (horizontalPathClear(b))
			xCoord += dx;

		if (verticalPathClear(b))
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
		int[] tempX = {
				(int) (xCoord + 14.1421356237*Math.cos(theta + Math.PI/4)),
				(int) (xCoord + 14.1421356237*Math.cos(theta + 3*Math.PI/4)),
				(int) (xCoord + 14.1421356237*Math.cos(theta + 5*Math.PI/4)),
				(int) (xCoord + 14.1421356237*Math.cos(theta + 7*Math.PI/4))
		};

		int[] tempY = {
				(int) (yCoord + 14.1421356237*Math.sin(theta + Math.PI/4)),
				(int) (yCoord + 14.1421356237*Math.sin(theta + 3*Math.PI/4)),
				(int) (yCoord + 14.1421356237*Math.sin(theta + 5*Math.PI/4)),
				(int) (yCoord + 14.1421356237*Math.sin(theta + 7*Math.PI/4))
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

		GL11.glColor4f(1f, 1f, 1f, 1f);
		GL11.glBegin(GL11.GL_QUADS);		

		for (int z = 0; z < poly.npoints; z++)
			GL11.glVertex2d(poly.xpoints[z], poly.ypoints[z]);

		GL11.glEnd();
		
		if (inventoryOpen)
			inventory.draw();
	}

	public void equipWeapon(){

		//only swaps the rate of fire which a player has, later should swap the 
		//movement speed of a player as well, we should add that later when we determine
		//the size of the map
		equippedWeapon = availableWeapons[equippedIndex];
		if (previousEquippedIndex != equippedIndex)
			rateOfFire = Ranged.fireRates[equippedWeapon];
		previousEquippedIndex = equippedIndex;
	}

	public void equipWeapon0(){
		if (availableWeapons[0] != null){
			equippedIndex = 0;
			reloading = false;
		}
	}

	public void equipWeapon1(){
		if (availableWeapons[1] != null){
			equippedIndex = 1;
			reloading = false;
		}
	}

	public void equipWeapon2(){
		if (availableWeapons[2] != null){
			equippedIndex = 2;
			reloading = false;
		}
	}

	public void equipWeapon3(){
		if (availableWeapons[3] != null){
			equippedIndex = 3;
			reloading = false;
		}
	}
	
	public void checkInventory(){
		
		inventory.checkClick();
		
	}

	public void interact(){

	}

	public void upLeft(){

		dy = 3.53553390593;
		dx = -3.53553390593;
	}

	public void upRight(){

		dy = 3.53553390593;
		dx = 3.53553390593;
	}

	public void downLeft(){

		dy = -3.53553390593;
		dx = -3.53553390593;
	}

	public void downRight(){

		dy = -3.53553390593;
		dx = 3.53553390593;
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

		List<Bullet> list = new ArrayList<Bullet>();
		if (!reloading && !magEmpty() && !mustReleaseShoot){
			//add recoil and gun specific things: movespeed with gun, etc....
			if (System.currentTimeMillis()-lastTimeShot > rateOfFire){
				lastTimeShot = System.currentTimeMillis();
				double x = p.getX()-xCoord;
				double y = p.getY()-yCoord;
				double theta = Math.atan(y/x);
				//because of arccos's range we need to add pi if they are shooting to the left
				if (p.getX()-xCoord < 0)
					theta += Math.PI;
				checkFireMode();
				for (int z = 0; z < Ranged.bulletCounts[equippedWeapon]; z++)
					list.add(new Bullet(xCoord, yCoord, theta, equippedWeapon));
				magazines.get(equippedWeapon).remove(0);
				return list;
			}
		}
		return list;
	}

	@Override
	public void dealDamage(double d){
		currentHealth -= d;
		if (currentHealth < -1)
			currentHealth = 0;
	}

	public void checkFireMode(){

		if (Ranged.fireModes[equippedWeapon] == 0)
			mustReleaseShoot = true;

		else if (Ranged.fireModes[equippedWeapon] == 1)
			mustReleaseShoot = false;

		else {
			System.out.println("There was an error in selecting a fire mode");
			System.exit(3);
		}
	}

	public void resetShot(){
		mustReleaseShoot = false;
	}

	private boolean verticalPathClear(Barrier b){

		Polygon temp = new Polygon();
		int[] tempX = {
				(int) (xCoord + 14.1421356237*Math.cos(theta + Math.PI/4)),
				(int) (xCoord + 14.1421356237*Math.cos(theta + 3*Math.PI/4)),
				(int) (xCoord + 14.1421356237*Math.cos(theta + 5*Math.PI/4)),
				(int) (xCoord + 14.1421356237*Math.cos(theta + 7*Math.PI/4))
		};

		int[] tempY = {
				(int) (yCoord + 14.1421356237*Math.sin(theta + Math.PI/4)),
				(int) (yCoord + 14.1421356237*Math.sin(theta + 3*Math.PI/4)),
				(int) (yCoord + 14.1421356237*Math.sin(theta + 5*Math.PI/4)),
				(int) (yCoord + 14.1421356237*Math.sin(theta + 7*Math.PI/4))
		};
		temp.npoints = tempX.length;
		temp.xpoints = tempX;
		temp.ypoints = tempY;

		for (int x = 0; x < temp.npoints; x++)
			temp.ypoints[x] += dy;

		return !b.collision(new Area(temp));
	}

	private boolean horizontalPathClear(Barrier b){

		Polygon temp = new Polygon();
		temp.npoints = poly.npoints;
		temp.xpoints = poly.xpoints;
		temp.ypoints = poly.ypoints;

		for (int x = 0; x < poly.npoints; x++)
			temp.xpoints[x]  += dx;

		return !b.collision(new Area(temp));
	}

	public boolean isInventoryOpen(){

		return inventoryOpen;
	}

	public boolean isPlayerMenuOpen(){

		return false;
	}
}