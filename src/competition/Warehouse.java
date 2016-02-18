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
	public Warehouse(int id, Location loc, HashMap inventoryIn)
	{
		this.ID = id;
		this.location = loc;
		this.inventory = inventoryIn;
	}

	public boolean hasEnoughProducts(Order order) {
		for(Product prod: order.itemIDs.keySet()){
			if(order.itemIDs.get(prod) > inventory.get(prod))
				return false;
		}
		return true;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	public String toString(){
		return "Warehouse id"+this.ID +" at ("+location.x +","+location.y+ ") and items" + inventory ; 
	}
}
