package competition;

import java.util.Dictionary;
import java.util.HashMap;

public class Warehouse {
	int x;
	int y;
	HashMap<Product, Integer> inventory;
	public Warehouse(int xIn, int yIn, HashMap inventoryIn)
	{
		x = xIn;
		y = yIn;
		inventoryIn = inventoryIn;
	}
}
