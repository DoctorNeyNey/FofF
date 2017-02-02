import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Board {

	private Fabio fabio;
	private List<Bullet> friendlyBullets = new ArrayList<Bullet>();
	private List<Bullet> enemyBullets = new ArrayList<Bullet>();

	public Board() {

		createFabio();	
	}

	public void moveAll(){

		fabio.move();
		for (Bullet b : friendlyBullets)
			b.move();

		for (Bullet b : enemyBullets)
			b.move();
	}

	
	private void drawHUD(){
		
		fabio.drawHealthBar();
		fabio.drawReloadBar();
		fabio.drawAmmoCount();
	}
	
	public void drawAll(){

		drawHUD();
		for (Bullet b : friendlyBullets)
			b.draw();
		for (Bullet b : enemyBullets)
			b.draw();
		fabio.draw();
	}

	public void checkCollisions(){

		for (int x = enemyBullets.size() - 1; x > -1; x--){
			if (enemyBullets.get(x).collision(fabio));
				enemyBullets.remove(x);
		}
	}

	private void createFabio(){

		fabio = new Fabio(500, 500);
	}

	public void playerUp(){

		fabio.up();
	}

	public void playerDown(){

		fabio.down();
	}

	public void playerStopVertical(){

		fabio.stopVertical();
	}

	public void playerRight(){

		fabio.right();
	}

	public void playerLeft(){

		fabio.left();
	}

	public void playerStopHorizontal(){

		fabio.stopHorizontal();
	}

	public void playerReload(){

		fabio.reload();
	}

	public void playerReloadingAction(){
		
		fabio.actionReload();
	}
	
	public void playerShoot(Point p){

		List<Bullet> list = fabio.shoot(p);
		if (list != null)
			for (Bullet b : list)
				if (b != null)
					friendlyBullets.add(b);
	}

	public void playerInteract(){

		fabio.interact();
	}

	public void playerOpenInventory(){

		fabio.openInventory();
	}

	public void playerRun(){

		fabio.run();
	}

	public void playerEquipWeapon(){
		fabio.equipWeapon();
	}
	
	public void playerIncreaseWeapon(){
		fabio.increaseWeapon();
	}
	
	public void playerDecreaseWeapon(){
		fabio.decreaseWeapon();
	}

	public void garbageCollector(){
		
	}
}