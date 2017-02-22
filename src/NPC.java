import java.util.ArrayList;
import java.util.List;

public class NPC extends Person {

	protected int model;
	protected String name;
	
	public NPC(int xCoord, int yCoord, int health, int model) {
		super(xCoord, yCoord, health);
		this.model = model;

	}

	public void speak(){
		
	}	
	
	public List<Bullet> attack(Fabio f){
		
		List<Bullet> list = new ArrayList<Bullet>();
		return list;
	}
}