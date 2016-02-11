package competition;

public class DroneWithDistance implements Comparable<DroneWithDistance>{
	private int distance;
	private Drone drone;
	private Warehouse warehouse;
	
	public DroneWithDistance(int dist, Drone d, Warehouse warehouse)
	{
		this.distance = dist;
		this.drone = d;
		this.warehouse = warehouse;
	}

	@Override
	public int compareTo(DroneWithDistance o) {
		return Integer.compare(distance, o.getDistance());
	}

	private int getDistance() {
		return distance;
	}
	
	
}
