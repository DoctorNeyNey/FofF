import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Inventory {

	private Item[][] inventory = new Item[6][5];
	private Item[] equipment = new Item[4];
	private Item[] weapons = new Item[4];
	private Rectangle[][] inventoryHitboxes = new Rectangle[6][5];
	private Rectangle[] equipmentHitboxes = new Rectangle[4];
	private Rectangle[] weaponHitboxes = new Rectangle[4];
	private int[] clickAt = new int[2];


	public Inventory(){
		createHitboxes();
	}

	private void drawEmptySlot(double x, double y, double w, double h, double R, double G, double B){

		GL11.glColor3d(R, G, B);
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x+w, y);
		GL11.glVertex2d(x+w, y-h);
		GL11.glVertex2d(x, y-h);		

		GL11.glEnd();
	}

	private void drawEmptySlot(double x, double y, double w, double h){

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x+w, y);
		GL11.glVertex2d(x+w, y-h);
		GL11.glVertex2d(x, y-h);

		GL11.glEnd();
	}

	private void drawTexture(double x, double y, String s){

		Texture t = null;
		try {
			t = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Color.white.bind();
		t.bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2d(x,y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2d(x+t.getTextureWidth(),y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2d(x+t.getTextureWidth(),y+t.getTextureHeight());
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2d(x,y+t.getTextureHeight());
		GL11.glEnd();
	}

	private void createHitboxes(){

		weaponHitboxes[0] = new Rectangle(564, 1020, 180, 180);
		weaponHitboxes[1] = new Rectangle(780, 1020, 180, 180);
		weaponHitboxes[2] = new Rectangle(780, 804, 180, 180);
		weaponHitboxes[3] = new Rectangle(564, 804, 180, 180);

		equipmentHitboxes[0] = new Rectangle(60, 1020, 180, 180);
		equipmentHitboxes[1] = new Rectangle(276, 1020, 180, 180);	
		equipmentHitboxes[2] = new Rectangle(60, 804, 180, 180);
		equipmentHitboxes[3] = new Rectangle(276, 804, 180, 180);

		for (int y = 0; y < inventory.length; y++)
			for (int x = 0; x < inventory[y].length; x++)
				inventoryHitboxes[y][x] = new Rectangle(1056+168*x, 1020-168*y, 132, 132);

	}

	public void draw(){

		drawEquipment();
		drawPlayerStats();
		drawWeapons();
		drawMouseOveredStats();
		drawInventorySlots();
	}

	public void checkClick(){



	}

	public void drawEquipment(){

		drawEmptySlot(36, 1044, 444, 444, 1, 0, 0);

		if (equipment[0] == null)
			drawEmptySlot(60, 1020, 180, 180, 1, 1, 1);
		else 
			drawTexture(60, 1020, equipment[0].getPicture());

		if (equipment[1] == null)
			drawEmptySlot(276, 1020, 180, 180);
		else 	
			drawTexture(276, 1020, equipment[1].getPicture());

		if (equipment[2] == null)
			drawEmptySlot(60, 804, 180, 180);
		else 
			drawTexture(60, 804, equipment[2].getPicture());

		if (equipment[3] == null)
			drawEmptySlot(276, 804, 180, 180);
		else
			drawTexture(276, 804, equipment[3].getPicture());


	}

	public void drawPlayerStats(){

		drawEmptySlot(36, 564, 948, 540, 1, 0 ,0);

	}

	public void drawWeapons(){

		drawEmptySlot(540, 1044, 444, 444, 1, 0, 0);
		if (weapons[0] == null)
			drawEmptySlot(564, 1020, 180, 180, 1, 1, 1);
		else
			drawTexture(564, 1020, weapons[0].getPicture());

		if (weapons[1] == null)
			drawEmptySlot(780, 1020, 180, 180);
		else 
			drawTexture(780, 1020, weapons[1].getPicture());

		if (weapons[2] == null)
			drawEmptySlot(780, 804, 180, 180);
		else
			drawTexture(780, 804, weapons[2].getPicture());

		if (weapons[3] == null)
			drawEmptySlot(564, 804, 180, 180);
		else
			drawTexture(564, 804, weapons[3].getPicture());

	}

	public void drawMouseOveredStats(){

	}

	public void drawInventorySlots(){

		drawEmptySlot(1032, 1044, 852, 1020, 1, 0, 0);
		GL11.glColor3d(1, 1, 1);
		for (int y = 0; y < inventory.length; y++)
			for (int x = 0; x < inventory[y].length; x++)
				if (inventory[y][x] == null)
					drawEmptySlot(1056+168*x, 1020-168*y, 132, 132);
				else 
					drawTexture(1056+168*x, 1020-168*y, inventory[y][x].getPicture());
	}
	
	public void withdrawCoins(int x){
		
		coins -= x;
		
	}
	
	public int getCoins(){
		return x;
	}
}