import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.openal.Audio;

public class Bullet extends Moveable {

	private double damage;
	private double theta;
	private Area area = new Area();

	public Bullet(double xCoord, double yCoord, double theta, int type){	
		super(xCoord, yCoord);
		double bulletVelocity;
		if (type >= 12 && type <= 16)
			bulletVelocity = Ranged.bulletVelocities[type]+2*Math.random();
		else
			bulletVelocity = Ranged.bulletVelocities[type];
		double variability = Ranged.variabilities[type]*Math.random()-Ranged.variabilities[type]/2;
		damage = Ranged.damages[type];
		this.theta = theta;
		double cos = Math.cos(theta+variability);
		double sin = Math.sin(theta+variability);
		dx = cos*bulletVelocity;
		dy = sin*bulletVelocity;		
		createPolygon();
	}

	private void createPolygon(){

		int[] xCoords = {

				(int) (xCoord + 8.24264068712*Math.cos(theta+Math.PI/4)),
				(int) (xCoord + 8.24264068712*Math.cos(theta+3*Math.PI/4)),
				(int) (xCoord + 8.24264068712*Math.cos(theta+5*Math.PI/4)),
				(int) (xCoord + 8.24264068712*Math.cos(theta+7*Math.PI/4))
		};

		int[] yCoords = {

				(int) (yCoord + 8.24264068712*Math.sin(theta+Math.PI/4)),
				(int) (yCoord + 8.24264068712*Math.sin(theta+3*Math.PI/4)),
				(int) (yCoord + 8.24264068712*Math.sin(theta+5*Math.PI/4)),
				(int) (yCoord + 8.24264068712*Math.sin(theta+7*Math.PI/4))
		};

		poly.npoints = xCoords.length;
		poly.xpoints = xCoords;
		poly.ypoints = yCoords;
		area = new Area(poly);
	}

	public void draw(){

		createPolygon();
		GL11.glColor3d(0.9960784314, 0.8862745098, 0.2431372549);		
		GL11.glBegin(GL11.GL_QUADS);

		for (int x = 0; x < poly.npoints; x++)
			GL11.glVertex2d(poly.xpoints[x], poly.ypoints[x]);

		GL11.glEnd();
	}


	public boolean collision(Fabio f){		

		return false;
	}

	public boolean collision(Immoveable i){

		return false;
	}	

	public boolean collision(Person npc){

		return false;
	}

	public double getDamage(){

		return damage;
	}
	
	public Area getArea(){
		
		return area;
	}
}
