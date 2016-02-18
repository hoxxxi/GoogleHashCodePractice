package competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import mainCompetition.GlobalClock;

public class MainCompetition {

	public static void main(String[] args) throws IOException {
		// Take input
//		 BufferedReader in = new BufferedReader(new
//		 FileReader("redundancy.in"));
//		 File file = new File("redundancy.txt");

//		 BufferedReader in = new BufferedReader(new
//		 FileReader("mother_of_all_warehouses.in"));
//		 File file = new File("mother.txt");

		BufferedReader in = new BufferedReader(new FileReader("busy_day.in"));
		File file = new File("busyDay.txt");

		String[] landscapeDefinition = in.readLine().split(" ");// {"100",
																// "100", "3",
																// "50", "500"};
																// // grid h,
																// grid w, n of
																// drones,
																// deadline,
																// drone payload

		int deadline = Integer.parseInt(landscapeDefinition[3]);
		int numberOfDrones = Integer.parseInt(landscapeDefinition[2]);
		int maxCapacity = Integer.parseInt(landscapeDefinition[4]);

		ArrayList<Drone> droneArray = new ArrayList<>();

		for (int i = 0; i < numberOfDrones; i++) {
			droneArray.add(new Drone(new Location(0, 0), null, null, false, maxCapacity, i));
		}

		GlobalClock.getClock(); // I don't think I'll use that

		int numberOfProductTypes = Integer.parseInt(in.readLine());

		ArrayList<Product> productTypes = new ArrayList<Product>();
		String[] individualProductWeight = in.readLine().split(" ");
		for (int i = 0; i < numberOfProductTypes; i++) {
			productTypes.add(new Product(i, Integer.parseInt(individualProductWeight[i])));
		}

		// System.out.println(productTypes);

		int numberOfWarehouses = Integer.parseInt(in.readLine());
		ArrayList<Warehouse> warehouseList = new ArrayList<Warehouse>();
		for (int i = 0; i < numberOfWarehouses; i++) {
			String[] warehouseCoordinate1 = in.readLine().split(" ");
			String[] quanttyOfEachProductatWarehouse1 = in.readLine().split(" ");

			HashMap<Product, Integer> inventory = new HashMap<>();

			for (int j = 0; j < numberOfProductTypes; j++) {
				inventory.put(productTypes.get(j), Integer.parseInt(quanttyOfEachProductatWarehouse1[j]));
			}
			warehouseList.add(new Warehouse(i,
					new Location(Integer.parseInt(warehouseCoordinate1[0]), Integer.parseInt(warehouseCoordinate1[0])),
					inventory));

		}

		// System.out.println(warehouseList);

		for (Drone dr : droneArray) {
			dr.setCurrentLocation(warehouseList.get(0).getLocation());
		}

		int numberOfOrders = Integer.parseInt(in.readLine());
		Stack<Order> orderStack = new Stack<Order>();
		for (int i = 0; i < numberOfOrders; i++) {
			String[] orderCoordinates1 = in.readLine().split(" ");
			int numberOFItems1 = Integer.parseInt(in.readLine());
			String[] productsInOrder = in.readLine().split(" "); // Change to
																	// dictionary
			HashMap<Product, Integer> productTypesAndQUantities = new HashMap<>();

			for (int j = 0; j < productsInOrder.length; j++) {
				Product product = productTypes.get(Integer.parseInt(productsInOrder[j]));
				productTypesAndQUantities.put(product, 1);
			}
			orderStack.push(new Order(i,
					new Location(Integer.parseInt(orderCoordinates1[0]), Integer.parseInt(orderCoordinates1[1])),
					productTypesAndQUantities));
		}
		// System.out.println(orderStack);

		ArrayList<String> listOfInstructions = new ArrayList<String>();
		ArrayList<Drone> listOfUnavailableDrones = new ArrayList<Drone>();

		for (int currentTime = 0; currentTime < deadline; currentTime++) {
			for (Drone d : listOfUnavailableDrones) {
				if (d.getOccupiedUntil() == currentTime) {
					d.setOccupied(false);
					listOfUnavailableDrones.remove(d);
				}
			}
			if (listOfUnavailableDrones.size() != droneArray.size()) {
				while (!orderStack.isEmpty()) {
					{
						Order currentOrder = orderStack.pop();
						if (currentOrder.getMass() > maxCapacity)
							break;

						HashMap<Product, Integer> itemsInOrder = currentOrder.getItemIDs();

						Drone bestDrone = droneArray.get(0);
						Warehouse preferredWarehouse = warehouseList.get(0);

						for (Drone dr : droneArray) {
							if (!dr.isOccupied) {
								// Get preferred warehouse
								Location droneCurrentLocation = dr.getLocation();
								int shortestPath = Integer.MAX_VALUE;

								for (Warehouse warehouse : warehouseList) {
									if (GetInstructions.distanceBetween(droneCurrentLocation,
											warehouse.getLocation()) < shortestPath) {
										if (warehouse.hasEnoughProducts(currentOrder)) {
											preferredWarehouse = warehouse;
											shortestPath = GetInstructions.distanceBetween(droneCurrentLocation,
													warehouse.getLocation());
											bestDrone = dr;
										}
									}
								}
							}
						}
						if (bestDrone.isOccupied)
							continue;
						for (Product prod : itemsInOrder.keySet()) {
							int productsInWarehouse = preferredWarehouse.inventory.get(prod);
							int productsInOrder = itemsInOrder.get(prod);
							listOfInstructions.add(bestDrone.load(preferredWarehouse, productsInOrder, prod));
							preferredWarehouse.inventory.put(prod, productsInWarehouse - productsInOrder);

						}
						for (Product prod : itemsInOrder.keySet()) {
							int productsInOrder = itemsInOrder.get(prod);
							listOfInstructions.add(bestDrone.deliver(currentOrder, productsInOrder, prod));
						}

						bestDrone.setOccupied(true);
						bestDrone.setOccupiedUntil(currentTime
								+ GetInstructions.distanceBetween(bestDrone.getLocation(),
										preferredWarehouse.getLocation())
								+ GetInstructions.distanceBetween(preferredWarehouse.getLocation(),
										currentOrder.getLocation())
								+ 2);
					}
				}
			}
		}
		// System.out.println(listOfInstructions);

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(listOfInstructions.size() + "\n");
		System.out.println(listOfInstructions.size());
		for (String str : listOfInstructions) {
			bw.write(str + "\n");
		}

		bw.close();

		System.out.println("Process finished");
	}
}
