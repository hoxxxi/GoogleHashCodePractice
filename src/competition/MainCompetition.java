package competition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import mainCompetition.GlobalClock;

public class MainCompetition {

	public static void main(String[]args) throws IOException
	{
		//Take input
		BufferedReader in = new BufferedReader(new FileReader("inputComp.txt"));
		
		String []landscapeDefinition = in.readLine().split(" ");//{"100", "100", "3", "50", "500"}; // grid h, grid w, n of drones, deadline, drone payload
		
		int deadline = Integer.parseInt(landscapeDefinition[3]);
		int numberOfDrones = Integer.parseInt(landscapeDefinition[3]);
		ArrayList<Drone> droneArray = new ArrayList<>();
		for(int ruk = 0;ruk<numberOfDrones;ruk++)
		{
			droneArray.add(new Drone(new Location(0, 0), null, null, false, Integer.parseInt(landscapeDefinition[4]), ruk));
		}
		GlobalClock.getClock();
		
		int numberOfProductTypes = Integer.parseInt(in.readLine());
		ArrayList<Product> productTypes = new ArrayList<Product>();
		String []individualProductWeight = in.readLine().split(" ");
		for(int asd = 0; asd<numberOfProductTypes; asd++)
		{
			productTypes.add(new Product(asd, Integer.parseInt(individualProductWeight[asd])));
		}
	
		
		
		int numberOfWarehouses = Integer.parseInt(in.readLine());
		ArrayList<Warehouse> warehouseList = new ArrayList<Warehouse>();
		for(int currw = 0;currw<numberOfWarehouses;currw++)
		{
			String []warehouseCoordinate1 = in.readLine().split(" ");
			String []quanttyOfEachProductatWarehouse1 = in.readLine().split(" ");
		
			HashMap<Product, Integer> inventory = new HashMap<>();
			
			for(int bah = 0; bah<numberOfProductTypes; bah++)
			{
				inventory.put(productTypes.get(bah), Integer.parseInt(quanttyOfEachProductatWarehouse1[bah]));
			}
			warehouseList.add(new Warehouse(new Location(Integer.parseInt(warehouseCoordinate1[0]),Integer.parseInt(warehouseCoordinate1[0])),inventory));
			
		}
		for(Drone dr: droneArray)
		{
			dr.setCurrentLocation(warehouseList.get(0).getLocation());
		}
		int numberOfOrders = Integer.parseInt(in.readLine());
		Stack<Order> orderStack = new Stack<Order>();
		for(int i =0;i<numberOfOrders;i++)
		{
			String []orderCoordinates1 = in.readLine().split(" ");
			int numberOFItems1 = Integer.parseInt(in.readLine());
			String []productTypes1 = in.readLine().split(" "); //Change to dictionary
			HashMap<Product, Integer> productTypesAndQUantities = new HashMap<>();
			
			for(int kur = 0; kur<productTypes1.length; kur++)
			{
				Product word =productTypes.get(Integer.parseInt(productTypes1[kur]));
				int count = productTypesAndQUantities.containsKey(word) ? productTypesAndQUantities.get(word) : 0;
				productTypesAndQUantities.put(word, count + 1);
			}
			orderStack.push(new Order(new Location(Integer.parseInt(orderCoordinates1[0]), Integer.parseInt(orderCoordinates1[1])), productTypesAndQUantities));
		}
		
		while ( !orderStack.isEmpty()) {
			{
				Order currentOrder = orderStack.pop();
				
				Location orderLocation = currentOrder.getLocation();
				
				HashMap<Product, Integer> itemsInOrder = currentOrder.getItemIDs();
				
				for(Drone dr: droneArray)
				{
					if (!dr.isOccupied)
					{
						//Get preferred warehouse
						Location droneCurrentLocation = dr.getLocation();
						int shortestPath = Integer.MAX_VALUE;
						Warehouse preferredWarehouse = warehouseList.get(0);
						for(Warehouse wareh: warehouseList)
						{
							if(GetInstructions.distanceBetween(droneCurrentLocation, wareh.getLocation())<shortestPath)
							{
								if(wareh.hasEnoughProducts(currentOrder))
								{
									preferredWarehouse = wareh;
									shortestPath = GetInstructions.distanceBetween(droneCurrentLocation, wareh.getLocation());
								}
							}
						}
						
						
						dr.load(preferredWarehouse, numberOfProducts, p)
						dr.d
					}
				}
//				GetInstructions(orderList,);
			}
		}
	}
}
