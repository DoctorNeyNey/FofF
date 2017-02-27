import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Enemy extends NPC{

	private boolean alerted = false;
	private Texture texture;
	private long lastShot = 0, outOfAmmo = 0;
	private int weapon, magazine, magSize;
	private double lastSeenX, lastSeenY, theta = 0;

	public Enemy(int xCoord, int yCoord, int health, int model) {
		super(xCoord, yCoord, health, model);
		weapon = 1;
		magSize = magazine = Ranged.magSizes[weapon];
	}

	public void hit(Bullet b){

		dealDamage(b.getDamage());
	}

	public List<Bullet> attack(Fabio f, Barrier b){

		List<Bullet> list = new ArrayList<Bullet>();
		reload();

		if (System.currentTimeMillis()-lastShot > Ranged.fireRates[weapon]*2 && magazine != 0)
			if (hasLineOfSight(f, b)){
				lastShot = System.currentTimeMillis();
				magazine--;
				double x = f.getxCoord()-xCoord;
				double y = f.getyCoord()-yCoord;
				double theta = Math.atan(y/x);
				if (f.getxCoord() - xCoord < 0)
					theta += Math.PI;

				for (int z = 0; z < Ranged.bulletCounts[weapon]; z++)
					list.add(new Bullet(xCoord, yCoord, theta, weapon));

				if (magazine == 0)
					outOfAmmo = System.currentTimeMillis();
			}
		return list;
	}

	public void move(Barrier b){

		if (horizontalPathClear(b))
			xCoord += dx;

		if (verticalPathClear(b))
			yCoord += dy;
	}

	private boolean verticalPathClear(Barrier b) {


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

	private boolean horizontalPathClear(Barrier b) {

		Polygon temp = new Polygon();
		temp.npoints = poly.npoints;
		temp.xpoints = poly.xpoints;
		temp.ypoints = poly.ypoints;

		for (int x = 0; x < poly.npoints; x++)
			temp.xpoints[x]  += dx;

		return !b.collision(new Area(temp));
	}

	public void search(Fabio f, Barrier b){

		if (hasLineOfSight(f,b)){
			lastSeenX = f.getxCoord();
			lastSeenY = f.getyCoord();
			dx = 0;
			dy = 0;
		}

		if (!hasLineOfSight(f,b)){
			double x = lastSeenX - xCoord;
			double y = lastSeenY - yCoord;
			double theta = Math.atan(y/x);
			if (x < 0)
				theta += Math.PI;
			dx = 6*Math.cos(theta);
			dy = 6*Math.sin(theta);

			System.out.println(lastSeenX);
			System.out.println(lastSeenY);
			if (x < 7 && y < 7)
				dx = dy = 0;
		}
	}

	public boolean hearFootsteps(Fabio fabio){



		return false;
	}

	public void reload(){

		if (System.currentTimeMillis() - outOfAmmo > Ranged.reloadSpeeds[weapon]*2 && magazine == 0)
			magazine = magSize;
	}

	public boolean hasLineOfSight(Fabio f, Barrier b){

		Polygon p = new Polygon();
		int[] x = {

				(int) f.getxCoord(),
				(int) (f.getxCoord()+1),
				(int) xCoord,
				(int) (xCoord+1)
		};

		int[] y = {

				(int) f.getyCoord(),
				(int) (f.getyCoord()+1),
				(int) yCoord,
				(int) (yCoord+1)
		};

		p.npoints = x.length;
		p.xpoints = x;
		p.ypoints = y;

		Area a = new Area(p);
		a.intersect(new Area(b.getPoly()));
		return a.isEmpty();
	}

	public void draw(){

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

		GL11.glBegin(GL11.GL_QUADS);

		for (int x = 0; x < poly.npoints; x++)
			GL11.glVertex2i(poly.xpoints[x], poly.ypoints[x]);

		GL11.glEnd();
	}
}	