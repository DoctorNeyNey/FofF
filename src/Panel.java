import java.awt.Point;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Panel {
	private boolean pastIntroScreen = false;
	private Board board;
	private IntroScreen introScreen;

	
	public static void main(String[] args){
	
		new Panel();
	}

	public Panel(){

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
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		createIntroScreen();

		// repeats things while running
		while (!Display.isCloseRequested()){

			//remove anything thats been drawn
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			//check mouse and keyboard
			pollInputs();
			//draw, check collision, npcs....
			if (pastIntroScreen)
				boardFunctions();
			else
				introScreenFunctions();
			//repaint
			Display.update();	
			//how many refreshes per second/ FPS
			Display.sync(60);	
		}
		//exit functions
		Display.destroy();
		Mouse.destroy();
		Keyboard.destroy();
		System.exit(0);
	}

	private void introScreenFunctions(){

		introScreen.draw();
		introScreen.highLightSelectedIndex();
	}

	private void createIntroScreen(){

		introScreen = new IntroScreen(this);
	}

	public void createBoard(){

		board = new Board();
	}

	public void passIntroScreen(){

		pastIntroScreen = true;
		introScreen = null;
	}

	private void boardFunctions(){

		board.drawAll();
		board.moveAll();
		board.checkCollisions();
		board.playerEquipWeapon();
		board.playerReloadingAction();
	}

	private void pollInputs(){

		if (pastIntroScreen){
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

			//open inventory
			if (Keyboard.isKeyDown(Keyboard.KEY_I))
				board.openPlayerInventory();

			//interact
			if (Keyboard.isKeyDown(Keyboard.KEY_E))
				board.playerInteract();

			//equip slots
			//swap Weapon
			if (Keyboard.isKeyDown(Keyboard.KEY_1))
				board.playerEquipWeapon1();

			if (Keyboard.isKeyDown(Keyboard.KEY_2))
				board.playerEquipWeapon2();

			if (Keyboard.isKeyDown(Keyboard.KEY_3))
				board.playerEquipWeapon3();

			if (Keyboard.isKeyDown(Keyboard.KEY_4))
				board.playerEquipWeapon4();

			if (Keyboard.isKeyDown(Keyboard.KEY_5))
				board.playerEquipWeapon5();

			if (Keyboard.isKeyDown(Keyboard.KEY_6))
				board.playerEquipWeapon6();

			if (Keyboard.isKeyDown(Keyboard.KEY_7))
				board.playerEquipWeapon7();

			int dWheel = Mouse.getDWheel();
			if (dWheel > 0)
				board.playerIncreaseWeapon();
			else if (dWheel < 0)
				board.playerDecreaseWeapon();

			//shoot 
			/**0 is the left click**/
			if (Mouse.isButtonDown(0))
				board.playerShoot(new Point(Mouse.getX(), Mouse.getY()));	

			if (!Mouse.isButtonDown(0))
				board.playerResetShot();

			//quick close
			if (Keyboard.isKeyDown(Keyboard.KEY_EQUALS))
				System.exit(0);
		}
		else {
			
			//quick close
			if (Keyboard.isKeyDown(Keyboard.KEY_EQUALS))
				System.exit(0);

			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S))
				introScreen.down();

			if (Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W))
				introScreen.up();

			if (!Keyboard.isKeyDown(Keyboard.KEY_UP) && !Keyboard.isKeyDown(Keyboard.KEY_DOWN)
					&& !Keyboard.isKeyDown(Keyboard.KEY_S) && !Keyboard.isKeyDown(Keyboard.KEY_W)
					&& !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !Keyboard.isKeyDown(Keyboard.KEY_SPACE))
				introScreen.resetRelease();

			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
				introScreen.execute();

			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
				introScreen.back();
		}
	}
}