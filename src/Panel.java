import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.ImageIOImageData;

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
			//fps
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


	}

	private void pollInputs(){

		//upward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			board.playerUp();
		
		//rightward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			board.playerRight();
		
		//downward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			board.playerDown();
		
		//leftward velocity
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			board.playerLeft();	

		//reload
		if (Keyboard.isKeyDown(Keyboard.KEY_R))
			board.playerReload();		

		//shoot 
		/**0 is the left click**/
		if (Mouse.isButtonDown(0))
			board.playerShoot(new Point(Mouse.getX(), Mouse.getY()));		

		//interact
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
			board.playerInteract(new Point(Mouse.getX(), Mouse.getY()));
		
	}


}
