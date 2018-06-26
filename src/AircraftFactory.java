/*
 * Created by katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class AircraftFactory {
	private	int			counter;

	public Flyable newAircraft(String type, String name, int longitude,
			int latitude, int height) throws Exception{
		Flyable			temp;

		if (height < 0 || height > 100) {
			throw new Exception("Wether you are superman or a spaceship, return to sender.");
		}
		Coordinates coordinates;
		switch (type) {
			case "Baloon":
				coordinates = new Coordinates(longitude, latitude, height);
				temp = new Baloon(name, coordinates);
				break;	
			case "JetPlane":
				coordinates = new Coordinates(longitude, latitude, height);
				temp = new JetPlane(name, coordinates);
				break;
			case "Helicopter": 
				coordinates = new Coordinates(longitude, latitude, height);
				temp = new Helicopter(name, coordinates);
				break;
			default:
				throw new Exception("Aircraft type not recorgnised");
		}
		return (temp);
	}

	public void			setCounter(int counter) { this.counter = counter; }
	public int			getCounter() { return this.counter; }
}
