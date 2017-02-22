import java.awt.Point;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class Board {

	private Fabio fabio;
	private List<Bullet> friendlyBullets = new ArrayList<Bullet>();
	private List<Bullet> enemyBullets = new ArrayList<Bullet>();
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Barrier b = new Barrier(200, 200, 40, 40, 8, 5);

	public Board() {

		createFabio();
		enemies.add(new Enemy(1000, 500, 100, 0));
	}

	public void moveAll(){

		fabio.move(b);

		for (Bullet b : friendlyBullets)
			b.move();

		for (Bullet b : enemyBullets)
			b.move();
	}


	private void drawHUD(){

		fabio.drawAmmoCount();
		fabio.drawHealthBar(100, 100);
		fabio.drawReloadBar();
		fabio.drawInventory();
	}

	public void drawAll(){

		drawHUD();
		for (Bullet b : friendlyBullets)
			b.draw();		
		for (Bullet b : enemyBullets)
			b.draw();
		fabio.draw();
		b.draw();

		for (Enemy e : enemies)
			e.draw();
	}

	public void killEnemies(){

		for (int x = enemies.size()-1; x > -1; x--)
			if (enemies.get(x).timeToDie())
				enemies.remove(x);
	}

	public void checkCollisions(){

		/**FABIO CHECKS IF HE RUNS INTO A WALL IN HIS OWN MOVE METHOD**/

		//ENEMY BULLETS THAT HIT FABIO
		for (int x = enemyBullets.size() - 1; x > -1; x--)
			if (enemyBullets.get(x).collision(fabio))
				enemyBullets.remove(x);

		//FABIO'S BULLETS THAT HIT ENEMIES
		for (int x = friendlyBullets.size()-1; x > -1; x--)
			for (Enemy e : enemies)
				if (friendlyBullets.get(x).collision(e)){
					e.hit(friendlyBullets.get(x));
					friendlyBullets.remove(x);
				}

		//BULLETS THAT COLLIDE INTO A WALL
		for (int x = enemyBullets.size() - 1; x > -1; x--)
			if (b.collision(new Area(enemyBullets.get(x).getPoly())))
				enemyBullets.remove(x);

		for (int x = friendlyBullets.size() - 1; x > -1; x--)
			if (b.collision(new Area(friendlyBullets.get(x).getPoly())))
				friendlyBullets.remove(x);	
	}

	public void checkEnemyShots(){

		for (Enemy e : enemies)
			enemyBullets.addAll(e.attack(fabio, b));
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

	public void playerUpLeft(){

		fabio.upLeft();
	}

	public void playerUpRight(){

		fabio.upRight();
	}

	public void playerDownRight(){

		fabio.downRight();
	}

	public void playerDownLeft(){

		fabio.downLeft();
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

		friendlyBullets.addAll(fabio.shoot(p));
	}

	public void playerInteract(){
		fabio.interact();
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

	public void playerResetShot(){
		fabio.resetShot();
	}

	public void playerEquipWeapon0(){
		fabio.equipWeapon0();
	}

	public void playerEquipWeapon1(){
		fabio.equipWeapon1();
	}

	public void playerEquipWeapon2(){
		fabio.equipWeapon2();
	}

	public void playerEquipWeapon3(){
		fabio.equipWeapon3();
	}

	public void openPlayerInventory(){
		fabio.openInventory();
	}
}