package competition;

import java.util.HashMap;

public class Order {
	int ID;
	Location location;
	HashMap<Product, Integer> itemIDs;
	public Order( Location loc, HashMap<Product, Integer> itemsIDsIn)
	{
		itemIDs = itemsIDsIn;
		this.location = loc;
		this.itemIDs=itemsIDsIn;
	}
}
