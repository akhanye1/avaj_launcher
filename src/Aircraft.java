/* 
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class Aircraft {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	private static long		idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	
	private long nextId() {
		return (1);
	}
}
