
public class Bullet extends Moveable {

	private int damage;
	public static int PISTOL_ROUND = 0;
	
	public Bullet(int xCoord, int yCoord, double theta, int type){
		
		super(xCoord, yCoord);
		switch (type){
		case 0:
			dx = Math.cos(theta)*8;
			dy = Math.sin(theta)*8;
			damage = 25;
		}
	}
	
	public void draw(){
		
	}
	
	public void move(){
		
	}
	
	public void collision(){
		
	}
	
	
}
