package mainCompetition;

import java.util.Observable;
import java.util.Observer;

import competition.Location;
import competition.Order;
import competition.Product;

public class Drone implements Observer {

	Location currentLocation;
	Order assignedOrder;
	int time = 0;
			
	public Drone(Location currentLocation, Order assignedOrder, Product loaded,
			boolean isOccupied) {
		super();
		this.currentLocation = currentLocation;
		this.assignedOrder = assignedOrder;
		this.loaded = loaded;
		this.isOccupied = isOccupied;
	}
	static int maxCapacity;
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
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
	Product loaded;
	boolean isOccupied;

	@Override
	public void update(Observable arg0, Object arg1) {
		this.time = (Integer) arg1;		
	}
	
	
	
}
