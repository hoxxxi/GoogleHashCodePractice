package mainCompetition;

public class DroneWithDistance implements Comparable<DroneWithDistance>{
	private int distance;
	private Drone drone;
	
	public DroneWithDistance(int dist, Drone d)
	{
		this.distance = dist;
		this.drone = d;
	}

	@Override
	public int compareTo(DroneWithDistance o) {
		return Integer.compare(distance, o.getDistance());
	}

	private int getDistance() {
		return distance;
	}
	
	
}
