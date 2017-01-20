
public class NPC extends Person {

	private boolean hostile;
	
	public NPC(int xCoord, int yCoord, int health, boolean hostile) {
		super(xCoord, yCoord, health);
		this.hostile = hostile;
	}

	public void speak(){
		
	}	
}
