import java.awt.Point;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Panel {

	private Board board;

	public static void main(String[] args){

		new Panel();
	}

	public Panel(){

		createBoard();

		try {
			//create display and mouse and keyboard listeners
			Display.setDisplayMode(new DisplayMode(1920, 1080));
			Display.setTitle("Fable of Fabio");
			Display.setVSyncEnabled(true);
			Display.create();
			Keyboard.create();
			Mouse.create();
		}
		catch(LWJGLException e){
			e.printStackTrace();
			System.exit(1);
		}

		//Display Settings
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 1920, 0, 1080, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		

		// repeats things while running
		while (!Display.isCloseRequested()){

			//remove anything thats been drawn
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			//draw, check collision, npcs....
			boardFunctions();
			//check mouse and keyboard
			pollInputs();
			//repaint
			Display.update();	
			//how many refreshes per second
			Display.sync(60);	
		}
		//exit functions
		Display.destroy();
		Mouse.destroy();
		Keyboard.destroy();
		System.exit(0);
	}
	
	private void createBoard(){

		board = new Board();
	}

	private void boardFunctions(){

		board.drawAll();
		board.moveAll();
		board.checkCollisions();
	}

	private void pollInputs(){

		//upward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			board.playerUp();

		//downward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			board.playerDown();
		
		//up and down stop
		if (!(Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_W)))
			board.playerStopVertical();

		//rightward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			board.playerRight();

		//leftward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			board.playerLeft();	

		//left and right stop
		if (!(Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_A)))
			board.playerStopHorizontal();
		
		//reload
		if (Keyboard.isKeyDown(Keyboard.KEY_R))
			board.playerReload();		

		//running
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			board.playerRun();
		
		//equip weapon in slot 1
		if (Keyboard.isKeyDown(Keyboard.KEY_1))
			board.playerEquip1();
		
		//equip weapon in slot 2
		if (Keyboard.isKeyDown(Keyboard.KEY_2))
			board.playerEquip2();
		
		//equip weapon in slot 3
		if (Keyboard.isKeyDown(Keyboard.KEY_3))
			board.playerEquip3();
		
		//equip weapon in slot 4
		if (Keyboard.isKeyDown(Keyboard.KEY_4))
			board.playerEquip4();
		
		//open inventory
		if (Keyboard.isKeyDown(Keyboard.KEY_I))
			board.playerOpenInventory();
		
		//shoot 
		/**0 is the left click**/
		if (Mouse.isButtonDown(0))
			board.playerShoot(new Point(Mouse.getX(), Mouse.getY()));		

		//interact
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
			board.playerInteract();
		
		//quick close
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			System.exit(0);

	}
}