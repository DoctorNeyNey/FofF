import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Board {

	private Fabio fabio;
	private List<Bullet> bullets = new ArrayList<Bullet>();
	
	
	public Board() {

		createFabio();	
	}

	public void moveAll(){
		
		fabio.move();
	}
	
	public void checkCollisions(){
		
		
	}
	
	private void createFabio(){
		
		fabio = new Fabio(500, 500);
	}
	
	public void playerUp(){
		
		fabio.up();
	}
	
	public void playerRight(){
		
		fabio.right();
	}
	
	public void playerDown(){
		
		fabio.down();
	}
	
	public void playerLeft(){
		
		fabio.left();
	}
	
	public void playerReload(){
		
		fabio.reload();
	}
	
	public void playerShoot(Point p){
		
		fabio.shoot(p);
	}
	
	public void playerInteract(Point p){
	
		fabio.interact(p);
	}
}
