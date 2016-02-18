package competition;

import java.util.HashMap;

public class Order {
	int ID;
	Location location;
	HashMap<Product, Integer> itemIDs;
	public Order(int orderID, Location loc, HashMap<Product, Integer> itemsIDsIn)
	{
		this.ID = orderID;
		itemIDs = itemsIDsIn;
		this.location = loc;
		this.itemIDs=itemsIDsIn;
	}
	public int getMass() {
		int massOfProducts = 0;
		for(Product p: itemIDs.keySet())
		{
			massOfProducts += p.weight * itemIDs.get(p);
			}
		return massOfProducts;
	}
	public HashMap<Product, Integer> getItemIDs()
	{
		return this.itemIDs;
	}
	public void executeWithDrone(DroneWithDistance bestDroneForTask) {
		Drone drone = bestDroneForTask.getDrone();
		Warehouse warehouse = bestDroneForTask.getWarehouse();
//		Set<Product> keys = itemIDs.keySet();
//		
//		for(Integer numorders: itemIDs.values()) {
//				drone.load( warehouse, numorders)
//		}
//		send to client
//		unload
		
	}
	public Location getLocation() {
		return location;
	}
	
	public String toString(){
		return "Order id"+this.ID+ " to loc ("+location.x+","+location.y+") with products:"+itemIDs;
	}
}
