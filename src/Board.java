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

	public void drawAll(){

		for (Bullet b : friendlyBullets)
			b.draw();

		for (Bullet b : enemyBullets)
			b.draw();

		fabio.draw();
	}

	public void checkCollisions(){

		for (Bullet b : enemyBullets)
			b.collision(fabio);
	}

	private void createFabio(){

		fabio = new Fabio(500, 500, 100);
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

	public void playerShoot(Point p){

		friendlyBullets.add(fabio.shoot(p));
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

	public void offScreenDeleter(){

		for (int x = friendlyBullets.size(); x > -1; x--)
			if (!friendlyBullets.get(x).isInView())
				friendlyBullets.remove(x);

		for (int x = enemyBullets.size(); x > -1; x--)
			if (!enemyBullets.get(x).isInView())
				enemyBullets.remove(x);
	}

	public void playerEquip1(){
		
		fabio.equip1();
	}

	public void playerEquip2(){

		fabio.equip2();
	}

	public void playerEquip3(){

		fabio.equip3();
	}

	public void playerEquip4(){

		fabio.equip4();
	}
}
