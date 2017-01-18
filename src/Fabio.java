import org.lwjgl.util.Point;

public class Fabio extends Person{

	public Fabio(int xCoord, int yCoord, int health) {
		super(xCoord, yCoord, health);
		
	}

	public void move(){
		
		xCoord += dx;
		yCoord += dy;
		
	}
	
	public void draw(){
		
		
	}
	
	public void interact(Point p){
		
	}
	
	public void up(){
		
		dy = 5;
	}
	
	public void down(){
		
		dy = -5;
	}
	
	public void left(){
		
		dx = -5;
	}
	
	public void right(){
		
		dx = 5;
	}
	
	public void reload(){
		
	}
	
	public Bullet shoot(Point p){
		
		//add recoil and gun specific things: clip size, rate of fire, etc....
		//i think we should use a case and switch with ints to specify what gun the player has
		/** as of now all it does is shoot where the mouse is pointed**/
		
		double bulletSpeed = 5; //we should change this to be specific to each type of ammunition as well
		
		double x = p.getX()-xCoord;
		double y = p.getY()-yCoord;
		double theta = Math.atan(y/x);
				
		return new Bullet(xCoord, yCoord, theta, Bullet.PISTOL_ROUND);
	}
}
