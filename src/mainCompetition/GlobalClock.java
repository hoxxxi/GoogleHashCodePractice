package mainCompetition;

import java.util.Observable;

public class GlobalClock extends Observable {
	public int clock = 0;
	public static GlobalClock gc;
	
	private GlobalClock() {
		clock = 0;
	}
	
	public static GlobalClock getClock() {
		if (gc == null) {
			gc = new GlobalClock();
		} else {
			return gc;
		}
	}

	public int getTime() {
		return this.clock;
	}
	public void incrementClock() {
		clock++;
		notifyObservers(clock);
	}
	
}
