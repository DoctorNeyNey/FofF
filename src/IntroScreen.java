import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class IntroScreen {

	private String[] menu = {"Play", "Options", "Quit"};
	private TrueTypeFont menuFont;
	private Texture texture;
	private Color[] colors = {Color.white, Color.white, Color.white, Color.white, Color.white};
	private int selectedIndex = 0;
	private boolean mustRelease = false, displayMainOptions = false, displayOptionComponent = false;
	private Panel p;


	public IntroScreen(Panel p){

		this.p = p;

		try{
			//creates the font
			InputStream inputStream = ResourceLoader.getResourceAsStream("Fonts/BodoniXT.ttf");
			Font menuFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			this.menuFont = new TrueTypeFont(menuFont.deriveFont(48f), false);

			//loads the image for the title
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Images/FABLE OF FABIO TITLE SCREEN1.png"));
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	private void drawTitle(){

		Color.white.bind();
		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(680,-900);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(680+texture.getTextureWidth(),-900);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(680+texture.getTextureWidth(),-900+texture.getTextureHeight());
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(680,-900+texture.getTextureHeight());

		GL11.glEnd();
	}

	public void draw(){

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glRotated(180, 0, Display.getHeight()/2, 0);
		GL11.glRotated(180, 0, 0, 0);

		//need to use the negative in the y position
		for (int x = 0; x < menu.length; x++)
			menuFont.drawString(1000-menuFont.getWidth(menu[x])/2, -700+100*x, menu[x], colors[x]);

		drawTitle();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glRotated(180, 0, -Display.getHeight()/2, 0);
		GL11.glRotated(180, 0, 0, 0);

	}

	public void highLightSelectedIndex(){

		for (int x = 0; x < colors.length; x++)
			colors[x] = Color.white;

		colors[selectedIndex] = Color.yellow;
	}

	public void up(){

		if (!mustRelease)
			if (selectedIndex > 0){
				selectedIndex--;
				mustRelease = true;
			}
	}

	public void down(){

		if (!mustRelease)
			if (selectedIndex < menu.length-1){
				selectedIndex++;
				mustRelease = true;
			}
	}

	private void openOptions(){

		String[] temp = {"Controls", "Gameplay", "Audio Settings", "Video Settings", "Back"};
		selectedIndex = 0;
		menu = temp;
		displayMainOptions = true;
	}

	public void execute(){

		if (!mustRelease){
			if (!displayMainOptions && !displayOptionComponent){
				if (selectedIndex == 0){
					p.createBoard();
					p.passIntroScreen();
				}

				else if (selectedIndex == 1)
					openOptions();

				else
					System.exit(0);
			}

			else if (displayMainOptions){		

				if (selectedIndex == 0)
					System.out.println("controls menu has been selected");

				else if (selectedIndex == 1)
					System.out.println("gameplay menu has been selected");

				else if (selectedIndex == 2)
					System.out.println("Audio Settings have been selected");

				else if (selectedIndex == 3)
					System.out.println("Video Settings have been selected");

				else 
					back();
			}
		}
		mustRelease = true;
	}

	public void back(){
		if (!mustRelease){
			if (displayMainOptions){
				String[] temp = {"Play", "Options", "Quit"};
				menu = temp;
				displayMainOptions = false;
				selectedIndex = 0;
				mustRelease = true;
			}
			else if (displayOptionComponent){
				String[] temp = {"Controls", "Gameplay", "Audio Settings", "Video Settings", "Back"};
				menu = temp;		
				displayMainOptions = true;
				displayOptionComponent = false;
				selectedIndex = 0;
				mustRelease = true;
			}
		}
	}

	public void resetRelease(){

		mustRelease = false;
	}
}