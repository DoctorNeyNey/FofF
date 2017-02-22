import java.util.ArrayList;
import java.util.List;

public class Neutral extends NPC {
	
	private boolean hostile = false;
	
	public Neutral(int xCoord, int yCoord, int health, int model) {
		super(xCoord, yCoord, health, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(){
		
		
	}
	
	public List<Bullet> attack(Fabio f){
		
		ArrayList<Bullet> list = new ArrayList<Bullet>();
		if (hostile){
		
			
		}
		return list;
	}
	
	public boolean getHostile(){
		return hostile;
	}
	
	public void setHostile(boolean h){
		hostile = h;
	}
}
