/*
 * Created by katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class AircraftFactory {
	private	Coordinates coordinates;
	private	int			counter;

	public Flyable newAircraft(String type, String name, int longitude,
			int latitude, int height) {
		switch (type) {
			case "Baloon":
				coordinates = new Coordinates(longitude, latitude, height);
				return (new Baloon(name, coordinates));	
			case "JetPlane":
				coordinates = new Coordinates(longitude, latitude, height);
				return (new JetPlane(name, coordinates));	
			case "Helicopter": 
				coordinates = new Coordinates(longitude, latitude, height);
				return (new Helicopter(name, coordinates));	
			default:
				coordinates = new Coordinates(longitude, latitude, height);
				return (new Helicopter(name, coordinates));	
		}
	}

	public void			setCounter(int counter) { this.counter = counter; }
	public int			getCounter() { return this.counter; }
}
