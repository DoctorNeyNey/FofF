import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class Board {

	private Fabio fabio;
	private List<Bullet> friendlyBullets = new ArrayList<Bullet>();
	private List<Bullet> enemyBullets = new ArrayList<Bullet>();
	private Barrier b = new Barrier(200, 200, 40, 40, 8, 5);

	public Board() {

		createFabio();
	}

	public void moveAll(){

		fabio.move(b);
		
		for (Bullet b : friendlyBullets)
			b.move();

		for (Bullet b : enemyBullets)
			b.move();
	}


	private void drawHUD(){

		fabio.drawHealthBar(100, 100);
		fabio.drawReloadBar();
		fabio.drawAmmoCount();
		fabio.drawInventory();
	}

	public void drawAll(){

		for (Bullet b : friendlyBullets)
			b.draw();		
		for (Bullet b : enemyBullets)
			b.draw();
		fabio.draw();
		drawHUD();
		b.draw();
	}

	public void checkCollisions(){
		
		/**FABIO CHECKS IF HE RUNS INTO A WALL IN HIS OWN MOVE METHOD**/
		
		//ENEMY BULLETS THAT HIT FABIO
		for (int x = enemyBullets.size() - 1; x > -1; x--)
			if (enemyBullets.get(x).collision(fabio))
				enemyBullets.remove(x);

		//BULLETS THAT COLLIDE INTO A WALL
		for (int x = enemyBullets.size() - 1; x > -1; x--)
			if (b.collision(enemyBullets.get(x).getArea()))
				enemyBullets.remove(x);
		for (int x = friendlyBullets.size() - 1; x > -1; x--)
			if (b.collision(friendlyBullets.get(x).getArea()))
				friendlyBullets.remove(x);	
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
			for (Bullet b : list)
				friendlyBullets.add(b);
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

	public void playerEquipWeapon1(){
		fabio.equipWeapon1();
	}

	public void playerEquipWeapon2(){
		fabio.equipWeapon2();
	}

	public void playerEquipWeapon3(){
		fabio.equipWeapon3();
	}

	public void playerEquipWeapon4(){
		fabio.equipWeapon4();
	}

	public void playerEquipWeapon5(){
		fabio.equipWeapon5();
	}

	public void playerEquipWeapon6(){
		fabio.equipWeapon6();
	}

	public void playerEquipWeapon7(){
		fabio.equipWeapon7();
	}

	public void openPlayerInventory(){
		fabio.openInventory();
	}
}