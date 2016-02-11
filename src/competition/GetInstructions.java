package competition;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.Utilities;

public class GetInstructions {
	ArrayList<Order> pendingOrders;
	
	ArrayList<Drone> availableDrones;
	ArrayList<DroneWithDistance> listOfDronesForTask;
	
	ArrayList<Warehouse> warehouses;
	
	for(Order order:pendingOrders){

		ArrayList<Warehouse> possibleWarehouseList = new ArrayList<Warehouse>();
		
		for(Warehouse warehouse: warehouses){
			if(warehouse.hasEnoughProducts(order)) // Check if given warehouse has enough products
			{
				possibleWarehouseList.add(warehouse);
			}
		}
		
		for(Warehouse warehouse: possibleWarehouseList){
			for(Drone drone: availableDrones)
			{
				int distance = distanceBetween( drone, warehouse) + distanceBetween( warehouse, order);
				listOfDronesForTask.add(new DroneWithDistance(distance, drone));
			}
		}
		Collections.sort(listOfDronesForTask);
		execute Order with drone with lowest distance
		order.executeWithDrone(listOfDronesForTask.get(0));
		remove drone from dronesAvailable
		remove products from warehouse
	}
	
	
}
