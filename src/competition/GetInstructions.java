package competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import javax.swing.text.Utilities;

public class GetInstructions {
	Stack<Order> pendingOrders;

	ArrayList<Drone> availableDrones;
	ArrayList<DroneWithDistance> listOfDronesForTask;

	ArrayList<Warehouse> warehouses;

	public GetInstructions(Stack<Order> pendingOrders, ArrayList<Drone> availDrones) {

		this.pendingOrders = pendingOrders;
		this.availableDrones = availDrones;
		listOfDronesForTask = new ArrayList<DroneWithDistance>();

		for (Order order : pendingOrders) {
			if (order.getMass() > Drone.getMaxCapacity())
				continue;
			{

				ArrayList<Warehouse> possibleWarehouseList = new ArrayList<Warehouse>();

				for (Warehouse warehouse : warehouses) {
					if (warehouse.hasEnoughProducts(order)) // Check if given
															// warehouse
															// has enough
															// products
					{
						possibleWarehouseList.add(warehouse);
					}
				}

				for (Warehouse warehouse : possibleWarehouseList) {
					for (Drone drone : availableDrones) {
						int distance = distanceBetween(drone.getLocation(), warehouse.getLocation())
								+ distanceBetween(warehouse.getLocation(), order.getLocation());
						listOfDronesForTask.add(new DroneWithDistance(distance, drone, warehouse));
					}
				}

				Collections.sort(listOfDronesForTask);
				DroneWithDistance bestDroneForTask = listOfDronesForTask.get(0);

				order.executeWithDrone(bestDroneForTask);
				availableDrones.remove(bestDroneForTask.getDrone());

			}
		}
	}

	public static int distanceBetween(Location l1, Location l2) {
		return (int) Math.ceil(Math.sqrt(Math.pow((l1.x - l2.x), 2) + Math.pow((l1.y - l2.y), 2)));
	}
}
