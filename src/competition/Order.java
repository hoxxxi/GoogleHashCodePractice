package competition;

import java.util.HashMap;

public class Order {
	int ID;
	Location location;
	HashMap<Product, Integer> itemIDs;
	int massOfProducts;
	public Order( Location loc, HashMap<Product, Integer> itemsIDsIn)
	{
		itemIDs = itemsIDsIn;
		this.location = loc;
		this.itemIDs=itemsIDsIn;
	}
	public int getMass() {
		
		return massOfProducts;
	}
	public void executeWithDrone(DroneWithDistance bestDroneForTask) {
		Drone drone = bestDroneForTask.getDrone();
		
	}
	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
}
