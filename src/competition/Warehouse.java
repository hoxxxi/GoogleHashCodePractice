package competition;

import java.util.HashMap;

public class Warehouse {	
	int ID;
	Location location;
	HashMap<Product, Integer> inventory;
	
	public boolean satisfyOrder(Order order)
	{
		for(Product p:inventory.keySet())
		{
			if(inventory.get(p) < order.itemIDs.get(p))
				return false;
		}
		return true;
	}
	public Warehouse(Location loc, HashMap inventoryIn)
	{
		this.location = loc;
		inventoryIn = inventoryIn;
	}

	public boolean hasEnoughProducts(Order order) {
		
		return false;
	}
}
