import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Person extends Moveable{

	protected int health;
	protected List<Item> inventory = new ArrayList<Item>();
	
	public Person(double xCoord, double yCoord, int health) {
		super(xCoord, yCoord);
		this.health = health;
	}

	public void move(){
		
	}
	
	public void draw(){
		
	}
	
	public int getHealth(){
		return health;
	}
	
	public void dealDamage(double d){
		health -= d;
	}
	
	public boolean timeToDie(){
		
		return health < 0;
	}
	
}