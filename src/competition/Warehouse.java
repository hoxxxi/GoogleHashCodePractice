package competition;

import java.util.HashMap;

public class Warehouse {	
	int ID;
	Location location;
	HashMap<Product, Integer> inventory;
	
	public Warehouse(Location loc, HashMap inventoryIn)
	{
		this.location = loc;
		inventoryIn = inventoryIn;
	}

	public boolean hasEnoughProducts(Order order) {
		
		return false;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
}
