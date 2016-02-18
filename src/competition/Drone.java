package competition;

import java.util.Observable;
import java.util.Observer;

import competition.Location;
import competition.Order;
import competition.Product;

public class Drone implements Observer {

	int ID;
	Location location;
	Order assignedOrder;
	int capacity;
	int time = 0;
	Product loaded;
	boolean isOccupied;
	int occupiedUntil;
	
	public Drone(Location currentLocation, Order assignedOrder, Product loaded,
			boolean isOccupied, int capacityIn, int ID) {
		super();
		this.capacity=capacityIn;
		this.ID = ID;
		this.location = currentLocation;
		this.assignedOrder = assignedOrder;
		this.loaded = loaded;
		this.isOccupied = isOccupied;
	}
	static int maxCapacity;
	public Location getLocation() {
		return location;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.location = currentLocation;
	}
	public Order getAssignedOrder() {
		return assignedOrder;
	}
	public void setAssignedOrder(Order assignedOrder) {
		this.assignedOrder = assignedOrder;
	}
	public static int getMaxCapacity() {
		return maxCapacity;
	}
	public static void setMaxCapacity(int maxCapacity) {
		Drone.maxCapacity = maxCapacity;
	}
	public Product getLoaded() {
		return loaded;
	}
	public void setLoaded(Product loaded) {
		this.loaded = loaded;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getOccupiedUntil() {
		return occupiedUntil;
	}
	public void setOccupiedUntil(int occupiedUntil) {
		this.occupiedUntil = occupiedUntil;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.time = (Integer) arg1;		
	}
	
	public String unload(Warehouse w, int numberOfProducts, Product p) {
		return this.ID + " " + "U" + " " + w.ID + " " + p.ID + " " + numberOfProducts;
	}
	
	public String load(Warehouse w, int numberOfProducts, Product p) {
		return this.ID + " " + "L" + " " + w.ID + " " + p.ID + " " + numberOfProducts;
	}
	
	public String deliver(Order o, int numberOfProducts, Product p) {
		return this.ID + " " + "D" + " " + o.ID + " " + p.ID + " " + numberOfProducts;
	}
	
	public String wait(int numOfTurns) {
		return this.ID + " " + "W" + " " + numOfTurns;
	}
	
	
}
