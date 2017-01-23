
public class Outfit extends Item{

	private Head head;
	private Shirt shirt;
	private Pants pants;
	private Shoes shoes;

	
	public Outfit(Head head, Shirt shirt, Pants pants, Shoes shoes){
				
		this.head = head;
		this.shirt = shirt;
		this.pants = pants;
		this.shoes = shoes;
	}
	
	public void draw(double x, double y){
		
		if (head != null)
			head.draw(x, y);
		
		if (shirt != null)
			shirt.draw(x, y);
		
		if (pants != null)
			pants.draw(x, y);
		
		if (shoes != null)
			shoes.draw(x, y);
		
	}
	
	public void recieveStatsFromClothes(){
		
		
	}

}
