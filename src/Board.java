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

		fabio.drawHealthBar(100, 100);
		fabio.drawReloadBar();
		fabio.drawAmmoCount();
		fabio.drawInventory();
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

		for (int x = enemyBullets.size() - 1; x > -1; x--)
			if (enemyBullets.get(x).collision(fabio))
				enemyBullets.remove(x);
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

	public boolean playerMagEmpty(){
		return fabio.magEmpty();
	}
}